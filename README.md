Microservices for Todo (in progress)

1) db-service :
  Microservice which handles all database related activities.  It is a Eureka client. It handles :
    a. Users table
    b. Tasks table
  The database used here is Mysql

2) user-management-service :
  Microservice which handles all users related activities. It is a Eureka client. It handles :
    a. Adding a user.
    b. Getting a user for given id,
    It internally calls db-service to get/add users from database.
    
3) task-management-service : 
  Microservice which handles all tasks related activities. It is a Eureka client. It handles :
    a. Adding a task.
    b. Getting a task for given user id,
    It internally calls db-service to get/add tasks from database.
    
4) eureka-server : 
    This is the Eureka Server to which all the above services are registered.
