import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Bot {
    private GameState gameState;
    private static Manager manager;

    public Bot(GameState gameState, Manager manager)
    {
        this.gameState=gameState;
        this.manager=manager;
    }

    public void makeBestMove()
    {
        int x=0;
        int y=0;
        FieldState[][] board=gameState.getBoard();
        int bestScore= Integer.MIN_VALUE;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==FieldState.Empty)
                {
                    board[i][j]=FieldState.O;

                    //alpha equals -infinity, as we always want it to get bigger for successful
                    //the same, but in other way goes for beta
                    int score=alphaBetaPuring(board, 0, false, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    board[i][j]=FieldState.Empty;
                    if(score>bestScore)
                    {
                        bestScore=score;
                        x=i;
                        y=j;
                    }
                }
            }
        }
        this.makeMove(x,y);
    }

    private int alphaBetaPuring(FieldState[][] board, int depth, boolean maxMove, int alpha, int beta)
    {
        manager.getCheckBoardState().checkIfGameShouldEnd(gameState);

        //player win
        if (manager.getCheckBoardState().isGameFinished() == true && manager.getCheckBoardState().getWinner()==FieldState.X) {
            manager.getCheckBoardState().setGameFinished(false);
            return -10 + depth;
        }

        //computer win
        else if  (manager.getCheckBoardState().isGameFinished() == true && manager.getCheckBoardState().getWinner()==FieldState.O)
        {
            manager.getCheckBoardState().setGameFinished(false);
            return 10 - depth;
        }

        //tie
        else if  (manager.getCheckBoardState().isGameFinished() == true && manager.getCheckBoardState().getWinner()==FieldState.Empty)
        {
            manager.getCheckBoardState().setGameFinished(false);
            return 0;
        }

        if(depth>=gameState.getLevel())
            return 0;

        //computer move
        if(maxMove) {
            //it has to be lower than -10, so it will be changed in any case
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == FieldState.Empty) {

                        //Computer is checking all possibilities for it's next move(or more, depending of the depth)
                        // after a possibility is checked the field is getting back to it's previous, empty space
                        board[i][j] = FieldState.O;
                        int score = alphaBetaPuring(board, depth + 1, false, alpha, beta);
                        board[i][j] = FieldState.Empty;

                        bestScore=Math.max(score,bestScore);

                        alpha=Math.max(alpha, bestScore);

                        //if beta is lesser than alpha we know that some boards states won't be checked, as they are worse anyway,
                        //so they are pruned
                        if(beta<=alpha)
                            return bestScore;
                    }
                }
            }
            return bestScore;
        }

        //player move simulation for bot
        else
        {
            //it has to be higher than 10, so it will be changed in any case
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == FieldState.Empty) {

                        //Computer is checking all possibilities for player's next move(or more, depending of the depth)
                        // after a possibility is checked the field is getting back to it's previous, empty space
                        board[i][j] = FieldState.X;
                        int score = alphaBetaPuring(board, depth + 1, true, alpha, beta);
                        board[i][j] = FieldState.Empty;

                        bestScore=Math.min(score,bestScore);
                        beta=Math.min(beta, bestScore);

                        //if beta is lesser than alpha we know that some boards states won't be checked, as they are worse anyway,
                        //so they are pruned
                        if(beta<=alpha)
                            return bestScore;
                    }
                }
            }
            return bestScore;
        }
    }


    //It will never be called, as it is just less efficient alpha-beta puring
    private int minMaxAlgorithm(FieldState[][] board, int depth, boolean maxMove)
    {
        manager.getCheckBoardState().checkIfGameShouldEnd(gameState);

        //player win
        if (manager.getCheckBoardState().isGameFinished() == true && manager.getCheckBoardState().getWinner()==FieldState.X) {
            manager.getCheckBoardState().setGameFinished(false);
            return -10 + depth;
        }

        //computer win
        else if  (manager.getCheckBoardState().isGameFinished() == true && manager.getCheckBoardState().getWinner()==FieldState.O)
        {
            manager.getCheckBoardState().setGameFinished(false);
            return 10 - depth;
        }

        //tie
        else if  (manager.getCheckBoardState().isGameFinished() == true && manager.getCheckBoardState().getWinner()==FieldState.Empty)
        {
            manager.getCheckBoardState().setGameFinished(false);
            return 0;
        }

        if(depth>=gameState.getLevel())
            return 0;

        //computer move
        if(maxMove) {
            //it has to be lower than -10, so it will be changed in any case
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == FieldState.Empty) {
                        board[i][j] = FieldState.O;
                        int score = minMaxAlgorithm(board, depth + 1, false);
                        board[i][j] = FieldState.Empty;
                        bestScore=Math.max(score,bestScore);
                    }
                }
            }
            return bestScore;
        }

        //player move simulation for bot
        else
        {
            //it has to be higher than 10, so it will be changed in any case
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == FieldState.Empty) {
                        board[i][j] = FieldState.X;
                        int score = minMaxAlgorithm(board, depth + 1, true);
                        board[i][j] = FieldState.Empty;
                         bestScore=Math.min(score,bestScore);
                    }
                }
            }
            return bestScore;
        }
    }


    //Method to make a move when computer will decide where to go
    private void makeMove(int x, int y)
    {
        FieldState[][] board=gameState.getBoard();

        board[x][y]=FieldState.O;
        JButton button=manager.getField(x,y);
        ButtonClick buttonClick=new ButtonClick(button, gameState, manager);
        try {
            Image img = ImageIO.read(getClass().getResource("resources/oIcon.png"));
            buttonClick.setButtonsIcon(img,button);
        }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
