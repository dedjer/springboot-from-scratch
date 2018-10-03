insert into db_example.customers (customer_id, fullname) values (1,'Ronnie');
insert into db_example.customers (customer_id, fullname) values (2,'Bobby');
insert into db_example.customers (customer_id, fullname) values (3,'Ricky');
insert into db_example.customers (customer_id, fullname) values (4,'Mike');
insert into db_example.customers (customer_id, fullname) values (5,'Ralph');
insert into db_example.customers (customer_id, fullname) values (6,'Johnny');

insert into db_example.addresses (address_id, city, state, street, zipcode, customer_id) values (1, 'Dallas', 'Texas', 'Galleria Dr', '75240', 1);
insert into db_example.addresses (address_id, city, state, street, zipcode, customer_id) values (2, 'Plano', 'Texas', 'Legacy Rd', '75024', 2);
insert into db_example.addresses (address_id, city, state, street, zipcode, customer_id) values (3, 'McKinney', 'Texas', 'Main St', '75555', 1);

insert into db_example.vehicles (vehicle_id, make) values (1, "Nissan");
insert into db_example.vehicles (vehicle_id, make) values (2, "Subaru");
insert into db_example.vehicles (vehicle_id, make) values (3, "Yamaha");
insert into db_example.vehicles (vehicle_id, make) values (4, "Honda");

insert into db_example.customer_vehicle (customer_id, vehicle_id) values (1,1);
insert into db_example.customer_vehicle (customer_id, vehicle_id) values (2,2);
insert into db_example.customer_vehicle (customer_id, vehicle_id) values (3,3);
insert into db_example.customer_vehicle (customer_id, vehicle_id) values (4,4);

