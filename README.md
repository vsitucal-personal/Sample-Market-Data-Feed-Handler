# Sample-Market-Data-Feed-Handler

A simple market data feed handler written in Java. Shows how market data is sent from the exchange to the trading participants, things may be more complicated in the real world setting. In this mini-project server and client are started in a single Main class for convenience sake to demonstrate how it works but client and server can be run independently.

*market data stored in sample_market_data.txt, hard coded in the project but can be changed to feed a file to the main method\
*(changelog) you can now feed an input file when running in a command line\

Running from command line without IDE\
-clone this project to your machine\
-After cloning, enter the commands below. sample_market_data.txt should be in the directory you are working on \
$ cd Sample-Market-Data-Feed-Handler\
$ java -cp build\classes mdfh.Main sample_market_data.txt\

