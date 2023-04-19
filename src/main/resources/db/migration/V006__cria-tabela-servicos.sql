create table servicos(
     id int not null auto_increment primary key,
     nome varchar(255),
     preco decimal(19,2),
     hotel_id int not null,
     foreign key (hotel_id) references hoteis(id),
)