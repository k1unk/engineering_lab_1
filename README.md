[![CI](https://github.com/k1unk/engineering_lab_1/actions/workflows/main.yml/badge.svg)](https://github.com/k1unk/engineering_lab_1/actions/workflows/main.yml)

## Описание

С помощью данного сервиса можно конвертировать:
- ºF в ºC
- ºC в ºF

## Запуск напрямую

java -jar lab_1-1.0-SNAPSHOT-jar-with-dependencies.jar


## Docker

Собрать образ:
    docker build -t lab.jar .
Запустить контейнер: 
    docker run -i lab.jar
