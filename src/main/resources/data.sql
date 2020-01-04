INSERT INTO recipe (recipe_name, recipe_description, recipe_duration) VALUES
  ('Rösti', 'Raffeln, anbraten', 30),
  ('Zürcher Geschnetzeltes', 'Raffeln, anbraten', 60),
  ('Spaghetti Bolognese', 'Hackfleisch anbraten, mit Zwiebeln, Gemüse und Tomaten 2h kochen lassen, 10 minuten vor Schluss Nudeln kochen.', 120),
  ('Nudeln allarrabbiata', 'Nudeln vorkochen, Zwiebeln mit Chilis anbraten, Tomaten dazu, für 20 minuten kochen lassen', 40),
  ('Paneng Curry', 'Raffeln, anbraten', 50),
  ('Chicken Nuggets mit Pommes', 'Alles in die Fritteuse für 10 minuten', 10),
  ('Sandwich', 'Brot schneiden, Butter oder Mayonnaise drauf, nach Wahl belegen', 10),
  ('Austern', 'Im Wasser Kochen, Pommes dazu in den Backofen', 30),
  ('Kartoffelgratin', 'Schneiden, kochen, backen', 30),
  ('Käsespätzle', 'Anbraten, Käse drüber, kochen lassen', 30),
  ('Stroganoff', 'Reis vorkochen, Fleisch anbraten, Gemüse dazu und 20 minuten weiterkochen', 50),
  ('Rindssteak', 'Reis vorkochen, Fleisch anbraten', 30),
  ('Pürierte Gemüsesuppe', 'Saisongemüse grob schneiden, 30 Minuten in Bouillon kochen, pürieren', 35);

INSERT  INTO tag (id, tag_name, tag_type) VALUES
    ('1', 'Indian', 'cuisine'),
    ('2', 'Swiss', 'cuisine'),
    ('3', 'Austrian', 'cuisine'),
    ('4', 'French', 'cuisine'),
    ('5', 'Japanese', 'cuisine'),
    ('6', 'Chinese', 'cuisine'),
    ('7', 'American', 'cuisine'),

    ('8', 'Gluten free', 'diet'),
    ('9', 'Vegetarian', 'diet'),
    ('10', 'Vegan', 'diet'),
    ('11', 'Paleo', 'diet'),

    ('12', 'Breakfast', 'course'),
    ('13', 'Lunch', 'course'),
    ('14', 'Dinner', 'course');

INSERT INTO recipe_tag (recipe_id, tag_id) VALUES
    ('1', '2'),
    ('1', '8'),
    ('1', '9'),
    ('1', '10'),
    ('1', '12'),

    ('2', '2'),
    ('2', '14'),

    ('3', '4'),
    ('3', '13'),

    ('4', '4'),
    ('4', '14'),

    ('5', '8'),
    ('5', '9'),
    ('5', '10'),

    ('6', '7'),
    ('6', '11'),
    ('6', '13'),

    ('7', '7'),
    ('7', '13'),

    ('8', '11'),
    ('8', '13'),

    ('9', '4'),
    ('9', '9'),
    ('9', '14'),

    ('10', '3'),
    ('10', '9'),

    ('11', '11'),
    ('11', '14'),

    ('12', '11'),
    ('12', '14'),

    ('13', '9'),
    ('13', '10');

INSERT INTO unit (id, unit_name) VALUES
    (1, 'Tablespoon');

INSERT INTO ingredient (ingredient_name, ingredient_unit_id) VALUES
    ('Milk', 1),
    ('Eggs', 1),
    ('Chicken', 1),
    ('Celery', 1),
    ('Apples', 1),
    ('Oranges', 1),
    ('Rice', 1),
    ('Noodles', 1),
    ('Mustard',1),
    ('Butter',1),
    ('Oil', 1),
    ('Olives', 1),
    ('Garlic', 1),
    ('Onions', 1),
    ('Pepper', 1),
    ('Salt', 1),
    ('Flour', 1),
    ('Potatoes', 1),
    ('Gruyere', 1),
    ('Beef',1),
    ('Lemongrass', 1),
    ('Curry powder', 1),
    ('Eggplant', 1);

