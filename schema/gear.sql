insert into brand (id, version, name, date_created, last_updated) VALUES
(1,1,'The North Face','2013-03-27','2013-03-27'),
(2,1,'Nalgene','2013-03-27','2013-03-27'),
(3,1,'Platypus','2013-03-27','2013-03-27'),
(4,1,'Under Armour','2013-03-27','2013-03-27'),
(5,1,'Marmot','2013-03-27','2013-03-27'),
(6,1,'Columbia Sportswear','2013-03-27','2013-03-27'),
(7,1,'REI','2013-03-27','2013-03-27'),
(8,1,'Maglite','2013-03-27','2013-03-27'),
(9,1,'Suunto','2013-03-27','2013-03-27'),
(10,1,'Repel','2013-03-27','2013-03-27'),
(11,1,'All Terrain','2013-03-27','2013-03-27');

insert into gear_item_type (id, version, name, date_created, last_updated) VALUES
(1,1,'Daypack','2013-03-27','2013-03-27'),
(2,1,'Water Bottle','2013-03-27','2013-03-27'),
(3,1,'Soft Bottle','2013-03-27','2013-03-27'),
(4,1,'Rain Jacket','2013-03-27','2013-03-27'),
(5,1,'Long sleeved shirt','2013-03-27','2013-03-27'),
(6,1,'Sun hat','2013-03-27','2013-03-27'),
(7,1,'hat','2013-03-27','2013-03-27'),
(8,1,'gloves','2013-03-27','2013-03-27'),
(9,1,'insect repellant','2013-03-27','2013-03-27'),
(10,1,'sunscreen','2013-03-27','2013-03-27'),
(11,1,'first aid kit','2013-03-27','2013-03-27'),
(12,1,'flashlight','2013-03-27','2013-03-27'),
(13,1,'compass','2013-03-27','2013-03-27');

insert into gear (id, version, title, weight, brand_id, item_id, date_created, last_updated) VALUES
(1,1,'Borealis',41,1,1,'2013-03-27','2013-03-27'),
(2,1,'Tritan Wide Mouth',15,2,2,'2013-03-27','2013-03-27'),
(3,1,'with Closure Cap',1.3,3,3,'2013-03-27','2013-03-27'),
(4,1,'Precip Jacket',13.1,5,4,'2013-03-27','2013-03-27'),
(5,1,'ColdGear® Compression Mock Tops',7,4,5,'2013-03-27','2013-03-27'),
(6,1,'HeatGear® Compression',5,4,5,'2013-03-27','2013-03-27'),
(7,1,'Silver Ridge Booney II',0,6,6,'2013-03-27','2013-03-27'),
(8,1,'Passing Through Beanie',0,1,7,'2013-03-27','2013-03-27'),
(9,1,'Oslo Grip',0,7,8,'2013-03-27','2013-03-27'),
(10,1,'Mini Pro 2 AA LED',4.1,8,12,'2013-03-27','2013-03-27'),
(11,1,'M-3D Leader',1.6,9,13,'2013-03-27','2013-03-27'),
(12,1,'Sportsmen Max Formula Insect Repellent 40% DEET lotion',0,10,9,'2013-03-27','2013-03-27'),
(13,1,'Terrasport SPF30 Oxybenzone-Free Natural',0,11,10,'2013-03-27','2013-03-27');

