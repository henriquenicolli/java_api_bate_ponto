O AFD deve: 
1. Apresentar o formato predeterminado neste anexo.
2. Apresentar-se no formato texto, codificado no padrão ASCII da norma ISO 8859-1. 
3. Apresentar-se com cada linha correspondente a um registro, terminando com os caracteres 13 e 10, respectivamente, da tabela ASCII da norma ISO 8859-1. 
4. Ordenar os registros pelo Número Sequencial de Registro - NSR. 
5. Não conter linhas em branco. 
6. Os tipos dos dados nos campos podem ser: 1. N: numérico; 2. A: alfanumérico; 3. D: data, no formato "AAAA-MM-dd", onde: 4. AAAA: ano; 5. MM: mês; 6. dd: dia do mês; e 
7. DH: data e hora, no formato "AAAA-MM-ddThh:mm:00ZZZZZ", onde
8.  AAAA: ano; 
9. MM: mês; 
10. dd: dia do mês; 
11. T: fixo com valor "T"; 
12. hh: hora (00 a 23); 
13. mm: minutos (00 a 59); 
14. 00: segundos (fixos com valor "00"); 
15. ZZZZZ: fuso horário, onde o primeiro digito representa o sinal (positivo ou negativo) e os outros quatro dígitos representam a hora e os minutos. 
16. O preenchimento dos campos deve se iniciar pela esquerda e posições não utilizadas devem ser preenchidas com espaço. 
17. Para os registros dos tipos "1" a "5" deve ser gravado o Código de Verificação de Redundância, utilizando o CRC-16 (Cyclic Redundancy Check) do registro. 
18. O registro do tipo "7" deve utilizar o padrão SHA-256 (Secure Hash Algorithm - 256 bits) na geração do campo nº 8 (código hash). 19. Ser nomeado pela junção da palavra "AFD" com: 
	1.  para o REP-P: número de registro no INPI, CNPJ/CPF do empregador e "REP_P".

Este arquivo é composto dos seguintes tipos de registro:

Registro do tipo "1" - Cabeçalho

| Referência do campo | Posição  | Tamanho | Tipo | Conteúdo                                                                                                      |
| ------------------- | -------- | ------- | ---- | ------------------------------------------------------------------------------------------------------------- |
| 1                   | 001- 009 | 9       | N    | "000000000".                                                                                                  |
| 2                   | 010- 010 | 1       | N    | Tipo do registro. Preencher com "1".                                                                          |
| 3                   | 011-011  | 1       | N    | Tipo de identificador do empregador: - "1": CNPJ; - "2": CPF.                                                 |
| 4                   | 012- 025 | 14      | N    | CNPJ ou CPF do empregador.                                                                                    |
| 5                   | 026- 039 | 14      | N    | CNO (Cadastro Nacional de Obras) ou CAEPF (Cadastro de Atividade Econômica da Pessoa Física), quando existir. |
| 6                   | 040- 189 | 150     | A    | Razão social ou nome do empregador                                                                            |
| 7                   | 190- 206 | 17      | N    | Preencher com: <br>- Número de registro no INPI, no caso de REP-P.                                            |
| 8                   | 207- 216 | 10      | D    | Data inicial dos registros no arquivo.                                                                        |
| 9                   | 217-226  | 10      | D    | Data final dos registros no arquivo.                                                                          |
| 10                  | 227- 250 | 24      | DH   | Data e hora da geração do arquivo. (data e hora): 2021-04-27T16:44:00-0300.                                   |
| 11                  | 251-253  | 3       | N    | Versão do leiaute do AFD. Preencher com "003".                                                                |
| 12                  | 254- 254 | 1       | N    | Tipo de identificador do fabricante ou desenvolvedor do REP: - "1": CNPJ; - "2": CPF.                         |
| 13                  | 255- 268 | 14      | N    | CNPJ ou CPF do fabricante ou desenvolvedor do REP                                                             |
| 14                  | 269- 298 | 30      | A    | Modelo, no caso de REP-C.                                                                                     |
| 15                  | 299- 302 | 4       | A    | CRC-16 do registro.                                                                                           |

Registro do tipo "2" - Inclusão ou alteração da identificação da empresa no REP

| Referência do campo | Posição  | Tamanho | Tipo | Conteúdo                                                                                                          |
| ------------------- | -------- | ------- | ---- | ----------------------------------------------------------------------------------------------------------------- |
| 1                   | 001- 009 | 9       | N    | NSR.                                                                                                              |
| 2                   | 010- 010 | 1       | N    | Tipo do registro. Preencher com "2".                                                                              |
| 3                   | 011-034  | 24      | DH   | Data e hora da gravação do registro.                                                                              |
| 4                   | 035- 048 | 14      | N    | CPF do responsável pela inclusão ou alteração.                                                                    |
| 5                   | 049- 049 | 1       | N    | Tipo de identificador do empregador: - "1": CNPJ; - "2": CPF.                                                     |
| 6                   | 050- 063 | 14      | N    | CNPJ ou CPF do empregador.                                                                                        |
| 7                   | 064- 077 | 14      | N    | CNO (Cadastro Nacional de Obras) ou CAEPF (Cadastro de Atividade Econômica da Pessoa Física), quando existir.<br> |
| 8                   | 078- 227 | 150     | A    | Razão social ou nome do empregador.                                                                               |
| 9                   | 228-327  | 100     | A    | Local de prestação de serviços.                                                                                   |
| 10                  | 328-331  | 4       | A    | CRC-16 do registro.                                                                                               |
Registro do tipo "3" - Marcação de ponto para REP-C e REP-A

	N/A

