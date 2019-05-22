# ArchUnit Examples

This module houses some example rules to illustrate how to use ArchUnit
(and also provide input for the `archunit-integration-test`):
* [`example-junit4`](example-junit4/src/test/java/com/tngtech/archunit/exampletest/junit4/)
  for ArchUnit rules using JUnit 4
* [`example-junit5`](example-junit5/src/test/java/com/tngtech/archunit/exampletest/junit5/)
  for ArchUnit rules using JUnit 5
* [`example-plain`](example-plain/src/test/java/com/tngtech/archunit/exampletest/)
  for plain ArchUnit rules, which can be used with any test runner (e.g. TestNG)
    
Those examples are applied to classes from [`example-plain/main`](example-plain/src/main/java/com/tngtech/archunit/example/),
which are designed to break the architectural concepts (like layer dependencies, etc.).
This demonstrates how ArchUnit detects such violations.

In order to execute those tests (marked with `@Category(Example.class)`, excluded from the regular build),
simply add the property `example` to the Gradle build:
```
../gradlew clean build -P example
```

Alternatively, the tests can also be run directly from any IDE, of course.

Happy exploring!