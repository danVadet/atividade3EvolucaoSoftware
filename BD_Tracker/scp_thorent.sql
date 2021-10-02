create database ThorEnt;

use ThorEnt;

create table Peer(
	ip char(15) primary key
);

create table Arquivo(
	hashArquivo    char(33)  not null,
    nome		   char(150) not null,
    tamanhoArquivo double    not null,
    tamanhoVetor   int 		 not null,
    ip 			   char(15)  not null,
    
    primary key Arquivo(hashArquivo, ip),
    
    constraint fk_arquivo_peer foreign key Arquivo (ip) references Peer (ip)
    on update cascade
    on delete cascade
);