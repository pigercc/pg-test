mvn clean package install -Dmaven.test.skip=true
docker build -t pg-test-web .
docker run --rm -it --name pg-test-web -e "SERVER_PORT=3478" -e "SPRING_CLOUD_CONSUL_DISCOVERY_INSTANCE-ID=pg-test-web-sw" pg-test-web