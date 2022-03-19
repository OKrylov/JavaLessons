CREATE TABLE drivers
(
    id      SMALLSERIAL PRIMARY KEY,
    name    VARCHAR(20),
    age     SMALLINT NOT NULL CHECK (age > 0),
    license BOOLEAN  NOT NULL DEFAULT false,
    car_id  SMALLINT REFERENCES cars (id)
);

CREATE TABLE cars
(
    id    SMALLSERIAL PRIMARY KEY,
    brand VARCHAR(20) NOT NULL,
    model VARCHAR(20) NOT NULL,
    cost  INTEGER     NOT NULL CHECK (cost > 0)
);