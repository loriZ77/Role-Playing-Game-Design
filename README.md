# Role Playing Games Design
<br>

> This design is to present a solution in order to show different types of gears for a character in RPG game, comparison between two characters and the result of battle is further implemented in main class.

<br>There are 3 types of gears for each character to choose from: 

* Head gear (limit one piece each character, only have defensive values) 

* Hand gear (limit two pieces each character, only have attack values) 

* Footwear (limit two pieces each character, have both attach values and defensive values)




## Implements

* Gear.java is an interface that declares methods of getAdjective(), getNoun(), getAttackValue(), getDefenseValue(), combine() and compare(). The design of interface follows Interface segregation rule. 

* AbstractGear.java is an abstract class that defines method implementations declared by interface, and construct the common fields (String adjective, String noun, int attackValue, int defenseValue,boolean isCombined).

* HeadGear.java is a concrete class that is a subclass of Gear and inherit from Gear as using super function to extend the constructor from it. defenseValue is set to 0 by default and not passing from constructor.
ToString() and combine() methods are override in case the type of object is specified. 

* HandGear.java is a concrete class that is a subclass of Gear and inherit from Gear as using super function to extend the constructor from it. attackValue is set to 0 by default and not passing from constructor. ToString() and combine() methods are override in case the type of object is specified. 

* FootWear.java is a concrete class that is a subclass of Gear and inherit from Gear as using super function to extend the constructor from it. ToString() and combine() methods are override in case the type of object is specified. 

* Player.java is a class that define a player and realized the pickup gear method.
The combined item cannot be combined again.
When the capacity reaches, compare the picked up item with the existing one. Keep the better one and discard the weaker one.

* Battle.java is a driver class that implements a battle between two players and print the details of this battle.

<br>

## Test

Abby = new Player("Abby", 3, 10);
Bob = new Player("Bob", 10, 5);

Player 1:   Abby
Head Gear:  Better HeadGear -- Defense Value: 8  
Hand Gear1: Long Recurve Scepter -- Attack Value: 19 
Hand Gear2: Vampiric Scepter -- Attack Value: 3 
Foot Wear1: Speedy Swift Tabi -- Attack Value: 9 -- Defense Value: 14 
Foot Wear2: Ninja Tabi -- Attack Value: 2 -- Defense Value: 2 
Abby has 11 attack points and 16 defense strength. 
 
Player 2:   Bob
Head Gear:  Better HeadGear -- Defense Value: 8  
Hand Gear1: Haunting Speedy Boot -- Attack Value: 19 
Hand Gear2: Swift Tabi -- Attack Value: 5 
Foot Wear1: Long Recurve Scepter -- Attack Value: 14 -- Defense Value: 7 
Foot Wear2: Vampiric Scepter -- Attack Value: 3 -- Defense Value: 7 
Bob has 17 attack points and 14 defense strength. 
 
The battle ends with Abby having 1 units of damage -- Bob having 0 units of damage.
Bob Wins!
