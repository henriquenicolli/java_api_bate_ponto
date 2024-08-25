O AEJ deve: 
1. Apresentar o formato predeterminado neste anexo. 
2. Apresentar-se no formato texto, codificado no padrão ASCII da norma ISO 8859-1. 
3. Apresentar-se com cada linha correspondente a um registro, terminando com os caracteres 13 e 10, respectivamente, da tabela ASCII da norma ISO 8859-1. 
4. Cada linha do arquivo digital representará um registro e deve conter os campos que estão no leiaute definido para o registro. Ao final de cada campo, com exceção do último campo do registro, deve ser inserido o caractere delimitador "|" (pipe ou barra vertical). 
5. Não conter linhas em branco. 
6. Os tipos dos dados nos campos podem ser: 
	 N: numérico; 
	 A: alfanumérico; 
	 H: hora, no formato "hhmm";
	 D: data, no formato "AAAA-MM-dd", onde: 
	 1. AAAA: ano; 
	 2. MM: mês; 
	 3. dd: dia do mês; e 
	 4. DH: data e hora, no formato "AAAA-MM-ddThh:mm:00ZZZZZ", onde: 
	 5. AAAA: ano; 
	 6. MM: mês; 
	 7. dd: dia do mês; 
	 8. T: fixo com valor "T"; 
	 9. hh: hora (00 a 23); 
	 10. mm: minutos (00 a 59); 
	 11. 00: segundos (fixos com valor "00"); 
	 12. ZZZZZ: fuso horário, onde o primeiro digito representa o sinal (positivo ou negativo) e os outros quatro dígitos representam a hora e os minutos

Este arquivo é composto dos seguintes tipos de registro:
Registro do tipo "1" - Cabeçalho

| Referência do campo | Nome do campo   | Tamanho  | Tipo | Conteúdo                                                               |
| ------------------- | --------------- | -------- | ---- | ---------------------------------------------------------------------- |
| 1                   | tipoReg         | 2        | N    | Tipo do registro. Preencher com "01".                                  |
| 2                   | tpIdtEmpregador | 1        | N    | Tipo de identificador do empregador: - "1": CNPJ; - "2": CPF.          |
| 3                   | idtEmpregador   | 11 ou 14 | N    | CNPJ ou CPF do empregador.                                             |
| 4                   | caepf           | 14       | N    | CAEPF (Cadastro de Atividade Econômica da Pessoa Física), caso exista. |
| 5                   | cno             | 12       | N    | CNO (Cadastro Nacional de Obras), caso exista.                         |
| 6                   | razaoOuNome     | 1 a 150  | A    | Razão social ou nome do empregador.                                    |
| 7                   | dataInicialAej  | 10       | D    | Data inicial dos registros no AEJ.<br>                                 |
| 8                   | dataFinalAej    | 10       | D    | Data final dos registros no AEJ.                                       |
| 9                   | dataHoraGerAej  | 24       | DH   | Data e hora da geração do AEJ. (: 2021-04-27T16:44:00-0300.)           |
| 10                  | versaoAej       | 3        | A    | Versão do leiaute do AEJ. Preencher com "001"                          |

Registro do tipo "02" - REPs utilizados

| Referência do campo | Nome do campo | Tamanho | Tipo | Conteúdo                                                                                                                                                                                                                     |
| ------------------- | ------------- | ------- | ---- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1                   | tipoReg       | 2       | N    | Tipo do registro. Preencher com "02".                                                                                                                                                                                        |
| 2                   | idRepAej      | 1 a 9   | N    | Identificador do REP no AEJ                                                                                                                                                                                                  |
| 3                   | tpRep         | 1       | N    | Tipo do REP: <br>- "1": REP-C; <br>- "2": REP-A; <br>- "3": REP-P                                                                                                                                                            |
| 4                   | nrRep         | 17      | N    | Número de fabricação ou identificador do REP, caso exista algum REP associado à marcação. Campo obrigatório quando o campo fonteMarc for igual a "O". <br>Preencher com: <br>- Número de registro no INPI, no caso de REP-P. |

Registro do tipo "03" - Vínculos

