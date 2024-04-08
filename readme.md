# FUNCIONALIDADES DA API

### Visao funcionario
1. Registrar o ponto de um funcionario [ ]
2. Recuperar espelho de ponto de um funcionario [ ]
3. Recuperar um snapshot dos ultimos registros de pontos [ ]
4. Ser capaz de calcular as horas trabalhadas em um determinado dia [ ]
5. Ser capaz de calcular as horas extras totais do mes [ ]
6. Ser capaz de calcular as horas extras do dia de trabalho [ ]
7. Recuperar as ferias cadastradas de um funcionario [ ]
8. Recuperar as informacoes de remuneracao de um funcionario[ ]
9. Gerar o informe de rendimentos de um funcionario [ ]
10. Gerar o demonstrativo de pagamento de um funcionario [ ]
11. Recuperar as licencas cadastradas de um funcionario [ ] 
    

### Visao empresa

1. gestao funcionario
   - Cadastrar um funcionario [ ]
   - Cadastrar remuneracao de um funcionario [ ]
   - Cadastrar ferias de um funcionario [ ]
   - Cadastrar licenca de um funcionario [ ]
   - Gerir documentos de um funcionario [ ]

2. relatorios
   - Gerar relatorio com dados de localizacao e horario de ponto de um funcionario [ ]
   - Gerar holerite de um funcionario [ ]
   - Gerar informacoes de ferias de um funcionario [ ]
   - Gerar informacoes de licencas de um funcionario [ ]
   - gerar relatorio de jornada de trabalho de um funcionario [ ]


***
A Portaria 671 é a lei responsável por permitir o registro do ponto digital, validando o uso dos chamados pontos alternativos. O Pontomais salva as informações de jornada de trabalho e os registros de ponto na nuvem, como previsto e exigido pela lei.

***
realizar a emissão dos arquivos AFD e AEJ, obrigatórios em caso de solicitação do auditor fiscal do trabalho. São mais de 20 relatórios gerenciais em poucos cliques, dando mais segurança jurídica para a empresa e agilidade no setor de RH.



***
DA JORNADA DE TRABALHO
- CAP 5, pag 13, subsecao 1

Art. 78. O REP-P é o programa (software) executado em servidor dedicado ou em ambiente de
nuvem com certificado de registro nos termos do art. 91, utilizado exclusivamente para o registro de
jornada e com capacidade para emitir documentos decorrentes da relação do trabalho e realizar controles
de natureza fiscal trabalhista, referentes à entrada e à saída de empregados nos locais de trabalho.

Art. 91. O REP-P deve possuir certificado de registro de programa de computador no Instituto
Nacional da Propriedade Industrial, atender ao art. 78 e aos requisitos elencados no Anexo IX.

Art. 79. O REP-C e o REP-P, definidos no art. 76 e no art. 78, devem emitir ou disponibilizar acesso
  ao comprovante de registro de ponto do trabalhador, que tem como objetivo comprovar o registro de
  marcação realizada pelo empregado, contendo no mínimo as seguintes informações:

  1. cabeçalho contendo o título "Comprovante de Registro de Ponto do Trabalhador";

  2. Número Sequencial de Registro - NSR

  3. identificação do empregador contendo nome, CNPJ/CPF e CEI/CAEPF/CNO, caso exista;

  4.  local da prestação do serviço ou endereço do estabelecimento ao qual o empregado esteja
      vinculado, quando exercer atividade externa ou em instalações de terceiros;

  5.  identificação do trabalhador contendo nome e CPF;


  6. data e horário do respectivo registro;


  7. modelo e número de fabricação, no caso de REP-C, ou número de registro no Instituto
     Nacional da Propriedade Industrial, no caso de REP-P;

  8.  código hash (SHA-256) da marcação, exclusivamente para o REP-P; e


  9. assinatura eletrônica contemplando todos os dados descritos nos incisos I a VIII, no caso de
       comprovante impresso.

Art. 80. O comprovante de registro de ponto do trabalhador pode ter o formato impresso ou de
  arquivo eletrônico.

Parágrafo único. Caso o comprovante de registro de ponto do trabalhador tenha o formato
  eletrônico:

  1. o arquivo deve ter o formato Portable Document Format - PDF e ser assinado
     eletronicamente conforme art. 87 e art. 88;

  2. ao trabalhador deve ser disponibilizado, por meio de sistema eletrônico, acesso ao
     comprovante após cada marcação, independentemente de prévia solicitação e autorização; e

  3.  o empregador deve possibilitar a extração, pelo empregado, dos comprovantes de registro
      de ponto das marcações realizadas, no mínimo, nas últimas quarenta e oito horas.


