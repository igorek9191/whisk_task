### About test automation task:
UI tests <br />
Requirements for 1 and 2 tests: Should be realized in one test-class<br />
#### Test 1:
1. Navigate to https://my.whisk-dev.com/
2. Sign in
3. Navigate to Shopping tab
4. Add 5 popular items
5. Check by Name that 5 items are added to Shopping list<br />
#### Test 2:
6. 1-4 steps from 1 test
7. Delete Shopping list
8. Check that user doesn't have Shopping lists<br />
#### Back-end tests: <br />
   Requirements: Create tests in one test-class and relized precondition from 1 step for all back tests<br />
   host: https://api.whisk-dev.com/ <br />
   Content-type: application/json<br />
   Authorization: Bearer Hp1wwzc0AMBi2YyXE2UPqB2pQQoAyG1GLgf9fbDbtCRXNBNONrfMTLGHNohqaqyx<br />
#### Test 1:
9. Create Shoping list POST: /list/v2
   body:
   {
   "name": "string",
   "primary": false
   }
10. Get Shopping List by id: GET /list/v2/{id}
11. Verify that response contains necessary id
12. Verify that Shopping list is empty (content object is empty)<br />
####Test 2:
13. 1 step from Test 1
14. Delete Shopping list by id DELETE: /list/v2/{id}
15. Get Shopping List by id: GET /list/v2/{id}
16. Verify that code response = 200
17. Verify that response message is 'shoppingList.notFound'

### Required Tools
Java 14<br />
Gradle 7.1<br />
allure 2.15.0<br />

### Launch of tests
In the root of project put in command prompt:<br />
```gradle clean test ```<br />
OR<br />
```./gradlew clean test ``` (if you work at Mac)

### Test report
In the root of project put in command prompt:<br />
```allure serve build/allure-results/```  <br />
Then open ```Behaviors``` tab and you will see the result. <br />` 
