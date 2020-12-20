FROM ubuntu:20.04

RUN ["apt-get", "update"]
# Missing needed library and wget for downloading another missing one
RUN ["apt-get", "install", "-y", "wget", "libatomic1"]

WORKDIR /tmp

# Missing libffi6 library
RUN ["wget", "http://de.archive.ubuntu.com/ubuntu/pool/main/libf/libffi/libffi6_3.2.1-8_amd64.deb"]
RUN ["dpkg", "-i", "libffi6_3.2.1-8_amd64.deb"]

WORKDIR /tmp/auth-serivce
COPY dist/build/auth-service/auth-service auth-service
ENTRYPOINT ["./auth-service"]

# TODO try to make alpine work for smaller image
#FROM alpine:3.12.3
#WORKDIR /tmp/auth-serivce
#COPY dist/build/auth-service/auth-service auth-service
#ENTRYPOINT ["./auth-service"]