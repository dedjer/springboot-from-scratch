## Project Spring Boot from Scratch

Goal of this repo is to create a spring boot project from scratch 
so I understand each dependency I add to a project and how to resolve 
issues.  

This is project mimics what [Spring Initialzr](http://start.spring.io) 
would do if you were trying to build a Spring Data JPA REST project.

## Maven Dependencies

MySql Connector

```maven
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
```

REST Annotation Support

```maven
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-rest</artifactId>
    </dependency>
 
```

JPA / Hibernate object relational mapper (ORM)

```maven
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
```
        
HAL Browser to create a website to navigate our REST apis

```maven
    <dependency>
        <groupId>org.springframework.data</groupId>
        <artifactId>spring-data-rest-hal-browser</artifactId>
    </dependency>
```

Mean Bean to easily unit test our POJOs

```maven
    <dependency>
        <groupId>org.meanbean</groupId>
        <artifactId>meanbean</artifactId>
        <version>2.0.3</version>
        <scope>test</scope>
    </dependency>
```

Spring Boot Test Starter (JUnit, Mockito, etc)  

```maven
   <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
 
```

DevTools for Hot Reloading our changes in Chrome

```maven
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
```

Lombok to easily wire up constructors, getters, and setters

```maven
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.4</version>
        <scope>provided</scope>
    </dependency>
```

## Project Files

# lab-springboot-enum
