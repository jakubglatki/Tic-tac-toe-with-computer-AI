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

    public void makeRandomMove()
    {
        FieldState[][] board=gameState.getBoard();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                if(board[i][j]==FieldState.Empty)
                {
                    board[i][j]=FieldState.O;
                    JButton button=manager.getField(i,j);
                    ButtonClick buttonClick=new ButtonClick(button, gameState, manager);
                    try {
                        Image img = ImageIO.read(getClass().getResource("resources/oIcon.png"));
                        buttonClick.setButtonsIcon(img,button);
                        return;
                    }
                    catch (Exception ex) {
                        System.out.println(ex);
                    }
                    return;
                }
            }

        }
    }
}
