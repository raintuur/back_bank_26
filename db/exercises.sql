-- todo:
-- C - Create
-- R - Read
-- U - Update
-- D - Delete


-- todo:
-- C - INSERT
-- R - SELECT
-- U - UPDATE
-- D - DELETE

select l.name, status, c.name
from location l
         JOIN city c ON c.id = l.city_id
where c.name = 'Tallinn';


select atm.serial_number, l.name, atm.status
from atm
         JOIN location l on l.id = atm.location_id
         JOIN city c on c.id = l.city_id
         JOIN atm_service_relation asr on atm.id = asr.atm_id
         JOIN atm_service "as" on "as".id = asr.atm_service_id
WHERE c.name = 'Tallinn'
  AND "as".name = 'maksed';


SELECT *
FROM city ORDER BY name;

INSERT INTO "user" (username, password)
VALUES ('Mario', '123');

INSERT INTO customer(first_name, last_name, personal_code, user_id)
VALUES ('Mario', 'Mumm', 'EE001', 2);

UPDATE customer
SET first_name = 'rain', last_name = 'tüür'
WHERE personal_code = 'EE0001';

DELETE
FROM customer
WHERE personal_code = 'EE001';
