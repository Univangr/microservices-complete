DROP TABLE IF EXISTS UNIVAN_SCHEMA.EMPLOYEES;

DROP SCHEMA IF EXISTS UNIVAN_SCHEMA;

CREATE SCHEMA IF NOT EXISTS UNIVAN_SCHEMA;
 
CREATE TABLE IF NOT EXISTS UNIVAN_SCHEMA.EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);
 
INSERT INTO UNIVAN_SCHEMA.EMPLOYEES (first_name, last_name, career) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');