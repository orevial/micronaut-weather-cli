# For JDK 8
#FROM oracle/graalvm-ce:19.3.1-java8 as graalvm
# For JDK 11
FROM oracle/graalvm-ce:19.3.1-java11 as graalvm
RUN gu install native-image

COPY . /home/app/weather-cli
WORKDIR /home/app/weather-cli

RUN native-image --no-server -cp build/libs/weather-cli-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/weather-cli/weather-cli /app/weather-cli
ENTRYPOINT ["/app/weather-cli"]
