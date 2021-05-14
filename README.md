# Question Time

this project as been design for the need of a good friend that was giving lecture and wanted to send one question each day to is student

## prereqest

get the projet:

`git clone `

this section is not mondatorry, it is design to help people that don't have any knowladge with JAVA to set up there environement easly

[asdf](https://asdf-vm.com/#/core-manage-asdf?id=install)

## install

you have to install AdoptOpenJDK 16 to run this project local. You can use asdf installed earlier

```bash
cd question-time-api

asdf plug-add java

asdf install java adoptopenjdk-16.0.1+9

asdf local java adoptopenjdk-16.0.1+9

```

if you don't want to bother with this you can just run the docker to run this application see [docker](### docker) section

## Usage

### with local setting

to start server the webserver API just run :

```bash
./mvnw spring-boot:run
```

### Docker
