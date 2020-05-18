import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel mainWindow;
    private JButton field0;
    private JButton field1;
    private JButton field2;
    private JButton field3;
    private JButton field4;
    private JButton field5;
    private JButton field6;
    private JButton field7;
    private JButton field8;
    private JPanel ticTacToePanel;
    private JPanel statisticPanel;
    private JComboBox levelCB;
    private JLabel userWinsValue;
    private JLabel tiesValue;
    private JLabel computerWinsValue;
    private static Manager manager;
    private static GameState gameState;
    private static CheckBoardState checkBoardState;

    public JButton getField0() {
        return field0;
    }

    public JButton getField1() {
        return field1;
    }

    public JButton getField2() {
        return field2;
    }

    public JButton getField3() {
        return field3;
    }

    public JButton getField4() {
        return field4;
    }

    public JButton getField5() {
        return field5;
    }

    public JButton getField6() {
        return field6;
    }

    public JButton getField7() {
        return field7;
    }

    public JButton getField8() {
        return field8;
    }

    public JComboBox getLevelCB() {
        return levelCB;
    }

    public static CheckBoardState getCheckBoardState() {
        return checkBoardState;
    }


    public void setUserWinsValue(String value) {
        this.userWinsValue.setText(value);
    }


    public void setTiesValue(String value) {
        this.tiesValue.setText(value);
    }

    public void setComputerWinsValue(String value) {
        this.computerWinsValue.setText(value);
    }

    public static void setGameState(GameState gameState) {
        GUI.gameState = gameState;
    }

    private void addButtonsActionListeners()
    {
        field0.addActionListener(new ButtonClick(field0, gameState, manager));
        field6.addActionListener(new ButtonClick(field6, gameState, manager));
        field3.addActionListener(new ButtonClick(field3, gameState, manager));
        field1.addActionListener(new ButtonClick(field1, gameState, manager));
        field7.addActionListener(new ButtonClick(field7, gameState, manager));
        field4.addActionListener(new ButtonClick(field4, gameState, manager));
        field2.addActionListener(new ButtonClick(field2, gameState, manager));
        field8.addActionListener(new ButtonClick(field8, gameState, manager));
        field5.addActionListener(new ButtonClick(field5, gameState, manager));

    }

    public static Manager getManager() {
        return manager;
    }

    public GUI()
    {
        GridLayout layout = new GridLayout(3,3,7,7);
        ticTacToePanel.setLayout(layout);

        checkBoardState=new CheckBoardState();

        manager=new Manager(this);
        manager.setButtonsProperties();
        gameState= new GameState(manager);
        manager.setComboBoxValues();
        addButtonsActionListeners();
        levelCB.addItemListener(new ChangeLevel(gameState, manager));
    }


    public static void main(String[] args) {
        int height = 480;
        int width = 640;


        JFrame frame = new JFrame("Tic-tac-toe");
        frame.setPreferredSize(new Dimension(width, height));
        frame.setContentPane(new GUI().mainWindow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

    }
}
