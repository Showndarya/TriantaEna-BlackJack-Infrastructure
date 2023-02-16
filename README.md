# Modified Black Jack Game Infrastructure

- Classes:
1) Cell: The board consists of a matrix of Cells. A Cell is a class used to store any object value.
2) Player: Houses player information with private variables like name, id, score, past moves.
3) Score: Maintains scores of the players. Statistics include the number of wins, loses, and
draws. Can be extended to add more statistics.
4) Team: Class to hold team information, list of players with manipulation functions.
- Abstract Classes:
1. Board: Elements of the board like board dimensions, board layout, count of players, game
pieces. Functions to set board pieces, game moves, resetting the board, printing the board
on the terminal.
2. Engine: The class which houses the main game loop. Used to create the game board, add
players, teams, while keeping track of the overall scores.
3. Piece: Abstract class to hold functions related to getting internal and display value for each
piece (game piece).
- Interfaces:
1) Move: Interface to represent a player’s move. For example placing a piece in tic tac toe, or a
castle move in chess.
2) Turn: Interface to hold functions for handling turn based games.

Built on base code from [Reusable-Board-Game-Structure](https://github.com/Showndarya/Reusable-Board-Game-Structure)
