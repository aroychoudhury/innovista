--
-- Sample dataset containing a number of Users and related Workgroups.   :)
--

-- =================================================================================================

insert into work_group(id, wkgrp_name, wkgrp_desc) values (1001, 'HASALL', 'General for all the users');
insert into user(user_Id, first_name, last_name, garm_level, email_id, user_active, workgroup_id) values (101, 'Rao', 'Ganguri', 1, 'rao@verizon.com', 'Yes', 1001);
insert into user(user_Id, first_name, last_name, garm_level, email_id, user_active, workgroup_id) values (102, 'sss', 'rrrr', 1, 'ssao@verizon.com', 'Yes', 1001);
insert into user(user_Id, first_name, last_name, garm_level, email_id, user_active, workgroup_id) values (103, 'nnn', 'oooo', 1, 'nnao@verizon.com', 'Yes', 1001);


insert into work_group(id, wkgrp_name, wkgrp_desc) values (1002, 'ETMS Dev', 'Etms dev testing');
insert into user(user_Id, first_name, last_name, garm_level, email_id, user_active, workgroup_id) values (104, 'Brao', 'Brao123', 1, 'brao@verizon.com', 'No', 1002);

insert into work_group(id, wkgrp_name, wkgrp_desc) values (1003, 'ETMS Test', 'For Testing');
insert into user(user_Id, first_name, last_name, garm_level, email_id, user_active, workgroup_id) values (105, 'Abh', 'R123', 1, 'abh@verizon.com', 'Yes', 1003);

insert into work_group(id, wkgrp_name, wkgrp_desc) values (1004, 'TEST 212', 'Tet 231111');
insert into user(user_Id, first_name, last_name, garm_level, email_id, user_active, workgroup_id) values (106, 'irfan', '123333', 1, 'irfan@verizon.com', 'No', 1004);

