# Payment API Project

 This is a project to create a Payment API using the following technologies:

- Kotlin
- Spring Boot
- Java 21 (install using SDK Man)
- REST

For starters, it will be created a Mock API. Therefore, databases, events and complex business rules won't be used. 
However, this project will be improved by adding complexity and other technologies.

## API Specification

### Base URL
http://localhost:8080

### Endpoints
#### Create a New Payment
* HTTP Method: POST
* Endpoint: /payments
* Description: It creates a new payment
* Request body:
```json
{
 "amount": 100.50,
 "currency": "USD",
 "paymentMethod": "CREDIT_CARD",
 "description": "Payment for purchase #1234"
}
```
* Success response (200 OK):
```json
{
 "id": 1,
 "amount": 100.50,
 "currency": "USD",
 "paymentMethod": "CREDIT_CARD",
 "description": "Payment for purchase #1234",
 "status": "PENDING",
 "createdAt": "2024-06-04T12:34:56Z"
}
```
 

#### Get Payment By Id
* HTTP Method: GET
* Endpoint: /payments/{id}
* Description: It returns a specific payment by the given ID
* Request body: This request does not have a body
* Success response:
```json
{
 "id": 1,
 "amount": 100.50,
 "currency": "USD",
 "paymentMethod": "CREDIT_CARD",
 "description": "Payment for purchase #1234",
 "status": "PENDING",
 "createdAt": "2024-06-04T12:34:56Z"
}
```
  
