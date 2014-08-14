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
mvn clean package

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


License
=======
Apache License, Version 2.0
http://www.apache.org/licenses/LICENSE-2.0
