# Sleep-Team

# Tic-Tac-Toe Site
### Contributors: Chuyang, Demetrius , Devin, James, Devin 

A Tic-Tac-Toe site to play the game with a bot or a person.

#### Features:
- [] Play Tic-Tac-Toe
- [] VS. A.I. (Easy)
- [] VS. Player
- [] Login and logout
- [] Keep Track of Wins
- [] VS. A.I. (Hard)

#### Backend To Do:
- [] Create User Model (Simon)
    - ID, Username,  Password, Wins, Losses
- [] Create Board Model (Demetrius)
    - 2d Array (3x3) filled with undefined x's or o's, state of game (Finished or Unfinished), Winner ( x's or o's or undefined)
- [] Controllers and Services (Simon and Demetrius)
    -Basic stuff. Endpoint to call board model vs ai and seperate one for vs player, endpoint to call user model.
        -[x]updateWinPlusOne path: /users/updateWinPlusOne/{username}       returns: User object      error return: nothing (to be updated)
        -[x]updateLossPlusOne path: /users/updateLossPlusOne/{username}     returns: User object      error return: nothing (to be updated)
        -[x]find user by id path: /users/id/{userId}                        returns: User object      error return: nothing (to be updated)
        -[x]find user by username path: /users/username/{username}          returns: User object      error return: nothing (to be updated)

#### Frontend To Do:
- [] TicTacToe NavBar (Devin)
- [] Create Basic Layout to display Tic-Tac-Toe Board (Chuyang)
- [] Create the ability to click on board and siaply x's or o's
- [] The ability to pick x's  or o's
- [] Display Winner once game is done
- [] Make calls to backend for state of game
- [] Login and logout
- [] Login Screen (James)
- [] Make calls to backend for user
- [] display amount of wins somewhere
