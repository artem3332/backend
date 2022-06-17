# backend

Сonnecting to the database:

server.port=8095 ;
spring.datasource.url=jdbc:postgresql://localhost:5432/DataBase ;
spring.datasource.username=username ;
spring.datasource.password=password ;
spring.datasource.driver-class-name=org.postgresql.Driver ;

spring.jpa.database=postgresql ;
spring.jpa.generate-ddl=true ;
spring.jpa.show-sql=true ;
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQL10Dialect ;

EndPoints:

1)Post
http://localhost:port/users/create
Body(JSON):
{
    "login":"123",
    "name":"name",
    "password":"Password1",
    "roleList":["role1","role2"]
}

2)Get
http://localhost:port/users/findAll

3)Get
http://localhost:port/users/userById
Body(JSON):
{
    "login":"123"
}

4)Delete
http://localhost:port/users/userDeleteById
Body(JSON):
{
    "login":"123"
}

5)Put
http://localhost:port/users/userPutById
Body(JSON):
{
    "login":"123",
    "stringList":["role1","role2"]
}
