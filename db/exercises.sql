-- todo:
--  C - Create
--  R - Read
--  U - Update
--  D - Delete


-- todo:
--  C - INSERT
--  R - SELECT
--  U - UPDATE
--  D - DELETE

SELECT atm.serial_number, l.name, atm.status AS "seisund"
FROM atm
         JOIN location l ON l.id = atm.location_id
         JOIN city c ON c.id = l.city_id
         JOIN atm_service_relation asr ON atm.id = asr.atm_id
         JOIN atm_service "as" ON "as".id = asr.atm_service_id
WHERE c.name = 'Tallinn'
  AND "as".name = 'maksed';

INSERT INTO public."user" (username, password, role_id) VALUES ('rain', '123', 2);

INSERT INTO public.customer (first_name, last_name, personal_code, user_id) VALUES ('Rain', 'Tüür', 'EE0001', 2);


UPDATE customer
SET first_name = 'rain', last_name = 'tüür'
WHERE personal_code = 'EE00001';


s




