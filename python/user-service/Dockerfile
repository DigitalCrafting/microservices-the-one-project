FROM python:3.7-alpine3.12

COPY ./src /app
COPY ./scripts/wait-for-service.sh /app/script.sh

RUN apk update
RUN apk add bash
RUN apk add curl

WORKDIR /app

COPY ./requirements.txt ./requirements.txt

RUN pip install -r requirements.txt

#CMD ./script.sh python ./app.py
CMD python ./app.py