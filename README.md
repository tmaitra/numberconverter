I have created a single API to convert the different number types

Method: `POST`
End point: `http://<host:port>/convert`

Request:

```
{
    "input": "23",
    "from": "DECIMAL",
    "to": "ROMAN"
}
```
Response:

```
{
    "result": "XXIII"
}
```

Implemented some basic exception handling.

Request:

```
{
    "input": "23",
    "from": "DECIMAL",
    "to": "BINARY"
}
```

Response:

```
{
    "timestamp": "2023-03-16T14:25:24.863918",
    "error": "BE-0001",
    "message": "Not supported operation"
}
```

It's also storing the Audit Log and created one sample end point to fetch all the audit log.

Method: `GET`

`http://<host:port>/audit`

Response:

```
[
    {
        "id": 1,
        "input": "23",
        "toType": "ROMAN",
        "fromType": "DECIMAL",
        "createdOn": "2023-03-16T13:22:29.025+00:00"
    },
    {
        "id": 2,
        "input": "23",
        "toType": "ROMAN",
        "fromType": "DECIMAL",
        "createdOn": "2023-03-16T13:24:04.465+00:00"
    },
    {
        "id": 3,
        "input": "23",
        "toType": "ROMAN",
        "fromType": "DECIMAL",
        "createdOn": "2023-03-16T13:24:05.997+00:00"
    }
]
```
This code can be exteded for any other conversion with out changing the contract. I have created an `ConversionTypeEnum` which can
be extended and add new types of conversion. Also, we are maintaing a converterMap to store all types of conversion implementation.
We can add new types there.

Provided some basic unit test cases to make sure functionality is working properly.





