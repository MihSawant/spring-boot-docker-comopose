# Spring Boot Docker Compose
new spring boot 3.0.1-rc has new feature where we can use docker-compose file,so
at runtime it will check for it and load it and run it first, then start the app

so in this example, i have created docker compose file which has config for MongoDB, so it
will spin up a container and run mongo on it and in my app i am using mongo repository, so it will use 
that DB.
Other than the docker compose file, there is no other config added.