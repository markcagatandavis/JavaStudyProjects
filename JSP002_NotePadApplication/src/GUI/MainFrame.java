package GUI;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private MainTextArea mainTextArea;
    private ToolBar toolBar;

    private JPanel mainPanel;

    public MainFrame()
    {
        //MainFrame Configurations.
        super("Notepad Express");
        setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
        setSize(900,800);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);

        //Create panel for everything to sit on.
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);

        //Add panel to main area.
        toolBar = new ToolBar();
        mainPanel.add(toolBar, BorderLayout.NORTH);

        //Add text Area to panel.
        mainTextArea = new MainTextArea();
        mainPanel.add(mainTextArea);

        //Set all above visible.
        pack();
        setVisible(true);
    }
}
