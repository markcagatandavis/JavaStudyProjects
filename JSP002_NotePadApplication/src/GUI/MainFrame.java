package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame
{
    private ToolBar toolBar;
    private JTextArea textArea;
    private Font defaultFont = new Font("Times New Roman", Font.PLAIN, 16);

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
        getContentPane().setBackground(Color.BLACK);
        setMinimumSize(new Dimension(800,800));
        setLocationRelativeTo(null);

        //Add menu to main area.
        toolBar = new ToolBar();
        setJMenuBar(toolBar.createMenuBar());

        //Add Main Text Area to JFrame
        MainTextArea();

        //Set all above visible and packs.
        pack();
        setVisible(true);
    }

    public void MainTextArea()
    {
        /*
            * This section creates the main Text Area component.
        */
        textArea = new JTextArea();
        textArea.setFont(defaultFont);
        textArea.setBackground(Color.white);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setVisible(true);

        //Add scroll pane
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVisible(true);
        add(scroll);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        scroll.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2,2,2,2)));

    }
}
