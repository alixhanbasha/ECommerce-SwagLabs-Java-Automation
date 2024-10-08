# Swag Labs Automation

![Build](https://github.com/alixhanbasha/ECommerce-SwagLabs-Java-Automation/actions/workflows/maven.yml/badge.svg)

This is an example automation project that demonstrates the power and flexibility of Java + SerenityBDD with the Screen Play Pattern.

This project is a work in progress, and is updated on a regular basis.

Website under test: https://www.saucedemo.com/

![Checkout the documentation related to the features](src/test/resources/features/readme.md)

[Test Strategy](https://sugar-raclette-919.notion.site/Test-Strategy-for-Swag-Labs-897d5bccecac49739de0e26574e22690?pvs=4)


You can view the [QA Tickets (Read Only)](https://sugar-raclette-919.notion.site/ed8d249635b842e3bb8f6d0f54d81603?v=cdddfd633e9443a8a60e568df83c8bb3) made with Notion.
I chose Notion for test management because of its free plan and web-hosting. Ideally I would choose Jira/Xray but that's not free.

---

## Installation

Make sure you have **Java 21**, **Maven 3.8.^**, **Chromium or Google Chrome** installed.

```sh 
git clone https://github.com/alixhanbasha/ECommerce-SwagLabs-Java-Automation.git
cd ECommerce-SwagLabs-Java-Automation
mvn clean install # to install the dependencies
mvn verify -Dcucumber.tags="not @wip" # to run all the test cases not marked as @wip
```

If you want to check out the reports, click [this link](https://github.com/alixhanbasha/ECommerce-SwagLabs-Java-Automation/actions/workflows/maven.yml), select the latest run, 
and you should find the 'Serenity Report' artifact.
