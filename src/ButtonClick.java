import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClick implements ActionListener {

    private JButton button;

    public ButtonClick(JButton button)
    {
        this.button=button;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        try {
            Image img = ImageIO.read(getClass().getResource("resources/xIcon.png"));
            button.setIcon(new ImageIcon(img));
            button.setFocusable(false);
            button.removeActionListener(this);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
