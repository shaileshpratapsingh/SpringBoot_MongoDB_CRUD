# Spring Boot MongoDB CRUD APIs

This repository contains Spring boot endpoints with mongoDB as database.

## Import

Import this repository in eclipse/STS/intellij as existing maven project.

## Start Server
1. Right click on project and click on 'Run as' -> 'Java Application'.
2. Select main class 'Application.java'
3. Click OK, It will start the server

## Test APIs
These APIs can be tested using Postman or any other client.

## Endpoints
1. GET: localhost:8080/api/v1/users
2. GET: localhost:8080/api/v1/users/{id}
3. POST: localhost:8080/api/v1/users
  
    Request :
   ```bash
      {
          "firstName": "shailesh",
          "surName": "singh",
          "title": "Mr.",
          "dob": "1991-06-11T18:25:43.511Z"
      }
   ```
 4. DELETE: localhost:8080/api/v1/users/{id}
 5. PUT: localhost:8080/api/v1/users/{id}

    Request :
   ```bash
         {
            "firstName": "shailesh",
            "surName": "singh",
            "title": "Mr.",
            "dob": "1991-06-11T18:25:43.511Z"
         }
   ```

## Unit Tests
Unit test cases are available for service class.

### Run Unit Test Cases
Right click on test file -> Run as -> Junit Test


