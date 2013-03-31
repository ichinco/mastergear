insert into trail (id, version, name, location, latitude, longitude, date_created, last_updated, max_elevation) VALUES
(1,1,'Franconia Ridge','Franconia, NH',44.159,-71.645,'2013-03-27','2013-03-27',5249),
(2,1,'Acadia National Park','Bar Harbor, ME',44.35,68.2167,'2013-03-31','2013-03-31',1528);

insert into gear_user (id, version, username, password, enabled, account_expired, account_locked, password_expired, date_created, last_updated) VALUES
(1,1,'mountaindude','',true,false,false,false,'2013-03-31','2013-03-31');

insert into user_profile (id, version, user_id, about, gear_philosophy, twitter_id, date_created, last_updated, favorite_trail_id) VALUES 
(1,1,1,'I''ve been hiking for 10 years, all day hikes, in the north east. I love the feeling of accomplishment you get from being at the top of the mountain.','I''m pretty relaxed about gear. I try to keep things light when I can, but for short distances, I find it doesn''t matter so much. I''ve been caught in some sticky situations before and I''d rather have some resources to help me get out of them than be stuck.','','2013-03-31','2013-03-31',2);

insert into user_trail(id,version,user_id,trail_id,notes,hike_date,date_created,last_updated) VALUES 
(1,1,1,1,'','2012-05-15','2013-03-31','2013-03-31'),
(2,1,1,2,'','2011-05-15','2013-03-31','2013-03-31');