Registro do tipo "4" - Ajuste do relógio

	Preciso?

Registro do tipo "5" - Inclusão, alteração ou exclusão de empregado no REP

| Referência do campo | Posição  | Tamanho | Tipo | Conteúdo                                                                          |
| ------------------- | -------- | ------- | ---- | --------------------------------------------------------------------------------- |
| 1                   | 001- 009 | 9       | N    | NSR.                                                                              |
| 2                   | 010-010  | 1       | N    | Tipo do registro. Preencher com "5".                                              |
| 3                   | 011-034  | 24      | DH   | Data e hora da gravação do registro.                                              |
| 4                   | 035-035  | 1       | N    | Tipo de operação: - <br>"I": inclusão; - <br>"A": alteração; - <br>"E": exclusão. |
| 5                   | 036-047  | 12      | N    | CPF do empregado                                                                  |
| 6                   | 048-099  | 52      | A    | Nome do empregado                                                                 |
| 7                   | 100-103  | 4       | A    | Demais dados de identificação do empregado.<br>                                   |
| 8                   | 104-114  | 11      | N    | CPF do responsável pela alteração.                                                |
| 9                   | 115-118  | 4       | A    | CRC-16 do registro.                                                               |

Registro do tipo "6" - Eventos sensíveis do REP

| Referência do campo | Posição  | Tamanho | Tipo | Conteúdo                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| ------------------- | -------- | ------- | ---- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1                   | 001- 009 | 9       | N    | NSR.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| 2                   | 010- 010 | 1       | N    | Tipo do registro. Preencher com "6".                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| 3                   | 011- 034 | 24      | DH   | Data e hora da gravação do registro.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| 4                   | 035- 036 | 2       | N    | Tipo de evento: "01": abertura do REP por manutenção ou violação (somente para REP-C); "02": retorno de energia (REP-C ou REP-P); "03": introdução de dispositivo externo de memória na Porta Fiscal (somente para REP-C); "04": retirada de dispositivo externo de memória na Porta Fiscal (somente para REP-C); "05": emissão da Relação Instantânea de Marcações (somente para REP-C); "06": erro de impressão (somente para REP-C); "07": disponibilidade de serviço (somente para REP-P); "08": indisponibilidade de serviço (somente para REP-P).<br><br><br> |

Registro do tipo "7" - Marcação de ponto para REP-P

| Referência do campo | Posição  | Tamanho | Tipo | Conteúdo                                                                                                                                                                                                          |
| ------------------- | -------- | ------- | ---- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1                   | 001- 009 | 9       | N    | NSR.                                                                                                                                                                                                              |
| 2                   | 010-010  | 1       | A    | Tipo do registro. Preencher com "7".                                                                                                                                                                              |
| 3                   | 011- 034 | 24      | DH   | Data e hora da marcação de ponto.                                                                                                                                                                                 |
| 4                   | 035- 046 | 12      | N    | CPF do empregado<br><br><br>                                                                                                                                                                                      |
| 5                   | 047- 070 | 24      | DH   | Data e hora de gravação do registro.                                                                                                                                                                              |
| 6                   | 071- 072 | 2       | N    | Identificador do coletor da marcação: "01": aplicativomobile; "02":browser(navegador internet); "03": aplicativodesktop; "04": dispositivo eletrônico; "05": outro dispositivo eletrônico não especificado acima. |
| 7                   | 073- 073 | 1       | N    | Informar "0" para marcaçãoon-lineou "1" para marcaçãooff-line.<br>                                                                                                                                                |
| 8                   | 074-137  | 64      | A    | Códigohash.                                                                                                                                                                                                       |
Será utilizado o padrão SHA-256 na geração do código hash especificado no campo nº 8, e seu cálculo será feito com base nos dados abaixo:
1. NSR (campo nº 1); 
2. tipo do registro (campo nº 2); 
3. data e hora da marcação de ponto (campo nº 3); 
4. CPF do empregado (campo nº 4); 
5. data e hora da gravação do registro (campo nº 5); 
6. identificador do coletor da marcação (campo nº 6); 
7. informação se a marcação foi on-line ou off-line (campo nº 7); e 8. código hash (SHA-256) do registro anterior, caso exista

Registro do tipo "9" - Trailer


| Referência do campo | Posição | Tamanho | Tipo | Conteúdo                                           |
| ------------------- | ------- | ------- | ---- | -------------------------------------------------- |
| 1                   | 001-009 | 9       | N    | "999999999".                                       |
| 2                   | 010-018 | 9       | N    | Quantidade de registros do tipo "2" no arquivo.    |
| 3                   | 019-027 | 9       | N    | Quantidade de registros do tipo "3" no arquivo     |
| 4                   | 028-036 | 9       | N    | Quantidade de registros do tipo "4" no arquivo     |
| 5                   | 037-045 | 9       | N    | Quantidade de registros do tipo "5" no arquivo     |
| 6                   | 046-054 | 9       | N    | Quantidade de registros do tipo "6" no arquivo     |
| 7                   | 055-063 | 9       | N    | Quantidade de registros do tipo "7" no arquivo<br> |
| 8                   | 064-064 | 1       | N    | Tipo do registro. Preencher com "9"                |

Assinatura digital

| Referência do campo | Posição | Tamanho | Tipo | Conteúdo            |
| ------------------- | ------- | ------- | ---- | ------------------- |
| 1                   | 001-100 | 100     | A    | Assinatura digital. |
