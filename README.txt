JVesuvius - a JSON web service.

JVesuvius is a JSON web service written in Java. It talks to PostgreSQL database and returns the results in JSON format. It uses Jersey and Jackson libraries and PostgreSQL JDBC driver.

The service can return:
    * full list of products
    * description of an individual product


Deployment instructions
-----------------------
    * Application requires
      -- PostgreSQL database running on localhost
      -- Apache Tomcat server running on localhost
      -- Apache Ant installed

    * Download and place external libraries (.jars) in <project_root>/lib directory.
      (Sorry, no Maven support just yet.)
      Please see file "dependencies.txt" for the full list of external libraries.

    * Enter database username and password into the file
      <project_root>/src/main/config/dbCredentials.properties .

    * Build the project by running "ant".
      Ant will
      -- compile java code
      -- build a .war archive
      -- deploy .war archive to Tomcat webapps directory (/var/lib/tomcat7/webapps/)
      -- generate API documentation


Usage instructions
------------------
    * To get the full list of products run:
      curl http://127.0.0.1:8080/jvesuvius/products/list

    * To get description of an individual product run:
      curl http://127.0.0.1:8080/jvesuvius/products/45701
      (where 45701 is a product ID)
