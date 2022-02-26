# Arkanoid
Arkanoid game developed in Java using OOP principles and design patterns.

The game has 4 levels, It saves the high score of the games played on your computer and you can see it in the menu when press h or at the end of the game (when losing or winning), You can pause the game using p, and continue using space.
The source code is divided into packages:
"animations" package contains the different animations code files of the game such as the menu, the count down at the start of each level, game over screen, you win screen, high score screen, and pause screen.
"collidables" package contains the object that can be collidable such as block and paddle.
"game" package contains classes and interfaces that belong to the game logic.
"level" package contains the four levels information.
"listeners" package contains the listeners from the observer design pattern.
"shapes" package contains all the shapes I used such as Rectangle.
"sprites" package contains the graphic which may be moved on screen such as ball.

To run the game you can download the jar file into a directory in your computer and from this directory on cmd run the command: java -jar Arkanoid.jar

The attached video is an example of playing the game (it's a speedup version).
https://user-images.githubusercontent.com/74676502/155840829-122a2b4b-23f5-4748-8d6f-9d75bab8d111.mov

