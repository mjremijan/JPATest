-- Create the tables
CREATE TABLE public.myorder
(
   pk_text text, 
   pk_numeric numeric, 
   pk_ts timestamp with time zone, 
   name text, 
   CONSTRAINT order_pk PRIMARY KEY (pk_text, pk_numeric, pk_ts)
) 
WITH (
  OIDS = FALSE
)
;
CREATE TABLE public.myorderitems
(
   pk_text text, 
   pk_numeric numeric, 
   pk_ts timestamp with time zone, 
   pk_text_two text, 
   name text, 
   CONSTRAINT orderitem_pk PRIMARY KEY (pk_text, pk_numeric, pk_ts, pk_text_two)
) 
WITH (
  OIDS = FALSE
)
;

