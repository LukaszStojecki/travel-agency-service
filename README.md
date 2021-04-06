# Travel agency service

## Table of contents
* [General info](#General-info)
* [Main system functions](#Main-system-functions)
* [Technologies](#Technologies)
* [TODO](#TODO)
* [How To Use](#How-To-Use)
* [Status](#status)
* [Contact](#contact)

## General info

Application which allows you to search for tours by specific criteria and to "buy" them.

## Main system functions

 1. Homepage:
  * presentation of promoted tours
  * presentation of upcoming tours (globally)
  * presentation of upcoming tours (by continent)
  * presentation of upcoming tours (by country)

2. Configuring tours by an administrator: 
  * Administrator can add continent, country, city, hotel and airport
  * Administrator can add, delete and edit tours.

3. Searching for tours according to specified criteria:
  * Search for tours by departure and return date

4. Buying a tour - calculating the final amount according to the number of people:
  * after choosing a specific tour, you can purchase it
  * please enter the number of adults and children
  * the amount for the tour will be calculated (based on the number of people)

## Example users

  | login  | Password |  Role |
  | ------ | -------- | ----- |
  | admin  |  admin1  | ADMIN |
  | user   |  user1   | USER  |
## Tools used:

 * JDK 11
 * Spring(Security, Boot, Data JPA, MVC)
 * Lombok
 * Hibernate
 * MySQL
 * Thymeleaf
 * Bootstrap

## TODO
 * [X] add tests
 * [X] presentation of recently bought tours

## How To Use
 $ git clone https://github.com/LukaszStojecki/travel-agency-service

 $ cd travel-agency-service

 $ mvn spring-boot:run

## Status
Project is: finished.

## Contact

For any issues with the app or repository, please contact me at lukasz.stojecki@o2.pl
