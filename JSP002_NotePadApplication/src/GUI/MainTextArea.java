package GUI;


import javax.swing.*;
import java.awt.*;

public class MainTextArea extends JPanel
{
    private JTextArea textArea;
    private JPanel textPanel;

    private Font defaultFont = new Font("Times New Roman", Font.PLAIN, 12);

    public MainTextArea()
    {
        textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
        add(textPanel);

        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane);

        textArea = new JTextArea();
        textArea.setFont(defaultFont);
        textArea.setBackground(Color.white);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setVisible(true);

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(1280,1080));
        textPanel.add(scroll);
    }
}
