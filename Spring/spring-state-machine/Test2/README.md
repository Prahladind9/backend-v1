# WorkMotion Senior Backend Challenge
WorkMotion Senior Backend Challenge Task

For downloading dependencies and running tests locally:

```shell
mvn clean install
```

### Run Application

For running the application:

```shell
docker-compose build && docker-compose up -d
```

### Explore API

For exploring the API, you can visit swagger-ui link

* [Swagger UI](http://localhost:8080/openapi/swagger-ui.html)
* [Openapi JSON](http://localhost:8080/openapi/v3/api-docs)

--------------

## Testing app via rest api
Sample "workMotion.postman_collection.json" is located under resources

### addEmployee > PostMethod
```
http://localhost:8080/employee/addEmployee
```
```
{
    "orgId": 1,
    "name": "prao",
    "age": 29,
    "contractCompany": "WorkMotion",
    "contractStart": "2020-01-01",
    "contractEnd": "2021-01-01"
}
```
Response
```
{
    "employee": {
        "id": 1,
        "orgId": 1,
        "name": "prao",
        "age": 29,
        "contractCompany": "WorkMotion",
        "contractStart": "2020-01-01",
        "contractEnd": "2021-01-01",
        "state": "ADDED",
        "subState": "NA",
        "createAt": "2022-01-09T19:36:39.580853"
    },
    "nextActionToTake": "Choose nextPossibleEvent",
    "nextPossibleEvent": [
        "TO_IN_CHECK"
    ],
    "targetState": "IN_CHECK"
}
```
### getEmployeeDetails > GetMethod
```
http://localhost:8080/employee/getEmployeeDetails/1
```
Response
```
{
    "employee": {
        "id": 1,
        "orgId": 1,
        "name": "prao",
        "age": 29,
        "contractCompany": "WorkMotion",
        "contractStart": "2020-01-01",
        "contractEnd": "2021-01-01",
        "state": "IN_CHECK",
        "subState": "[SECURITY_CHECK_STARTED, WORK_PERMIT_CHECK_STARTED]",
        "createAt": "2022-01-09T19:36:39.580853",
        "lastUpdatedAt": "2022-01-09T19:41:49.194413",
        "lastUpdatedState": "ADDED"
    },
    "nextActionToTake": "Choose nextPossibleEvent",
    "nextPossibleEvent": [
        "TO_SECURITY_CHECK_FINISHED",
        "TO_WORK_PERMIT_CHECK_FINISHED"
    ],
    "targetState": "APPROVED"
}
```
### updateEmployeeState > PostMethod
```
http://localhost:8080/employee/updateEmployeeState/1?event=TO_IN_CHECK
```
Response
```
{
    "employee": {
        "id": 1,
        "orgId": 1,
        "name": "prao",
        "age": 29,
        "contractCompany": "WorkMotion",
        "contractStart": "2020-01-01",
        "contractEnd": "2021-01-01",
        "state": "IN_CHECK",
        "subState": "[SECURITY_CHECK_STARTED, WORK_PERMIT_CHECK_STARTED]",
        "createAt": "2022-01-09T19:36:39.580853",
        "lastUpdatedAt": "2022-01-09T19:41:49.194413",
        "lastUpdatedState": "ADDED"
    },
    "nextActionToTake": "Choose nextPossibleEvent",
    "nextPossibleEvent": [
        "TO_SECURITY_CHECK_FINISHED",
        "TO_WORK_PERMIT_CHECK_FINISHED"
    ],
    "targetState": "APPROVED"
}
```