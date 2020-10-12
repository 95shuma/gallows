# Gallows


### При разрабобтке используется

* java version "13.0.2"
* javac 13.0.2
* Sring Boot 2.3.0.RELEASE
* PostgreSQL 12, compiled by Visual C++ build 1914, 64 bit
* IntelliJ IDEA 2019.3.3 (Ultimate Edition)
* Apache Maven 3.6.1

### Инструкция по разворчиванию окружения
Открыть терминал  
Вставить:
```
git clone https://github.com/95shuma/gallows.git
```
Войти в папку gallows (команда для терминала: cd gallows)  
Прописать команду в терминале: 
```
docker-compose build
```
После окончания выполнения команды  
Прописать команду в терминале: 
```
docker-compose up
```
После запуска программы  
Перейти в браузер и прописать: [localhost:8080](http://localhost:8080/)

### Об игре GALLOWS
Есть панель администратора и панель пользователя  
Функционал панели администратора:
* может добавить пользователя
* может добавить новое слово
* посмотреть статистику всех игроков
Функционал панели пользователя:
* игра
* посмотреть свою статистику

Тестовые данные
* Админ (login: "admin"; password: "admin")
* User (login: "user"; password: "user")

## Собрано с помощью

* [Maven](https://maven.apache.org/) - Dependency Management

## Автор

* https://github.com/95shuma
