package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.DefaultMenuLayout;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by MarkCagatanDavis on 20/07/2017.
 */
public class TitleScreen extends JPanel
{
    private JPanel titleNamePanel, titleMenuButtonPanel, titleScreenImagePanel;
    private JLabel titleNameLabel, titleScreenImageLabel;
    public static JButton startButton;
    private JButton continueButton;
    private JButton exitButton;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 32);
    private Font startButtonFont = new Font("Times New Roman", Font.PLAIN, 30);
    private Border noBorder = BorderFactory.createEmptyBorder();
    private ImageIcon titleScreenImage, titleNameImage;

    public TitleScreen()
    {
        //This is creating the JPanel for the image to sit on.
        titleScreenImagePanel = new JPanel();
        titleScreenImagePanel.setBounds(0, 0, 1280, 720);
        titleScreenImagePanel.setLayout(new GridBagLayout());
        add(titleScreenImagePanel);

        //This is adding the image to JLabel
        titleScreenImageLabel = new JLabel();
        titleScreenImage = new ImageIcon(".//res//TitleScreenBackground.jpg");
        titleScreenImageLabel.setIcon(titleScreenImage);
        titleScreenImagePanel.add(titleScreenImageLabel);

        //This is used to create the text panel
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(320, 200, 600, 160);
        titleNamePanel.setOpaque(false);
        titleScreenImageLabel.add(titleNamePanel);

        titleNameLabel = new JLabel();
        titleNameImage = new ImageIcon(".//res//TitleName.png");
        titleNameLabel.setIcon(titleNameImage);
        titleNamePanel.add(titleNameLabel);

        //This is used to create the button menu panel
        titleMenuButtonPanel = new JPanel();
        titleMenuButtonPanel.setBounds(420, 450, 400, 200);
        titleMenuButtonPanel.setOpaque(false);

        //This creates the start button
        startButton = new JButton();
        startButton.setPreferredSize(new Dimension(400,50));
        startButton.setIcon(new ImageIcon(".//res/NewAdventureButton.png"));
        startButton.setForeground(Color.lightGray);
        startButton.setFont(startButtonFont);
        startButton.setBorder(noBorder);
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> {
            titleMenuButtonPanel.setVisible(false);
            titleMenuButtonPanel.setEnabled(false);
            titleNamePanel.setVisible(false);
            titleNamePanel.setEnabled(false);
        });

        continueButton = new JButton();
        continueButton.setPreferredSize(new Dimension(400,50));
        continueButton.setIcon(new ImageIcon(".//res/ContinueAdventureButton.png"));
        continueButton.setForeground(Color.lightGray);
        continueButton.setFont(startButtonFont);
        continueButton.setBorder(noBorder);
        continueButton.setOpaque(false);
        continueButton.setContentAreaFilled(false);
        continueButton.setFocusPainted(false);
        continueButton.addActionListener(e -> {
            System.out.println("TEST CONTINUE OUTPUT"); //This will be used to load game from save file
        });

        //This creates the exit button
        exitButton = new JButton();
        exitButton.setPreferredSize(new Dimension(400,50));
        exitButton.setIcon(new ImageIcon(".//res/ExitAdventureButton.png"));
        exitButton.setForeground(Color.lightGray);
        exitButton.setFont(startButtonFont);
        exitButton.setBorder(noBorder);
        exitButton.setOpaque(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addActionListener((ActionEvent e) -> System.exit(0)); //This closes the application on button press.

        //This adds the menu buttons to the panel
        setLayout(new BorderLayout());
        titleScreenImageLabel.add(titleMenuButtonPanel);
        titleMenuButtonPanel.add(startButton);
        titleMenuButtonPanel.add(continueButton);
        titleMenuButtonPanel.add(exitButton);
    }
}