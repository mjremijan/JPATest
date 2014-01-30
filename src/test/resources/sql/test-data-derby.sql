-- Create the tables
CREATE TABLE myorder
(
   pk_text varchar(100), 
   pk_numeric numeric, 
   pk_ts timestamp, 
   name varchar(100),  
   PRIMARY KEY (pk_text, pk_numeric, pk_ts)
);

CREATE TABLE myorderitems
(
   pk_text varchar(100), 
   pk_numeric numeric, 
   pk_ts timestamp, 
   pk_text_two varchar(100),    
   name varchar(100),
   PRIMARY KEY (pk_text, pk_numeric, pk_ts, pk_text_two)
);

insert into myorder (pk_text,pk_numeric,pk_ts,name)
values ('test-data', 54321, '2014-01-30-10.11.30.766', 'red');

insert into myorderitems (pk_text,pk_numeric,pk_ts,pk_text_two,name)
values ('test-data', 54321, '2014-01-30-10.11.30.766', 'c1', 'child1');

insert into myorderitems (pk_text,pk_numeric,pk_ts,pk_text_two,name)
values ('test-data', 54321, '2014-01-30-10.11.30.766', 'c2', 'child2');

insert into myorderitems (pk_text,pk_numeric,pk_ts,pk_text_two,name)
values ('test-data', 54321, '2014-01-30-10.11.30.766', 'c3', 'child3');
