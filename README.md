# Web E-Commerce Automation Testing

This repository contains automated tests for a web e-commerce application using **Java**, **Selenium WebDriver**, **TestNG**, and **GitHub Actions** for Continuous Integration/Continuous Deployment (CI/CD).

## Project Overview

The goal of this project is to provide an automated testing suite for a web e-commerce website. The tests are written in Java using Selenium WebDriver for browser automation, and TestNG for organizing and executing tests. GitHub Actions is used for continuous integration, running the tests automatically when changes are pushed to the repository.

## Tools and Technologies

- **Java**: The programming language used for writing the tests.
- **Selenium WebDriver**: The browser automation tool used for interacting with the web application.
- **TestNG**: The testing framework used for running and organizing the tests.
- **GitHub Actions**: Continuous integration and deployment service to automatically run tests on every change in the repository.

## Features

- Automated functional tests for the web e-commerce application.
- **Page Object Model (POM)**: The organization of the tests is based on the Page Object Model (POM), providing a structured, maintainable way of organizing test code by separating page interactions from test logic.
- CI/CD setup to ensure high-quality code with each change.

## Getting Started

### Prerequisites

To run the tests locally, you need to have the following tools installed:

- **Java 17** or higher.
- **Maven** for project management and dependencies.
- **IDE** like IntelliJ IDEA or Eclipse to open and run the project.

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/alevtinasemeniuk/web-ecommerce-automation.git
2. Install dependencies using Maven:

    ```bash
   mvn install
   
3. Run the tests locally:

    ```bash
   mvn test

## On GitHub Actions

- Tests are automatically triggered on each pull request.

## Continuous Integration (CI)

The project uses **GitHub Actions** to run tests automatically on every pull request to the `main` branch.  
The configuration is located in `.github/workflows/ci.yml`.

## File Structure

- **src/test/java** - Contains test classes and test scripts.
- **src/test/resources** - Configuration files for the tests.
- **pom.xml** - Maven configuration file for dependency management.
- **.github/workflows/ci.yml** - GitHub Actions workflow configuration file.

## Contributing

✨ If you want to contribute to this project, feel free to fork the repository and create a pull request! ✨  



