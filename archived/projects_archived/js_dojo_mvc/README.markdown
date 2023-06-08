# Single page ajax web app

@author : sapan verma.
This is a single page web app coded to exercise dojo(1.8) skills and to serve as a refrence implementation for any future projects which need to utilise the frameworks involved without much configuration hassle.

## Frameworks used
 - spring (DI, MVC) : annotation based
 - hibernate 3.x: annotation base
 - dojo 1.8

## web urls of interest : 
 - / : base url for application
 - /mockingbird.htm : for application testing
 
## highlights : 
 - js architecture.
 - client - server communication via json.

## drawbacks : 
 - no css : web app ain't pretty
 - no service layer logic
 - no client side domain objects
 - HTML templating in client side logic layer
 - no usage of dojo/topic. Explicit event handling used.
 - explicit contact id manipulation by user
 
## some configuration remarks :
 - this app database settings are defined in hibernate.cfg.xml
 - all the required jars are within this project, so no need to waste time hunting for them (!).
