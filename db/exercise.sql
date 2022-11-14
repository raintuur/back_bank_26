-- todo:
--  C - Create
--  R - Read
--  U - Update
--  D - Delete

-- todo: SQL-is
--  C - INSERT
--  R - SELECT
--  U - UPDATE
--  D - DELETE

-- select name, status, city_id
-- from location where city_id=1;

--select l.name, status
--from location l join city c on c.id = l.city_id where c.name='Tallinn';

select atm.serial_number, l.name, atm.status
from atm
         join location l on atm.location_id = l.id
         join city c on c.id = l.city_id
         join atm_service_relation asr on atm.id = asr.atm_id
         join atm_service "as" on asr.atm_service_id = "as".id
where c.name = 'Tallinn'
  and "as".name = 'maksed'
;

insert into "user" (username, password, role_id)
values ('Mai', '123', 2);

insert into customer (first_name, last_name, personal_code, user_id)
values ('Mai', 'Kaseoja', 'EE000134', 2);

update customer
set first_name = 'rain', last_name = 'tüür'
where personal_code = 'EE00001';


-- kustutamisel peab suhtes (joones) panema cascading

delete
from customer
where personal_code = 'EE000134';

delete
from "user"
where id= 2;



