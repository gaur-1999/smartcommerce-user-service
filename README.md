# SmartCommerce User Service

Microservices-based e-commerce backend — User authentication and authorization service.

## Tech Stack
- Java 17
- Spring Boot 4.x
- Spring Security
- JWT Authentication
- MySQL
- Docker

## Features
- User Registration with BCrypt password encryption
- JWT based Login
- Protected Profile API
- Role based access control (USER/ADMIN)
- Global Exception Handling

## API Endpoints

| Method | URL | Description | Auth |
|--------|-----|-------------|------|
| POST | /api/auth/register | Register new user | No |
| POST | /api/auth/login | Login and get token | No |
| GET | /api/user/profile | Get user profile | Yes |

## Setup

1. Clone the repo
2. Create MySQL database: `smartcommerce_users`
3. Copy `application.properties.example` to `application.properties`
4. Add your MySQL password
5. Run the application

## Related Services
- [Product Service](https://github.com/gaur-1999/smartcommerce-product-service)
- [Order Service](https://github.com/gaur-1999/smartcommerce-order-service)
- [Notification Service](https://github.com/gaur-1999/smartcommerce-notification-service)