Art. 81. Todos os tipos de sistema de registro eletrônico de ponto devem gerar o Arquivo Fonte
de Dados, conforme Anexo V.

§ 2º No caso de REP-A e REP-P, o Arquivo Fonte de Dados deve ser prontamente gerado e
entregue, quando solicitado pelo Auditor-Fiscal do Trabalho.


Art. 82. O programa de tratamento de registro de ponto é o conjunto de rotinas informatizadas
que tem por função tratar os dados relativos à marcação dos horários de entrada e saída contidas no
Arquivo Fonte de Dados, gerando o relatório Espelho de Ponto Eletrônico e o Arquivo Eletrônico de
Jornada.

Parágrafo único. A função de tratamento dos dados se limitará a acrescentar informações para
complementar eventuais omissões no registro de ponto, inclusive ausências e movimentações do banco
de horas, ou indicar marcações indevidas

Art. 83. O programa de tratamento de registro de ponto, independentemente do sistema de
registro eletrônico de ponto utilizado, deve gerar o Arquivo Eletrônico de Jornada, conforme Anexo VI, e o
relatório Espelho de Ponto Eletrônico, conforme art. 84.


Art 84.  O relatório Espelho de Ponto Eletrônico gerado pelo programa de tratamento de registro
de ponto deve conter, no mínimo, as seguintes informações:

  1.  identificação do empregador contendo nome, CNPJ/CPF e CEI/CAEPF/CNO, caso exista;

  2. identificação do trabalhador contendo nome, CPF, data de admissão e cargo/função;

  3. data de emissão e período do relatório Espelho de Ponto Eletrônico;

  4. horário e jornada contratual do empregado;

  5. marcações efetuadas no REP e marcações tratadas (incluídas, desconsideradas e préassinaladas) no Programa de Tratamento de Registro de Ponto; e

  6. duração das jornadas realizadas (considerando o horário noturno reduzido, se for o caso).

Parágrafo único. O trabalhador deverá ter acesso às informações constantes do relatório
Espelho de Ponto Eletrônico por meio de sistema informatizado, mensalmente de forma eletrônica ou
impressa ou em prazo inferior, a critério da empresa.

Art. 85. O empregador deverá disponibilizar os arquivos eletrônicos gerados e relatórios
emitidos pelo programa de tratamento de registro de ponto ao Auditor-Fiscal do Trabalho, quando
solicitados, no prazo mínimo de dois dias, a critério deste.


Art. 86. A assinatura eletrônica será utilizada como meio de comprovação da autoria e
integridade de documentos eletrônicos gerados pelo sistema de registro eletrônico de ponto e pelo
programa de tratamento de registro de ponto, nos termos do art. 10 da Medida Provisória nº 2.200-2, de 24
de agosto de 2001.


Parágrafo único. A assinatura eletrônica, do fabricante ou do desenvolvedor, deve ser atribuída
às saídas geradas:


  1. pelo REP: Arquivo Fonte de Dados, Comprovante de Registro de Ponto do Trabalhador e, no
  caso do REP-C, Relação Instantânea de Marcações; e

  1. pelo Programa de Tratamento de Registro de Ponto: Arquivo Eletrônico de Jornada.


Art. 88. As assinaturas eletrônicas geradas pelo REP-A, REP-P e programa de tratamento de
registro de ponto devem utilizar certificados digitais válidos e emitidos por autoridade certificadora
integrante da Infraestrutura de Chaves Públicas Brasileira - ICP-Brasil, constituindo-se em assinaturas
eletrônicas qualificadas, nos termos da Lei nº 14.063, de 23 de setembro de 2020.


Art. 89. Os fabricantes ou desenvolvedores de sistema de registro de ponto e de programa de
tratamento de registro de ponto deverão fornecer à empresa usuária do seu equipamento ou programa o
documento denominado Atestado Técnico e Termo de Responsabilidade, assinado pelo responsável
técnico pelo equipamento ou programa e pelo responsável legal da empresa fabricante ou
desenvolvedora, afirmando expressamente que seu equipamento ou programa atende às determinações
desta Seção.


§ 1º O Atestado Técnico e Termo de Responsabilidade deve ser emitido conforme modelo
especificado no Anexo VII.

§ 2º O Atestado Técnico e Termo de Responsabilidade deve ser emitido na forma de documento
eletrônico, nos termos do art. 10 da Medida Provisória nº 2.200-2, de 2001, e possuir assinatura eletrônica
qualificada, nos termos do inciso III do art. 4° da Lei nº 14.063, de 2020, pertencente exclusivamente à
pessoa física.

