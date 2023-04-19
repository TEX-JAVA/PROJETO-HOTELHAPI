create table reservas_servicos(
     reserva_id int not null,
     servico_id int not null,
     primary key (reserva_id, servico_id),
     foreign key (reserva_id) references reservas(id),
     foreign key (servico_id) references servicos(id)
);