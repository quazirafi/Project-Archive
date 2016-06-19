DROP SCHEMA IF EXISTS sust_archive;

CREATE SCHEMA sust_archive;

USE sust_archive;

CREATE TABLE tag (
                tag_id INT AUTO_INCREMENT NOT NULL,
                tag_name VARCHAR(40) NOT NULL,
                tag_desc VARCHAR(50) NOT NULL,
                PRIMARY KEY (tag_id)
);


CREATE UNIQUE INDEX tag_name
 ON tag
 ( tag_name );

CREATE TABLE Department (
                dept_id INT AUTO_INCREMENT NOT NULL,
                dept_name VARCHAR(60) NOT NULL,
                dept_code VARCHAR(30) NOT NULL,
                PRIMARY KEY (dept_id)
);


CREATE UNIQUE INDEX department_unique
 ON Department
 ( dept_code );

CREATE TABLE Exam (
                exam_id BIGINT AUTO_INCREMENT NOT NULL,
                usn_no INT NOT NULL,
                dept_id INT NOT NULL,
                exam_start VARCHAR(30) NOT NULL,
                exam_end VARCHAR(30) NOT NULL,
                reg_start VARCHAR(30) NOT NULL,
                reg_end VARCHAR(30) NOT NULL,
                PRIMARY KEY (exam_id)
);


CREATE UNIQUE INDEX exam_unique
 ON Exam
 ( usn_no, dept_id );

CREATE TABLE Exam_committee (
                exam_committee_id INT AUTO_INCREMENT NOT NULL,
                exam_id BIGINT NOT NULL,
                session INT NOT NULL,
                semester INT NOT NULL,
                chairman_id INT NOT NULL,
                start_Date VARCHAR(30) NOT NULL,
                end_date VARCHAR(30) NOT NULL,
                PRIMARY KEY (exam_committee_id)
);


CREATE UNIQUE INDEX exam_committee_unique
 ON Exam_committee
 ( exam_id, session );

CREATE TABLE Submission (
                submission_id INT AUTO_INCREMENT NOT NULL,
                comment_student VARCHAR(90),
                submission_ver INT,
                comment_teacher VARCHAR(80),
                submission_time VARCHAR(40) NOT NULL,
                PRIMARY KEY (submission_id)
);


CREATE TABLE Project (
                project_id INT AUTO_INCREMENT NOT NULL,
                project_title VARCHAR(60) NOT NULL,
                project_desc VARCHAR(90),
                PRIMARY KEY (project_id)
);


CREATE TABLE project_tag (
                project_tag_id INT AUTO_INCREMENT NOT NULL,
                tag_id INT NOT NULL,
                project_id INT NOT NULL,
                PRIMARY KEY (project_tag_id)
);


CREATE TABLE Task_type (
                task_type_id INT NOT NULL,
                task_type_name VARCHAR(30) NOT NULL,
                PRIMARY KEY (task_type_id)
);


CREATE UNIQUE INDEX task_type_idx
 ON Task_type
 ( task_type_name );

CREATE TABLE Task (
                task_id INT AUTO_INCREMENT NOT NULL,
                task_title VARCHAR(50) NOT NULL,
                task_desc VARCHAR(200),
                task_deadline DATETIME NOT NULL,
                task_type_id INT NOT NULL,
                task_total_group_no INT NOT NULL,
                task_total_submisson_no INT NOT NULL,
                is_open BOOLEAN NOT NULL,
                PRIMARY KEY (task_id)
);


CREATE TABLE groups (
                group_id INT AUTO_INCREMENT NOT NULL,
                group_name VARCHAR(30) NOT NULL,
                task_id INT NOT NULL,
                PRIMARY KEY (group_id)
);


CREATE UNIQUE INDEX group_unique
 ON groups
 ( group_name, task_id );

CREATE TABLE project_group (
                project_group_id INT AUTO_INCREMENT NOT NULL,
                project_id INT NOT NULL,
                group_id INT NOT NULL,
                PRIMARY KEY (project_group_id)
);


CREATE TABLE project_group_submit (
                project_group_submit_id INT AUTO_INCREMENT NOT NULL,
                submission_id INT NOT NULL,
                project_group_id INT NOT NULL,
                PRIMARY KEY (project_group_submit_id)
);


