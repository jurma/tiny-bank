# Tiny Bank Guide

## Overview
Tiny-bank is a simple Spring Boot project that simulates a basic banking system using an in-memory database. The application demonstrates CRUD operations with the following features:

- Deposit funds into the account.
- Withdraw funds from the account.
- Retrieve the account balance.
- View the transaction history.

## Assumptions
- Thread safety implemented in the very basic way
- No error handling and mapping implemented
- The data model and architecture are designed in such a way as to enable easy future transition to a relational database.
- No tests are implemented 

## Prerequisites
- Java 23.
- Gradle build tool.
- An IDE or text editor for development (e.g., IntelliJ IDEA, Eclipse, VS Code).

## Project Setup

### 1. Clone the Repository
```bash
git clone <repository-url>
cd tiny-bank
```

### 2. Build the Project
Make sure `build.gradle` is properly configured. Run the following command to build the project:
```bash
gradle build
```

### 3. Run the Application
Start the application using:
```bash
gradle bootRun
```

The application will be accessible at `http://localhost:8080`.

## API Endpoints
* NB: you can use `queries.http` file with prepared queries

### 1. Deposit Funds
- **URL:** `/api/bank/deposit`
- **Method:** `POST`
- **Parameters:**
    - `amount` (double): The amount to deposit.
- **Response:**
    - The updated account balance.

### Example Request
```bash
curl -X POST "http://localhost:8080/api/bank/deposit?amount=100"
```

### 2. Withdraw Funds
- **URL:** `/api/bank/withdraw`
- **Method:** `POST`
- **Parameters:**
    - `amount` (double): The amount to withdraw.
- **Response:**
    - The updated account balance.

### Example Request
```bash
curl -X POST "http://localhost:8080/api/bank/withdraw?amount=50"
```

### 3. Get Account Balance
- **URL:** `/api/bank/balance`
- **Method:** `GET`
- **Response:**
    - The current account balance.

### Example Request
```bash
curl -X GET "http://localhost:8080/api/bank/balance"
```

### 4. View Transaction History
- **URL:** `/api/bank/transactions`
- **Method:** `GET`
- **Response:**
    - A list of transactions, each with the type (`DEPOSIT` or `WITHDRAW`) and the amount.

### Example Request
```bash
curl -X GET "http://localhost:8080/api/bank/transactions"
```

## Dependencies
This project uses the following dependencies:
- Spring Boot Starter Web
- Lombok (for reducing boilerplate code)

## Thread safety
Basic thread safety implemented for entities

## Extending the Project
The project architecture allows easily switch to use with relation database and JPA 

## Troubleshooting
- Ensure Java and Gradle are installed and correctly configured.
- If the application fails to start, check the logs for errors.

## License
This project is licensed under the MIT License. Refer to the LICENSE file for details.
