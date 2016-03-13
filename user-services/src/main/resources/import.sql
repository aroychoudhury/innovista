--
-- Sample dataset containing a number of Users and related Workgroups.   :)
--

-- =================================================================================================

insert into app_group(group_id, group_name, group_desc, active_ind) values (1001, 'HASALL', 'General for all the users', 'A');
insert into app_user(user_id, original_id, first_name, last_name, garm_level, gsam_level, email_id, active_ind, app_group_id) values (101, 'v906567', 'Rao', 'Ganguri', 1, '8AUS', 'rao@verizon.com', 'A', 1001);
insert into app_user(user_id, original_id, first_name, last_name, garm_level, gsam_level, email_id, active_ind, app_group_id) values (102, 'v567343', 'sss', 'rrrr', 1, '8AUS', 'ssao@verizon.com', 'A', 1001);
insert into app_user(user_id, original_id, first_name, last_name, garm_level, gsam_level, email_id, active_ind, app_group_id) values (103, 'v456544', 'nnn', 'oooo', 1, '8AUS', 'nnao@verizon.com', 'A', 1001);

------------------ 2nd Work Group ----------------------------
insert into app_group(group_id, group_name, group_desc, active_ind) values (1002, 'ETMS_DEV', 'Etms dev testing', 'A');
insert into app_user(user_id, original_id, first_name, last_name, garm_level, gsam_level, email_id, active_ind, app_group_id) values (104, 'v123132', 'Brao', 'Brao123', 1, '8AUS', 'brao@verizon.com', 'A', 1002);


