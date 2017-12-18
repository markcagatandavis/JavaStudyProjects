package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame
{
    private ToolBar toolBar;

    public MainFrame()
    {
        /*
            *
            * This section creates the main JFrame and add's components to JFrame.
            *
        */

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
        setResizable(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setMinimumSize(new Dimension(800,800));
        setLocationRelativeTo(null);

        //Add menu to main area.
        toolBar = new ToolBar();
        setJMenuBar(toolBar.createMenuBar());

        //Initialize TabbedPane to MainFrame.
        TabbedPane tabbedPane = new TabbedPane();
        add(tabbedPane);

        //Set all above visible and packs.
        pack();
        setVisible(true);
    }
}
