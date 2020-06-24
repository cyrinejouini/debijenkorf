# debijenkorf image Service Assignement
## Getting started
Follow the instructions in order to test it.

[More on AWS S3](https://docs.aws.amazon.com/s3/index.html)

## Prerequisites
 - Apache Maven
 - JDK 1.7+
 
 ## Configuration
Modify application.properties file with your aws s3 credentials

```java
spring.servlet.multipart.max-file-size=5242880
app.aws.iam.accesskey=<add-your-access-key>
app.aws.iam.secretkey=<add-your-secret-key>
app.aws.s3.clientregion=<add-your-s3-client-region>
app.aws.s3.bucketname=<add-your-s3-bucket-name>
```
 ## Build & Run
 -Build with Maven
 
```bash
mvn clean package
```
 -Run jar file
 java -jar debijenkorf-0.0.1-SNAPSHOT.jar 
-Run application: http://localhost:8080
 
 
 
