CREATE TABLE `books` (
  `idBook` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT 'null',
  `author` varchar(45) DEFAULT 'null',
  `price` double NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`idBook`),
  UNIQUE KEY `idbook_UNIQUE` (`idBook`)
)