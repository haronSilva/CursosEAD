insert into aluno (nome, matricula) values('Haron', 'AL1234');
insert into aluno (nome, matricula) values('Amanda', 'AL4321');
insert into curso (nome) values ('Programção Web');
insert into CURSO_ALUNO (aluno_id, curso_id) values (1, 1);
insert into CURSO_ALUNO (aluno_id, curso_id) values (2, 1);

insert into users(username, password, enabled) values ('haron', '{bcrypt}$2a$10$vcoEdK1t1XAaVd3Wt3L3ZuqhYprThyaRwX2WkjfC9sfLERqC/.t.e', true);
insert into authorities(username, authority) values ('haron', 'ROLE_ADMIN');

insert into users(username, password, enabled) values ('aluno', '{bcrypt}$2a$10$3l2o9kTB2SzAHTLLrkpFkOurLSIYZ2X/837jSCqyY/Ce190Jo2fOi', true);
insert into authorities(username, authority) values ('aluno', 'ROLE_USER');

