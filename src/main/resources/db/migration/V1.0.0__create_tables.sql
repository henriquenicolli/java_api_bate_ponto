CREATE TABLE tbl_registro_ponto (
    id INT NOT NULL AUTO_INCREMENT,
    data_hora_registro_ponto datetime,
    latitude VARCHAR (100),
    longitude VARCHAR (100),
    PRIMARY KEY (id)
);