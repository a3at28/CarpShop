CREATE TABLE manufacturer
(
    id         INTEGER PRIMARY KEY AUTO_INCREMENT,
    brand_name TEXT NOT NULL
);

CREATE TABLE boils
(
    id              INTEGER PRIMARY KEY AUTO_INCREMENT,
    manufacturer_id INTEGER NOT NULL REFERENCES manufacturer,
    name            TEXT    NOT NULL,
    diameter        INTEGER NOT NULL CHECK (diameter > 0),
    weight          INTEGER NOT NULL CHECK (weight > 0),
    quantity        INTEGER NOT NULL DEFAULT 0 CHECK (quantity >= 0),
    imageURL        TEXT,
    price           INTEGER NOT NULL CHECK (price > 0)
);

CREATE TABLE client
(
    id               INTEGER PRIMARY KEY AUTO_INCREMENT,
    name             TEXT NOT NULL,
    number           TEXT NOT NULL,
    email            TEXT NOT NULL,
    shipping_address TEXT NOT NULL
);

CREATE TABLE orders
(
    id          INTEGER PRIMARY KEY AUTO_INCREMENT,
    client_id   INTEGER NOT NULL REFERENCES client,
    payment     BOOLEAN,
    boil_id     INTEGER NOT NULL REFERENCES boils,
    name        TEXT    NOT NULL,
    quantity    INTEGER NOT NULL CHECK (quantity > 0),
    imageURL    TEXT,
    order_price INTEGER NOT NULL CHECK (order_price > 0)
);










