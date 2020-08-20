# gallows


### При разрабобтке используется

* java version "13.0.2"
* javac 13.0.2
* Sring Boot 2.3.0.RELEASE
* PostgreSQL 12.3, compiled by Visual C++ build 1914, 64 bit
* IntelliJ IDEA 2019.3.3 (Ultimate Edition)
* Apache Maven 3.6.1

### Инструкция по разворчиванию окружения

создать базу данных в Postgres
с именем "gallows_db"

```
git clone https://github.com/95shuma/gallows.git
```

Открыть с помощью IntelliJ IDEA
* в файле application.properties
ввести свои данные 
* spring.datasource.url - путь к БД
* spring.datasource.username - имя пользователя
* spring.datasource.password - пароль

запустить проект

Тестовые данные
* Админ (login: "admin"; password: "admin")
* User (login: "user"; password: "user")

## Собрано с помощью

* [Maven](https://maven.apache.org/) - Dependency Management

## Автор

* https://github.com/95shuma
