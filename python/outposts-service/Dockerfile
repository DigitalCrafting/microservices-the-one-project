FROM python:3.7-alpine3.12

COPY ./src /app
COPY ./scripts/wait-for-service.sh /app/script.sh

RUN apk update
RUN apk add bash
RUN apk add curl
RUN pip install flask requests

WORKDIR /app

CMD ./script.sh python ./app.py
