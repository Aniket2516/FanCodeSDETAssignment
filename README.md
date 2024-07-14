
# Fancode SDET Assignment

This project ensure that the users in 'Fancode' city have completed more than 50% of their tasks based on their ToDos.

## Prerequisites
Before using this, ensure that you have following installed on you machine:

* Java Development Kit (JDK)
* Maven Build tool
* Any Integrated Development Environment (IDE) 

## Getting Started 

1. Clone the repository on local machine
  ```console
git clone https://github.com/Anic10x3/FancodeAssignmentTest.git
```
2. Open the project in your preferred IDE

3. Build the project using Maven to resolve the dependencies

## Running Test
Following are the steps for execution:

4. Right click on the testng.xml file and Click Run as Testng suite or

Navigate to src/test/java/ > FancodeGetRequest.java > Right Click on the file and Click run as TestNG test.

5. Test results will be displayed in the console, including Passes, Fail and Skips and any assertions.

6. ExtentReport will be generated for the result with logs 

## Scenario Automated

* All users of City FanCode should have more than half of their todos task completed.
* Users are identified based on latitude between (-40 to 5) and longitude between (5 to 100).
* For each user, fetch their todos and calculate the completion percentage.
* Assert that the completion percentage is greater than 50%.
* Logs added to trace execution steps and help in debugging.


## Endpoints used

#### Get all users

```https://jsonplaceholder.typicode.com
  GET /users
```

| Description                |
| :------------------------- |
| **This endpoint fetches the users present in the system**.  |

#### Get todo

```https://jsonplaceholder.typicode.com
  GET /todos
```

| Description                       |
| :-------------------------------- |
 **This endpoint fetches all the todos in the system** |


### Test Results
Test results will be displayed in the console as well as Extent Report will be generated in Reports folder with the name 'TestReports.html'





