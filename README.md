# hmpo-accessment

This project uses Rest assured, cucumber and junit to test codebase API.

## Running the application

application is defaulted to dev profile in pom.xml properties if you don't provide profile like below-
```shell script
mvn test
```

You can test your application in dev profile using:
```shell script
mvn test -Pdev
```

You can test your application in test profile using:
```shell script
mvn test -Ptest
```

You can test your application in uat mode using:
```shell script
mvn test -Puat
```

## Generating cucumber report
report will be generated after every test run . This report can be accessed from report url generated after test run.

## you can also test the application features directly from TestRunner by changing tag in Testrunner.java