| Referência do campo | Nome do campo | Tamanho | Tipo | Conteúdo                              |
| ------------------- | ------------- | ------- | ---- | ------------------------------------- |
| 1                   | tipoReg       | 2       | N    | Tipo do registro. Preencher com "03". |
| 2                   | idtVinculoAej | 1 a 9   | N    | Identificador do vínculo no AEJ.      |
| 3                   | cpf           | 11      | N    | CPF do empregado<br><br><br>          |
| 4                   | nomeEmp       | 1 a 150 | A    | Nome do empregado.                    |

Registro do tipo "04" - Horário contratual

| Referência do campo | Nome do campo    | Tamanho | Tipo | Conteúdo                                               |
| ------------------- | ---------------- | ------- | ---- | ------------------------------------------------------ |
| 1                   | tipoReg          | 2       | N    | Tipo do registro. Preencher com "04".                  |
| 2                   | codHorContratual | 1 a 30  | A    | Código do horário contratual no AEJ.                   |
| 3                   | durJornada       | 1 a 12  | N    | Duração da jornada, convertida em minutos.<br><br><br> |
| 4                   | hrEntrada01      | 1 a 12  | H    | Hora da primeira entrada.<br><br><br>                  |
| 5                   | hrSaida01        | 1 a 12  | H    | Hora da primeira saída.                                |
| 6                   | hrEntrada02      | 0 ou 4  | H    | Hora da segunda entrada.                               |
| 7                   | hrSaida02        | 0 ou 4  | H    | Hora da segunda saída.                                 |

1. O campo codHorContratual identifica o horário contratual dentro do AEJ. 
2. Caso o horário contratual tenha mais de dois pares entrada/saída, esses devem ser informados em sequência. Assim, teremos os campos hrEntradaNN e hrSaidaNN, onde NN representa a ordem do par entrada/saída. 
3. Caso o horário seja noturno, o campo durJornada deve ser informado considerando a redução da hora noturna.

Registro do tipo "05" - Marcações

| Referência do campo | Nome do campo    | Tamanho | Tipo | Conteúdo                                                                                                                                                                                                    |
| ------------------- | ---------------- | ------- | ---- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1                   | tipoReg          | 2       | N    | Tipo do registro. Preencher com "05".                                                                                                                                                                       |
| 2                   | idtVinculoAej    | 1 a 9   | N    | Identificador do vínculo no AEJ (informado no registro do tipo "03")                                                                                                                                        |
| 3                   | dataHoraMarc     | 24      | DH   | Data e hora da marcação.<br><br><br>                                                                                                                                                                        |
| 4                   | idRepAej         | 0 a 9   | N    | Identificador do REP no AEJ (informado no registro do tipo "02")                                                                                                                                            |
| 5                   | tpMarc           | 1       | A    | Tipo da marcação: <br>- "E": marcação de entrada; <br>- "S": marcação de saída; <br>- "D": marcação desconsiderada.                                                                                         |
| 6                   | seqEntSaida      | 3       | N    | Número sequencial do par entrada/saída.                                                                                                                                                                     |
| 7                   | fonteMarc        | 1       | A    | Fonte da marcação: <br>- "O": marcação original do REP; <br>- "I ": marcação incluída manualmente; <br>- "P": marcação pré-assinalada; <br>- "X": ponto por exceção; <br>- "T ": outras fontes de marcação. |
| 8                   | codHorContratual | 0 a 30  | A    | Código do horário contratual no AEJ (informado no registro do tipo "04"). Campo obrigatório quando a marcação se tratar da primeira entrada, ou seja, tpMarc igual a "E" e seqEntSaida igual a "1".         |
| 9                   | motivo           | 0 a 150 | A    | Motivo da desconsideração ou inclusão da marcação. Campo obrigatório quando tpMarc for igual a "D" ou fonteMarc for igual a "I"                                                                             |

Registro do tipo "06" - Identificação da matrícula do vínculo no eSocial, para empregados com mais de um vínculo no AEJ

