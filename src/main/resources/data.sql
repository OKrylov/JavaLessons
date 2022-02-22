INSERT INTO faculty (name, color)
VALUES ('Gryffindor', 'Red'),
       ('Slytherin', 'Green'),
       ('Hufflepuf', 'Yellow'),
       ('Ravenclaw', 'Blue');

INSERT INTO student (name, age)
VALUES ('Harry', 29),
       ('Oleg', 29),
       ('Peter', 32);

UPDATE student
SET faculty_id = (SELECT f.id FROM faculty f WHERE f.name = 'Gryffindor')
WHERE faculty_id IS NULL;

INSERT INTO student (name, age)
VALUES ('John', 25),
       ('Ivan', 23),
       ('Eugene', 18);

UPDATE student
SET faculty_id = (SELECT f.id FROM faculty f WHERE f.name = 'Slytherin')
WHERE faculty_id IS NULL;