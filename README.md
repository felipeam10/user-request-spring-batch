# ![DevSuperior logo](https://raw.githubusercontent.com/devsuperior/bds-assets/main/ds/devsuperior-logo-small.png) Read data from remote API and save data to DB using Spring Batch
>  Case study to implement a job to read data from a remote API and save to the database using Spring Batch

#### Before starting

- clients project --> in folder src/main/resources/client_project/clients --> open and run this project for your tests with principal user-request-spring-batch project
- [Using Docker Compose with MySQL and phpMyAdmin](https://github.com/devsuperior/docker-compose-mysql)

- Postman collection --> in folder resources/postman_files

#### import.sql

```sql
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('nabucodonosor', 'Franco Brasil', 'Araraquara/SP', 'https://avatars.githubusercontent.com/u/85499387?v=4', 44, 51, NOW(), 'http://githu.com/url', 'xpto');
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('moreirafelipe', 'Felipe Moreira', 'São Paulo/SP', 'https://avatars.githubusercontent.com/u/46508111?v=4', 129, 172, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('drapala', 'Drapala', 'Curitiba/PR', 'https://avatars.githubusercontent.com/u/85499387?v=4', 1, 0, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('tra91', 'Traski', 'Uberlandia/MG', 'https://avatars.githubusercontent.com/u/85099387?v=4', 44, 51, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('baba', 'Baba Olitch', 'Uberaba/MG', 'https://avatars.githubusercontent.com/u/85499387?v=4', 10, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('troski', 'Jorge Troski', 'Ribeirão Preto/SP', 'https://avatars.githubusercontent.com/u/85499350?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto');  
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('jorgeamado', 'Jorge Amado', 'Salvador/BA', 'https://avatars.githubusercontent.com/u/85499351?v=5', 1, 25, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('silvioalmeida', 'Silvio Almeida', 'São Paulo/SP', 'https://avatars.githubusercontent.com/u/85499350?v=4', 4, 10, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('micheli', 'Michelli Alexander', 'Florida/EUA', 'https://avatars.githubusercontent.com/u/10201024?v=4', 50, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('katia12', 'Katia Salla', 'Indaiatuba/SP', 'https://avatars.githubusercontent.com/u/2323213?v=4', 10, 10, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('ricardo', 'Ricardo Oliveira', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto');
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('karla', 'Karla Madeira', 'Belo Horizonte/NG', 'https://avatars.githubusercontent.com/u/85499351?v=5', 1, 25, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('paulo', 'Paulo Vieira', 'Palmas/TO', 'https://avatars.githubusercontent.com/u/85499350?v=4', 4, 10, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('luciano', 'Luciano Hulk', 'Rio de Janeiro/RJ', 'https://avatars.githubusercontent.com/u/10201024?v=4', 50, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('olaf12', 'Olaf', 'Indaiatuba/SP', 'https://avatars.githubusercontent.com/u/2323213?v=4', 10, 10, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('pbadsa', 'Rahauahuha', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('xptios', 'XPTOSLNS', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('ABACSDFS', 'ADBAVA', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('KAKSKS', 'KSKSIS', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('AKBAIA', 'AIBIANA', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto');
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('sallve', 'Sallve AA', 'Uberaba/SP', 'https://avatars.githubusercontent.com/u/2323213?v=4', 10, 10, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('nivea', 'Nivea', 'Goiania/GO', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('hiperx', 'HiperX', 'Salvador/BA', 'https://avatars.githubusercontent.com/u/13232444?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('greece', 'Greece', 'Atenas/GR', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('gil', 'Gil', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto');
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('aaa', 'AAA', 'Araraquara/SP', 'https://avatars.githubusercontent.com/u/85499387?v=4', 44, 51, NOW(), 'http://githu.com/url', 'xpto');
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('bbb', 'BBB', 'São Paulo/SP', 'https://avatars.githubusercontent.com/u/46508111?v=4', 129, 172, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('ccc', 'CCC', 'Curitiba/PR', 'https://avatars.githubusercontent.com/u/85499387?v=4', 1, 0, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('ddd', 'DDD', 'Uberlandia/MG', 'https://avatars.githubusercontent.com/u/85099387?v=4', 44, 51, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('eee', 'EEE', 'Uberaba/MG', 'https://avatars.githubusercontent.com/u/85499387?v=4', 10, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('fff', 'FFF', 'Ribeirão Preto/SP', 'https://avatars.githubusercontent.com/u/85499350?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto');  
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('ggg', 'GGG', 'Salvador/BA', 'https://avatars.githubusercontent.com/u/85499351?v=5', 1, 25, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('hhh', 'HHH', 'São Paulo/SP', 'https://avatars.githubusercontent.com/u/85499350?v=4', 4, 10, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('iii', 'Michelli Alexander', 'Florida/EUA', 'https://avatars.githubusercontent.com/u/10201024?v=4', 50, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('jjj', 'Katia Salla', 'Indaiatuba/SP', 'https://avatars.githubusercontent.com/u/2323213?v=4', 10, 10, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('kks', 'Ricardo Oliveira', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto');
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('lll', 'Karla Madeira', 'Belo Horizonte/NG', 'https://avatars.githubusercontent.com/u/85499351?v=5', 1, 25, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('mmm', 'Paulo Vieira', 'Palmas/TO', 'https://avatars.githubusercontent.com/u/85499350?v=4', 4, 10, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('nnn', 'Luciano Hulk', 'Rio de Janeiro/RJ', 'https://avatars.githubusercontent.com/u/10201024?v=4', 50, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('ooo', 'Olaf', 'Indaiatuba/SP', 'https://avatars.githubusercontent.com/u/2323213?v=4', 10, 10, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('ppp', 'Rahauahuha', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('qqq', 'XPTOSLNS', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('rrr', 'ADBAVA', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('sss', 'KSKSIS', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('ttt', 'AIBIANA', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto');
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('uuu', 'Sallve AA', 'Uberaba/SP', 'https://avatars.githubusercontent.com/u/2323213?v=4', 10, 10, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('vvv', 'Nivea', 'Goiania/GO', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('www', 'HiperX', 'Salvador/BA', 'https://avatars.githubusercontent.com/u/13232444?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('yyy', 'Greece', 'Atenas/GR', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto'); 
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('zzz', 'KSKSIS', 'Uberlandia/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url', 'xpto');
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('tmp', 'User tmp', 'Indaiatuba/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url/tmp', 'tmp');
INSERT INTO tb_client(login, name, location, avatar_url, followers, following, created_at, repos_url, company) VALUES('tmp123', 'User tmp 123', 'Franca/SP', 'https://avatars.githubusercontent.com/u/13232132?v=4', 30, 12, NOW(), 'http://githu.com/url/tmp', 'tmp');
```

#### Script

```sql
CREATE DATABASE app;
DROP TABLE IF EXISTS tb_user;
CREATE TABLE tb_user(login VARCHAR(30), name VARCHAR(60), avatar_url VARCHAR(100), PRIMARY KEY(login));
```