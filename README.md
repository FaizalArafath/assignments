Transfer Service
================

1. Requirement

This project involves building an API to account to account transfer. Details are available in the following document
https://github.com/FaizalArafath/assignments/blob/master/Requirement.pdf
 
2. Assumptions

a)	Account to account transfer is supported by the system where as both accounts are part of the same system. Inter-bank money transfer and transfer to any other 3rd party system is not in the scope of the project. 
b)	Account Creation API can be consumed by two parties 
1.	One thru the end user by self registration (Partially Done)
2.	Another via the ADMIN application available in the system (TODO)
c)	System supports default currency - EURO and hence the API does not explicitly expose any currency parameter
 
3. PROPOSED Solution to handle simultaneous requests
a.	Synchronized block: Logic to transfer can be put it in synchronized block so that the other thread will be waiting for current thread to complete its task. (Solution 1 – Not implemented)

b.	Queue transfer object: Put transfer object in to a queue. Transfer will be done one by one. (Solution 2 – Not implemented) 

c.	Lock table rows: Transfer request will lock the toAccount and fromAccount row so the other thread cannot read / write to both accounts. Second thread will wait for the lock to release. (Solution 3 – Implemented)
 Justification: Solution 1 and 2 will hold all requests in queue regardless of the accounts that are currently being processed(FromAccount and ToAccount of a particular transaction). Locking table rows makes sure that only the requests that involve the accounts being processed currently are put on hold. 
 
4. Security consideration 

a.	Account information has to be encrypted in the DB (To be implemented. Not in scope)
b.	Secure service connections using HTTPS (To be implemented. Not in scope)
c.	Token based authentication for REST service. But for the scope of this version project, basic authentication has been implemented. Can be extended to include more sophisticated authentication and authorization mechanisms
 
5. TODO’s

a.	Fetching account details transaction associated with account. 
b.	User activation link is not done. Activation link is not generated and sent back to the response. 
c.	User activation service when user click activation URL. 
d.	Junit for account service.
e.	Security consideration mentioned above is not implemented. 
 
6. Class Diagram

https://github.com/FaizalArafath/assignments/blob/master/transferServiceClassDiagram.png
 
7. Java Document

https://github.com/FaizalArafath/assignments/tree/master/java-doc/com/aspire
 
 
Installation Instruction
========================


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

1.	Account Service:

a.	[POST] http://localhost:8093/ingenico/accounts - to create new account
b.	[PUT] http://localhost:8093/ingenico/accounts/activate/{accountId} - to activate account
c.	[PUT] http://localhost:8093/ingenico/accounts - update account details
d.	[GET] http://localhost:8093/ingenico/accounts/{accountId} - to get account information
e.	[DELETE] http://localhost:8093/ingenico/accounts/delete/{accountId} - to delete account

2. Transfer Service:
	   
a.	 [PUT] http://localhost:8093/ingenico/transfer-api - transfer amount 

