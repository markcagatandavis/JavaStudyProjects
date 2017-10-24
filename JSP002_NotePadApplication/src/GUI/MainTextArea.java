package GUI;


import javax.swing.*;
import java.awt.*;

public class MainTextArea extends JPanel
{
    private JTextArea textArea;
    private JPanel textPanel;

    private Font defaultFont = new Font("Times New Roman", Font.PLAIN, 16);

    public MainTextArea()
    {

        //Create Panel for text area to sit on
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        add(textPanel);

        //Create main Typing area
        textArea = new JTextArea();
        textArea.setFont(defaultFont);
        textArea.setBackground(Color.white);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setVisible(true);

        //Add scroll pane
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(1280,960));
        scroll.setVisible(true);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textPanel.add(scroll);
    }
}
