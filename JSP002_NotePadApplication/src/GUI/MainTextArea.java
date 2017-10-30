package GUI;


import javax.swing.*;
import java.awt.*;

public class MainTextArea extends JPanel
{
    private JTextArea textArea;
    private Font defaultFont = new Font("Times New Roman", Font.PLAIN, 16);

    public MainTextArea()
    {
        //Create main Typing area
        textArea = new JTextArea(40,100);
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
    }
}
