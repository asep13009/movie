# Java Spring BOOT ~ MOVIE RESTFULL

Movie backend apps with java 11

## RUN APP

build .jar app in ~procetbase/target/
```bash
mvn clean install
```
run result build app
```bash
java -jar movie-0.0.1-SNAPSHOT.jar
```

## Detail App
application.properties

```java
# port 8011 if run localhost  = http://localhost:8011/Movies
server.port=8011

# database make mariadb this is setting in application properties
spring.datasource.url=jdbc:mariadb://localhost:3306/movie?serverTimezone=Asia/Jakarta
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=12345
spring.jpa.hibernate.ddl-auto=update

```


## GIT

[GIT Asep Sudrajat](https://github.com/asep13009)
