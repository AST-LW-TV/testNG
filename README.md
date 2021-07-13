# TestNG

## Walkthrough

### [utilities package](https://github.com/AST-LW-TV/testNG/tree/main/testNG/src/test/java/utilities)
 
- ####[pages package](https://github.com/AST-LW-TV/testNG/tree/main/testNG/src/test/java/utilities/pages)
    - [HomePage Class](https://github.com/AST-LW-TV/testNG/blob/main/testNG/src/test/java/utilities/pages/HomePage.java) - Home page functionalities
    - [LoginPage Class](https://github.com/AST-LW-TV/testNG/blob/main/testNG/src/test/java/utilities/pages/LoginPage.java) - Login page functionalities
- ####[screenshots package](https://github.com/AST-LW-TV/testNG/tree/main/testNG/src/test/java/utilities/screenshot)
    - [Screenshot Class](https://github.com/AST-LW-TV/testNG/blob/main/testNG/src/test/java/utilities/ScreenShot.java) - Screenshot functionality
    - When Succeeded, navigates to home page ... 
    ![](https://github.com/AST-LW-TV/testNG/blob/main/testNG/src/test/java/utilities/screenshot/success_1.png) 
    - When Failed, exits by taking screenshot ... 
    ![](https://github.com/AST-LW-TV/testNG/blob/main/testNG/src/test/java/utilities/screenshot/errorLogin_3.png)

- #### [BrowserSetUp Class](https://github.com/AST-LW-TV/testNG/blob/main/testNG/src/test/java/utilities/BrowserSetUp.java)

    - Sets the browser
    - Navigates to the specified URL
    - returns the driver element

- #### [PageReference Class](https://github.com/AST-LW-TV/testNG/blob/main/testNG/src/test/java/utilities/PageReference.java) 
  - Concept of Page-Object Model

- #### [Listener Class](https://github.com/AST-LW-TV/testNG/blob/main/testNG/src/test/java/utilities/Listener.java)
  - Listens to the tests when passed or failed and performs the defined functionality 

### [testscripts packages](https://github.com/AST-LW-TV/testNG/tree/main/testNG/src/test/java/testscripts)
- Implements the [LoginTest Class](https://github.com/AST-LW-TV/testNG/blob/main/testNG/src/test/java/testscripts/LoginTest.java) 
  - Has two test cases for valid and invalid login credentials
- To execute the tests, run the following command in CLI  

```
mvn -P LoginTests test  
```  
