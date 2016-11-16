<a href="http://projectdanube.org/" target="_blank"><img src="http://projectdanube.github.com/xdi2/images/projectdanube_logo.png" align="right"></a>
<img src="http://projectdanube.github.com/xdi2/images/logo64.png"><br>

This is a website representing SNCF, a railway operator.

This is part of a demo for [ÆTERNAM](https://aeternam.eu/), it shows how a passenger can buy a train ticket while staying in control of their data in a "self-sovereign" way. A "Passenger Name Record" (PNR) is created and governed by XDI link contracts that allow different involved parties to view and update it in various ways.

### Information

* [Screencast](https://vimeo.com/191811593)
* [Diagrams](https://projectdanube.github.io/aeternam-xdi-webshop/XDI-AETERNAM-demo.pdf)

See [aeternam-xdi-webshop](https://github.com/projectdanube/aeternam-xdi-webshop/) for a complete description of the demo setup.

### How to build

First, you need to build the main [XDI2](http://github.com/projectdanube/xdi2) project.

After that, just run

    mvn clean install jetty:run

Then the website is available at

	http://localhost:7205/

### Community

Google Group: http://groups.google.com/group/xdi2

IRC: irc://irc.freenode.net:6667/xdi