insert into provider (id, version, type, provider_id, image_id, gear_id, gender, date_created, last_updated) VALUES 
-- daypack
(1,1,'REI','833670','bb/cf3f9864-f3e4-470c-b4d8-dbbc66cbfa10',1,'MALE','2013-03-27','2013-03-27'),
(2,1,'AMAZON','B0089RQY06','51v7QicjDVL._SX342_',1,'MALE','2013-03-27','2013-03-27'),
-- nalgene
(3,1,'AMAZON','B002PLU912','41Wc9N0Y--L._SX342_',2,'UNISEX','2013-03-27','2013-03-27'),
(4,1,'EMS','3662701','',2,'UNISEX','2013-03-27','2013-03-27'),
-- platypus
(5,1,'REI','820769','jj/df42500b-1fda-4190-8436-032c3d5124d0',3,'UNISEX','2013-03-27','2013-03-27'),
(6,1,'AMAZON','B000J2KEGY','71nFy2U%2BQ5S._SL1500_',3,'UNISEX','2013-03-27','2013-03-27'),
-- marmot rain jacket
(7,1,'AMAZON','B004OVE430','81uU358TFzL._SL1500_',4,'MALE','2013-03-27','2013-03-27'),
(8,1,'REI','804391','bb/065b7b7a-d01f-48e5-aafe-9c0c3f2198a0',4,'MALE','2013-03-27','2013-03-27'),
-- underarmor coldgear
(9,1,'AMAZON','B0002GDWJI','51WXUrlcf2L._SL1096_',5,'MALE','2013-03-27','2013-03-27'),
-- underarmor heatgear
(10,1,'AMAZON','B000AAC27O','31xB1AIoDxL',6,'MALE','2013-03-27','2013-03-27'),
-- hat
(11,1,'AMAZON','B004ISKEX8','31L4eI1LZzL',7,'MALE','2013-03-27','2013-03-27'),
-- fleece hat
(12,1,'REI','845498','cc/39116b48-9422-47b0-9873-a0415a4156e2',8,'UNISEX','2013-03-27','2013-03-27'),
-- fleece gloves
(13,1,'REI','803854','xx/b9a74e79-f457-49da-99ae-e96434b5c7d2',9,'UNISEX','2013-03-27','2013-03-27'),
-- flashlight
(14,1,'REI','843844','ii/5b35f00f-62d7-4490-9dfb-25e58e3f7862',10,'UNISEX','2013-03-27','2013-03-27'),
(15,1,'AMAZON','B005UUSAAM','519GKGAFxoL._SL1000_',10,'UNISEX','2013-03-27','2013-03-27'),
-- compass
(16,1,'REI','408150','',11,'UNISEX','2013-03-27','2013-03-27'),
(17,1,'AMAZON','B000FEWA6S','31005HKCD1L',11,'UNISEX','2013-03-27','2013-03-27'),
-- insect repllent
(18,1,'AMAZON','B000PGJ4LA','71FzuKnKe2L._SL1500_',12,'UNISEX','2013-03-27','2013-03-27'),
-- sun screen
(19,1,'AMAZON','B007AJNY6G','31NprAyHFrL.jpg',13,'UNISEX','2013-03-27','2013-03-27');

insert into trail (id, version, name, location, latitude, longitude, max_elevation, date_created, last_updated) VALUES 
(1,1,'Franconia Notch State Park','Lincoln, NH',44.0456,-71.6706,5089,'2013-04-20','2013-04-20');

insert into gear_user (id, version, username, password, enabled, account_expired, account_locked, password_expired, date_created, last_updated) VALUES
(1,1,'mountaindude','',true,false,false,false,'2013-04-20','2013-04-20');

insert into gear_list (id, version, season, trail_id, hike_type, list_description, date_created, last_updated, user_id) VALUES
(1,1,'SUMMER',1,'DAY','This is a basic dayhiking gear list, which should be suitable for anyone hiking in NH in the milder months','2013-03-27','2013-03-27',1);

insert into gear_list_gear (id, version, gear_id, list_id, quantity, notes, gear_type, date_created, last_updated) VALUES
(1,1,1,1,1,'','PACK','2013-03-27','2013-03-27'),
(2,1,2,1,2,'I guess I''m old fashioned, but I like carrying my water in sturdy nalgene bottles.','WATER','2013-03-27','2013-03-27'),
(3,1,4,1,1,'','CLOTHES','2013-03-27','2013-03-27'),
(4,1,6,1,1,'','CLOTHES','2013-03-27','2013-03-27'),
(5,1,7,1,1,'','CLOTHES','2013-03-27','2013-03-27'),
(6,1,8,1,1,'','CLOTHES','2013-03-27','2013-03-27'),
(7,1,9,1,1,'','CLOTHES','2013-03-27','2013-03-27'),
(8,1,10,1,1,'','EMERGENCY','2013-03-27','2013-03-27'),
(9,1,11,1,1,'','EMERGENCY','2013-03-27','2013-03-27'),
(10,1,12,1,1,'','OTHER','2013-03-27','2013-03-27'),
(11,1,13,1,1,'','OTHER','2013-03-27','2013-03-27');
