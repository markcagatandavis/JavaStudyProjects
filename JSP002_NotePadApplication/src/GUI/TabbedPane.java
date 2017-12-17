package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class TabbedPane extends JPanel
{
    JTabbedPane tabbedPane = new JTabbedPane();
    MainTextArea mainTextArea = new MainTextArea();
    private JScrollPane scroll;
    private JTextArea tempGetTextArea = mainTextArea.getTextArea();

    public TabbedPane ()
    {
        //Set layout so TabbedPane auto sizes to JFrame size
        setLayout(new BorderLayout());

        //Initialize JTabbedPane and pass through JScrollPane from text area method.
        add(tabbedPane, BorderLayout.CENTER);
        addTabbedPane();
    }

    public void addTabbedPane() {
        JScrollPane scroll = createScrollPane();
        tabbedPane.addTab("New Document", scroll);
    }

    public JScrollPane createScrollPane()
    {
        /*
         * Adding scroll pane into it's own method so it can be called in other classes
         */
        //Add scroll pane
        scroll = new JScrollPane(tempGetTextArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Border scrollBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        scroll.setBorder(BorderFactory.createCompoundBorder(scrollBorder, BorderFactory.createEmptyBorder(1,1,1,1)));
        scroll.setVisible(true);

        return scroll;
    }
}
