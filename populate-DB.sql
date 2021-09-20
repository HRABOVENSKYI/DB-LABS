-- call_address
INSERT INTO `hrabovenskyi`.`call_address` (`region`, `city_or_village`, `street`, `building`, `flat`) VALUES ('Lviv', 'Lviv', 'Skoryny', '55', '12');
INSERT INTO `hrabovenskyi`.`call_address` (`region`, `city_or_village`, `street`, `building`, `flat`) VALUES ('Lviv', 'Lviv', 'Skoryny', '29', '108');
INSERT INTO `hrabovenskyi`.`call_address` (`region`, `city_or_village`, `place`) VALUES ('Lviv', 'Lviv', 'Near theatre of opera and ballet');
INSERT INTO `hrabovenskyi`.`call_address` (`region`, `city_or_village`, `place`) VALUES ('Lviv', 'Svirzh', 'Near church');
INSERT INTO `hrabovenskyi`.`call_address` (`region`, `city_or_village`, `place`) VALUES ('Lviv', 'Yasninska', 'Lake near the park');
INSERT INTO `hrabovenskyi`.`call_address` (`region`, `city_or_village`, `street`, `place`) VALUES ('Odessa', 'Zatoka', 'Soniachna', 'Poligraphist camp');
INSERT INTO `hrabovenskyi`.`call_address` (`region`, `city_or_village`, `street`, `building`, `place`) VALUES ('Lviv', 'Lviv', 'Promyslova', '13', 'Roof');
INSERT INTO `hrabovenskyi`.`call_address` (`region`, `city_or_village`, `street`, `building`, `flat`) VALUES ('Lviv', 'Lviv', 'Stryiska', '118', '23');
INSERT INTO `hrabovenskyi`.`call_address` (`region`, `city_or_village`, `place`) VALUES ('Lviv', 'Navariya', 'On the lake');
INSERT INTO `hrabovenskyi`.`call_address` (`region`, `city_or_village`, `street`, `building`, `flat`) VALUES ('Lviv', 'Lviv', 'Promyslova', '118', '23');

-- reporter
INSERT INTO `hrabovenskyi`.`reporter` (`phone_number`, `surname`, `name`) VALUES ('380440609242', 'Nicholson', 'Jack');
INSERT INTO `hrabovenskyi`.`reporter` (`phone_number`, `surname`, `name`) VALUES ('380449209451', 'Marlon', 'Brando');
INSERT INTO `hrabovenskyi`.`reporter` (`phone_number`, `surname`, `name`) VALUES ('380635556157', 'De Nitro', 'Robert');
INSERT INTO `hrabovenskyi`.`reporter` (`phone_number`, `surname`, `name`) VALUES ('380395552787', 'Al', 'Pacino');
INSERT INTO `hrabovenskyi`.`reporter` (`phone_number`, `surname`, `name`) VALUES ('380395559610', 'Hoffman', 'Dustin');
INSERT INTO `hrabovenskyi`.`reporter` (`phone_number`, `surname`, `name`) VALUES ('380635554248', 'Hanks', 'Tom');
INSERT INTO `hrabovenskyi`.`reporter` (`phone_number`, `surname`, `name`) VALUES ('380505557912', 'Hopkins', 'Anthony');
INSERT INTO `hrabovenskyi`.`reporter` (`phone_number`, `surname`, `name`) VALUES ('380505556432', 'Newman', 'Paul');
INSERT INTO `hrabovenskyi`.`reporter` (`phone_number`, `surname`, `name`) VALUES ('380417155524', 'Trasy', 'Spencer');

-- call
INSERT INTO `hrabovenskyi`.`call` (`reporter_phone_number`, `short_description`, `detailed_description`, `call_address_id`, `call_time`) VALUES ('380440609242', 'Boy broke his leg', 'Jumped down from the tree', '3', '2006-12-30 00:38:54.840');
INSERT INTO `hrabovenskyi`.`call` (`reporter_phone_number`, `short_description`, `detailed_description`, `call_address_id`, `call_time`) VALUES ('380440609242', 'Boy broke his arm', 'During soccer', '5', '2006-12-31 00:38:54.840000');
INSERT INTO `hrabovenskyi`.`call` (`reporter_phone_number`, `short_description`, `call_address_id`, `call_time`) VALUES ('380449209451', 'Car stuck in the mud', '9', '2007-12-31 00:38:54.840000');
INSERT INTO `hrabovenskyi`.`call` (`reporter_phone_number`, `short_description`, `call_address_id`, `call_time`) VALUES ('380635556157', 'House on fire', '5', '2007-12-31 00:38:54.840000');
INSERT INTO `hrabovenskyi`.`call` (`reporter_phone_number`, `short_description`, `call_address_id`, `call_time`) VALUES ('380635554248', 'Car crash', '3', '2007-12-31 00:38:54.840000');
INSERT INTO `hrabovenskyi`.`call` (`reporter_phone_number`, `short_description`, `call_address_id`, `call_time`) VALUES ('380417155524', 'Robbery', '4', '2006-12-31 00:38:54.840000');
INSERT INTO `hrabovenskyi`.`call` (`reporter_phone_number`, `short_description`, `call_address_id`, `call_time`) VALUES ('380417155524', 'Flood', '2', '2008-12-31 00:38:54.840000');
INSERT INTO `hrabovenskyi`.`call` (`reporter_phone_number`, `short_description`, `call_address_id`, `call_time`) VALUES ('380505556432', 'Robbery', '6', '2008-12-31 00:38:54.840000');
INSERT INTO `hrabovenskyi`.`call` (`reporter_phone_number`, `short_description`, `call_address_id`, `call_time`) VALUES ('380505556432', 'Car crash', '7', '2008-12-31 00:38:54.840000');
INSERT INTO `hrabovenskyi`.`call` (`reporter_phone_number`, `short_description`, `call_address_id`, `call_time`) VALUES ('380417155524', 'Flood', '1', '2008-12-31 00:38:54.840000');

