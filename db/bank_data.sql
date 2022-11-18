INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Viljandi');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Pärnu');

INSERT INTO public.location (id, city_id, name) VALUES (DEFAULT, 1, 'Tondi Selver');
INSERT INTO public.location (id, city_id, name) VALUES (DEFAULT, 1, 'Jarve Selver');
INSERT INTO public.location (id, city_id, name) VALUES (DEFAULT, 2, 'Tartu Veeriku Selver');
INSERT INTO public.location (id, city_id, name) VALUES (DEFAULT, 3, 'Port Arturi Selver');

INSERT INTO public.atm (id, serial_number, location_id) VALUES (DEFAULT, 'AAA123', 1);
INSERT INTO public.atm (id, serial_number, location_id) VALUES (DEFAULT, 'BBB123', 1);
INSERT INTO public.atm (id, serial_number, location_id) VALUES (DEFAULT, 'CCC123', 4);

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

INSERT INTO public.role (id, type) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, type) VALUES (DEFAULT, 'customer');

INSERT INTO public."user" (id, username, password) VALUES (DEFAULT, 'admin', '123');
INSERT INTO public."user" (username, password) VALUES ('Mario', '123');

INSERT INTO public.customer(first_name, last_name, personal_code, user_id) VALUES ('Mario', 'Mumm', 'EE001', 2);
