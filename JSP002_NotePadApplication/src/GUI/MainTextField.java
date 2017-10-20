package GUI;


import javax.swing.*;
import java.awt.*;

public class MainTextField
{
    private JTextField textField;

    private Font defaultFont = new Font("Times New Roman", Font.PLAIN, 12);

    public MainTextField()
    {
        textField = new JTextField();
        textField.setBackground(Color.white);
        textField.setPreferredSize(new Dimension(980,980));
        textField.setFont(defaultFont);
        textField.setVisible(true);

    }
}
