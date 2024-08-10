#M1 Basic HardCode mode.
#export JAVA_OPTS="$JAVA_OPTS -ea"
#export JAVA_OPTS="$JAVA_OPTS -Xms2g"
#export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=$PROFILE"
#export JAVA_OPTS="$JAVA_OPTS -Daws.region=us-east-1"
#export JAVA_OPTS="$JAVA_OPTS -Djms.queue.name=car-demo-dev"
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.databaseName=car_dev"
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.portNumber=5432"
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.username=admin"
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.password=password123"
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.serverName=jdbc:postgresql://172.17.0.2:5432/car_dev"
#export JAVA_OPTS="$JAVA_OPTS -Dserver.port=8080"

#Command for M1

#M2 Advanced flexible Configuration Manner
export JAVA_OPTS="$JAVA_OPTS -ea"
export JAVA_OPTS="$JAVA_OPTS -Xms2g"
export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=${PROFILE}"
export JAVA_OPTS="$JAVA_OPTS -Daws.region=${REGION}"
export JAVA_OPTS="$JAVA_OPTS -Djms.queue.name=${QUEUE_NAME}"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.databaseName=${DB_NAME}"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.portNumber=${DB_PORT}"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.username=${DB_USERNAME}"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.password=${DB_PW}"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.serverName=jdbc:postgresql://${DB_URL}:${DB_PORT}/${DB_NAME}"
export JAVA_OPTS="$JAVA_OPTS -Ddatabase.serverName=jdbc:postgresql://172.17.0.2:5432/car_dev"
export JAVA_OPTS="$JAVA_OPTS -Dserver.port=8080"

#Command for M2

#Reference: Below is copyied from Mac's Tomcat/bin/setenv_backup.sh
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.driver=org.postgresql.Driver"
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.dialect=org.hibernate.dialect.PostgreSQL9Dialect"
#export JAVA_OPTS="$JAVA_OPTS -Dsecret.key=12345678"
#export JAVA_OPTS="$JAVA_OPTS -Dlogging.level.org.springframework=INFO"
#export JAVA_OPTS="$JAVA_OPTS -Dlogging.levelt.com.ascending=TRACE"
#export JAVA_OPTS="$JAVA_OPTS -Dspring.profiles.active=dev"
#export CATALINA_OPTS="$CATALINA_OPTS -Djms.queue.name=car-demo-dev"
#export CATALINA_OPTS="$CATALINA_OPTS -Daws.region=us-east-1"
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.databaseName=car_dev"
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.portNumber=5432"
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.username=admin"
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.password=password123"
#export JAVA_OPTS="$JAVA_OPTS -Ddatabase.serverName=jdbc:postgresql://localhost:5432/car_dev"
#export JAVA_OPTS="$JAVA_OPTS -Dserver.port=8080"
