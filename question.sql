USE sust_archive;

CREATE TABLE question (
                question_id INT AUTO_INCREMENT NOT NULL,
                course_id INT NOT NULL,
                question_type_id INT NOT NULL,
				question_url VARCHAR(30) NOT NULL,
                PRIMARY KEY (question_id)
);




CREATE TABLE question_type (
                question_type_id INT NOT NULL,
                question_type_name VARCHAR(30) NOT NULL,
                PRIMARY KEY (question_type_id)
);


CREATE UNIQUE INDEX question_type_idx
 ON question_type
 ( question_type_name );

ALTER TABLE question ADD CONSTRAINT question_type_question_fk
FOREIGN KEY (question_type_id)
REFERENCES question_type (question_type_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE question ADD CONSTRAINT course_question_fk
FOREIGN KEY (course_id)
REFERENCES course (course_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;





INSERT INTO question_type VALUES(1, "Term_test");
INSERT INTO question_type VALUES(2, "Final");

INSERT into question VALUES(1,1,1,"dummy url 1");
INSERT into question VALUES(2,1,2,"dummy url 2");
