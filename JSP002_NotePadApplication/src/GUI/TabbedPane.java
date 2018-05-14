package GUI;

import javax.swing.*;
import javax.swing.border.Border;
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
        add(tabbedPane, BorderLayout.CENTER);
        addTabbedPane();
    }

    public void addTabbedPane() {
        JScrollPane tempScroll = createScrollPane();
        tabbedPane.addTab("New Document", tempScroll);
    }

    public JScrollPane createScrollPane()
    {
        //Add scroll pane
        JScrollPane scroll = new JScrollPane(mainTextArea.getTextArea());
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Border scrollBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        scroll.setBorder(BorderFactory.createCompoundBorder(scrollBorder, BorderFactory.createEmptyBorder(1,1,1,1)));
        scroll.setVisible(true);

        return scroll;
    }
}
