# TennisV1
Tennis Game

## Rules

The scoring system is rather simple:

1. Each player can have either of these points in one game 0 15 30 40

2. If you have 40 and you win the ball you win the game, however there are special rules.

3. If both have 40 the players are deuce. 
  
    a. If the game is in deuce, the winner of a ball will have advantage and game ball. 
  
    b. If the player with advantage wins the ball he wins the game 
  
    c. If the player without advantage wins they are back at deuce.

1. A game is won by the first player to have won at least four points in total and at least two points more than the opponent.

2. The running score of each game is described in a manner peculiar to tennis: scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively.

3. If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.

4. If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.

To Run this application in Spring Suite Tool (STS)
Download code and Run As Spring Boot Project, With Tomcat Port 8081 using JAVA Version 8

Now, Run below API in Postman or any other API Platform.
localhost:8081/getGameScore/
with two parameters "playerOneScore" & "playerTwoScore" under BODY in form-data Section, to pass individual Score of both the players.