CREATE TABLE Task_project (
                task_project_id INT AUTO_INCREMENT NOT NULL,
                task_id INT NOT NULL,
                project_id INT NOT NULL,
                PRIMARY KEY (task_project_id)
);


CREATE UNIQUE INDEX task_project_unique
 ON Task_project
 ( task_id, project_id );

CREATE TABLE Designation (
                desig_id INT AUTO_INCREMENT NOT NULL,
                desig_name VARCHAR(50) NOT NULL,
                desig_desc VARCHAR(200),
                PRIMARY KEY (desig_id)
);


CREATE UNIQUE INDEX designation_unique
 ON Designation
 ( desig_name );

CREATE TABLE Course (
                course_id INT AUTO_INCREMENT NOT NULL,
                course_code VARCHAR(30) NOT NULL,
                course_title VARCHAR(30) NOT NULL,
                credit DOUBLE NOT NULL,
                semester INT NOT NULL,
                session INT NOT NULL,
                offering_dept VARCHAR(30) NOT NULL,
                accepting_dept VARCHAR(30) NOT NULL,
                PRIMARY KEY (course_id)
);


CREATE UNIQUE INDEX course_unique
 ON Course
 ( course_code, offering_dept, accepting_dept, session );

CREATE TABLE Course_task (
                course_task_id INT AUTO_INCREMENT NOT NULL,
                course_id INT NOT NULL,
                task_id INT NOT NULL,
                exam_committee_id INT NOT NULL,
                PRIMARY KEY (course_task_id)
);


CREATE TABLE user_type (
                user_type_id INT AUTO_INCREMENT NOT NULL,
                user_type_name VARCHAR(30) NOT NULL,
                user_desc VARCHAR(60),
                PRIMARY KEY (user_type_id)
);


CREATE INDEX user_type_idx
 ON user_type
 ( user_type_name );

CREATE UNIQUE INDEX user_type_unique
 ON user_type
 ( user_type_name );

CREATE TABLE User (
                user_id BIGINT AUTO_INCREMENT NOT NULL,
                user_name VARCHAR(30) NOT NULL,
                password VARCHAR(30) NOT NULL,
                user_type_id INT NOT NULL,
                user_email VARCHAR(50) NOT NULL,
                PRIMARY KEY (user_id)
);


CREATE UNIQUE INDEX user_unique
 ON User
 ( user_name );

CREATE UNIQUE INDEX user_idx1
 ON User
 ( user_name );

CREATE TABLE Teacher (
                instructor_id BIGINT NOT NULL,
                employee_code VARCHAR(30) NOT NULL,
                dept_id INT NOT NULL,
                desig_id INT NOT NULL,
                is_permanent BOOLEAN NOT NULL,
                email VARCHAR(30) NOT NULL,
                is_available BOOLEAN NOT NULL,
                user_id BIGINT NOT NULL,
                PRIMARY KEY (instructor_id)
);


CREATE UNIQUE INDEX teacher_unique
 ON Teacher
 ( employee_code, dept_id );

CREATE TABLE Teaches (
                teaches_id INT AUTO_INCREMENT NOT NULL,
                course_id INT NOT NULL,
                instructor_id BIGINT NOT NULL,
                PRIMARY KEY (teaches_id)
);


CREATE UNIQUE INDEX teaches_unique
 ON Teaches
 ( course_id, instructor_id );

CREATE TABLE student (
                student_id INT AUTO_INCREMENT NOT NULL,
                registration_no INT NOT NULL,
                email_no VARCHAR(50) NOT NULL,
                dept_id INT NOT NULL,
                contact_no VARCHAR(30) NOT NULL,
                Address VARCHAR(90),
                first_name VARCHAR(30) NOT NULL,
                last_name VARCHAR(30) NOT NULL,
                marital_status VARCHAR(30),
                blood_group VARCHAR(30),
                religion VARCHAR(30),
                date_of_birth DATE,
                gender VARCHAR(30) NOT NULL,
                user_id BIGINT NOT NULL,
                PRIMARY KEY (student_id)
);


CREATE UNIQUE INDEX student_idx_unique
 ON student
 ( registration_no );

CREATE TABLE Student_group (
                stud_group_id INT AUTO_INCREMENT NOT NULL,
                student_id INT NOT NULL,
                group_id INT NOT NULL,
                PRIMARY KEY (stud_group_id)
);


