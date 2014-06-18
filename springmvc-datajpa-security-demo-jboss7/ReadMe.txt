Hi,
This application is code for http://www.sivalabs.in/2014/03/springmvc4-spring-data-jpa.html on JBoss AS 7.1.
1. DispatcherServlet mapping to "/" is not working.
2. Filter definitions through JavaConfig not working, so defined them in web.xml.
3. Changed all the Security interceptor URL mappings to /app/* as per DispatcherServlet mapping path.