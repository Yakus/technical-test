DROP TABLE IF EXISTS logger;

CREATE TABLE logger (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  message VARCHAR(250) NOT NULL,
  code VARCHAR(250) NOT NULL
);

INSERT INTO logger (message, code) VALUES
  ('message 1', 'INFO'),
  ('message 2', 'WARNING'),
  ('message 3', 'ERROR');