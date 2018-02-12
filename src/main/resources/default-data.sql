
-- nt_server_group START
INSERT INTO nt_server_group (id,name) VALUES (1,'korea');
-- nt_server_group END

-- nt_server START
INSERT INTO nt_server (id,name,port,port2,public_host,private_host,server_type,server_group_id) VALUES (1,'push1',443,4433,'ps01.113366.com','ps01.113366.com',1,1);
INSERT INTO nt_server (id,name,port,port2,public_host,private_host,server_type,server_group_id) VALUES (2,'rsnet2',443,443,'stgwalpa.startsupport.com','13.124.46.231',2,1);
-- nt_server END

