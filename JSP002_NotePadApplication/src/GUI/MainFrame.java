package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private JTextField textField;
    private ToolBar toolBar;

    public MainFrame()
    {
        super("Notepad Express");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1020,1080);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        textField = new JTextField();
        textField.setBackground(Color.white);
        textField.setSize(980,980);
        textField.setVisible(true);
        add(textField, BorderLayout.SOUTH);


        toolBar = new ToolBar();
        add(toolBar, BorderLayout.NORTH);
    }
}
