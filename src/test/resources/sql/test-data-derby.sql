-- Create the tables
CREATE TABLE myorder
(
   pk_text varchar(100), 
   pk_numeric numeric, 
   pk_ts timestamp, 
   "name" varchar(100),  
   PRIMARY KEY (pk_text, pk_numeric, pk_ts)
);

CREATE TABLE myorderitems
(
   pk_text varchar(100), 
   pk_numeric numeric, 
   pk_ts timestamp, 
   pk_text_two varchar(100),    
   "name" varchar(100),
   PRIMARY KEY (pk_text, pk_numeric, pk_ts, pk_text_two)
);