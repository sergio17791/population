CREATE TABLE province (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(60) NOT NULL,
	created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 	updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
 	PRIMARY KEY province_pk (id)
)