FROM openjdk:17-jdk-slim

RUN groupadd --gid 1000 -r app && \
    useradd --uid 1000 --no-log-init -g app app

WORKDIR /home/app
COPY build/libs/service.jar ./service.jar
RUN chown -R app:app .

USER app
RUN mkdir log

EXPOSE 8080 1099

ENTRYPOINT exec java \
            -Djava.rmi.server.hostname=${JMX_HOSTNAME:-localhost} \
            -Dcom.sun.management.jmxremote.ssl=false \
            -Dcom.sun.management.jmxremote.authenticate=false \
            -Dcom.sun.management.jmxremote.port=1099 \
            -Dcom.sun.management.jmxremote.rmi.port=1099 \
            -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=log/heapdump.hprof \
            -Xlog:gc*=info:file=log/gc.log:time:filecount=4,filesize=32m \
            -XX:+UnlockDiagnosticVMOptions -XX:+DebugNonSafepoints \
            ${JAVA_OPTS} \
            -jar service.jar