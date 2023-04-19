create table usuarios(
    id int not null auto_increment primary key,
    nome varchar(255),
    email varchar(255),
    senha varchar(255),
    classe_usuario_id int not null,
    foreign key (classe_usuario_id) references classes_usuarios(id)
)