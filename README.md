# IBM Project Readme

Welcome to the IBM Project! This is a demo project built using Spring Boot that showcases various features and technologies. This README provides an overview of the project structure, dependencies, and key information to help you get started.

## Table of Contents
- [Introduction](#introduction)
- [Technologies](#technologies)
- [Setup](#setup)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction
The IBM Project is a Spring Boot application designed to demonstrate the usage of Spring Boot, Spring Data JPA, and other related technologies. It provides a foundation for building web-based applications with a focus on simplicity and rapid development.

## Technologies
The project is built using the following technologies and dependencies:

- [Spring Boot](https://spring.io/projects/spring-boot): A powerful framework for building production-ready applications.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa): Simplifies the interaction with databases using JPA (Java Persistence API).
- [H2 Database](https://www.h2database.com/html/main.html): An in-memory database for development and testing purposes.
- [Lombok](https://projectlombok.org/): A library that reduces boilerplate code by providing annotations to generate common code.
- [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.2/reference/html/getting-started.html#getting-started-installing-spring-boot): A set of tools for development, including automatic restarts and hot swapping.
- [Spring Boot Starter Validation](https://spring.io/guides/gs/validating-form-input/): Integrates validation features into Spring Boot applications.
- [JUnit Jupiter](https://junit.org/junit5/docs/current/user-guide/): A testing framework for Java, used for writing and running tests.
- [Testcontainers](https://www.testcontainers.org/): A Java library for testing containers, providing reusable components for database testing.

## Setup
To run the IBM Project on your local machine, follow these steps:

1. Make sure you have Java 17 installed.
2. Clone this repository to your local machine.
3. Navigate to the project directory.
4. Build the project using Maven: `mvn clean install`

## Usage
Once you've successfully set up the project, you can run it using the following command:

```bash
mvn spring-boot:run
```
# IBM Project - Controller Routes

Here are the available routes in the `ReservationController` of the IBM project.

## Reservation Routes

### Insert Reservation
- **URL:** `/reservas`
- **Method:** `POST`
- **Description:** Insert a new reservation with the provided details.
- **Request Body (JSON):** `ReservationDto`
- **Response:** Details of the inserted reservation.

### List All Reservations
- **URL:** `/reservas`
- **Method:** `GET`
- **Description:** List all existing reservations.
- **Response:** List of all reservations.

### Get Reservation by ID
- **URL:** `/reservas/{id}`
- **Method:** `GET`
- **Description:** Get a reservation by its ID.
- **URL Parameters:** `id` (reservation ID)
- **Response:** Details of the corresponding reservation.

### Update Reservation
- **URL:** `/reservas/{id}`
- **Method:** `PUT`
- **Description:** Update details of an existing reservation.
- **URL Parameters:** `id` (reservation ID)
- **Request Body (JSON):** `ReservationDto`
- **Response:** Details of the updated reservation.

### Cancel Reservation
- **URL:** `/reservas/{id}/cancelar`
- **Method:** `DELETE`
- **Description:** Cancel an existing reservation.
- **URL Parameters:** `id` (reservation ID)
- **Response:** Details of the canceled reservation.

### List Confirmed Reservations
- **URL:** `/reservas/confirmadas`
- **Method:** `GET`
- **Description:** List all confirmed reservations.
- **Response:** List of confirmed reservations.

### List Pending Reservations
- **URL:** `/reservas/pendentes`
- **Method:** `GET`
- **Description:** List all pending reservations.
- **Response:** List of pending reservations.

### List Canceled Reservations
- **URL:** `/reservas/canceladas`
- **Method:** `GET`
- **Description:** List all canceled reservations.
- **Response:** List of canceled reservations.

---

*Note: Make sure to replace the variables enclosed in curly braces (e.g., `{id}`) with appropriate values when making requests.*