§ 3º O arquivo eletrônico que contém o Atestado Técnico e Termo de Responsabilidade deve ter
o formato Portable Document Format - PDF, e o empregador deverá mantê-lo para apresentação à
Inspeção do Trabalho.

§ 4º O empregador somente poderá utilizar o sistema de registro de ponto e de programa de
tratamento de registro de ponto se possuir o Atestado Técnico e Termo de Responsabilidade emitido pelos
fabricantes ou desenvolvedores dos equipamentos ou programas

Art. 91. O REP-P deve possuir certificado de registro de programa de computador no Instituto
Nacional da Propriedade Industrial, atender ao art. 78 e aos requisitos elencados no Anexo IX.



--------------------------------

ANEXO IX
- REQUISITOS DO REGISTRADOR ELETRÔNICO DE PONTOVIA PROGRAMA - REP-P
- O REP-P deve apresentar os seguintes requisitos:
1. Permitir a identificação da organização e do trabalhador.
2. Possuir ou acessar relógio que mantenha sincronismo com a Hora Legal Brasileira (HLB)
   disseminada pelo Observatório Nacional (ON), com uma variação de no máximo 30 (trinta) segundos.

3. Todo coletor de marcação de registro de ponto conectado ao REP-P deve exibir relógio não-analógico contendo horas, minutos e segundos no momento da marcação


4. As marcações registradas realizadas no REP-P devem ser oriundas de coletor on-line
(conectado ao REP-P), podendo excepcionalmente estar off-line (não conectado ao REP-P).


5. No caso de registro off-line, as marcações devem ser enviadas posteriormente no primeiro
   momento em que o coletor entrar em modo on-line (conectado ao REP-P), garantidas as normas de
   segurança da informação contidas nesta Portaria

6. Acesso a meio de armazenamento com redundância, alta disponibilidade e confiabilidade,
   denominado Armazenamento de Registro de Ponto - ARP. As seguintes operações devem ser gravadas na
   ARP:

   a) inclusão ou alteração das informações do empregador, armazenando os dados de data, hora e
   responsável pela inclusão ou alteração; tipo de identificador do empregador (CNPJ ou CPF); identificação
   do empregador; CEI/CAEPF/CNO, caso exista; razão social ou nome; e local da prestação do serviço ou
   endereço do estabelecimento ao qual o empregado esteja vinculado, quando exercer atividade externa ou
   em instalações de terceiros;

   b) ajuste do relógio, armazenando os dados de data antes do ajuste, hora antes do ajuste, data
   ajustada e hora ajustada, além de identificação do responsável pelo ajuste do relógio;
   
   c) inserção, alteração e exclusão de dados de empregado, armazenando os dados de data e
   hora da operação, tipo de operação, número do CPF, nome do empregado e demais dados necessários à
   identificação do trabalhador pelo REP, além de identificação do responsável pela operação;


   d) eventos sensíveis do REP, considerando seus respectivos códigos; e

   e)marcação de ponto, armazenando número do CPF, data e hora da marcação, fuso horário da
   marcação, data e hora da gravação do registro, fuso horário da gravação do registro, identificador do
   coletor e código hash (SHA-256)

OBS: Cada estabelecimento terá sua própria sequência de NSR, consistindo em numeração
sequencial em incrementos unitários, iniciando-se em 1 na primeira operação do REP em relação ao
estabelecimento.


7. Os dados armazenados na ARP não devem ser apagados ou alterados, direta ou
indiretamente, pelo prazo mínimo legal.


1. Realizar marcação de ponto, composta dos seguintes passos:
   
   a) receber de forma inequívoca a identificação do trabalhador, valendo-se de serviços
   informáticos que garantam a disponibilidade permanente desta funcionalidade;

   b) obter a data e a hora de registro do ponto de forma confiável;

   c) registrar a marcação de ponto na ARP; e

   d) disponibilizar Comprovante de Registro de Ponto do Trabalhador conforme arts. 8º e 9º

2. Caso seja adotado o formato impresso para o Comprovante de Registro de Ponto do
Trabalhador, a impressão deverá ser feita em cor contrastante com o papel, em caracteres legíveis com a
densidade horizontal máxima de oito caracteres por centímetro e o caractere não poderá ter altura inferior
a três milímetros.


