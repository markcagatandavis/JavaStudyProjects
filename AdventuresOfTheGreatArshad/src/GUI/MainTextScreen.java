package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Mark.Davis on 23/07/2017.
 */
public class MainTextScreen extends JPanel
{
    private JPanel mainTextPanel,mainTextImagePanel;
    private JTextArea mainTextArea;
    private Font mainTextFont = new Font("Times New Roman", Font.PLAIN, 18);
    private JLabel mainTextPanelImageLabel;
    private ImageIcon mainTextAreaImage;
    private JScrollPane scrollPane;
    private Border noBorder = BorderFactory.createEmptyBorder();

    public MainTextScreen()

    {
        //This is the panel for the main text area, where the story is told.
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(0, 0, 480, 510); //480x480
        mainTextPanel.setLayout(null);
        mainTextPanel.setBackground(Color.gray);
        add(mainTextPanel);

        //This is adding a background image to the mainTextPanel.
        //Note: You need a new panel for the label to sit on (can't add to main panel)
        mainTextImagePanel = new JPanel();
        mainTextImagePanel.setBounds(0, 0, 480, 510);
        mainTextImagePanel.setLayout(new BorderLayout());
        mainTextPanel.add(mainTextImagePanel);

        mainTextPanelImageLabel = new JLabel();
        mainTextAreaImage = new ImageIcon(".//res//mainTextPanel.png");
        mainTextPanelImageLabel.setIcon(mainTextAreaImage);
        mainTextImagePanel.add(mainTextPanelImageLabel);

        //This is the main text area, where text is displayed.
        mainTextArea  = new JTextArea();
        mainTextArea.setForeground(Color.BLACK);
        mainTextArea.setFont(mainTextFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        mainTextArea.setHighlighter(null);
        mainTextArea.setOpaque(false);
        scrollPane = new JScrollPane(mainTextArea);
        scrollPane.setBounds(50,30,380,450);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        scrollPane.setBorder(noBorder);
        mainTextPanelImageLabel.add(scrollPane);
    }

    //This is to allow text from IngameFrame PlayerInput to communicate to IngameFrame MainTextScreen for append text.
    public void appendMainTextArea(String text)
    {
            mainTextArea.append(text + "\n");
    }

    //This is to allow text from IngameFrame PlayerInput to communicate to IngameFrame MainTextScreen for set text.
    public void setMainTextArea (String text)
    {
        mainTextArea.setText(text + "\n");
    }
}