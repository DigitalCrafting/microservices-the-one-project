# Root for microservices written in Python

## How to
Before running any service `build.sh` should be run. The script takes care of creating different configurations for different environments ex. local or docker.

## Why
To handle different environments I decided to use the easiest solution possible which is to simply copy the correct file to predefined place and treat it as a module.

Why not use a library ? After looking at possible solutions (briefly, so I might have missed something) it turned out some run script was required to tell the app what environment it is in. 
I didn't like that solution because for security reasons I want to keep other environments settings hidden and my solution allows me to do that.

For example, when copying the app to docker container I only need to copy the `src` directory and it will **only** contain settings for *docker* environment, while when using one of the solutions I found, **all** of the configs are copied and the app decides which one to use.