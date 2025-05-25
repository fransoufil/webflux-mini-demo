# WebFlux Mini Demo

## Descrição
Projeto de exemplo com Spring WebFlux, demonstrando:
- `Mono.flatMap`
- `switchIfEmpty`
- `Schedulers.boundedElastic()`
- `WebClient` com fallback
- Diferença entre `flatMap` e `concatMap`

## Pré-requisitos
- Java 17+
- Maven ou Gradle
- Banco H2 (in-memory)

## Como rodar
```bash
mvn spring-boot:run
