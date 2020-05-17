import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClick implements ActionListener {

    private JButton button;

    ButtonClick(JButton button)
    {
        this.button=button;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
