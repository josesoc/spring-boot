## spring-boot-base

* spring-boot-base

  - versions
    - v2.7: spring-data jpa criteria support
    - v2.6: spring-data jpa relations
    - v2.5: multiple databases support by spring-profiles
    - v2.4: i18n support
    - v2.3: Twitter Bootstrap support    
    - v2.2: spring-data jpa support with unit tests
    - v2.1: logging support
    - v2.0: Apache Tiles support
    - v1.0: spring-boot basic sample with jstl support
    
  - execute
  	- execute tests: 
    	- mvn test
    	- mvn test -Dspring.profiles.active=mysql
    
  	- execute web application: 
    	- mvn spring-boot:run
    	- mvn spring-boot:run -Drun.jvmArguments="-Dspring.profiles.active=mysql"
    
  	- accessing web application: http://localhost:8080
  	
  - rest
    - curl localhost:8080/role/getAll
    - curl -H "Content-Type: application/json" -d '{"name":"admin"}' http://localhost:8080/role/add
  
  
