🥒 My BDD Cucumber Demo Project
A sample Cucumber BDD automation framework built using Java, Selenium, Maven, and integrated with Extent Reports for clear and structured reporting.

🚀 Tech Stack
Language: Java
Framework: Cucumber (Behavior Driven Development)
Build Tool: Maven
Testing Library: JUnit
Reporting: Extent Reports
Design Pattern: Page Object Model (POM)

💡 Key Highlights
Demonstrates BDD approach using Cucumber feature files
Implements Page Object Model (POM) for better structure and maintainability
Integrated Extent Reports for detailed HTML execution reports
Configurable test execution via Maven (mvn test)
Includes example test scenarios for learning and demonstration

🧠 Sample Scenario
    Feature: Login Functionality
    Scenario: Valid login with correct credentials
    Given User is on login page
    When User enters valid username and password
    Then User is navigated to the homepage
    
📊 Extent Report Example
After test execution, a detailed HTML report is generated under target/ExtentReports/, showing:
Pass/fail status for each step
Execution duration
Screenshot attachments for failed steps
Scenario-wise summary

🧩 How to Run
Clone the repository
Run the following command:
mvn clean test
View the HTML report under:
target/ExtentReports/

👩‍💻 About the Author
Honeyta Alexander — QA Automation Engineer with 7+ years of experience in automation testing using Selenium, Java, TestNG, and Cucumber.
Currently based in Dubai, exploring new opportunities in QA Automation / Test Lead roles.
📫 LinkedIn: linkedin.com/in/honeyta-alexanderqaautomation
