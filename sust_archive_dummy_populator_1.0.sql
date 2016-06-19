USE sust_archive;

INSERT INTO department VALUES(1, "Computer Science and Engineering", "CSE");
INSERT INTO department VALUES(2, "Electrical & Electronic Engineering", "EEE");
INSERT INTO department VALUES(3, "Industrial Production and Engineering", "IPE");
INSERT INTO department VALUES(4, "Physics", "PHY");
INSERT INTO department VALUES(5, "Genetic Engineering and Biotechnology", "GEB");


INSERT INTO user_type VALUES(1, "Administrator", "Primary level authority.");
INSERT INTO user_type VALUES(2, "Teacher", "Secondary level authority");
INSERT INTO user_type VALUES(3, "Student", "Tertiary level authority");


-- admin account
INSERT INTO user VALUES(1, "admin", "1234", 1, "admin@sustarchive.com");
-- teacher accounts(3)
INSERT INTO user VALUES(2, "sknabil", "1234", 2, "sknabil@sustarchive.com");
INSERT INTO user VALUES(3, "sabir_ismail", "1234", 2, "sabir_ismail@sustarchive.com");
INSERT INTO user VALUES(4, "eamin_rahman", "1234", 2, "eamin_rahman@sustarchive.com");
-- student accounts(15)
INSERT INTO user VALUES(5, "shafin_mahmud", "1234", 3, "shafin.mahmud@student.sust.edu");
INSERT INTO user VALUES(6, "pranon_rahman", "1234", 3, "pranon@student.sust.edu");
INSERT INTO user VALUES(7, "ahsankabir", "1234", 3, "ahsankabir@student.sust.edu");
INSERT INTO user VALUES(8, "saimon", "1234", 3, "saimon@student.sust.edu");
INSERT INTO user VALUES(9, "shuvanon_razik", "1234", 3, "shuvanon_razik@student.sust.edu");
INSERT INTO user VALUES(10, "fahim06", "1234", 3, "fahim06@student.sust.edu");
INSERT INTO user VALUES(11, "niloy", "1234", 3, "niloy@student.sust.edu");
INSERT INTO user VALUES(12, "ibtida.phoenix", "1234", 3, "ibtida.phoenix@student.sust.edu");
INSERT INTO user VALUES(13, "biswajit", "1234", 3, "biswajit@student.sust.edu");
INSERT INTO user VALUES(14, "shibbir", "1234", 3, "shibbir@student.sust.edu");
INSERT INTO user VALUES(15, "tariqhasananjan", "1234", 3, "tariqhasananjan@student.sust.edu");
INSERT INTO user VALUES(16, "tanzira_najnin", "1234", 3, "tanzira_najnin@student.sust.edu");
INSERT INTO user VALUES(17, "sakibulmowla", "1234", 3, "sakibulmowla@student.sust.edu");
INSERT INTO user VALUES(18, "ayon18", "1234", 3, "ayon18@student.sust.edu");
INSERT INTO user VALUES(19, "sumaiyafahmida", "1234", 3, "sumaiyafahmida@student.sust.edu");


INSERT INTO student VALUES(1, 2011331001, "shafin.mahmud@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Sheikh Shafin", "Mahmud", "single", "AB+", "Islam", "1990-01-01", "male", 5);
INSERT INTO student VALUES(2, 2011331002, "pranon@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Pranon", "Rahman Khan", "single", "AB+", "Islam", "1990-01-01", "male", 6);
INSERT INTO student VALUES(3, 2011331003, "ahsankabir@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Ahsan", "Kabir", "married", "AB+", "Islam", "1990-01-01", "male", 7);
INSERT INTO student VALUES(4, 2011331004, "saimon@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Sakhawat Hossain", "Saimon", "single", "AB+", "Islam", "1990-01-01", "male", 8);
INSERT INTO student VALUES(5, 2011331005, "shuvanon_razik@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Shuvanon", "Razik", "single", "AB+", "Islam", "1990-01-01", "male", 9);
INSERT INTO student VALUES(6, 2011331006, "fahim06@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Fahim", "Rahman", "single", "AB+", "Islam", "1990-01-01", "male", 10);
INSERT INTO student VALUES(7, 2011331007, "niloy@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Assaduzzaman", "Niloy", "single", "AB+", "Islam", "1990-01-01", "male", 11);
INSERT INTO student VALUES(8, 2011331008, "ibtida.phoenix@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Hasin Ibtida", "Alam", "single", "AB+", "Islam", "1990-01-01", "male", 12);
INSERT INTO student VALUES(9, 2011331009, "biswajit@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Biswajit", "Debnath", "single", "AB+", "Hindu", "1990-01-01", "male", 13);
INSERT INTO student VALUES(10, 2011331012, "shibbir@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Shibbir Ahmed", "Osmani", "married", "AB+", "Islam", "1990-01-01", "male", 14);
INSERT INTO student VALUES(11, 2011331013, "tariqhasananjan@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Md.", "Tariq Hasan", "single", "AB+", "Islam", "1990-01-01", "male", 15);
INSERT INTO student VALUES(12, 2011331015, "tanzira_najnin@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Tanzira", "Najnin", "single", "AB+", "Islam", "1990-01-01", "female", 16);
INSERT INTO student VALUES(13, 2011331017, "sakibulmowla@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Sakibul", "Mowla", "single", "AB+", "Islam", "1990-01-01", "male", 17);
INSERT INTO student VALUES(14, 2011331018, "ayon18@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Mohammad Ashfaq", "Ur Rahman", "single", "AB+", "Islam", "1990-01-01", "male", 18);
INSERT INTO student VALUES(15, 2011331019, "sumaiyafahmida@student.sust.edu", 1, "+8809999999999", "Unknown",
						"Sumaiya Fahmida", "Chowdhury", "single", "AB+", "Islam", "1990-01-01", "female", 19);


