# Project Title

2-Player 6-Stone Kalah Game

## Getting Started

About the game
Each of the two players has six pits in front of him/her. To the right of the six pits, each player has a larger pit, his Kalah or house. At the start of the game, six stones are put In each pit.

The player who begins picks up all the stones in any of their own pits, and sows the stones on to the right, one in each of the following pits, including his own Kalah. No stones are put in the opponent's' Kalah. If the players last stone lands in his own Kalah, he gets another turn. This can be repeated any number of times before it's the other player's turn.

When the last stone lands in an own empty pit, the player captures this stone and all stones in the opposite pit (the other players' pit) and puts them in his own Kalah.

The game is over as soon as one of the sides run out of stones. The player who still has stones in his/her pits keeps them and puts them in his/hers Kalah. The winner of the game is the player who has the most stones in his Kalah.

## Built With

* [Java](https://java.com/en/download/) - Programming language used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Primefaces](https://www.primefaces.org/) - Used to generate user interface

## How to run locally

```
git clone https://github.com/GH-Vidya/kalah-six-stone.git
cd kalah-six-stone
mvn clean install
mvn spring-boot:run
```
When the server starts, open the following URL in your favourite browser
```
http://localhost:8080/game.xhtml
```

## How to play

You will see the following landing page with above URL. There are 2 players defined (Blue and Orange). The pits and houses are identified by each block on the gird. The large blocks are the houses and smaller blocks are the pits. The pits and houses for each player can be identifed by the color of the blocks. Initially all the block are empty and you need to click on "Start" button in order to inititate the game. Game can be started by any of the players. At any point the game board can be reset using the "Reset" button.

![landing page](https://github.com/GH-Vidya/kalah-six-stone/blob/master/src/main/resources/images/firstscreen.PNG)

After clicking on "Start" you will see that all the blocks are initialized with the default values. To play, just click on the number inside the block that you want to select. This will automatically calculate the stones in each pit and will also handle the following scenarios.

* No stones are put in the opponent's' house
* When the last stone lands in an own empty pit, the player captures this stone and all stones in the opposite pit (the other players' pit) and puts them in his own House
* If the players last stone lands in his own Kalah, he gets another turn

After each move, you will see a small message box on the top right corner that will instruct you on your next move. Following messages will appear according to the game status after that move 

* Next Move : blue/orange
* Last stone landed in your own Kalah. Play Again
* This pit is empty. Cannot be selected
* Cannot select house. Play Again
* Game Over

![game started](https://github.com/GH-Vidya/kalah-six-stone/blob/master/src/main/resources/images/gamestarted.PNG)

When one of the sides run out of stones, the game is over and final scores will be calcuated for each player and the winner is declare as shown in the image below.

![game over](https://github.com/GH-Vidya/kalah-six-stone/blob/master/src/main/resources/images/gameover.PNG)



