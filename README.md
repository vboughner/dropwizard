### Dropwizard

Learning repo for [Dropwizard](http://www.dropwizard.io/1.2.2/docs/index.html#),
a framework for serving REST api with Java, using JETTY, Jersey, and Jackson

#### Build and Run

mvn clean install

java -jar target/dropwizard-tutorial-1.0-SNAPSHOT.jar server hello-world.yml

Look in browser at [Hello](http://localhost:8080/hello-world) or
[Hello w/name](http://localhost:8080/hello-world?name=Successful+Dropwizard+User)

#### Admin Port

Look at the admin port in a browser with `http://localhost:8081/`

#### Health Check

To see your applications health enter url `http://localhost:8081/healthcheck`

#### My Journey with Dropwizard

I wanted to be able to create a REST api with Java so I can create a back-end and run it
on AWS or Google Compute Engine.

I researched various technologies behind writing REST services in Java.
It appears the alternatives to consider seriously are:
* JAX-RS and Jersey (a reference implementation of JAX-RS)
* Dropwizard (a newish framework that includes JETTY, Jersey, and Jackson)
* Spring Boot (which provides an MVC framework)
* RESTEasy (a JBoss implementation)
* Play Framework (for Java and Scala)
* RestExpress

I decided to limit it to Java frameworks because I desire a review of Java.
Spring is tempting because it is already in use everywhere,
but I’d really like to learn something that is more modern, and Dropwizard
is looking like it was put together from other string libraries in 2015 and claims to be ops-friendly.

In the end appears that the two best choices are:
* JAX-RS and Jersey (a reference implementation of JAX-RS) (udemy course)
* Dropwizard (a newish framework that includes JETTY, Jersey, and Jackson) (website, tutorial)

I come to the conclusion that it is probably best to use Dropwizard,
because it includes some standard open-source libraries that will be useful having experience with
in and of themselves, and it seems quite popular and productive for people.  Tutorials are available.

Steps to take, following the
[getting started guide](http://www.dropwizard.io/1.2.2/docs/getting-started.html#gs-maven-setup):
* install brew for mac if you don't already have it
* install maven with: brew install maven
* make sure you have JAVA_HOME set to something like:
/Library/Java/JavaVirtualMachines/jdk1.8.0_112.jdk/Contents/Home
* mkdir dropwizard; cd dropwizard; git init
* mvn archetype:generate -DarchetypeGroupId=io.dropwizard.archetypes -DarchetypeArtifactId=java-simple -DarchetypeVersion=1.2.2
* for the variables maven asks about, use the package name you want, instead of io.dropwizard,
and don’t put spaces in the “Name” because they get used in a real class name