INSERT INTO course VALUES(1, "CSE 300", "Project 300", 2.0, 6, 2011, "1", "1");
INSERT INTO course VALUES(2, "CSE 361", "Networking", 3.0, 6, 2011, "1", "1");
INSERT INTO course VALUES(3, "CSE 331", "Software Engineering", 3.0, 6, 2011, "1", "1");

-- all students registered for CSE 300
INSERT INTO course_registration VALUES(1, 1, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(2, 2, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(3, 3, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(4, 4, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(5, 5, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(6, 6, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(7, 7, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(8, 8, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(9, 9, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(10, 10, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(11, 11, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(12, 12, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(13, 13, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(14, 14, 1, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(15, 15, 1, true, 0.0, 0.0);
-- all students registered for CSE 361
INSERT INTO course_registration VALUES(16, 1, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(17, 2, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(18, 3, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(19, 4, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(20, 5, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(21, 6, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(22, 7, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(23, 8, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(24, 9, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(25, 10, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(26, 11, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(27, 12, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(28, 13, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(29, 14, 2, true, 0.0, 0.0);
INSERT INTO course_registration VALUES(30, 15, 2, true, 0.0, 0.0);


INSERT INTO designation VALUES(1, "Professor", "No description available");
INSERT INTO designation VALUES(2, "Assistant Professor", "No description available");
INSERT INTO designation VALUES(3, "Lecturer", "No description available");


INSERT INTO teacher VALUES(1, "SKN", 1, 3, true, "sknabil@sustarchive.com", true, 2);
INSERT INTO teacher VALUES(2, "MSI", 1, 3, true, "sabir_ismail@sustarchive.com", true, 3);
INSERT INTO teacher VALUES(3, "ERM", 1, 3, true, "eamin_rahman@sustarchive.com", true, 4);


INSERT INTO teaches VALUES(1, 1, 1);
INSERT INTO teaches VALUES(2, 2, 1);
INSERT INTO teaches VALUES(3, 3, 2);


INSERT INTO exam VALUES(1, 1, 1, "2014-12-01", "2014-12-15", "2014-11-01", "2014-11-25");


INSERT INTO exam_committee VALUES(1, 1, 2011, 6, 1, "2014-07-01", "2014-12-31");


INSERT INTO task_type VALUES(1, "Assignment");
INSERT INTO task_type VALUES(2, "Project");
INSERT INTO task_type VALUES(3, "Thesis");


INSERT INTO task VALUES(1, "Project 300", "Build a web application with Spring framework",
						 "2015-06-01 12-00-00", 2, 0, 0, true);
INSERT INTO task VALUES(2, "Build application using Socket programming",
						"Desktop/Mobile", "2015-07-01 12-00-00", 2, 0, 0, true);
INSERT INTO task VALUES(3, "Submit a Use Case document",
						"Students can choose their project to write use case for",
						"2015-07-01 12-00-00", 1, 0, 0, true);


INSERT INTO course_task VALUES(1, 1, 1, 1);
INSERT INTO course_task VALUES(2, 2, 2, 1);
INSERT INTO course_task VALUES(3, 3, 3, 1);


INSERT INTO tag VALUES(1, "admission test", "No description");
INSERT INTO tag VALUES(2, "android", "Mobile development");
INSERT INTO tag VALUES(3, "bangla computational linguistics", "No description");
INSERT INTO tag VALUES(4, "machine learning", "No description");
INSERT INTO tag VALUES(5, "pipilika", "Bangla search engine");
INSERT INTO tag VALUES(6, "ocr", "Optical Character Recognition");


INSERT INTO groups VALUES(1, "Unnamed01", 1);
INSERT INTO groups VALUES(2, "Unnamed02", 1);
INSERT INTO groups VALUES(3, "Unnamed03", 1);
INSERT INTO groups VALUES(4, "Unnamed04", 1);
INSERT INTO groups VALUES(5, "Unnamed05", 1);
INSERT INTO groups VALUES(6, "Unnamed06", 2);
INSERT INTO groups VALUES(7, "Unnamed07", 2);
INSERT INTO groups VALUES(8, "Unnamed08", 2);


INSERT INTO student_group VALUES(1, 1, 1);
INSERT INTO student_group VALUES(2, 2, 1);
INSERT INTO student_group VALUES(3, 3, 2);
INSERT INTO student_group VALUES(4, 5, 2);
INSERT INTO student_group VALUES(5, 6, 3);
INSERT INTO student_group VALUES(6, 7, 3);
INSERT INTO student_group VALUES(7, 8, 3);
INSERT INTO student_group VALUES(8, 9, 4);
INSERT INTO student_group VALUES(9, 10, 5);
INSERT INTO student_group VALUES(10, 12, 5);
INSERT INTO student_group VALUES(11, 1, 6);
INSERT INTO student_group VALUES(12, 4, 6);
INSERT INTO student_group VALUES(13, 7, 7);
INSERT INTO student_group VALUES(14, 12, 7);
INSERT INTO student_group VALUES(15, 14, 8);
INSERT INTO student_group VALUES(16, 15, 8);


INSERT INTO project VALUES(1, "Bangla speech to text converter", "No description available");
INSERT INTO project VALUES(2, "SUST Archives", "No description available");
INSERT INTO project VALUES(3, "SUST Navigator 2.0", "No description available");
INSERT INTO project VALUES(4, "Exam automation", "No description available");
INSERT INTO project VALUES(5, "Multi chat messenger", "No description available");
INSERT INTO project VALUES(6, "Restaurant point of sales", "No description available");


INSERT INTO project_group VALUES(1, 1, 1);
INSERT INTO project_group VALUES(2, 2, 2);
INSERT INTO project_group VALUES(3, 2, 3);
INSERT INTO project_group VALUES(4, 3, 4);
INSERT INTO project_group VALUES(5, 4, 5);
INSERT INTO project_group VALUES(6, 5, 6);
INSERT INTO project_group VALUES(7, 6, 7);
INSERT INTO project_group VALUES(8, 6, 8);


INSERT INTO project_tag VALUES(1, 3, 1);
INSERT INTO project_tag VALUES(2, 4, 1);
INSERT INTO project_tag VALUES(3, 5, 1);
INSERT INTO project_tag VALUES(5, 2, 3);
INSERT INTO project_tag VALUES(6, 2, 6);

-- schema confusing but query works
INSERT INTO task_project VALUES(1, 1, 1);
INSERT INTO task_project VALUES(2, 1, 2);
INSERT INTO task_project VALUES(3, 1, 3);
INSERT INTO task_project VALUES(4, 1, 4);
INSERT INTO task_project VALUES(5, 2, 5);
INSERT INTO task_project VALUES(6, 2, 6);


INSERT INTO submission VALUES(1, "No comments", 1, "No comments", "2015-03-17 15-25-00","dummy url 1");
INSERT INTO submission VALUES(2, "No comments", 1, "No comments", "2015-03-18 12-00-00","dummy url 2");
INSERT INTO submission VALUES(3, "No comments", 1, "No comments", "2015-03-18 12-00-00","dummy url 3");
INSERT INTO submission VALUES(4, "No comments", 1, "No comments", "2015-04-10 19-20-00","dummy url 4");
INSERT INTO submission VALUES(5, "No comments", 1, "No comments", "2015-04-10 19-25-00","dummy url 5");
INSERT INTO submission VALUES(6, "No comments", 1, "No comments", "2015-04-10 19-27-00","dummy url 6");
INSERT INTO submission VALUES(7, "No comments", 1, "No comments", "2015-05-05 11-50-00","dummy url 7");
INSERT INTO submission VALUES(8, "No comments", 1, "No comments", "2015-05-08 20-15-00","dummy url 8");


INSERT INTO project_group_submit VALUES(1, 1, 2);
INSERT INTO project_group_submit VALUES(2, 2, 2);
INSERT INTO project_group_submit VALUES(3, 3, 3);
INSERT INTO project_group_submit VALUES(4, 4, 4);
INSERT INTO project_group_submit VALUES(5, 5, 3);
INSERT INTO project_group_submit VALUES(6, 6, 2);
INSERT INTO project_group_submit VALUES(7, 7, 6);
INSERT INTO project_group_submit VALUES(8, 8, 7);