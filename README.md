Example application for JavaZone X

It has been set up for running on Heroku, CloudFoundry and OpenShift.

# Running on CloudFoundry
At the moment there is two setups:
* Running against the public CloundFoundry - This is supported by the Maven plugin, and the config there is setu up for this.
* Running against private cloud setup - Could not get Maven to do this so I created a manifest.yaml and deployed with vmc.

## Running against a private cloud setup
You can find the setup that I have tested this with at https://github.com/anderssv/cloudfoundry-vagrant . There you will also find some information about vmc setup.

Setup vmc and do the following:

```
$ mvn clean install -Pcloudfoundry
$ cd weboo-webapp
$ vmc push
```

Edit the manifest.yml file in the weboo-webapp directory to change URL and other stuff.

# Juju

Do setup

```
$ juju bootstrap
$ juju deploy local:mappami
$ juju expose mappami
```


