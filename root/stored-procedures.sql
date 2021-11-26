USE
`lab7`;

DROP PROCEDURE IF EXISTS createCoworker;
DELIMITER
//
CREATE PROCEDURE createCoworker(
    `surname` VARCHAR (45),
    `name` VARCHAR (45),
    `seniority` INT,
    `dob` DATE,
    `passport_number` VARCHAR (100),
    `position_id` INT,
    `academic_status_id` INT,
    `degree_id` INT
)
BEGIN
INSERT INTO coworker(`surname`, `name`, `seniority`, `dob`, `passport_number`, `position_id`, `academic_status_id`,
                     `degree_id`)
VALUES (surname, name, seniority, dob, passport_number, position_id, academic_status_id, degree_id);
END
//
DELIMITER ;
