build:
	docker compose up --build

down:
	docker compose down

run:
	docker exec -it spring-boot-tomcat sh

prune:
	docker buildx prune

port-is-used:
	lsof -i:8755