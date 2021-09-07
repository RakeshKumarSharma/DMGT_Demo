# DMGTtest
Notes about the Test Framework

This Test Framework is built with Following tech stack:

Java

Selenium Webdriver

Cucumber

Maven

#How to run the tests

Clone the repository locally

Choose the browser to run the tests in the ``src/test/resources/project.properties`` file.

Default is "chrome" , the framework supports "firefox" also.

From the command line run the following command 

``mvn clean test  -Dcucumber.options="--tags @booking"``