# README #

This README would normally document whatever steps are necessary to get your application up and running.

### This repository is for page:

[automationpractice.com](http://automationpractice.com )

* This repository was created as part of the final project, a course on "Manual Tester with an introduction to automation" organized by Softie.pl

## Used:	

1. Java 11+
2. Maven (This project is Maven type, so we need add support for Maven)
3. Selenium WebDriver (We need for servicing web browswer)
4. jUnit 5.x (We need to build test framework - for example "@Test" annotation)
5. Page object pattern
6. Page factory

### How do I get set up? ###

* Summary of set up and configuration:

1. IntelliJ Idea Community 2020.1 version > New > project from version controll
2. Right click on project folder > add framework support > (check) Maven

### Used packages description ###
* In src>test>java folder we have 3 packages:

1. pageobjects (which contains classes that corresponds to each of our pages and keeping methods that work on those pages, and all locators).

2. tests (package which contains all logic of tests written in jUnit)

3. utils (some classes that we need as additions to test, something that makes testing easier).



### Contribution guidelines ###

* Dependencies:

1. com.github.javafaker version>1.0.2
2. org.junit.jupiter version>5.6.3
3. org.seleniumhq.selenium version>5.6.3
4. All code of dependencies is in pom.xml file.

