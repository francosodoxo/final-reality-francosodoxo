Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---

This project runs with Java 14.

Compile
---
Compile this project with the Gradle script provided and choose
the java version 14.

Run
---
Run this project with the Gradle script provided by default. Be careful
with the java version you want to run. This will not run with newer java 
versions unless you update the Gradle configurations.

```sh
gradle build && gradle run
```
Optionally, you can run this application with intellij by clicking
the run button aside FinalReality gui's class

Description
-----------
This project was designed using SOLID principles. The player has characters
and weapons that thier characters can equip to attack enemies.

On one hand, the enemies and the characters are abstracted in AbstractUnit using the 
public interface IUnit, and the characters are abstracted in a AbstractUnit's
subclass called AbstractCharacter too. This second abstact class implements
the public interface ICharacter. On the other hand, the weapons are abstracted to
AbstractWeapon class that implements the IWeapon interface.

The characters are compared in all its properties, but the turns queue.

Features to consider
--------------------
The feature of equipping a weapon is done by a double dispatch, usign 
interfaces, for example, IWeaponBlack that is implemented by weapons that can be
equipped by a black magician, and IBlackAllowedWeapons that is implemented by 
a black magician that lets it equip a IWeaponBlack weapon.

Game Flow
---------
The game has 3 states, the first is when the units are fighting, the second is 
when the player loses the game, and the last is when they win the game.

Controllers
-----------
There is many controller classes. 

The character controller manages the creation of characters and 
getting its data. They are created and managed outside the
player responsability

The enemy controller performs the same features like the point before, 
but for enemies.

The fight controller performs the attacks between enemies and characters.

The flow controller manages the game's states, fighting, player wins and
player loses.

The player controller is created to manage the player's allowed actions, 
like equipping weapons, adding characters to its ownership and the character's data
that are under their ownership.

The turn controller manages the character's turn, allowing to perform their actions
and finishing their turn, making they to wait is turn again.

The weapon controller lets create weapons, add to the game and equip them to
a character.
