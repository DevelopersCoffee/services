CURRENT_BRANCH = 0.1.0
REPOSITORY = us-central1-docker.pkg.dev/itinerary-342515/docker-registry
IMAGE_NAME = service

.PHONY: all

all: build-jar build-image push-image

build-jar:
	./gradlew clean build -x test

build-image: build-jar
	docker buildx build --platform linux/amd64 -t ${IMAGE_NAME}:$(CURRENT_BRANCH) -f ./LocalDockerBuildAndPush --load .

push-image: build-image
	docker tag ${IMAGE_NAME}:$(CURRENT_BRANCH) ${REPOSITORY}/${IMAGE_NAME}:$(CURRENT_BRANCH)
	docker push ${REPOSITORY}/${IMAGE_NAME}:$(CURRENT_BRANCH)