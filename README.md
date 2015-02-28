Example application for JavaZone X

# Running with Docker
I am testing a setup with Docker and a HAProxy in front. To use it, you need to:

* Install Docker
* Install Docker Compose

And then run: ```mvn clean install -P generate-script && docker-compose up```

Then test ```docker-compose scale web=2``` . This will store the state, so if you kill of the setup. Then do another ```docker-compose up``` it will start with multiple web instances.

I'll work on getting HAProxy to pick up new info dynamically when new containers are added. :)