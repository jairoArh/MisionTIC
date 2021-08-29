DROP TABLE IF EXISTS EMPLOYEE;
CREATE TABLE EMPLOYEE(
    code VARCHAR(10) NOT NULL PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    date_birthday date NOT NULL,
    gender ENUM('M','F') NOT NULL DEFAULT 'F',
    city VARCHAR(30) NOT NULL,
    salary NUMERIC(12,2) NOT NULL DEFAULT 900000 CHECK (salary > 500000)
);

INSERT INTO EMPLOYEE VALUES('43775','Jose Antonio','Pérez Roncancio',"1993-7-23",'M',"Sogamoso",1500000);
INSERT INTO EMPLOYEE VALUES('87456','Adriana María','Barrera Ortiz','2001-10-7','F','Medellín',1200000);
INSERT INTO EMPLOYEE VALUES('15455','Claudia Patricia','Reyes Hernández','1985-01-30','F','Bogotá D.C',2200000);
INSERT INTO EMPLOYEE VALUES('67374','Magda Johana','Riveros Martínez','2000-6-19','F','Sogamoso',1750000);
INSERT INTO EMPLOYEE VALUES('37475','Leonel Ramiro','Restrepo Condía','1992-4-12','M','Manizalez',890000);
INSERT INTO EMPLOYEE VALUES('93745','Sandra Rocio','Buitrago Lloreda','1991-8-20','F','El Cocuy',950000);
INSERT INTO EMPLOYEE VALUES('58374','Ana María','Velez Jaramillo','2003-2-15','F','Medellín',1300000);
INSERT INTO EMPLOYEE VALUES('87932','Pedro Alberto','Vianchá Correa','1989-09-16','M','Yopal',1000000);
INSERT INTO EMPLOYEE VALUES('17374','Martha Lucía','Bermudez Caro','1978-3-27','F','Ibague',980000);
INSERT INTO EMPLOYEE VALUES('27475','Mario Alberto','Rodríguez Jiménez','1990-11-17','M','Barranquilla',1450000);
INSERT INTO EMPLOYEE VALUES('63747','Carlos Alberto','Díaz Niño','1968-06-27','M','Cali',2500000);
INSERT INTO EMPLOYEE VALUES('83846','Jorge Arturo','López Vargas','1973-12-5','M','Bogotá D.C',3200000);
INSERT INTO EMPLOYEE VALUES('28485','Diana','Niño Cristancho','1985-5-21','F','Medellín',2700000);
INSERT INTO EMPLOYEE VALUES('48374','Carolina Andrea','Martínez Ochoa','1974-3-19','F','Bucaramanga',1300000);
INSERT INTO EMPLOYEE VALUES('62743','Hernando José','Hernández Roa','1992-9-21','M','Tunja',1600000);
INSERT INTO EMPLOYEE VALUES('59384','Ignacio José','Torres Guio','2001-9-1','M','Facatativa',880000);
INSERT INTO EMPLOYEE VALUES('28374','Teresa de Jesús','González Díaz','2001-10-7','F','Chiquinquirá',1000000);
INSERT INTO EMPLOYEE VALUES('18374','Liliana','Fernández Pérez','1989-1-5','F','Girardot',1700000);
INSERT INTO EMPLOYEE VALUES('32424','Nelson Eduardo','Galviz Salamanca','1996-8-19','M','Santa Martha',2200000);
INSERT INTO EMPLOYEE VALUES('62646','Edilberto Jesús','Quesada Mora','1976-5-1','M','Montería',900000);
INSERT INTO EMPLOYEE VALUES('92343','Orlando','Sánchez Pedraza','2001-2-14','M','Aguazul',2300000);
INSERT INTO EMPLOYEE VALUES('22938','Laura Daniela','Zapata Flórez','1982-1-20','F','Pamplona',1400000);
INSERT INTO EMPLOYEE VALUES('58384','Ivonne','Giraldo Perea','1992-3-10','F','San Gil',1600000);
INSERT INTO EMPLOYEE VALUES('78349','Juan David','Rojas Herrera','2002-9-3','M','Melgar',1100000);
INSERT INTO EMPLOYEE VALUES('79944','Camilo Andrés','Correa Bello','1963-2-28','M','El Espino',1250000);
INSERT INTO EMPLOYEE VALUES('29384','Fernando Andrés','Alvárez Botía','1983-4-18','M','Bogota D.C.',3250000);
INSERT INTO EMPLOYEE VALUES('53636','Leidy Paola','Jiménez Rico','1977-3-28','F','Sogamoso',1350000);
INSERT INTO EMPLOYEE VALUES('93734','Samuel David','Avella Sánchez','1995-3-8','M','Sonson',970000);
INSERT INTO EMPLOYEE VALUES('25456','Bertha Cecilia','Neira Rojas','1982-5-18','F','San Luis de Palenque',1620000);
INSERT INTO EMPLOYEE VALUES('38485','Fabio Alejandro','Duarte Rincón','1970-1-11','M','La Dorada',1800000);
INSERT INTO EMPLOYEE VALUES('34543','Roberto Antonio','Olarte Porras','1992-2-21','M','Quibdó',2300000);
INSERT INTO EMPLOYEE VALUES('10033','Carmen Paricia','Pérez Herrera','1983-9-11','f','Palmira',1800000);
INSERT INTO EMPLOYEE VALUES('78287','Elena','Herrera Pineda','1962-12-24','F','Cúcuta',3100000);
