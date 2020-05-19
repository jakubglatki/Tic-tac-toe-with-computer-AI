import javax.swing.*;
import java.awt.*;

public class Manager {

    private static GUI gui;

    public Manager(){};

    public Manager(GUI gui)
    {
        this.gui=gui;
    }

    public void setButtonsProperties()
    {
        gui.getField0().setBackground(Color.white);
        gui.getField0().setOpaque(true);
        gui.getField0().setName("field0");

        gui.getField1().setBackground(Color.white);
        gui.getField1().setOpaque(true);
        gui.getField1().setName("field1");

        gui.getField2().setBackground(Color.white);
        gui.getField2().setOpaque(true);
        gui.getField2().setName("field2");

        gui.getField3().setBackground(Color.white);
        gui.getField3().setOpaque(true);
        gui.getField3().setName("field3");

        gui.getField4().setBackground(Color.white);
        gui.getField4().setOpaque(true);
        gui.getField4().setName("field4");

        gui.getField5().setBackground(Color.white);
        gui.getField5().setOpaque(true);
        gui.getField5().setName("field5");

        gui.getField6().setBackground(Color.white);
        gui.getField6().setOpaque(true);
        gui.getField6().setName("field6");

        gui.getField7().setBackground(Color.white);
        gui.getField7().setOpaque(true);
        gui.getField7().setName("field7");

        gui.getField8().setBackground(Color.white);
        gui.getField8().setOpaque(true);
        gui.getField8().setName("field8");

    }

    public void setComboBoxValues()
    {
        gui.getLevelCB().addItem("Very easy (1)");
        gui.getLevelCB().addItem("Easy (2)");
        gui.getLevelCB().addItem("Beginner (3)");
        gui.getLevelCB().addItem("Low intermediate (4)");
        gui.getLevelCB().addItem("Intermediate (5)");
        gui.getLevelCB().addItem("Upper Intermediate (6)");
        gui.getLevelCB().addItem("Hard (7)");
        gui.getLevelCB().addItem("Very hard (8)");
        gui.getLevelCB().addItem("Impossible (9)");
    }

    public JButton getField(int i, int j) {

        if (i == 0 && j == 0)
            return gui.getField0();

        else if(i==0 && j==1)
            return gui.getField1();

        else if(i==0 && j==2)
            return gui.getField2();

        else if (i == 1 && j == 0)
            return gui.getField3();

        else if(i==1 && j==1)
            return gui.getField4();

        else if(i==1 && j==2)
            return gui.getField5();

        else if (i == 2 && j == 0)
            return gui.getField6();

        else if(i==2 && j==1)
            return gui.getField7();

        else if(i==2 && j==2)
            return gui.getField8();

        else return new JButton();
    }

    public void finishedGame(GameState gameState)
    {
        this.setScoreValues(gameState);
        this.setScoreTexts(gameState);
    }

    public void resetBoard(GameState gameState)
    {
        FieldState[][] board= gameState.getBoard();
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j]=FieldState.Empty;
                gameState.setStartingPlayer();
                getCheckBoardState().setWinner(null);
                JButton button=this.getField(i,j);
                button.setIcon(null);
            }
        }
    }

    private void setScoreValues(GameState gameState)
    {
        if (getCheckBoardState().getWinner() == FieldState.X) {
            gameState.setPlayerScore(gameState.getPlayerScore() + 1);
        }
        else if (getCheckBoardState().getWinner() == FieldState.O)
        {
            gameState.setComputerScore(gameState.getComputerScore() + 1);
        }
        else if (getCheckBoardState().getWinner() == FieldState.Empty)
        {
            gameState.setTiesScore(gameState.getTiesScore()+1);
        }
    }

    private void setScoreTexts(GameState gameState)
    {
        String userScore= Integer.toString(gameState.getPlayerScore());
        gui.setUserWinsValue(userScore);

        String computerScore= Integer.toString(gameState.getComputerScore());
        gui.setComputerWinsValue(computerScore);

        String tiesScore= Integer.toString(gameState.getTiesScore());
        gui.setTiesValue(tiesScore);

    }

    public CheckBoardState getCheckBoardState()
    {
        return gui.getCheckBoardState();
    }

    public void setLevelFromComboBox(GameState gameState)
    {
        String strLevel=gui.getLevelCB().getSelectedItem().toString();
        strLevel = strLevel.replaceAll("\\D+","");

        int level = Integer.parseInt(strLevel);
        gameState.setLevel(level);
    }

}
