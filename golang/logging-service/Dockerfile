FROM alpine:3.12.3

WORKDIR /app

COPY ./dist/application.sh .

RUN mkdir /lib64 && ln -s /lib/libc.musl-x86_64.so.1 /lib64/ld-linux-x86-64.so.2

CMD /app/application.sh
