create table usuarios(
    id int not null auto_increment primary key,
    nome varchar(255),
    email varchar(255),
    senha varchar(255),
    classeUsuario_id int not null,
    foreign key (classeUsuario_id) references classesUsuarios(id)
)