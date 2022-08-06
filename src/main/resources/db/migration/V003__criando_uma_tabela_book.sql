create table book (
	id bigint not null auto_increment,
	image varchar(255),
	title varchar(60),
	author_id bigint,
	publisher_id bigint,
	primary key (id)
) engine=InnoDB;