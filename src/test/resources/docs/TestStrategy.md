# Test Strategy for Swag Labs

---

```text

This document is written as if Swag Labs is an actual project that needs testing, 
meaning the test strategy is written as if for a real company, by a real team with it's own QA department.

```

---

### 1. Scope
The testing will be performed on the ECommerce demo application which includes the following functionalities:
- User account authentication
- Product showcase
- Shopping cart

### 2. Test Approach
The testing approach for this web application will include the following steps:
- Test planning: The testing team will review the requirements and develop a test plan that outlines the testing scope, objectives, and timelines.
- Test design: The testing team will develop test cases and test scenarios based on the requirements and user stories. Test data will be identified, and test environments will be set up.
- Test execution: The test cases will be executed using manual and automated testing techniques. The testing team will report and track defects, and retest fixed defects.
- Test reporting: The testing team will prepare and share test reports that summarize the testing progress, the number of defects, and the overall quality of the application.

### 3. Testing Types
The following testing types will be performed during the testing of the web application:
- UI Testing
  - Functional testing: This type of testing ensures that the application functions correctly according to the requirements. It includes the testing of the above-mentioned features.
  - Usability testing: This type of testing focuses on user experience, ease of use, and user interface design.
  - Security testing: This type of testing ensures that the ECommerce application is secure from unauthorized access, data breaches, and other security threats.
  - Compatibility testing: This type of testing checks if the application functions correctly across different browsers, devices, and operating systems.
  - Performance testing: This type of testing evaluates the system's responsiveness, stability, and scalability under different load and conditions.
- API Testing
  - No need for API testing, since Swag Labs is a demo app that does not have any back-end API calls

### 4. Testing Tools
There are a multitude of tools out there, here is a list of hand-picked ones: 
- Test management tools
  - XRay
  - Zephyr
  - Notion // NOTE: This is plenty good for a demo app like Swag Labs. 
           // In a real life project, I would/do use Jira & XRay.
- Test automation tools
  - SerenityBDD (wrapper library for Selenium and Java)
- Performance testing tools
  - JMeter
  - Gatling
  - NeoLoad
- Code quality and static analysis tools
  - SonarQube & SonarLint
- Test data management tools
  - Parasoft
- Continuous integration and continuous delivery (CI/CD) tools
  - GitHub Actions
  - Jenkins
  - etc...
- Defect tracking tools
  - Jira, Bugzilla (or anything similar)

### 5. Hardware - Software Configuration
The testing will be conducted on the following hardware and software configurations (based on the user and traffic analytics provided by the web development team or marketing team):
- Operating systems: IOS, Android, Windows, macOS, Linux
- Browsers: Chrome, Firefox, Safari

### 6. Reporting
The testing team will prepare and provide the following reports:
- Test Cases Execution Report: Provides information on the execution of test cases, including: 
  - Pass/fail status
  - Test case IDs 
  - Associated defects or issues encountered during testing 

- Defect Report: Contains details about the defects or issues discovered during testing, including:
  - Description 
  - Severity 
  - Priority 
  - Steps to reproduce 
  - Current status (open, resolved, closed)
 
- Test Summary Report: Offers an overview of the testing activities conducted, including:
  - Number of test cases executed 
  - Pass/fail rates 
  - Test coverage achieved 
  - Overall assessment of the application's quality
   
- Test Progress Report: Tracks the progress of testing activities throughout the project, including:
  - Planned versus actual test execution 
  - Remaining work 
  - Milestones achieved 
  - Risks or issues encountered
   
- Test Coverage Report: Provides insights into the extent of testing coverage achieved, including:
  - Areas of the application tested 
  - Types of testing performed 
  - Gaps or areas requiring additional testing