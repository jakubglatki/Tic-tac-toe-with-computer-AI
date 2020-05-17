import javax.swing.*;
import java.awt.*;

public class Manager {

    private static GUI gui;

    public Manager(GUI gui1)
    {
        gui=gui1;
    }

    public void setButtonsProperties()
    {
        gui.getField0().setBackground(Color.white);
        gui.getField0().setOpaque(true);
        gui.getField1().setBackground(Color.white);
        gui.getField1().setOpaque(true);
        gui.getField2().setBackground(Color.white);
        gui.getField2().setOpaque(true);
        gui.getField3().setBackground(Color.white);
        gui.getField3().setOpaque(true);
        gui.getField4().setBackground(Color.white);
        gui.getField4().setOpaque(true);
        gui.getField5().setBackground(Color.white);
        gui.getField5().setOpaque(true);
        gui.getField6().setBackground(Color.white);
        gui.getField6().setOpaque(true);
        gui.getField7().setBackground(Color.white);
        gui.getField7().setOpaque(true);
        gui.getField8().setBackground(Color.white);
        gui.getField8().setOpaque(true);
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

}
