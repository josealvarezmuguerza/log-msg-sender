log-msg-sender
===============

This is a simple java project for testing purposes. It spits out log lines samples over different Log4j appenders, Flume-ng appender included.

Requirements
===========

 - JDK 1.6+
 - maven
 
 
Installation
===============
```java
git clone git@github.com:josealvarezmuguerza/log-msg-sender.git
cd log-msg-sender
mvn assembly:assembly

```

Usage
===============
```java
cd log-msg-sender/target
java -jar log-msg-sender-jar-with-dependencies.jar {args}

Arguments:

  -i: Number of iterations
       example 1000 messages: 'java -jar log-msg-sender-jar-with-dependencies.jar -i 1000'

  -f: Frequency
       example 100 messages every 30 seconds: 'java -jar log-msg-sender-jar-with-dependencies.jar -f 100 30'
```

Each sample log line has the following format:

```java
{ message_id } - { client_id } -  another log entry  - {localhost IP}


* where client_id from 1 to 10

ie:  1004 - 5 -  "another log entry"  - 127.0.0.1

```

###log4j.properties

Update this file in order to change the appender to use. In the bellow configuration, the 3 appenders are activated:

```java
log4j.rootLogger = INFO, stdout, file, flume

# Define the file appender
log4j.appender.file=org.apache.log4j.FileAppender
log4j.appender.file.File=messages.log
log4j.appender.file.layout=org.apache.log4j.PatternLayout

# Define the console appender
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.Target=System.out
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout

# Define the flume appender
log4j.appender.flume = org.apache.flume.clients.log4jappender.Log4jAppender
log4j.appender.flume.Hostname = 127.0.0.1
log4j.appender.flume.Port = 4141
log4j.appender.flume.layout=org.apache.log4j.PatternLayout

```


License
=======
Apache License, Version 2.0
http://www.apache.org/licenses/LICENSE-2.0
