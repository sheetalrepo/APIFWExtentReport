### OM ###
# Rest Assured TestNG based API Automation Framework
@ProdBug https://www.youtube.com/c/sheetalsingh23/videos


#How to run
mvn clean test -DsuiteXmlFile="demo.xml" -Denv="prod"
mvn clean test -DsuiteXmlFile="demo.xml" -Denv="sb"
mvn clean test -DsuiteXmlFile="demoExtent.xml" -Denv="prod"
mvn clean test -DsuiteXmlFile="demoExtent.xml" -Denv="sb"
mvn clean test -DsuiteXmlFile="demoWM.xml" -Denv="sb"


#Reports
Extent: target\extent-reports\extent-report.html
TestNG: target\surefire-reports\index.html


#FW Feature:
1. Running via mvn command line (easy to run via CICD)
2. Build will not fail/stop in case few TCs fail in between (maven-surefire-plugin)
3. Extent/TestNG Report
4. Retry listener implemented
5. Mocking
6. Test data reading from csv
7. Test data reading from Data Provider (few cases)
8. Env specific URLs (Prod, Sandbox, QA etc) placed in YAML file
9. Common endpoints placed in YAML file
10. Response verification via Deserialization (POJOs) and JSONPath


#Ref:
https://mvnrepository.com/artifact/com.aventstack/extentreports
https://www.extentreports.com/docs/versions/4/java/spark-reporter.html
https://json2csharp.com/code-converters/json-to-pojo

YAML https://www.youtube.com/watch?v=LqpuHqpB76s&list=PLEiBaBxmVLi8v8veL61aqsbEc5rofHDtL
RestAssured Basics: https://www.youtube.com/watch?v=AbJrfP4ziIk&list=PLEiBaBxmVLi-hoi61aX-2agQb8EXSCT5f
RestAssured Adv Topics: https://www.youtube.com/watch?v=lUcEYA4BS2E&list=PLEiBaBxmVLi_4HbysORHdMon4b4YMcZIW




