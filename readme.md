## Readers Club

[![Build Status](https://travis-ci.org/andela-womokoro/ReadersClub.svg)](https://travis-ci.org/andela-womokoro/ReadersClub)
[![Coverage Status](https://coveralls.io/repos/github/andela-womokoro/ReadersClub/badge.svg?branch=master)](https://coveralls.io/github/andela-womokoro/ReadersClub?branch=master)

The readers club application is just a simple Java application whose sole purpose is to demonstrates some of the features of the Java programming language. The application simulates a readers' club where the following holds true:

- the club has members
- members belong to one of two categories; staff or students
- members are place in two lists; one for staff, and the other for students
- the club keeps books
- books can be borrowed to members who request for them
- books are borrowed to members on a first-in-first-out (FIFO) basis, i.e. based on the time each member joins the club
- books are also borrowed to members based on rank (i.e. staff or student). Staff have precedence over students

## Installation

Install the following software before cloning the application from github.

- [Java Development Kit (JDK) 1.8] (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Git] (https://git-scm.com/downloads)
- [Netbeans 8.1 IDE] (https://netbeans.org/downloads/) (optional)

After installing the above software, clone the repository from github into your working directory using the following command:

```
$ git clone https://github.com/andela-womokoro/ReadersClub
`````

## Usage

You can run the readers club application from Netbeans, or your command prompt.

### Running the application with Netbeans

- Select the Readers Club project from the project explorer under the Projects Tab then right-click on it
- Click on properties
- Click on Run
- Make sure the Main Class is set to Club. (Make sure to use the fully qualified name i.e. readersClub.Club)
- Click OK.
- Clean and build your project by right-clicking on it under the Projects tab and selecting "Clean and Build" from the sub-menu 
- Run Project by right-clicking on the project and selecting "Run" from the sub-menu

### Running the application from a command prompt

To run the application, open a terminal window or command prompt (on Microsoft Windows), navigate to the directory where you cloned the project into...


## Contributing

[Wilson Omokoro](https://github.com/andela-womokoro)

## License

Readers Club is open-sourced software licensed under the [MIT license](http://opensource.org/licenses/MIT)
