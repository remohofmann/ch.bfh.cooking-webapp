;
CREATE USER IF NOT EXISTS "SA" SALT '4ee1ca1a83082f1a' HASH '509fab4298b1a3929a3ca47f5f5c7f80ef8bd6dee5414851e1db9d85994da559' ADMIN;          
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_757C4DB4_553D_43B0_B4F4_C2BE4F768BF3" START WITH 15 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."INGREDIENT_SEQ" START WITH 50;       
CREATE SEQUENCE "PUBLIC"."ROLE_SEQ" START WITH 250 INCREMENT BY 100;           
CREATE SEQUENCE "PUBLIC"."UNIT_SEQ" START WITH 50 INCREMENT BY 100;            
CREATE SEQUENCE "PUBLIC"."RECIPE_SEQ" START WITH 50;           
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_03BE50E2_FCFB_4373_860A_DAA537A7E88A" START WITH 24 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_CCE6CCBE_B6DF_4BF6_B3B7_9F5E519D6EA5" START WITH 17 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."TAG_SEQ" START WITH 50 INCREMENT BY 100;             
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_F5A6C033_C798_4C55_B41D_7A70A5B5DD97" START WITH 52 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."RECIPE_INGREDIENT_SEQ" START WITH 50 INCREMENT BY 100;               
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_15671EEB_C427_4DB7_B3F3_9551CE805000" START WITH 2 BELONGS_TO_TABLE; 
CREATE SEQUENCE "PUBLIC"."RECIPE_TAG_SEQ" START WITH 50 INCREMENT BY 100;      
CREATE SEQUENCE "PUBLIC"."USER_SEQ" START WITH 250 INCREMENT BY 100;           
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_014D8B04_75EC_401B_A4A5_4ECEFF55FD11" START WITH 14 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_00F21074_DDD1_48E0_AB73_056A37BC0EAA" START WITH 33 BELONGS_TO_TABLE;
CREATE MEMORY TABLE "PUBLIC"."ROLE"(
    "ID" LONG DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_F5A6C033_C798_4C55_B41D_7A70A5B5DD97") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_F5A6C033_C798_4C55_B41D_7A70A5B5DD97",
    "NAME" VARCHAR NOT NULL
);  
ALTER TABLE "PUBLIC"."ROLE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_2" PRIMARY KEY("ID");          
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.ROLE;     
INSERT INTO "PUBLIC"."ROLE" VALUES
(50, 'ADMIN'),
(51, 'USER');
CREATE MEMORY TABLE "PUBLIC"."RECIPE"(
    "ID" LONG DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_014D8B04_75EC_401B_A4A5_4ECEFF55FD11") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_014D8B04_75EC_401B_A4A5_4ECEFF55FD11",
    "RECIPE_NAME" VARCHAR(250) NOT NULL,
    "RECIPE_DESCRIPTION" VARCHAR(5000) NOT NULL,
    "RECIPE_DURATION" INT NOT NULL
);               
ALTER TABLE "PUBLIC"."RECIPE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8" PRIMARY KEY("ID");        
-- 13 +/- SELECT COUNT(*) FROM PUBLIC.RECIPE;  
INSERT INTO "PUBLIC"."RECIPE" VALUES
(1, STRINGDECODE('R\u00f6sti'), 'Raffeln, anbraten', 30),
(2, STRINGDECODE('Z\u00fcrcher Geschnetzeltes'), 'Raffeln, anbraten', 60),
(3, 'Spaghetti Bolognese', STRINGDECODE('Hackfleisch anbraten, mit Zwiebeln, Gem\u00fcse und Tomaten 2h kochen lassen, 10 minuten vor Schluss Nudeln kochen.'), 120),
(4, 'Nudeln allarrabbiata', STRINGDECODE('Nudeln vorkochen, Zwiebeln mit Chilis anbraten, Tomaten dazu, f\u00fcr 20 minuten kochen lassen'), 40),
(5, 'Paneng Curry', 'Raffeln, anbraten', 50),
(6, 'Chicken Nuggets mit Pommes', STRINGDECODE('Alles in die Fritteuse f\u00fcr 10 minuten'), 10),
(7, 'Sandwich', 'Brot schneiden, Butter oder Mayonnaise drauf, nach Wahl belegen', 10),
(8, 'Austern', 'Im Wasser Kochen, Pommes dazu in den Backofen', 30),
(9, 'Kartoffelgratin', 'Schneiden, kochen, backen', 30),
(10, STRINGDECODE('K\u00e4sesp\u00e4tzle'), STRINGDECODE('Anbraten, K\u00e4se dr\u00fcber, kochen lassen'), 30),
(11, 'Stroganoff', STRINGDECODE('Reis vorkochen, Fleisch anbraten, Gem\u00fcse dazu und 20 minuten weiterkochen'), 50),
(12, 'Rindssteak', 'Reis vorkochen, Fleisch anbraten', 30),
(13, STRINGDECODE('P\u00fcrierte Gem\u00fcsesuppe'), STRINGDECODE('Saisongem\u00fcse grob schneiden, 30 Minuten in Bouillon kochen, p\u00fcrieren'), 35);        
CREATE MEMORY TABLE "PUBLIC"."TAG"(
    "ID" LONG DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_757C4DB4_553D_43B0_B4F4_C2BE4F768BF3") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_757C4DB4_553D_43B0_B4F4_C2BE4F768BF3",
    "TAG_NAME" VARCHAR(64) NOT NULL,
    "TAG_TYPE" ENUM('cuisine', 'diet', 'course')
);         
ALTER TABLE "PUBLIC"."TAG" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("ID");           
-- 14 +/- SELECT COUNT(*) FROM PUBLIC.TAG;     
INSERT INTO "PUBLIC"."TAG" VALUES
(1, 'Indian', 'cuisine'),
(2, 'Swiss', 'cuisine'),
(3, 'Austrian', 'cuisine'),
(4, 'French', 'cuisine'),
(5, 'Japanese', 'cuisine'),
(6, 'Chinese', 'cuisine'),
(7, 'American', 'cuisine'),
(8, 'Gluten free', 'diet'),
(9, 'Vegetarian', 'diet'),
(10, 'Vegan', 'diet'),
(11, 'Paleo', 'diet'),
(12, 'Breakfast', 'course'),
(13, 'Lunch', 'course'),
(14, 'Dinner', 'course');             
CREATE MEMORY TABLE "PUBLIC"."UNIT"(
    "ID" LONG DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_15671EEB_C427_4DB7_B3F3_9551CE805000") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_15671EEB_C427_4DB7_B3F3_9551CE805000",
    "UNIT_NAME" VARCHAR(64) NOT NULL
);         
ALTER TABLE "PUBLIC"."UNIT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_27" PRIMARY KEY("ID");         
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.UNIT;     
INSERT INTO "PUBLIC"."UNIT" VALUES
(1, 'Tablespoon');          
CREATE MEMORY TABLE "PUBLIC"."INGREDIENT"(
    "ID" LONG DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_03BE50E2_FCFB_4373_860A_DAA537A7E88A") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_03BE50E2_FCFB_4373_860A_DAA537A7E88A",
    "INGREDIENT_NAME" VARCHAR(64) NOT NULL,
    "INGREDIENT_UNIT_ID" LONG
);              
ALTER TABLE "PUBLIC"."INGREDIENT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_10" PRIMARY KEY("ID");   
-- 23 +/- SELECT COUNT(*) FROM PUBLIC.INGREDIENT;              
INSERT INTO "PUBLIC"."INGREDIENT" VALUES
(1, 'Milk', 1),
(2, 'Eggs', 1),
(3, 'Chicken', 1),
(4, 'Celery', 1),
(5, 'Apples', 1),
(6, 'Oranges', 1),
(7, 'Rice', 1),
(8, 'Noodles', 1),
(9, 'Mustard', 1),
(10, 'Butter', 1),
(11, 'Oil', 1),
(12, 'Olives', 1),
(13, 'Garlic', 1),
(14, 'Onions', 1),
(15, 'Pepper', 1),
(16, 'Salt', 1),
(17, 'Flour', 1),
(18, 'Potatoes', 1),
(19, 'Gruyere', 1),
(20, 'Beef', 1),
(21, 'Lemongrass', 1),
(22, 'Curry powder', 1),
(23, 'Eggplant', 1);      
CREATE MEMORY TABLE "PUBLIC"."RECIPE_INGREDIENT"(
    "ID" LONG DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_CCE6CCBE_B6DF_4BF6_B3B7_9F5E519D6EA5") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_CCE6CCBE_B6DF_4BF6_B3B7_9F5E519D6EA5",
    "RECIPE_ID" LONG NOT NULL,
    "INGREDIENT_ID" LONG NOT NULL
);
ALTER TABLE "PUBLIC"."RECIPE_INGREDIENT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_7" PRIMARY KEY("ID");             
-- 16 +/- SELECT COUNT(*) FROM PUBLIC.RECIPE_INGREDIENT;       
INSERT INTO "PUBLIC"."RECIPE_INGREDIENT" VALUES
(1, 1, 18),
(2, 2, 20),
(3, 2, 1),
(4, 3, 8),
(5, 4, 8),
(6, 5, 23),
(7, 6, 3),
(8, 7, 19),
(9, 8, 15),
(10, 9, 18),
(11, 9, 1),
(12, 9, 19),
(13, 10, 19),
(14, 11, 20),
(15, 12, 20),
(16, 13, 23);          
CREATE MEMORY TABLE "PUBLIC"."RECIPE_TAG"(
    "ID" LONG DEFAULT (NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_00F21074_DDD1_48E0_AB73_056A37BC0EAA") NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_00F21074_DDD1_48E0_AB73_056A37BC0EAA",
    "RECIPE_ID" LONG NOT NULL,
    "TAG_ID" LONG NOT NULL
);              
ALTER TABLE "PUBLIC"."RECIPE_TAG" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_80" PRIMARY KEY("ID");   
-- 32 +/- SELECT COUNT(*) FROM PUBLIC.RECIPE_TAG;              
INSERT INTO "PUBLIC"."RECIPE_TAG" VALUES
(1, 1, 2),
(2, 1, 8),
(3, 1, 9),
(4, 1, 10),
(5, 1, 12),
(6, 2, 2),
(7, 2, 14),
(8, 3, 4),
(9, 3, 13),
(10, 4, 4),
(11, 4, 14),
(12, 5, 8),
(13, 5, 9),
(14, 5, 10),
(15, 6, 7),
(16, 6, 11),
(17, 6, 13),
(18, 7, 7),
(19, 7, 13),
(20, 8, 11),
(21, 8, 13),
(22, 9, 4),
(23, 9, 9),
(24, 9, 14),
(25, 10, 3),
(26, 10, 9),
(27, 11, 11),
(28, 11, 14),
(29, 12, 11),
(30, 12, 14),
(31, 13, 9),
(32, 13, 10);       
CREATE MEMORY TABLE "PUBLIC"."USER"(
    "ID" BIGINT NOT NULL,
    "FIRST_NAME" VARCHAR(255),
    "LAST_NAME" VARCHAR(255),
    "MAIL" VARCHAR(255),
    "PASSWORD" VARCHAR(255),
    "USERNAME" VARCHAR(255)
);               
ALTER TABLE "PUBLIC"."USER" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_27E" PRIMARY KEY("ID");        
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.USER;     
INSERT INTO "PUBLIC"."USER" VALUES
(50, 'Admin', 'Istrator', 'admin@admin', '$2a$10$SrxxAUsZKKf4//eBqR.3XOouNgABNCmU1fwoFBQ1InnJnFtZQvaly', 'admin'),
(51, 'Normal', 'Dude', 'user@user', '$2a$10$3rf/Ase0RR6nKda1yOejQeh1HnvOniRrfY8vf5wgr0PrXkR9Vx2gO', 'dude');             
CREATE MEMORY TABLE "PUBLIC"."USER_ROLES"(
    "USERS_ID" BIGINT NOT NULL,
    "ROLES_ID" BIGINT NOT NULL
);   
ALTER TABLE "PUBLIC"."USER_ROLES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_C" PRIMARY KEY("USERS_ID", "ROLES_ID");  
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.USER_ROLES;               
INSERT INTO "PUBLIC"."USER_ROLES" VALUES
(50, 51),
(50, 50),
(51, 51);         
ALTER TABLE "PUBLIC"."INGREDIENT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_109" FOREIGN KEY("INGREDIENT_UNIT_ID") REFERENCES "PUBLIC"."UNIT"("ID") NOCHECK;         
ALTER TABLE "PUBLIC"."RECIPE_INGREDIENT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_7C" FOREIGN KEY("RECIPE_ID") REFERENCES "PUBLIC"."RECIPE"("ID") NOCHECK;          
ALTER TABLE "PUBLIC"."RECIPE_INGREDIENT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_7CB" FOREIGN KEY("INGREDIENT_ID") REFERENCES "PUBLIC"."INGREDIENT"("ID") NOCHECK; 
ALTER TABLE "PUBLIC"."USER_ROLES" ADD CONSTRAINT "PUBLIC"."FKJ9553ASS9UCTJRMH0GKQSMV0D" FOREIGN KEY("ROLES_ID") REFERENCES "PUBLIC"."ROLE"("ID") NOCHECK;      
ALTER TABLE "PUBLIC"."USER_ROLES" ADD CONSTRAINT "PUBLIC"."FK7ECYOBAA59VXKXCKG6T355L86" FOREIGN KEY("USERS_ID") REFERENCES "PUBLIC"."USER"("ID") NOCHECK;      
ALTER TABLE "PUBLIC"."RECIPE_TAG" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_80A4" FOREIGN KEY("TAG_ID") REFERENCES "PUBLIC"."TAG"("ID") NOCHECK;     
ALTER TABLE "PUBLIC"."RECIPE_TAG" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_80A" FOREIGN KEY("RECIPE_ID") REFERENCES "PUBLIC"."RECIPE"("ID") NOCHECK;
