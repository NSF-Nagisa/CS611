# CS611-<A1>
## Tic-Tac-Toe-II
---------------------------------------------------------------------------
Liangzhuo Zhang
zhanglz@bu.edu
U67295731

## Files
---------------------------------------------------------------------------
Board.java
A class that has all information of the board and functions to put pieces.

C4Scheduler.java
The scheduler for Connect-4 extends Scheduler class.

Connect4.java
The connect-4 game extends Game class.

Game.java
The abstract class of board game. Including a start function, a setting function and a takePiece function.

Judge.java
The class that determines whether the winner is already decided on the chessboard.

Main.java
The main class of the project.

OandC.java
The Order and Chaos game extends Game class.

OandCPlayer.java
The player in Order and Chaos extends Player class.

OandCScheduler.java
The scheduler for Order and Chaos extends Scheduler class.

Player.java
The basic class for players.

Scheduler.java
An abstract class controls players to take turns. It has a takeAction function.

Scoreboard.java
A class that keeps a scoreboard to record the scores of two players and the number of ties.

TicTacToe.java
The tic-tac-toe game extends Game class.

tttScheduler.java
The scheduler for tic-tac-toe extends Scheduler class.

View.java
The class responsible for input from and output to the console.

## How to compile and run
---------------------------------------------------------------------------
1. Navigate to the directory "A611" after unzipping the files
2. Run the following instructions:
javac -d bin src/*.java
java -cp bin Main

## Input/Output Example
---------------------------------------------------------------------------
<Place here an example of how the program runs. Include both its
outputs and correctly formatted inputs. Please clearly mark the inputs.>
e.g.:
Welcome to Leon's game. Please select what you want to play:
1. tic-tac-toe
2. chaos and order
3. connect-4
4. exit
Input: 
2
Output:
Please enter the name of player 1:
Input: P1
Output:
Please enter the name of player 2:
Input: P2
Output:
Please choose the player who would be Order:
1. P1
2. P2
 
Input: 1
Output:

+---+---+---+---+---+---+
|0,0|0,1|0,2|0,3|0,4|0,5|
+---+---+---+---+---+---+
|1,0|1,1|1,2|1,3|1,4|1,5|
+---+---+---+---+---+---+
|2,0|2,1|2,2|2,3|2,4|2,5|
+---+---+---+---+---+---+
|3,0|3,1|3,2|3,3|3,4|3,5|
+---+---+---+---+---+---+
|4,0|4,1|4,2|4,3|4,4|4,5|
+---+---+---+---+---+---+
|5,0|5,1|5,2|5,3|5,4|5,5|
+---+---+---+---+---+---+

P1 Choose which piece you want to take:
 1. O
 2. X

Input:
2
Output:
P1 Enter your move:
Input:
3,2
Output:

+---+---+---+---+---+---+
|   |   |   |   |   |   |
+---+---+---+---+---+---+
|   |   |   |   |   |   |
+---+---+---+---+---+---+
|   |   |   |   |   |   |
+---+---+---+---+---+---+
|   |   | X |   |   |   |
+---+---+---+---+---+---+
|   |   |   |   |   |   |
+---+---+---+---+---+---+
|   |   |   |   |   |   |
+---+---+---+---+---+---+

P2 Choose which piece you want to take:
 1. O
 2. X
.
.
.
Output:

+---+---+---+---+---+---+
|   |   |   |   | X |   |
+---+---+---+---+---+---+
|   | O |   |   |   |   |
+---+---+---+---+---+---+
|   | O | X | X | X |   |
+---+---+---+---+---+---+
|   | X | X | O |   |   |
+---+---+---+---+---+---+
| O | O | O | O | O |   |
+---+---+---+---+---+---+
|   |   |   |   |   |   |
+---+---+---+---+---+---+

P1 wins.
Continue? (y/Y)
Input:
n
Output:
P1: 1
P2: 0
Stalemate: 0
