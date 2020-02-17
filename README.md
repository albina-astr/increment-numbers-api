API to increment digits from the string
---------------------------------------
Provides a method to increment integer values from the string (given string must not contain letters)

Stack:
- Spring Boot
- Java 8
- JUnit 4


METHOD DESCRIPTION
------------------------
Resource path: /numbers
------------------------

>1. POST /increment
- Increments integers from the string if the string consists of digits and whitespaces
- Parameter type: body
- Parameter content type: JSON
- Parameter model schema:
`{
    "request": "string"
}`
- Response Content Type: JSON
- Status 200


