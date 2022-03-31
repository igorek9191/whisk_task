### About test automation task:
UI tests <br />
Requirements for 1 and 2 tests: Should be realized in one test-class
Test 1: (Create this test without cycles in 6 steps (like for, foreach and etc))
1. Navigate to https://my.whisk-dev.com/
2. Sign in
3. Navigate to Shopping tab
4. Create Shopping list
5. Add 5 items
6. Check by Name that 5 items are added to Shopping list (check each name like a single test)
   Test 2:
1. 1-4 steps from 1 test
2. Delete Shopping list
3. Check that user doesn't have Shopping lists<br />
Back-end tests: <br />
   Requirements: Create tests in one test-class and relized precondition from 1 step for all back tests
   host: https://api.whisk-dev.com/
   Content-type: application/json
   Authorization: Bearer 4S6sAfpswCnp0N32xLv5VYgyrdVDCa1ENK0KA781GrzvGRgSlTxQFa5SaH6UPbIL
   Test 1:
1. Create Shoping list POST: /list/v2
   body:
   {
   "name": "string",
   "primary": false
   }
2. Get Shopping List by id: GET /list/v2/{id}
3. Verify that response contains necessary id
4. Verify that Shopping list is empty (content object is empty)
   Test 2:
1. 1 step from Test 1
2. Delete Shopping list by id DELETE: /list/v2/{id}
3. Get Shopping List by id: GET /list/v2/{id}
4. Verify that code response = 200
5. Verify that response message is 'shoppingList.notFound'

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
