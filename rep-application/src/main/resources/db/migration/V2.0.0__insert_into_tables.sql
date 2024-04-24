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