-- rescuer
INSERT INTO `hrabovenskyi`.`rescuer` (`surname`, `name`, `position`, `is_present`) VALUES ('Oliver', 'Laurence', 'RESCUER', '1');
INSERT INTO `hrabovenskyi`.`rescuer` (`surname`, `name`, `position`, `is_present`) VALUES ('Lemmon', 'Jack', 'RESCUER', '1');
INSERT INTO `hrabovenskyi`.`rescuer` (`surname`, `name`, `position`, `is_present`) VALUES ('Caine', 'Michael', 'RESCUER', '1');
INSERT INTO `hrabovenskyi`.`rescuer` (`surname`, `name`, `position`, `is_present`) VALUES ('Stewat', 'James', 'DOCTOR', '1');
INSERT INTO `hrabovenskyi`.`rescuer` (`surname`, `name`, `position`, `is_present`) VALUES ('Williams', 'Robin', 'DOCTOR', '1');
INSERT INTO `hrabovenskyi`.`rescuer` (`surname`, `name`, `position`, `is_present`) VALUES ('Duvall', 'Robert', 'RESCUER', '0');
INSERT INTO `hrabovenskyi`.`rescuer` (`surname`, `name`, `position`, `is_present`) VALUES ('Penn', 'Sean', 'RESCUER', '0');
INSERT INTO `hrabovenskyi`.`rescuer` (`surname`, `name`, `position`, `is_present`) VALUES ('Freeman', 'Morgan', 'DRIVER', '1');
INSERT INTO `hrabovenskyi`.`rescuer` (`surname`, `name`, `position`, `is_present`) VALUES ('Bridges', 'Jeff', 'DRIVER', '1');
INSERT INTO `hrabovenskyi`.`rescuer` (`surname`, `name`, `position`, `is_present`) VALUES ('Robert', 'Downey', 'DRIVER', '1');
INSERT INTO `hrabovenskyi`.`rescuer` (`surname`, `name`, `position`, `is_present`) VALUES ('Poitier', 'Sidney', 'FIREFIGHTER', '1');

-- rescue_vehicle
INSERT INTO `hrabovenskyi`.`rescue_vehicle` (`number`, `characteristics`) VALUES ('JRH5633', 'NissanSentra S / SL / SR / SV');
INSERT INTO `hrabovenskyi`.`rescue_vehicle` (`number`, `characteristics`) VALUES ('FJB759', 'MazdaMazda6 i');
INSERT INTO `hrabovenskyi`.`rescue_vehicle` (`number`, `characteristics`) VALUES ('7PHT809', 'NissanAltima Base / S / SL');
INSERT INTO `hrabovenskyi`.`rescue_vehicle` (`number`, `characteristics`) VALUES ('124253', 'BuickCentury Custom');
INSERT INTO `hrabovenskyi`.`rescue_vehicle` (`number`, `characteristics`) VALUES ('JFA9130', 'NissanAltima Base / S / SL');
INSERT INTO `hrabovenskyi`.`rescue_vehicle` (`number`, `characteristics`) VALUES ('3LSG492', 'PontiacFirebird');
INSERT INTO `hrabovenskyi`.`rescue_vehicle` (`number`, `characteristics`) VALUES ('7LHB983', 'ScionxB Base / Release Series 8.0');
INSERT INTO `hrabovenskyi`.`rescue_vehicle` (`number`, `characteristics`) VALUES ('8EHZ462', 'HYUNDAISANTA FE SE');
INSERT INTO `hrabovenskyi`.`rescue_vehicle` (`number`, `characteristics`) VALUES ('CFX244', 'DodgeDart GT');

