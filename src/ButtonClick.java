import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClick implements ActionListener {

    private static Manager manager;
    private JButton button;
    private static GameState gameState;

    public ButtonClick(JButton button, GameState gameState, Manager manager)
    {
        this.button=button;
        this.gameState=gameState;
        this.manager=manager;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

            //if field is empty we will change it to X, and bot will change his to O. Otherwise button is not clickable
            if(gameState.getFieldsState(button)==FieldState.Empty && manager.getCheckBoardState().isGameFinished()==false) {
                    this.buttonClickedWhenGameNotFinished();
            }
            else if(manager.getCheckBoardState().isGameFinished()==true)
            {
                manager.resetBoard(gameState);
                manager.getCheckBoardState().setGameFinished(false);
            }
    }

    private void buttonClickedWhenGameNotFinished()
    {
            if(gameState.getStartingPlayer()==StartingPlayer.Computer) {
                this.makeComputerMove();
                gameState.setStartingPlayer(StartingPlayer.Player);
            }
            else {
                this.makePlayerMove();
            }
    }

    private void makeComputerMove()
    {
        Bot bot = new Bot(gameState, manager);
        bot.makeBestMove();
    }

    private void makePlayerMove()
    {

        try {
            Image img = ImageIO.read(getClass().getResource("resources/xIcon.png"));
            setButtonsIcon(img, this.button);
            this.setFieldToX();
            manager.getCheckBoardState().checkIfGameShouldEnd(gameState);
            if (manager.getCheckBoardState().isGameFinished() == true) {
                manager.finishedGame(gameState);
                return;
            }
            this.makeComputerMove();
            manager.getCheckBoardState().checkIfGameShouldEnd(gameState);
            if (manager.getCheckBoardState().isGameFinished() == true) {
                manager.finishedGame(gameState);
                return;
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public void setButtonsIcon(Image img, JButton button)
    {
        button.setIcon(new ImageIcon(img));
    }

    private void setFieldToX() {
      FieldState[][]  board = gameState.getBoard();
        if (button.getName()=="field0") {
            board[0][0]=FieldState.X;
        }
        if (button.getName()=="field1") {
            board[0][1]=FieldState.X;
        }
        if (button.getName()=="field2") {
            board[0][2]=FieldState.X;
        }
        if (button.getName()=="field3") {
            board[1][0]=FieldState.X;
        }
        if (button.getName()=="field4") {
            board[1][1]=FieldState.X;
        }
        if (button.getName()=="field5") {
            board[1][2]=FieldState.X;
        }
        if (button.getName()=="field6") {
            board[2][0]=FieldState.X;
        }
        if (button.getName()=="field7") {
            board[2][1]=FieldState.X;
        }
        if (button.getName()=="field8") {
            board[2][2]=FieldState.X;
        }
    }
}
