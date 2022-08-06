create table author (
	id bigint not null auto_increment,
	name varchar(60) not null,
	birth_date date not null, primary key (id)
 ) engine=InnoDB;