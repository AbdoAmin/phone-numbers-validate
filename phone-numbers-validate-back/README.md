# Phone number validation by country
 to run this project with docker do the following steps:<br>
 <code> docker network create test-network </code>
  <br> then:
   <br>
 <code> docker build -t spring-phone-numbers . </code>
 <br> then:
 <br>
 <code> docker run -p 8080:8080 --rm -t --network test-network --name spring-phone-numbers spring-phone-numbers </code>
<br>
now you can run the API on localhost:8080.<br><br><br>