# springboot-practice-project



## mysql 초기화 (데이터베이스생성 + 유저생성)
show databases;

create database board;

create user 'tester'@'localhost' identified by 'asdf1234';

select `user` from `mysql`.`user`;

show grants for 'tester'@'localhost';

grant all on `board`.* to 'tester'@'localhost' with grant option;

flush privileges;



## application.yaml

debug: false

logging:
  level:
    com.spp.springbootpractieproject: debug
    org.springframework.web.servlet: debug
    org.hibernate.type.descriptor.sql.BasicBinder: trace

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/board
    username: tester
    password: asdf1234
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    defer-datasource-initialization: true
    hibernate.ddl-auto: create
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        default_batch_fetch_size: 100
  h2.console.enabled: true
  sql.init.mode: always

---

spring:
  config:
    activate:
      on-profile: testdb