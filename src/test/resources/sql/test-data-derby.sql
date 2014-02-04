-- Create the tables
CREATE TABLE "user"
(
   last_name varchar(100), 
   zip_code numeric, 
   birthday timestamp, 
   email varchar(100),  
   PRIMARY KEY (last_name, zip_code, birthday)
);

CREATE TABLE address
(
   last_name varchar(100), 
   zip_code numeric, 
   birthday timestamp,  
   address varchar(100),    
   type varchar(1),
   PRIMARY KEY (last_name, zip_code, birthday, address),
   CONSTRAINT address_fk FOREIGN KEY (last_name, zip_code, birthday) REFERENCES "user" (last_name, zip_code, birthday)
);

insert into "user" (last_name, zip_code, birthday, email)
values ('red', 90210, '1977-01-30-10.11.30.766', 'rita.red@internet.com');

insert into address (last_name, zip_code, birthday, address, type)
values ('red', 90210, '1977-01-30-10.11.30.766', '123 Work Street', 'w');

insert into address (last_name, zip_code, birthday, address, type)
values ('red', 90210, '1977-01-30-10.11.30.766', '123 Home Street', 'h');

insert into address (last_name, zip_code, birthday, address, type)
values ('red', 90210, '1977-01-30-10.11.30.766', '123 Summer Street', 's');
