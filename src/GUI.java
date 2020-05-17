import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JPanel mainWindow;
    private JButton field0;
    private JButton field3;
    private JButton field6;
    private JButton field2;
    private JButton field5;
    private JButton field8;
    private JButton field1;
    private JButton field4;
    private JButton field7;
    private JPanel ticTacToePanel;
    private JPanel statisticPanel;
    private JComboBox levelCB;
    private JLabel userWinsValue;
    private JLabel tiesValue;
    private JLabel computerWinsValue;
    private static Manager manager;

    public JButton getField0() {
        return field0;
    }

    public JButton getField3() {
        return field3;
    }

    public JButton getField6() {
        return field6;
    }

    public JButton getField2() {
        return field2;
    }

    public JButton getField5() {
        return field5;
    }

    public JButton getField8() {
        return field8;
    }

    public JButton getField1() {
        return field1;
    }

    public JButton getField4() {
        return field4;
    }

    public JButton getField7() {
        return field7;
    }

    public JComboBox getLevelCB() {
        return levelCB;
    }

    public GUI()
    {
        manager=new Manager(this);
        manager.setButtonsProperties();
        manager.setComboBoxValues();
        field0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
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
