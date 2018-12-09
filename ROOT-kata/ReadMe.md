## To run from the command line


# Classes

## Model

* Driver:
    * holds Driver's info (name)
    * serves as a representation of Driver Object 
    * it doesn't have much to it but I imagined it can be expended

* Driver Result:
    * holds calculated values for each driver
    * implements Comparable for easy sorting  

* Time:
    * holds hours and minutes as ints
    * I decided to make my own class for time for simplicity

* Trip:
    * holds start and end of the trip along with miles driven


## Controllers

* Calculator:
    * given a list of trips calculates total miles, speed
    * can check if a trip is valid (in speed range) 

* Main: 
    * initiates the program 
    * requires the input file as argument

* Menu:
    * handles input and output
    * reads from the file to instantiate objects
    * prints the report

* Register:
    * holds Driver and List of trips in a map
    * can add new Driver
    * have the ability to add a trip to Drivers list of trips


# Thought process

I started off with modeling the Driver, Trip and Time. At first, my Driver was holding a list of trips as it's parameter but after giving it some thought I decided they weren't a part of a Driver. The driver can have Trips but it isn't one. 
That's why I have Register class. It holds a Driver as a key and Trips as values. I thought it would be elegant and easy to manage.
Because I moved list of Trips out of Driver I had to move the functionality.
I created Calculator to deal with computing average speed and total mileage.
Along all that I was building Menu class. I wanted it to take care of in and outs of the system. It has a helper method that creates a list of Driver results. I wanted to have something like DTO or some temporary object to hold my calculated values to allow sorting without repeated calculations.

# Testing

I wasn't truly test-driving the process. I admit I need more practice in that department. However, I was building and running tests alongside the classes. All the public methods that are not getters or setters are unit tested.
I generated the input file to test the speed of the application. At a little over 1000 input lines it ran on average 119 milliseconds and for a file of 10000 lines, it was about 305 milliseconds.


 