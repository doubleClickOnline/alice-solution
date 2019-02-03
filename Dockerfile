FROM openjdk:8-jdk-alpine

RUN addgroup -S appgroup && \
        adduser -S appuser -G appgroup

RUN mkdir app
WORKDIR app

COPY /dist /app
RUN chown -R appuser:appgroup /app

USER appuser

CMD java -Xms1g -Xmx2g -jar alice-solution-*.jar "23170acc097c24edb98fc5488ab033fe" "poultry outwits ants" "wordlist" "1"