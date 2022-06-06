# Car API

The **Car API** is REST API which allows to maintain car versions. API uses H2 database to store car details.

### Run API locally

#### Build application
```mvn clean install```

#### Run application
```mvn spring-boot:run```

Note: the application starts on port 8081.

#### Test API

##### GET (Read car details)
```GET http://localhost:8081/api/car/<id>```

##### POST (Create new Car)
```POST http://localhost:8081/api/car```
Request body example:
```
{
"make": "Ford",
"model": "Ford Fiesta",
"version": "1",
"numberOfDoors": 4,
"co2Emission": 3.8,
"grossPrice": 34000.8,
"nettPrice": 30000.9,
"mileage": 1000
}
```

##### PUT (Update Car details)
```PUT http://localhost:8081/api/car/<id>```
Request body example:
```
{
"make": "Ford",
"model": "Ford Fiesta 1",
"version": "12",
"numberOfDoors": 4,
"co2Emission": 3.8,
"grossPrice": 34000.8,
"nettPrice": 30000.9,
"mileage": 1000
}
```

##### DELETE (Delete Car)
```DELETE http://localhost:8081/api/car/<id>```
