# Blankfactor Assignment

## Requirements
- JDK 1.8
- Maven

##  Frameworks
- Spring Boot 2.1.4.RELEASE

## SQLite DB
- sqlite-jdbc

## Parsing HTML page
- org.jsoup

## Exporting csv files
- com.opencsv

## Running the Application
1- Go to the root folder, open the command line, and type here: 
    ```
    clean package -DskipTests=true
    ```
    this command will install all necessary dependencies.
    then depending on the repository location, use this command to run the jar file
    ```java -jar Blanckfactor-0.0.1.jar```
    after that the application is going to run
2 - Reading all country report from HTML page and save it to generated SQLite DB in ```sqliteDatabase.db```
3 - You will be asked to Enter Region Name to present it into console (CMD) (eg. Europe)
4 - The application will presenf the data in formated table  and a message will appears that file ```export_Europe_YY_MM_DD.csv``` is generated successfully

## Additional information
The server is running on port: 8082
you can change it if needed from the resource file located at the location
```\src\main\resources\application.properties```
