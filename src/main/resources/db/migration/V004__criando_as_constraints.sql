
alter table book add constraint FKklnrv3weler2ftkweewlky958
 foreign key (author_id) references author (id);

alter table book add constraint FKgtvt7p649s4x80y6f4842pnfq
 foreign key (publisher_id) references publisher (id);
