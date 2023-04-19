create table reservas(
    id int not null auto_increment primary key,
    data_entrada DATE,
    data_saida DATE,
    qtd_pessoas int,
    total decimal(19,2),
    hotel_id int not null,
    quarto_id int not null,
    usuario_id int not null,
    foreign key (hotel_id) references hoteis(id),
    foreign key (quarto_id) references quartos(id),
    foreign key (usuario_id) references usuarios(id)
)