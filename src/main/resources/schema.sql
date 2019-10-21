DROP TABLE IF EXISTS recipes;

CREATE TABLE recipes (
                         id LONG AUTO_INCREMENT  PRIMARY KEY,
                         recipe_name VARCHAR(250) NOT NULL,
                         recipe_tag VARCHAR(250) NOT NULL,
                         recipe_description VARCHAR(5000) NOT NULL,
                         recipe_duration INT NOT NULL
);