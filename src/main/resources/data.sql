insert into db_example.customers (customer_id, fullname) values (1,'DJ');
insert into db_example.customers (customer_id, fullname) values (2,'Tricia');

insert into db_example.addresses (address_id, city, state, street, zipcode, customer_id) values (1, 'Dallas', 'Texas', 'Galleria Dr', '75240', 1);
insert into db_example.addresses (address_id, city, state, street, zipcode, customer_id) values (2, 'Plano', 'Texas', 'Legacy Rd', '75024', 2);
insert into db_example.addresses (address_id, city, state, street, zipcode, customer_id) values (3, 'McKinney', 'Texas', 'Main St', '75555', 1);