-- call_has_rescue_vehicle
INSERT INTO `hrabovenskyi`.`call_has_rescue_vehicle` (`call_id`, `rescue_vehicle_number`, `departure_time`, `return_time`) VALUES ('1', 'JRH5633', '2006-12-30 00:39:54.840', '2006-12-30 02:38:54.840');
INSERT INTO `hrabovenskyi`.`call_has_rescue_vehicle` (`call_id`, `rescue_vehicle_number`, `departure_time`, `return_time`) VALUES ('1', 'FJB759', '2006-12-30 00:39:54.840', '2006-12-30 02:38:54.840');
INSERT INTO `hrabovenskyi`.`call_has_rescue_vehicle` (`call_id`, `rescue_vehicle_number`, `departure_time`, `return_time`) VALUES ('1', '7PHT809', '2006-12-30 00:39:54.840', '2006-12-30 02:18:03.840');
INSERT INTO `hrabovenskyi`.`call_has_rescue_vehicle` (`call_id`, `rescue_vehicle_number`, `departure_time`, `return_time`) VALUES ('3', 'JRH5633', '2007-12-31 00:40:54.840000', '2007-12-31 02:40:54.840000');
INSERT INTO `hrabovenskyi`.`call_has_rescue_vehicle` (`call_id`, `rescue_vehicle_number`, `departure_time`, `return_time`) VALUES ('3', 'JFA9130', '2007-12-31 00:40:54.840000', '2007-12-31 02:40:54.840000');
INSERT INTO `hrabovenskyi`.`call_has_rescue_vehicle` (`call_id`, `rescue_vehicle_number`, `departure_time`, `return_time`) VALUES ('4', '3LSG492', '2007-12-31 00:38:54.840000', '2007-12-31 04:38:54.840000');
INSERT INTO `hrabovenskyi`.`call_has_rescue_vehicle` (`call_id`, `rescue_vehicle_number`, `departure_time`, `return_time`) VALUES ('5', '3LSG492', '2007-12-31 00:38:54.840000', '2007-12-31 04:38:54.840000');
INSERT INTO `hrabovenskyi`.`call_has_rescue_vehicle` (`call_id`, `rescue_vehicle_number`, `departure_time`, `return_time`) VALUES ('5', '8EHZ462', '2007-12-31 00:38:54.840000', '2007-12-31 04:38:54.840000');
INSERT INTO `hrabovenskyi`.`call_has_rescue_vehicle` (`call_id`, `rescue_vehicle_number`, `departure_time`, `return_time`) VALUES ('7', '3LSG492', '2008-12-31 00:38:54.840000', '2008-12-31 00:59:54.840000');
INSERT INTO `hrabovenskyi`.`call_has_rescue_vehicle` (`call_id`, `rescue_vehicle_number`, `departure_time`, `return_time`) VALUES ('7', '8EHZ462', '2008-12-31 00:38:54.840000', '2008-12-31 00:59:54.840000');

-- hospital
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('Children’s Hospitals');
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('OKHMADYT Lviv Regional Children’s Clinical Hospital');
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('Lviv Regional Children’s Specialized Clinical Hospital');
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('Hospitals');
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('Municipal Clinical Hospital No. 10');
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('Municipal Communal Clinical Hospital No. 3');
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('Communal Clinical Hospital No. 4');
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('Communal Municipal Clinical Hospital No. 5');
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('Military Medical Service of the Office of Security Service of Ukraine in Lviv Region');
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('State Border Guard Service Hospital');
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('Polyclinic of the Office of Ministry of Internal Affairs of Ukraine, Public Health Department in Lviv Region');
INSERT INTO `hrabovenskyi`.`hospital` (`name`) VALUES ('Lviv Regional Medical Rehabilitation Hospital');

-- injury
INSERT INTO `hrabovenskyi`.`injury` (`description`, `diagnosis`, `hospital_id`) VALUES ('Tried to stop drunk driver', 'Multiple fractures', '3');
INSERT INTO `hrabovenskyi`.`injury` (`description`, `diagnosis`, `hospital_id`) VALUES ('Jumped from second floor', 'Stretched tendons', '11');
INSERT INTO `hrabovenskyi`.`injury` (`description`, `diagnosis`, `hospital_id`) VALUES ('Was involved in a fight', 'Concussion', '1');

-- call_has_rescuer
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('1', '8');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('1', '9');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('1', '11');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`, `injury_id`) VALUES ('1', '1', '1');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('1', '2');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('1', '3');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('3', '8');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('3', '11');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('3', '10');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('4', '5');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('5', '9');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('5', '11');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('5', '2');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`, `injury_id`) VALUES ('5', '3', '3');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('5', '4');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('7', '8');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`) VALUES ('7', '9');
INSERT INTO `hrabovenskyi`.`call_has_rescuer` (`call_id`, `rescuer_id`, `injury_id`) VALUES ('7', '5', '2');
			