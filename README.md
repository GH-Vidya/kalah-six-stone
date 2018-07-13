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
cd <HOME_DIRECTORY>
git clone https://github.com/GH-Vidya/kalah-six-stone.git
cd kalah-six-stone
mvn clean install
mvn spring-boot:run

```
When the server starts, open the following URL
```
http://localhost:8080/game.xhtml
```