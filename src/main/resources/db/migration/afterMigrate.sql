insert ignore into author (id, name, birth_date) values (1, "J. R. R. Tolkien", "1973-03-02");
insert ignore into author (id, name, birth_date) values (2, "Paulo Coelho", "1947-08-24");
insert ignore into author (id, name, birth_date) values (3, "Alexandre Dumas", "1844-04-14");
insert ignore into author (id, name, birth_date) values (4, "Neil Gaiman", "1975-06-01");

insert ignore into publisher (id,name_publisher) values (1,"Rocco");
insert ignore into publisher (id,name_publisher) values (2,"Letras");
insert ignore  into publisher (id,name_publisher) values (3,"Paralela ");
insert ignore  into publisher (id,name_publisher) values (4,"Darkside");

insert ignore  into book (id,title, image, publisher_id, author_id ) values (1, "O Alquimista", "https://www.imgr.com/", 1, 2);
insert ignore  into book (id,title, image, publisher_id, author_id ) values (2,"Sandman", "https://www.imgr.com/", 4, 4);
insert ignore  into book (id,title, image, publisher_id, author_id ) values (3,"O senhor dos aneis", "https://www.imgr.com/", 3, 1);
insert ignore  into book (id,title, image, publisher_id, author_id ) values (4,"Os tres mosqueteiros", "https://www.imgr.com/", 2, 3);