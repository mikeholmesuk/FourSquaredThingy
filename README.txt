## FourSquare Thingy

This is a very (very) basic application demoing access to the FourSquare API (amongst a couple of other things). 

The application is built using the following technologies:

* [Dropwizard](http://www.dropwizard.io/) - for the application itself
* [Open Layers](http://openlayers.org/) - for the basic map view on the initial page.
* [Freemarker](http://freemarker.org/) - for templates, included as an optional Dropwizard module.
* [Google Fonts](https://www.google.com/fonts) - used on the page.
* [Bootstrap](http://getbootstrap.com/) - because everything has to have Bootstrap.
* [JQuery](https://jquery.com/) - for the Ajax stuff and DOM manipulation.
* [AssertJ](http://joel-costigliola.github.io/assertj/) - mainly because it is excellent.
* [Fyodor](http://www.fyodor.org.uk/) - for randomly generated data used in the tests.
* [Mockito](http://mockito.org/) - also for the high levels of excellence.

There may well be others I've forgotten to mention. 

NOTE: This was done as part of a tech test I did. It's not meant to be production ready (although I may well work on it over time) although it does have an element of 'properness' about it (directory structures, class naming, exception handling, builders, tests etc). however, it's mainly in place to prove that I can tap on keys and make things happen ;)

### Application overview

The application is a basic Dropwizard application. It has one page which is served from the root of the project. Making a request in the search box for a place name will go to the service which will proxy the request through to the FourSquare API. The results, which will include venues and geo-data for the place searched for, are mapped into a `Thing` and the list of venues is mapped into a list of `Thingy` objects (Thingys? Thingies?).

The results on the front end are used in two ways. Firstly, the geo-data is used to centre a map on the area being searched (which I know wasn't in the spec but I did it because I thought it might be interesting). Secondly, the place name, address, postcode and geo-address are displayed on the page. 

All very basic really.

### Running the code

I haven't shipped binaries with this (I can if need be) and by the time you read this I may or may not have added support to run it in Docker. In the absence of these however the easiest way is probably to run this from your IDE. I ran this in IntelliJ so if you want to run this in there then set it up to run in the following way:

* `Edit Configurations` -> `New`
* Select `Application`
* Ensure the `main` class is pointing to `com.tech.mike.ThingyApp`
* Add the bits that Dropwizard needs to the `Program Arguments` section -> `server default.yml`
* Click `Run` from the top menu.
* Be amazed.

If you're using a different IDE. Well, to be honest, you need to be better ;)

Once everything is up and running, you can access the service by navigating your browser to `localhost:8080`. That will bring up the one and only page.

### Running the tests

Again, probably easiest if you're in an IDE. If you're in there, select the tests directory and select `Run 'All tests'` and watch the bottom of the screen go green.

### Things to be improved

* Lots.