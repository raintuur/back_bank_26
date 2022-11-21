INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Pärnu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Viljandi');

INSERT INTO public.location (id, city_id, name) VALUES (DEFAULT, 1, 'Järve Selver');
INSERT INTO public.location (id, city_id, name) VALUES (DEFAULT, 1, 'Tondi Selver');
INSERT INTO public.location (id, city_id, name) VALUES (DEFAULT, 3, 'Port Arturi Selver');
INSERT INTO public.location (id, city_id, name) VALUES (DEFAULT, 2, 'Veeriku Selver');



INSERT INTO public.atm (id, serial_number, location_id) VALUES (DEFAULT, 'AAA', 1);
INSERT INTO public.atm (id, serial_number, location_id) VALUES (DEFAULT, 'BBB', 1);
INSERT INTO public.atm (id, serial_number, location_id) VALUES (DEFAULT, 'CCC', 3);
INSERT INTO public.atm (id, serial_number, location_id) VALUES (DEFAULT, 'DDD', 4);

INSERT INTO public.option (id, name) VALUES (DEFAULT, 'raha välja');
INSERT INTO public.option (id, name) VALUES (DEFAULT, 'raha sisse');
INSERT INTO public.option (id, name) VALUES (DEFAULT, 'maksed');

INSERT INTO public.atm_option (id, atm_id, option_id) VALUES (DEFAULT, 1, 1);
INSERT INTO public.atm_option (id, atm_id, option_id) VALUES (DEFAULT, 1, 2);
INSERT INTO public.atm_option (id, atm_id, option_id) VALUES (DEFAULT, 1, 3);
INSERT INTO public.atm_option (id, atm_id, option_id) VALUES (DEFAULT, 2, 1);
INSERT INTO public.atm_option (id, atm_id, option_id) VALUES (DEFAULT, 2, 2);
INSERT INTO public.atm_option (id, atm_id, option_id) VALUES (DEFAULT, 3, 1);
INSERT INTO public.atm_option (id, atm_id, option_id) VALUES (DEFAULT, 3, 2);
INSERT INTO public.atm_option (id, atm_id, option_id) VALUES (DEFAULT, 4, 1);


INSERT INTO public.role (id, type) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type) VALUES (DEFAULT, 'customer');

INSERT INTO public."user" (id, username, password, role_id) VALUES (DEFAULT, 'admin', '123', 1);
insert into public."user" (username, password, role_id) values ('Mai', '123', 2);

insert into public.customer (first_name, last_name, personal_code, user_id) values ('Mai', 'Kaseoja', 'EE000134', 2);