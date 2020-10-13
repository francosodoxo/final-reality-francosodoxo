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

This project run with Java 14.

Compile
---
Compile this projet with the Gradle script provided and choose
the java version 14.

Run
---
Run this project with the Gradle script provided by default. Be careful
with the java version you want to run. This will not run with newer java 
versions.

Description
-----------
This project was designed using SOLID principles. The player has characters
and weapons that thier characters can equip to attack enemies.

On one hand, the enemies and the characters are abstracted in AbstractUnit using the 
public interface IUnit and the characters are abstracted in a AbstractUnit's
subclass called AbstractCharacter too. This second abstact class implements
the public interface ICharacter. On the other hand, the weapons are abstracted to
AbstractWeapon class that implements the IWeapon interface.

The characters are compared in all its properties but the turns queue.