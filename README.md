# Answers to all 3 questions has been given.

## Prerequisites

Before you begin, ensure you have the following installed:

1.  **Maven:** Make sure Maven is installed on your system. You can verify this by running `mvn -v` in your terminal.
2.  **Firefox:** The tests may rely on the Firefox browser being installed.
3.  **Java and Dependencies:** Ensure you have a compatible Java Development Kit (JDK) installed and that all necessary project dependencies (as managed by Maven) are in place.

## Steps for Execution

You have two primary ways to execute the tests:

1.  **Run all tests using Maven:**
    Navigate to the root directory of your project in your terminal and execute the following Maven command:
    ```bash
    mvn test
    ```
    This command will compile your project and run all the tests configured in your `pom.xml` file.

2.  **Run individual test cases:**
    All the test code for UI tests can be found in the following Java file:
    ```
    src/test/java/TellusTests.java
    ```
    You can open this file in your Integrated Development Environment (IDE) and run individual test methods or test classes directly from there. This is often useful for debugging or focusing on specific test scenarios.

3.  **Run API test cases:**
    All the test code for API tests can be found in the following Java file:
    ```
    src/test/java/ApiCases/ApiTests.java
    ```
    Similar to UI tests, you can open this file in your IDE to run individual API test methods or classes.
