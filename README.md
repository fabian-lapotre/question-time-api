# Question Time

this project as been design for the need of a good friend that was giving lecture and wanted to send one question each day to is student

## prereqest

If you don't hava one of this utility install on your conputor, go to [install](##install) section to see how to do it.

1. [git](https://git-scm.com/)
2. [protoc](https://github.com/protocolbuffers/protobuf) protocol buffer compiler
3. [buf](https://docs.buf.build/introduction) build tool to make protobuf reeliable
4. [AdoptOpenJDK-16](https://adoptopenjdk.net/) OpenJDK (java) runtime environement

If everything is install, go to [Quick Start](##Quick Start) section

## install

### git

On debian base distribution:
```bash
sudo apt update && sudo apt install -y git
```
### protoc
This project is a restfull api that send data to client in protobuf format. you should install [buf](https://docs.buf.build/installation) and protoc to run this project

this section is not mondatorry, it is design to help people that don't have any knowladge with JAVA to set up there environement easly

[asdf](https://asdf-vm.com/#/core-manage-asdf?id=install)

you have to install AdoptOpenJDK 16 to run this project local. You can use asdf installed earlier

```bash
cd question-time-api

asdf plug-add java

asdf install java adoptopenjdk-16.0.1+9

asdf local java adoptopenjdk-16.0.1+9

```

if you don't want to bother with this you can just run the docker to run this application see [docker](### docker) section

## Quick Start 

get project:
```bash
git clone https://<PROJECT_URL>
```

### with local setting

fetch dependencies :

```bash 
./mvnw -U dependency:resolve
```

```bash 
./buf

to start server the webserver API just run :

```bash
./mvnw spring-boot:run
```

### Docker
