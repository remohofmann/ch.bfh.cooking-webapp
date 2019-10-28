DROP TABLE IF EXISTS recipe;
DROP TABLE IF EXISTS ingredient;
DROP TABLE IF EXISTS tag;
DROP TABLE IF EXISTS unit;
DROP TABLE IF EXISTS search_category;

CREATE TABLE recipe (
                         id LONG AUTO_INCREMENT  PRIMARY KEY,
                         recipe_name VARCHAR(250) NOT NULL,
                         recipe_tag VARCHAR(250) NOT NULL,
                         recipe_description VARCHAR(5000) NOT NULL,
                         recipe_duration INT NOT NULL
);

CREATE TABLE tag (
                        id LONG AUTO_INCREMENT PRIMARY KEY,
                        tag_name VARCHAR(64) NOT NULL
);

CREATE TABLE unit (
                        id LONG AUTO_INCREMENT PRIMARY KEY,
                        unit_name VARCHAR(64) NOT NULL
);

CREATE TABLE ingredient (
                        id LONG AUTO_INCREMENT PRIMARY KEY,
                        ingredient_name VARCHAR(64) NOT NULL,
                        ingredient_unit VARCHAR
);