# Bank Management API

A REST API built with Spring Boot for managing bank accounts.

## 🚀 Features
- Create bank account
- Get account by ID
- Get all accounts
- Deposit money
- Withdraw money
- Delete account

## 🛠️ Technologies
- Spring Boot
- Spring Data JPA
- MySQL

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|---------|------------|
| POST   | /accounts | Create account |
| GET    | /accounts | Get all accounts |
| GET    | /accounts/{id} | Get account by ID |
| PUT    | /accounts/deposit/{id} | Deposit money |
| PUT    | /accounts/withdraw/{id} | Withdraw money |
| DELETE | /accounts/{id} | Delete account |

## 🧪 Testing
Tested using Postman

## ▶️ Run the project
```bash
mvn spring-boot:run
