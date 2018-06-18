Transfer Service
===================
1. Requirement

This project involves building an API to account to account transfer. Details are available in the following document
https://github.com/FaizalArafath/assignments/blob/master/Requirement.pdf
 
2. Assumptions

Account to account transfer is within the same system. Not with bank or any other third party system. 
There can be two possible callers for Account Creation API - the end user or a bank admin
This API is built with the assumption that the account creation is a self registration process initiated by the end user and hence returns an activation link in the response using which the user can reset password and activate account. All usages of the API hereafter by the registered user are subject to authentication 
System supports default currency - EURO and hence the API does not explicitly expose any currency parameter
 
3. Approaches to handling simultaneous request

Synchronized block : Logic to transfer can be put it in synchronized block so that the other thread will be waiting for current thread to complete its task. 
Queue transfer object: Put transfer object to queue. Transfer will be done one by one. 
Lock table rows: Transfer request will lock the toAccount and fromAccount row so the other thread cannot read / write to both accounts. Second thread will wait for the lock to release. 
 
Best Solution: This implementation uses approach c - Locking Table Rows. Other two approaches hold all other requests if though they are not related to the request in process . Locking table rows makes  sure that only the requests that involve the accounts being processed currently are put on hold. 
 
4. Security consideration

Account information has to be encrypted in the DB
Secure the service connections using HTTPS
Token based authentication for REST service. But for the scope of this version  project,basic authentication has been implemented. Can be extended to include more sophisticated authentication and authorization mechanisms
 
5. TODOs

Fetching account details transaction associated with account. 
User activation link is not done. Activation link is not generated and sent back to the response. 
User activation service when user click activation URL. 
Junit for account service.
Security consideration mentioned above is not implemented. 
 
6. Class Diagram

https://github.com/FaizalArafath/assignments/blob/master/transferServiceClassDiagram.png
 
7. Java Document

https://github.com/FaizalArafath/assignments/tree/master/java-doc/com/aspire
 
 
Technology Stack
 
Instructions for Application Set up
 
How to Run:

This is a spring boot project. Maven is the build mechanism used. The application is packaged as a jar which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. Below are the set up instructions
1. Clone this repository
2. Make sure you are using JDK 1.8 and Maven 3.x
3. Run createDB.sql in your MYSQL
4. Change your DB details in application.yml file
5. You can build the project and run the tests by running mvn clean package
6. Once successfully built, you can run the service by one of these two methods:
        java -jar -Dspring.profiles.active=test target/transfer-service-api-0.0.1-SNAPSHOT.jar
7. Check the stdout or log file to make sure no exceptions are thrown
 
 
API Usage Guide:

1.Account Service:

  [POST] http://localhost:8093/ingenico/accounts - to create new account
  [PUT] http://localhost:8093/ingenico/accounts/activate/{accountId} - to activate account
  [PUT] http://localhost:8093/ingenico/accounts - update account details
  [GET] http://localhost:8093/ingenico/accounts/{accountId} - to get account information
  [DELETE] http://localhost:8093/ingenico/accounts/delete/{accountId} - to delete account
 
 2. Transfer Service:
 
   [PUT] http://localhost:8093/ingenico/transfer-api - transfer amount 