CREATE TABLE Course_registration (
                course_reg_id BIGINT NOT NULL,
                student_id INT NOT NULL,
                course_id INT NOT NULL,
                is_approved BOOLEAN NOT NULL,
                marks DOUBLE NOT NULL,
                GPA DOUBLE,
                PRIMARY KEY (course_reg_id)
);


CREATE UNIQUE INDEX course_reg_unique
 ON Course_registration
 ( student_id, course_id );

ALTER TABLE project_tag ADD CONSTRAINT tag_project_tag_fk
FOREIGN KEY (tag_id)
REFERENCES tag (tag_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Exam ADD CONSTRAINT department_exam_fk
FOREIGN KEY (dept_id)
REFERENCES Department (dept_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Teacher ADD CONSTRAINT department_teacher_fk
FOREIGN KEY (dept_id)
REFERENCES Department (dept_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE student ADD CONSTRAINT department_student_fk
FOREIGN KEY (dept_id)
REFERENCES Department (dept_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Exam_committee ADD CONSTRAINT exam_exam_committee_fk
FOREIGN KEY (exam_id)
REFERENCES Exam (exam_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Course_task ADD CONSTRAINT exam_committee_course_task_fk
FOREIGN KEY (exam_committee_id)
REFERENCES Exam_committee (exam_committee_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE project_group_submit ADD CONSTRAINT submission_project_group_submit_fk
FOREIGN KEY (submission_id)
REFERENCES Submission (submission_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Task_project ADD CONSTRAINT project_task_project_fk
FOREIGN KEY (project_id)
REFERENCES Project (project_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE project_group ADD CONSTRAINT project_project_group_fk
FOREIGN KEY (project_id)
REFERENCES Project (project_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE project_tag ADD CONSTRAINT project_project_tag_fk
FOREIGN KEY (project_id)
REFERENCES Project (project_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Task ADD CONSTRAINT task_type_task_fk
FOREIGN KEY (task_type_id)
REFERENCES Task_type (task_type_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Course_task ADD CONSTRAINT task_course_task_fk
FOREIGN KEY (task_id)
REFERENCES Task (task_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Task_project ADD CONSTRAINT task_task_project_fk
FOREIGN KEY (task_id)
REFERENCES Task (task_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE groups ADD CONSTRAINT task_group_fk
FOREIGN KEY (task_id)
REFERENCES Task (task_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE project_group ADD CONSTRAINT groups_project_group_fk
FOREIGN KEY (group_id)
REFERENCES groups (group_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Student_group ADD CONSTRAINT groups_student_group_fk
FOREIGN KEY (group_id)
REFERENCES groups (group_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE project_group_submit ADD CONSTRAINT project_group_project_group_submit_fk
FOREIGN KEY (project_group_id)
REFERENCES project_group (project_group_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Teacher ADD CONSTRAINT designation_teacher_fk
FOREIGN KEY (desig_id)
REFERENCES Designation (desig_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Course_registration ADD CONSTRAINT course_course_reg_fk
FOREIGN KEY (course_id)
REFERENCES Course (course_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Teaches ADD CONSTRAINT course_teaches_fk
FOREIGN KEY (course_id)
REFERENCES Course (course_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Course_task ADD CONSTRAINT course_course_task_fk
FOREIGN KEY (course_id)
REFERENCES Course (course_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE User ADD CONSTRAINT user_type_user_fk
FOREIGN KEY (user_type_id)
REFERENCES user_type (user_type_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE student ADD CONSTRAINT user_student_fk
FOREIGN KEY (user_id)
REFERENCES User (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Teacher ADD CONSTRAINT user_teacher_fk
FOREIGN KEY (user_id)
REFERENCES User (user_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Teaches ADD CONSTRAINT teacher_teaches_fk
FOREIGN KEY (instructor_id)
REFERENCES Teacher (instructor_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Course_registration ADD CONSTRAINT student_course_reg_fk
FOREIGN KEY (student_id)
REFERENCES student (student_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Student_group ADD CONSTRAINT student_student_group_fk
FOREIGN KEY (student_id)
REFERENCES student (student_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE Submission ADD submission_url VARCHAR(50);