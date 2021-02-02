# isdb
International Songs Database

#How to run app on docker
1. Build Image
docker build -t isdb:latest
2. Run image in a container
 docker run -p 8080:8080 api-container isdb
	#Run with Spring profile
	docker run -e "SPRING_PROFILES_ACTIVE=prod" -p 8080:8080 api-container isdb 
#How to debug application
docker run -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p 8080:8080 -p 5005:5005 -t api-container isdb:latest