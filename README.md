# Tic-tac-toe-with-computer-AI
Tic-tac-toe game with 9 differents levels of computer's AI
The game works in a way that user can click on every empty field and each time there should be an AI move MakeBestMove() method is called. 

Computer move is made by recuirsive method, that dependent on selected level (x), checks x moves ahead which move for it would be the best. 
This method uses min-max algorithm to determine which method will be the best, and it also uses alpha-beta puring to cut off unnecessary
branches, to not consider moves that won't happen in either case. 

![image](https://user-images.githubusercontent.com/32642333/83402694-7dc4d780-a407-11ea-98a3-806428788ff9.png)


