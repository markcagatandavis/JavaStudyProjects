package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame
{
    private MainTextArea mainTextArea;
    private ToolBar toolBar;

    private JPanel mainPanel;

    public MainFrame()
    {
        //MainFrame Configurations.
        super("Notepad Express");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                int action = JOptionPane.showConfirmDialog(null,
                        "Confirmation: Close Application?",
                        "EXIT APPLICATION?", JOptionPane.OK_CANCEL_OPTION);

                if (action == JOptionPane.OK_OPTION)
                {
                    System.exit(0);
                }
            }
        });
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
        setJMenuBar(toolBar.createMenuBar());

        //Add text Area to panel.
        mainTextArea = new MainTextArea();
        mainPanel.add(mainTextArea);

        //Set all above visible.
        pack();
        setVisible(true);
    }
}
