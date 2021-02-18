# microservices-the-one-project
### GOAL
Main goal of this project is to learn more about Microservice Architecture and how to implement it as well as learn how to write web applications in other languages.
As I've recently been playing Shadow of War, I've decided to write a system for managing Saurons army - The One system to rule them all :) 

For that I've decided to create one UI app (either web using Angular 10 and SpringBOOT or desktop using NodeJS and Electron) which will talk to the microservice backend. I'm planning to write most of the mechanisms required for microservices myself (as I said, I want to learn more about it and what better way to do so than to implement it) so I will not be using already existing libraries such as Netflix Hystrix, Ribbon etc. As I'm mainly Java and Angular Developer all this stuff will be written in Java using SpringBOOT while I'll try writing simple microservices in other languages such as:
- Haskell -> to learn some functional language
- Python -> because it's widely popular
- C++ -> because I've always liked that language
- GO -> just a gut feeling to go with it:)

I will also use Docker to run individual services and Docker-compose to run it all at ones.

The project architecture will evolve with time and I will try to document he whole process at [Dev.to](https://dev.to/digitalcrafting)

### Requirements

For now in order to build all of the services the requirements are:
1. [Java 11](https://www.azul.com/downloads/zulu-community/?package=jdk) + [Maven](https://maven.apache.org/download.cgi)
2. [Go](https://golang.org/dl/) 
3. [Haskell](https://www.haskell.org/platform/linux.html) + [Cabal](https://www.haskell.org/cabal/)
4. [Docker](https://docs.docker.com/engine/install/debian/)
5. [Docker-compose](https://docs.docker.com/compose/install/)
6. [Python3](https://www.python.org/downloads/) (comes with linux) + [Flask](https://pypi.org/project/Flask/) + [click](https://pypi.org/project/click/)

In the future I intend to add building the services using docker images instead of locally installed software.

### CLI Tools
This project comes with CLI tool written in python and required `click` package to be installed.

Currently, it allows us to build separate services for localhost and docker-compose deployment, as well as run them. As docker command runs compose underneath, `stop` needs to be called after killing `start` process.

Usage:

* `theonecli (local) (build|start) (--services|-s) <service,names>`
* `theonecli (docker) (build|start|stop) (--services|-s) <service,names>`

After adding the scripts directory to PATH we can use the CLI as follows:
`theonecli (local|docker) (start|build) (--services|-s) user,outpost (--profile|-p) (dev-local|dev-docker)`

`theonecli docker-compose (start|stop)`

Available services are listed in the CLI script itself, in the future I will move them to a config file.

In order for the CLI tool to work the services need to contain:
1. directory *scripts* containing:
 * *build.sh* script
 * *start.sh* script
2. Dockerfile 

Needlesly to say, on linux the CLI script as well as other *.sh files need to be modified using `chmod +x <file>` command if something is not working.

#### CLI Changelog
> #### v0.1.0
> * removed `docker-compose` command, it's functionality is now in `docker` command
> * removed option to start individual docker containers from the CLI
> * made building and running services locally and in `docker-compose` actually work
> #### v0.0.1
> * initial version of the CLI
> * available commands are: `local, docker, docker-compose`
