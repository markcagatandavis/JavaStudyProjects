package GUI;

import javax.swing.*;
import java.awt.*;


public class TabbedPane extends JPanel
{

    private JTabbedPane tabbedPane = new JTabbedPane();
    private MainTextArea mainTextArea = new MainTextArea();

    public TabbedPane ()
    {
        //Set layout so TabbedPane auto sizes to JFrame size
        setLayout(new BorderLayout());

        //Initialize JTabbedPane and pass through JScrollPane from text area method.
       setTabbedPane(mainTextArea.setScroll());

    }

    public void setTabbedPane(JScrollPane tempScrollPane)
    {
        tabbedPane.addTab("New Document", tempScrollPane);
        add(tabbedPane, BorderLayout.CENTER);
    }
}
