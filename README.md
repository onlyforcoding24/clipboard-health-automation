# clipboard-health-automation

## How to run Test case :
### Run following command to run test cases :
* **For chrome :**
    ```
        mvn clean verify -Dtags=@yourTagName -Ddevice=chrome
    ```
* **For Firefox :**
    ```
        mvn clean verify -Dtags=@yourTagName -Ddevice=firefox
    ```

##### By default the test will run on chrome browser if we dont mention -Ddevice parameter:
* Command to run is as follows :
    ``` 
       mvn clean verify -Dtags=@yourTag
    ```

##### We can also pass wait time through command line :

* Command to run :
    ```
        mvn clean verify -Dtags=@tagName -DwaitTime=40
    ```
* The mentioned wait time is in seconds.
* This makes your test case more smooth

##### We can also run test cases in parallel as shown below :
* Command to run :
    ```
        mvn clean verify -Dtags=@tagName -DwaitTime=40 -Dthreads=2
    ```
* Here two test cases will run in parallel as we mentioned threads as 2 in above cammand

## Run following command to run test cases (problem statement solution):
 ```
        mvn clean verify -Dtags=@amazon
```
## How to see/access report
* Once the test case run successfully then the report can be accessed from location /target/Automation-Report/index.html
* ![Alt text](images/report1.png?raw=true "Optional Title")
* ![Alt text](images/report2.png?raw=true "Optional Title")
* ![Alt text](images/report3.png?raw=true "Optional Title")