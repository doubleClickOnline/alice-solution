FROM openjdk:8-jdk-alpine

RUN addgroup -S appgroup && \
        adduser -S appuser -G appgroup

RUN mkdir app
WORKDIR app

COPY /dist /app
RUN chown -R appuser:appgroup /app

USER appuser

CMD java -jar alice-solution-1.0.jar "23170acc097c24edb98fc5488ab033fe" "poultry outwits ants" "wordlist" "1"