# req-res-testng

Use Java 8

Run test in folder 

```
/API-test/src/test/java/tests
```

If you want see allure results of tests.

1. Please install Allure Framework. https://docs.qameta.io/allure/

2. In the root of project:
   ```
   allure serve API-test/build/allure-results
   ```

For a second run, please check. That there is no "allure-results" folder in the "build" folder. If this folder "allure-results" does exist. Please delete it.