# simple-webapp

How to use
==================================================
A simple webapplication. It is maven based.
1. Use maven to build the war file, simple.war.
2. Deploy war file to a tomcat, 8 or above.  I tested on tomcat 8 only.
3. Open browser to load page http://[tomcat server]:[tomcat port/simple/index.html.
4. In the page, enter your data string and then click button "count".


Project Structure
==================================================
The backend is restful servic based on spring mvc.  The service class is StringCounter.java.  The unit test is in StringCounterTest.java.

The front end is a html file of angular.js, index.html
