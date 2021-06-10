# spring-boot-jms-message
# spring-boot-jms-message

1. Запустить IBM MQ, выполнив следующие команды:

$ docker pull ibmcom/mq

$  docker volume create qm1data

$ docker run -d --name mq --env LICENSE=accept --env MQ_QMGR_NAME=QM1 -p 1414:1414 -p 9443:9443 --volume qm1data:/mnt/mqm ibmcom/mq

После запуск докер контейнера проверить:

https://localhost:9443/
login: admin
password: passw0rd

Примечание:

Посмотреть версию IBM MQ:

$ docker exec mq dspmqver

Зайти в консоль докер контейнера IBM MQ:

$ docker exec -it mq /bin/bash

(См. https://blog.jeroenmaes.eu/2020/01/run-ibm-mq-in-docker-for-local-development/)

(См. https://github.com/ibm-messaging/mq-container)

(См. https://developer.ibm.com/components/ibm-mq/tutorials/mq-jms-application-development-with-spring-boot/)

2. Зайти в каталог: /applicationSendMsg/ и выполнить запуск приложения для отправки сообщений в очередь:

$ mvn clean package spring-boot:run

Отправка сообщений в очередь:

Ожидаемые параметры:

String message;

Integer age;

http://localhost:8080/send?message=textMessage&age=1

3. Зайти в каталог: /applicationGetMsg/ и выполнить запуск приложения слушателя очереди.

Для вывода списка сообщений:

http://localhost:8090/get