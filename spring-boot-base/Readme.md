## spring-boot-base

* spring-boot-base
  - execute tests: 
    - mvn test
    - mvn test -Dspring.profiles.active=mysql
    
  - execute web application: 
    - mvn spring-boot:run
    - mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=mysql"
    
  - accessing web application: http://localhost:8080
  
  
