REQUISITOS DO REGISTRADOR ELETRÔNICO DE PONTOVIA PROGRAMA - REP-P 
O REP-P deve apresentar os seguintes requisitos:

1. Permitir a identificação da organização e do trabalhador
2. Possuir ou acessar relógio que mantenha sincronismo com a Hora Legal Brasileira (HLB) disseminada pelo Observatório Nacional (ON), com uma variação de no máximo 30 (trinta) segundos.
3.  Todo coletor de marcação de registro de ponto conectado ao REP-P deve exibir relógio não-analógico contendo horas, minutos e segundos no momento da marcação.
4.  As marcações registradas realizadas no REP-P devem ser oriundas de coletor on-line (conectado ao REP-P), podendo excepcionalmente estar off-line (não conectado ao REP-P).
5.  No caso de registro off-line, as marcações devem ser enviadas posteriormente no primeiro momento em que o coletor entrar em modo on-line (conectado ao REP-P), garantidas as normas de segurança da informação contidas nesta Portaria.
6. Acesso a meio de armazenamento com redundância, alta disponibilidade e confiabilidade, denominado Armazenamento de Registro de Ponto - ARP. As seguintes operações devem ser gravadas na ARP:
	1. inclusão ou alteração das informações do empregador, armazenando os dados de data, hora e responsável pela inclusão ou alteração; tipo de identificador do empregador (CNPJ ou CPF); identificação do empregador; CEI/CAEPF/CNO, caso exista; razão social ou nome; e local da prestação do serviço ou endereço do estabelecimento ao qual o empregado esteja vinculado, quando exercer atividade externa ou em instalações de terceiros;
	2.  ajuste do relógio, armazenando os dados de data antes do ajuste, hora antes do ajuste, data ajustada e hora ajustada, além de identificação do responsável pelo ajuste do relógio;
	3. inserção, alteração e exclusão de dados de empregado, armazenando os dados de data e hora da operação, tipo de operação, número do CPF, nome do empregado e demais dados necessários à identificação do trabalhador pelo REP, além de identificação do responsável pela operação;
	4. eventos sensíveis do REP, considerando seus respectivos códigos; e
	5. marcação de ponto, armazenando número do CPF, data e hora da marcação, fuso horário da marcação, data e hora da gravação do registro, fuso horário da gravação do registro, identificador do coletor e código hash (SHA-256). 
	   OBS: Cada estabelecimento terá sua própria sequência de NSR, consistindo em numeração sequencial em incrementos unitários, iniciando-se em 1 na primeira operação do REP em relação ao estabelecimento
7. Os dados armazenados na ARP não devem ser apagados ou alterados, direta ou indiretamente, pelo prazo mínimo legal.
8. Realizar marcação de ponto, composta dos seguintes passos:
	1. receber de forma inequívoca a identificação do trabalhador, valendo-se de serviços informáticos que garantam a disponibilidade permanente desta funcionalidade; 
	2. obter a data e a hora de registro do ponto de forma confiável; 
	3. registrar a marcação de ponto na ARP; e 
	4. disponibilizar Comprovante de Registro de Ponto do Trabalhador conforme arts. 8º e 9º.
9. Caso seja adotado o formato impresso para o Comprovante de Registro de Ponto do Trabalhador, a impressão deverá ser feita em cor contrastante com o papel, em caracteres legíveis com a densidade horizontal máxima de oito caracteres por centímetro e o caractere não poderá ter altura inferior a três milímetros.
10. O registro da marcação de ponto gravada na ARP consistirá dos seguintes campos:
	1. NSR; 
	2. CPF do Trabalhador; 
	3. data da marcação; 
	4. horário de marcação, composto de hora, minutos e fuso horário; 
	5. data da gravação do registro; 
	6. horário da gravação do registro, composto de hora, minutos e fuso horário; 
	7. identificação do coletor; e 
	8. código hash (SHA-256).
11. Gerar o Arquivo Fonte de Dados - AFD, a partir dos dados armazenados na ARP, em conformidade com o Anexo I desta Portaria.
12.  Possibilitar a geração do AFD para um determinado intervalo temporal
13. Todos os equipamentos e programas informatizados que integram o REP-P devem apresentar alta disponibilidade, de modo a não comprometer o serviço de registro de ponto em qualquer uma de suas etapas.