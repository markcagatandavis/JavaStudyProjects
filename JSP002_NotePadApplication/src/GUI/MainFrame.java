package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame
{
    private MainTextArea mainTextArea;
    private ToolBar toolBar;

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
        setResizable(true);
        getContentPane().setBackground(Color.BLACK);
        setMinimumSize(new Dimension(800,800));
        setLocationRelativeTo(null);

        //Add menu to main area.
        toolBar = new ToolBar();
        setJMenuBar(toolBar.createMenuBar());

        //Add text Area to panel.
        mainTextArea = new MainTextArea();
        add(mainTextArea);

        //Set all above visible.
        pack();
        setVisible(true);
    }
}
