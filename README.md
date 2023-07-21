# Trello API Project - README

This project is a Java-based implementation of Trello API testing using Cucumber and Rest Assured libraries. The purpose of this project is to demonstrate how to interact with the Trello API, perform various actions, and validate the responses using BDD-style Cucumber scenarios and Rest Assured assertions.

## Prerequisites

To run this project, you need to have the following prerequisites installed on your system:

- Java Development Kit (JDK) - Version 8 or higher
- Maven - Build and dependency management tool

## Setup

1. Clone the project repository:

```
git clone https://github.com/MervinTravis/trello-api-automation-repo.git

2. Navigate to the project directory:

```
cd trello-api-project
```

3. Install project dependencies using Maven:

```
mvn install
```

## Configuration

I have already provided the Trello API credentials in the `configuration.properties` file located in the project's root directory. I you want tu use your credential open the file and update the following properties:

```
email=<your-trello-account-email>
password=<your-trello-account-password>
key=<your-trello-api-key>
token=<your-trello-api-token>
```

You can obtain your Trello API key and token by visiting the Trello Developer Portal: [https://trello.com/app-key](https://trello.com/app-key)

## Running the Tests

To run the tests, execute the following Maven command from the project directory:

```
mvn test

verify  from maven lifecycle. Triggers cucumber runner class and then generates
report

```

The tests will be executed, and the test results will be displayed in the console.

## Project Structure

The project follows the standard Maven directory structure. Here's an overview of the key directories and files:

- `src/test/java/com/trello/runners`: Contains the runner class for the test.
- `src/test/java/com/trello/step_definitions`: Contains the test code and step definitions.
- `src/test/java/com/trello/utilities`: Contains the necessary utility files.
- `src/test/resources/features`: Contains the test scenarios.
- `configuration.properties`: Contains the configuration properties.
- `pom.xml`: Maven project configuration file.
- `target`: Contains the test reports. To see the test report in HTML format, please run the tests through Shift+Alt+F10 and open the following file in a browser: `target/cucumber-html-reports/overview-features.html`

## Test Scenarios

The test scenarios are defined using Cucumber's Gherkin syntax and can be found in the `src/test/resources/features` directory. You can add or modify the existing scenarios to suit your testing needs.

## Libraries Used

This project utilizes the following libraries:

- Cucumber: A BDD-style testing framework that allows you to define test scenarios in a human-readable format.
- Rest Assured: A Java library for making HTTP requests and validating responses. It provides a simple and expressive syntax for API testing.

## Feedback and Contributions

If you have any feedback, suggestions, or issues with this project, please feel free to open an issue on the project repository. Contributions are also welcome!

For any further questions or inquiries, you can reach out to the project maintainer:


- Email: yukselsoysal@gmail.com