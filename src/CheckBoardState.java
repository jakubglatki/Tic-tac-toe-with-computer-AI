public class CheckBoardState {

    private boolean isGameFinished=false;
    private FieldState winner;

    public CheckBoardState()
    {
    }

    public void checkIfGameShouldEnd(GameState gameState)
    {
        this.checkHorizontally(gameState);

        if(!isGameFinished)
            this.checkVertically(gameState);

        if(!isGameFinished)
            this.checkDiagonally(gameState);

        if(!isGameFinished)
            this.checkIfAllFieldsAreTaken(gameState);
    }

    public boolean isGameFinished() {
        return isGameFinished;
    }

    public void setGameFinished(boolean gameFinished) {
        isGameFinished = gameFinished;
    }

    public void setWinner(FieldState fieldState)
    {
        winner=fieldState;
    }

    public FieldState getWinner() {
        return winner;
    }

    private void checkHorizontally(GameState gameState)
    {
        FieldState[][]board=gameState.getBoard();

        for (int i=0;i<3;i++)
        {
            if(board[i][0]==board[i][1] && board[i][0] == board[i][2])
            {
                if (board[i][0]==FieldState.X)
                {
                    isGameFinished=true;
                    setWinner(FieldState.X);
                    return;
                }
                else if(board[i][0]==FieldState.O)
                {
                    isGameFinished=true;
                    setWinner(FieldState.O);
                    return;
                }
            }
        }

        isGameFinished=false;
    }



    private void checkVertically(GameState gameState)
    {
        FieldState[][]board=gameState.getBoard();

        for (int i=0;i<3;i++)
        {
            if(board[0][i]==board[1][i] && board[0][i] == board[2][i])
            {
                if (board[0][i]==FieldState.X)
                {
                    isGameFinished=true;
                    setWinner(FieldState.X);
                    return;
                }
                else if(board[0][i]==FieldState.O)
                {
                    isGameFinished=true;
                    setWinner(FieldState.O);
                    return;
                }
            }
        }
        isGameFinished=false;
    }


    private void checkDiagonally(GameState gameState)
    {
        FieldState[][]board=gameState.getBoard();

        if(board[0][0]==board[1][1] && board[0][0]==board[2][2])
        {
            if (board[0][0]==FieldState.X)
            {
                isGameFinished=true;
                setWinner(FieldState.X);
                return;
            }

            else if(board[0][0]==FieldState.O)
            {
                isGameFinished=true;
                setWinner(FieldState.O);
                return;
            }
        }

        if (board[0][2]==board[1][1] && board[1][1]==board[2][0])
        {
            if (board[1][1]==FieldState.X)
            {
                isGameFinished=true;
                setWinner(FieldState.X);
                return;
            }

            else if(board[1][1]==FieldState.O)
            {
                isGameFinished=true;
                setWinner(FieldState.O);
                return;
            }
        }

        isGameFinished=false;
    }

    private void checkIfAllFieldsAreTaken(GameState gameState)
    {
        FieldState[][]board=gameState.getBoard();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==FieldState.Empty)
                    return;
            }
        }
        isGameFinished=true;
        setWinner(FieldState.Empty);
    }
}