| Referência do campo | Nome do campo | Tamanho | Tipo | Conteúdo                                                              |
| ------------------- | ------------- | ------- | ---- | --------------------------------------------------------------------- |
| 1                   | tipoReg       | 2       | N    | Tipo do registro. Preencher com "06".                                 |
| 2                   | idtVinculoAej | 1 a 9   | N    | Identificador do vínculo no AEJ (informado no registro do tipo "03"). |
| 3                   | matEsocial    | 1 a 30  | A    | Matrícula do vínculo no eSocial.<br><br><br>                          |

Registro do tipo "07" - Ausências e Banco de Horas

| Referência do campo | Nome do campo   | Tamanho | Tipo | Conteúdo                                                                                                                                                                                                          |
| ------------------- | --------------- | ------- | ---- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1                   | tipoReg         | 2       | N    | Tipo do registro. Preencher com "07".                                                                                                                                                                             |
| 2                   | idtVinculoAej   | 1 a 9   | N    | Identificador do vínculo no AEJ (informado no registro do tipo "03").                                                                                                                                             |
| 3                   | tipoAusenOuComp | 1       | N    | Código com tipo da ausência ou compensação: <br>- "1": Descanso Semanal Remunerado (DSR); <br>- "2": falta não justificada; <br>- "3": movimento no banco de horas; <br>- "4": folga compensatória de feriado<br> |
| 4                   | data            | 10      | D    | Data da ausência ou compensação.                                                                                                                                                                                  |
| 5                   | qtMinutos       | 0 a 12  | N    | Quantidade de minutos. Campo obrigatório se tipoAusenOuComp for igual a "3".                                                                                                                                      |
| 6                   | tipoMovBH       | 0 ou 1  | N    | Tipo de movimento no banco de horas: <br>- "1": inclusão de horas no banco de horas; <br>- "2": compensação de horas do banco de horas. Campo obrigatório se tipoAusenOuComp for igual a "3".                     |

Registro do tipo "08" - Identificação do PTRP (Programa de Tratamento de Registro de Ponto)

| Referência do campo | Nome do campo   | Tamanho  | Tipo | Conteúdo                                                                 |
| ------------------- | --------------- | -------- | ---- | ------------------------------------------------------------------------ |
| 1                   | tipoReg         | 2        | N    | Tipo do registro. Preencher com "08".                                    |
| 2                   | nomeProg        | 1 a 150  | A    | Nome do PTRP.                                                            |
| 3                   | versaoProg      | 1 a 8    | A    | Versão do PTRP.<br>                                                      |
| 4                   | tpIdtDesenv     | 1        | N    | Tipo de identificador do desenvolvedor do PTRP: - "1": CNPJ; - "2": CPF. |
| 5                   | idtDesenv       | 11 ou 14 | N    | CNPJ ou CPF do desenvolvedor do PTRP.                                    |
| 6                   | razaoNomeDesenv | 1 a 150  | A    | Razão social ou nome do desenvolvedor do PTRP                            |
| 7                   | emailDesenv     | 1 a 50   | N    | E-mail do desenvolvedor do PTRP.                                         |

Registro do tipo "99" - Trailer

| Referência do campo | Nome do campo     | Tamanho | Tipo | Conteúdo                                 |
| ------------------- | ----------------- | ------- | ---- | ---------------------------------------- |
| 1                   | tipoReg           | 2       | N    | Tipo do registro. Preencher com "99"     |
| 2                   | qtRegistrosTipo01 | 1 a 9   | N    | Quantidade de registros do tipo "01"     |
| 3                   | qtRegistrosTipo02 | 1 a 9   | N    | Quantidade de registros do tipo "02"     |
| 4                   | qtRegistrosTipo03 | 1 a 9   | N    | Quantidade de registros do tipo "03"     |
| 5                   | qtRegistrosTipo04 | 1 a 9   | N    | Quantidade de registros do tipo "04"     |
| 6                   | qtRegistrosTipo05 | 1 a 9   | N    | Quantidade de registros do tipo "05"     |
| 7                   | qtRegistrosTipo06 | 1 a 9   | N    | Quantidade de registros do tipo "06"<br> |
| 8                   | qtRegistrosTipo07 | 1 a 9   | N    | Quantidade de registros do tipo "07"     |
| 9                   | qtRegistrosTipo08 | 1 a 9   | N    | Quantidade de registros do tipo "08"     |
