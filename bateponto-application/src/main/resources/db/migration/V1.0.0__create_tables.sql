CREATE TABLE tbl_registro_ponto (
    id INT NOT NULL AUTO_INCREMENT,
    data_hora_registro_ponto DATETIME,
    latitude VARCHAR (100),
    longitude VARCHAR (100),
    tipo_registro INT,
    PRIMARY KEY (id)
);