10. O registro da marcação de ponto gravada na ARP consistirá dos seguintes campos:

   a) NSR

   b)  CPF do Trabalhador;

   c) data da marcação

   d) horário de marcação, composto de hora, minutos e fuso horário;

   e) data da gravação do registro;

   f) horário da gravação do registro, composto de hora, minutos e fuso horário

   g) identificação do coletor; e

   h) código hash (SHA-256).


11. Gerar o Arquivo Fonte de Dados - AFD, a partir dos dados armazenados na ARP, em
conformidade com o Anexo I desta Portaria

12. Possibilitar a geração do AFD para um determinado intervalo temporal.


13. Todos os equipamentos e programas informatizados que integram o REP-P devem
apresentar alta disponibilidade, de modo a não comprometer o serviço de registro de ponto em qualquer
uma de suas etapas.

-------------------------------------------

Anexo V

ARQUIVO FONTE DE DADOS - AFD

O AFD deve:
1. Apresentar o formato predeterminado neste anexo.
2. Apresentar-se no formato texto, codificado no padrão ASCII da norma ISO 8859-1.
3. Apresentar-se com cada linha correspondente a um registro, terminando com os caracteres
13 e 10, respectivamente, da tabela ASCII da norma ISO 8859-1.
4. Ordenar os registros pelo Número Sequencial de Registro - NSR.
5. Não conter linhas em branco.
6. Os tipos dos dados nos campos podem ser:
1. N: numérico;
2. A: alfanumérico;
3. D: data, no formato "AAAA-MM-dd", onde:
4. AAAA: ano;
5. MM: mês;
6. dd: dia do mês; e
7. DH: data e hora, no formato "AAAA-MM-ddThh:mm:00ZZZZZ", onde:
8. AAAA: ano;
9. MM: mês;
10. dd: dia do mês;
11. T: fixo com valor "T";
12. hh: hora (00 a 23);
13. mm: minutos (00 a 59);
14. 00: segundos (fixos com valor "00");
15. ZZZZZ: fuso horário, onde o primeiro digito representa o sinal (positivo ou negativo) e os
outros quatro dígitos representam a hora e os minutos.
16. O preenchimento dos campos deve se iniciar pela esquerda e posições não utilizadas devem
ser preenchidas com espaço.
17. Para os registros dos tipos "1" a "5" deve ser gravado o Código de Verificação de Redundância,
utilizando o CRC-16 (Cyclic Redundancy Check) do registro.
18. O registro do tipo "7" deve utilizar o padrão SHA-256 (Secure Hash Algorithm - 256 bits) na
geração do campo nº 8 (código hash)

19. Ser nomeado pela junção da palavra "AFD" com:
1. para o REP-C: número de fabricação do REP, CNPJ/CPF do empregador e "REP_C";
2. para o REP-A: CNPJ/CPF do empregador e "REP_A"; e
3. para o REP-P: número de registro no INPI, CNPJ/CPF do empregador e "REP_P".
Este arquivo é composto dos seguintes tipos de registro:
OLHAR REGISTROS PAG 87

--------------------------------

ANEXO VI
ARQUIVO ELETRÔNICO DE JORNADA - AEJ

O AEJ deve:
1. Apresentar o formato predeterminado neste anexo.
3. Apresentar-se no formato texto, codificado no padrão ASCII da norma ISO 8859-1.
4. Apresentar-se com cada linha correspondente a um registro, terminando com os caracteres
13 e 10, respectivamente, da tabela ASCII da norma ISO 8859-1.
5. Cada linha do arquivo digital representará um registro e deve conter os campos que estão no
leiaute definido para o registro. Ao final de cada campo, com exceção do último campo do registro, deve
ser inserido o caractere delimitador "|" (pipe ou barra vertical).
6. Não conter linhas em branco.
7. Os tipos dos dados nos campos podem ser:
N: numérico;
A: alfanumérico;
H: hora, no formato "hhmm";
D: data, no formato "AAAA-MM-dd", onde:
1. AAAA: ano;
2. MM: mês;
3. dd: dia do mês; e
2. DH: data e hora, no formato "AAAA-MM-ddThh:mm:00ZZZZZ", onde:
1. AAAA: ano;
2. MM: mês;
3. dd: dia do mês;
4. T: fixo com valor "T";
5. hh: hora (00 a 23);
6. mm: minutos (00 a 59);
7. 00: segundos (fixos com valor "00");
8. ZZZZZ: fuso horário, onde o primeiro digito representa o sinal (positivo ou negativo) e os
outros quatro dígitos representam a hora e os minutos

Este arquivo é composto dos seguintes tipos de registro: OLHAR REGISTROS PAG 91

-----------------------