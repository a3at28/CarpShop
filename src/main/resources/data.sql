INSERT INTO manufacturer (id, brand_name)
VALUES (1, 'CCMore'),
       (2, 'Dynamite Baits'),
       (3, 'Fresh Baits'),
       (4, '777 Baits'),
       (5, 'Fun Fishing'),
       (6, 'Richworth'),
       (7, 'StarBaits');

INSERT INTO boils (manufacturer_id, name, diameter, weight, quantity, imageURL, price)
VALUES (1, 'Odyssey XXX', 15, 300, 10, '/media/39bc29cc-0ac0-4b57-a1a2-ab1ae6d23e16.jpeg', 900),
       (2, 'Complex-T', 18, 1000, 14, '/media/38673e33-76b0-4c29-a62c-efc231d2ddc9.jpeg', 1800),
       (3, 'Super', 20, 1000, 21, '/media/1f7bfd30-59c6-45aa-85ad-8389329df974.jpeg', 1300),
       (4, 'Hi Attract', 20, 1000, 4, '/media/1774e33f-94e3-48b4-ae40-91d301299c40.jpeg', 1300),
       (5, 'Classic', 20, 1000, 11, '/media/804bfdd8-853d-4beb-8971-0504dcc85a97.jpeg', 2000),
       (6, 'Euroboilies', 15, 1000, 16, '/media/4ca21163-708b-4c43-9bc4-d2b774f12025.jpeg', 1500),
       (7, 'SIGNAL', 22, 6000, 15, '/media/26acc012-78e9-42a8-a0df-66919bbb1a13.jpeg', 2800);

INSERT INTO client (id, name, number, email, shipping_address)
VALUES (1, 'Максим', '89870072936', 'carpos@gmail.ru', 'Казань'),
       (2, 'Фанус', '89870072939', 'uit@gmail.ru', 'Казань'),
       (3, 'Анатолий', '89870029369', 'kubinkakzn@gmail.ru', 'Верхний Услон'),
       (4, 'Денис', '89870072939', 'denis@gmail.ru', 'Казань'),
       (5, 'Азат', '89870729369', 'a3at28@gmail.ru', 'Зеленодольск');

INSERT INTO orders (id, client_id, payment, boil_id, name, quantity, imageURL, order_price)
VALUES (1, 1, 1, 1, 'Odyssey XXX', 1, '/media/39bc29cc-0ac0-4b57-a1a2-ab1ae6d23e16.jpeg', 900),
       (2, 1, 0, 2, 'Complex-T', 3, '/media/38673e33-76b0-4c29-a62c-efc231d2ddc9.jpeg', 5400 ),
       (3, 1, 1, 3, 'Super', 1, '/media/1f7bfd30-59c6-45aa-85ad-8389329df974.jpeg', 1300 ),
       (4, 1, 1, 1, 'Hi Attract', 2, '/media/1774e33f-94e3-48b4-ae40-91d301299c40.jpeg', 2600);
