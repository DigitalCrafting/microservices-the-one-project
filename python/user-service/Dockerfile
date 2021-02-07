FROM python:3.7-alpine3.12

COPY ./src /app
COPY ./scripts/wait-for-service.sh /app/script.sh

RUN pip install flask

WORKDIR /app

CMD ./script.sh python ./app.py