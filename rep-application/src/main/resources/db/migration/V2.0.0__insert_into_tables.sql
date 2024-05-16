INSERT INTO TBL_COLETOR_REGISTRO (cod_idef_coletor_registro, descricao) VALUES
(01, 'aplicativo mobile'),
(02, 'browser (navegador internet)'),
(03, 'aplicativo desktop'),
(04, 'dispositivo eletrônico'),
(05, 'outro dispositivo eletrônico não especificado');

INSERT INTO TBL_TIPO_MARCACAO (cod_tipo_marcacao, descricao) VALUES
('E', 'marcação de entrada'),
('S', 'marcação de saída'),
('D', 'marcação desconsiderada');

INSERT INTO TBL_FONTE_MARCACAO (cod_fonte_marcacao, descricao) VALUES
('O', 'marcação original do REP'),
('I', 'marcação incluída manualmente'),
('P', 'marcação pré-assinalada');

INSERT INTO DB_REP.TBL_USUARIO (id_usuario, user_login, user_password, user_email) VALUES
('c54fcea1-b172-4c7c-8df4-fee205c0e97d', 'biondo', '12345', 'usuarioExemplo@email.com');

INSERT INTO DB_REP.TBL_TELEFONE (id_telefone, telefone, cod_operadora, whatsapp) VALUES
('594beb80-619c-4a5d-bac4-39eaae7c08ef', '99630-9395', '43', 1);

INSERT INTO DB_REP.TBL_EMPRESA (id_empresa, num_seq_registro, nome_empresa, razao_social, tipo_idef_empregador, cnpj, cpf, cod_idef_cei, cod_idef_caepf, cod_idef_cno, data_hora_inclusao_alteracao, tipo_operacao_inclusao_alteracao, id_telefone, id_usuario_inclusao_alteracao) VALUES
('56023a7e-7c21-4548-9f80-8a02069f9901', 0, 'Empresa Exemplo', 'Empresa Exemplo Ltda', 'A', 12345678901234, '12345678901', '123456', 12345678901234, 12345678901234, '2024-04-24 07:19:13', 'I', '594beb80-619c-4a5d-bac4-39eaae7c08ef', 'c54fcea1-b172-4c7c-8df4-fee205c0e97d');

INSERT INTO DB_REP.TBL_EMPR_ENDC (id_endereco, logradouro, numero, cep, bairro, cidade, pais, excluido, id_empresa) VALUES
('9f9a3bc1-7e5e-4ade-b71b-3c116c627217', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 0, '56023a7e-7c21-4548-9f80-8a02069f9901');

INSERT INTO DB_REP.TBL_HORARIO_CONTRATUAL (cod_hora_contratual, duracao_jornada, hora_primeira_entrada, hora_primeira_saida, hora_segunda_entrada, hora_segunda_saida) VALUES
(1, 500, '09:00:00', '12:00:00', '13:00:00', '18:00:00');

INSERT INTO DB_REP.TBL_EMPREGADO (id_empregado, num_seq_registro, emp_nome, cpf, data_admissao, email, departamento, cargo, banco, agencia, conta, cod_idef_ctps, cod_idef_caepf, cod_idef_cno, cod_matricula_esocial, excluido, id_empresa_endereco, cod_horario_contratual, id_telefone, id_empresa) VALUES
('576475e7-e365-4d71-be93-f8182866e102', 1, 'João Silva', '123.456.789-00', '2023-01-01', 'joao.silva@example.com', 'Desenvolvimento', 'Desenvolvedor', '341', '1234', '56789-0', 'CTPS123', 'CAEPF123', 'CNO123', 'ESOCIAL123', 0, '9f9a3bc1-7e5e-4ade-b71b-3c116c627217', 1, '594beb80-619c-4a5d-bac4-39eaae7c08ef', '56023a7e-7c21-4548-9f80-8a02069f9901');

