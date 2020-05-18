import javax.swing.*;

public class GameState {

    private int playerScore;
    private int computerScore;
    private int tiesScore;
    private FieldState[][] board;
    private int level;
    private StartingPlayer startingPlayer;
    private static Manager manager;

    public GameState(Manager manager) {
        this.manager = manager;
        this.board = new FieldState[3][3];
        FillBoard();
        setStartingPlayer();
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getTiesScore() {
        return tiesScore;
    }

    public FieldState[][] getBoard() {
        return board;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public void setTiesScore(int tiesScore) {
        this.tiesScore = tiesScore;
    }

    public void setBoard(FieldState[][] board) {
        this.board = board;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public StartingPlayer getStartingPlayer() {
        return startingPlayer;
    }

    private void setStartingPlayer() {
        int random = (int) (Math.random() * 2);

        if (random == 1) {
            startingPlayer = StartingPlayer.Player;
        } else startingPlayer = StartingPlayer.Computer;
    }


    //gives information if given field is Empty, O or X
    public FieldState getFieldsState(JButton button)
    {
        if (button.getName()=="field0") {
            return board[0][0];
        }
        if (button.getName()=="field1") {
            return board[0][1];
        }
        if (button.getName()=="field2") {
            return board[0][2];
        }
        if (button.getName()=="field3") {
            return board[1][0];
        }
        if (button.getName()=="field4") {
            return board[1][1];
        }
        if (button.getName()=="field5") {
            return board[1][2];
        }
        if (button.getName()=="field6") {
            return board[2][0];
        }
        if (button.getName()=="field7") {
            return board[2][1];
        }
        if (button.getName()=="field8") {
            return board[2][2];
        }

        else return FieldState.Empty;
    }

    //at the beginning all fields are empty
    private void FillBoard()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=FieldState.Empty;
            }
        }
    }
}
