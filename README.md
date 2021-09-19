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
Go to the root folder, open the command line, and type here: 
```
clean package -DskipTests=true
```
this command will install all necessary dependencies.
then depending on the repository location, use this command to run the jar file
```java -jar Blanckfactor-0.0.1.jar```
after that the application is going to run
1 - Reading all country report from HTML page and save it to generated SQLite DB in ```sqliteDatabase.db```
2 - You will be asked to Enter Region Name to present it into console (CMD) (eg. Europe)
3 - The application will presenf the data in formated table like this 
+-----+---------------------------+----------------------+---------------+---------------+---------------+
|  #  |           Name            |         Region       |  Total cases  |  Active cases |  Total Tests  |
+-----+---------------------------+----------------------+---------------+---------------+---------------+
| 1   | UK                        | Europe               | 7400739       | 1306901       | 289860893     |
| 2   | Russia                    | Europe               | 7274928       | 578028        | 186600000     |
| 3   | France                    | Europe               | 6949519       | 207031        | 134787318     |
| 4   | Spain                     | Europe               | 4929546       | 210236        | 63040355      |
| 5   | Italy                     | Europe               | 4632275       | 113040        | 89156919      |
| 6   | Germany                   | Europe               | 4146128       | 169873        | 70379237      |
| 7   | Poland                    | Europe               | 2897935       | 162964        | 20452385      |
| 8   | Ukraine                   | Europe               | 2348381       | 62654         | 12471387      |

    and a message will appears that file ```export_Europe_YY_MM_DD.csv``` is generated successfully

## Additional information
The server is running on port: 8082
you can change it if needed from the resource file located at the location
```\src\main\resources\application.properties```
