# washer
Java Websocket broker for [SpigotMC](https://www.spigotmc.org)

## Overview
This project aims to provide a Websocket-based plugin for SpigotMC Event and Server API so that clients can respond to, and alter, the game dynamically.

Two components are being developed here:
* a Java Plugin for SpigotMC
* a Python library (and examples) for using the plugin

## Requirements
This project uses:

* For the Java plugin:
  * Gradle 5 (https://gradle.org/)
  * Tyrus (https://tyrus-project.github.io/)
  * Spigot (https://www.spigotmc.org/)
  
* For the Python library:
  * Python 3.7
  * trio-websocket

## Running

Java plugin:
* TBD, but mostly: put the washer.jar into one directory, its dependencies in another, and adjust the spigot startup classpath

Python module:
* TBD, but build and install the wheel into a Python 3.7 environment

## Why?
This project came about after looking at how [Learn to Program with Minecraft](https://nostarch.com/programwithminecraft
) interacted with the game. The stack used in the book consists of:
* [RaspberryJuice plugin](https://github.com/zhuowei/RaspberryJuice) for the server, and
* [Py3MinePi](https://github.com/py3minepi/py3minepi) for the client

These projects appear largely finished, and they work still. However, they provide the ability to poll game state, but not the ability to push game events. The application protocol is a custom socket-based invention, too, so building clients for, e.g. interaction with a website would take additional effort.

In using WebSocket as a line protocol, and JSON as the application protocol, clients can be written in a diverse array of platforms, including the web.
