package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private MainTextField mainTextField;
    private ToolBar toolBar;

    private JPanel mainPanel;

    public MainFrame()
    {
        super("Notepad Express");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1020,1080);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setLocationRelativeTo(null);

        //Create panel for everything to sit on.
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        //Add text field to panel.
        mainTextField = new MainTextField();
        mainPanel.add(mainTextField);

        //Add panel to main area.
        toolBar = new ToolBar();
        mainPanel.add(toolBar, BorderLayout.NORTH);

        //Pack and show components.
        pack();
        setVisible(true);


    }
}
