package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sir.Dominar on 22/07/2017.
 */
public class PlayerInputScreen extends JPanel
{
    public static String getAppendedStoryLineText; //This is used to pull pending story from chapters.
    private MainTextScreen mainTextScreen;
    private int buttonState; //This is used to switch what the Enter Button & key does when pressed
    private TextInputListener textInputListener;
    private JPanel playerInputPanel, playerInputImagePanel;
    private JLabel playerInputPanelImageLabel; //Used for Image
    public static JTextField inputTextField; //Used for main input text field
    private JButton enterButton; //Used for enterButton
    private ImageIcon playerInputAreaImage;
    private Font mainTextFont = new Font("Times New Roman", Font.PLAIN, 18);
    private Border noBorder = BorderFactory.createEmptyBorder();

    public PlayerInputScreen(MainTextScreen setMainTextScreen)
    {
        this.mainTextScreen = setMainTextScreen;

        //This is the panel where user input is displayed to decide on directions.
        playerInputPanel = new JPanel();
        playerInputPanel.setBounds(0, 450, 480, 210);
        playerInputPanel.setBackground(Color.DARK_GRAY);
        playerInputPanel.setLayout(new GridBagLayout());
        add(playerInputPanel);

        //This is creating a JPanel for the Image to sit on.
        playerInputImagePanel = new JPanel();
        playerInputImagePanel.setBounds(0, 480, 480, 210);
        playerInputImagePanel.setLayout(new GridBagLayout());
        playerInputPanel.add(playerInputImagePanel);

        //This is adding a background image to the PlayerInput Field.
        playerInputPanelImageLabel = new JLabel();
        playerInputAreaImage = new ImageIcon(".//res//playerInputPanel.png");
        playerInputPanelImageLabel.setIcon(playerInputAreaImage);
        playerInputPanelImageLabel.setLayout(new GridBagLayout());
        playerInputImagePanel.add(playerInputPanelImageLabel);

        //This is creating the JTextFields for player input.
        inputTextField = new JTextField();
        inputTextField.setFont(mainTextFont);
        inputTextField.setHorizontalAlignment(SwingConstants.CENTER);
        inputTextField.setPreferredSize(new Dimension(240,80));
        inputTextField.setOpaque(false);
        inputTextField.setBorder(noBorder);
        inputTextField.addActionListener(new ActionListener()
        {   //This is used so the user can press enter on the keyboard to submit text to the text area.

            public void actionPerformed(ActionEvent e)
            {
                String text = inputTextField.getText();
                InputTextFieldEvent event = new InputTextFieldEvent(this, text);

                if (buttonState == 0) //This is used to append next line with no action
                {
                    if (inputTextField.getText().trim().isEmpty())
                    {
                        getAppendMainTextArea(getAppendedStoryLineText);
                    }
                    else
                    {
                        inputTextField.setText(null);
                    }
                }
                if (buttonState == 1) //Only accepts string for answer
                {
                    if (inputTextField.getText().matches("[a-zA-Z]+"))
                    {
                        textInputListener.setInputListenerOccurred(event);
                        getAppendMainTextArea(getAppendedStoryLineText);
                    }
                    else
                    {
                        getAppendMainTextArea("You have entered an invalid input, only letters are allowed.");
                    }
                }
                if (buttonState == 2) //Only accepts int for answer
                {
                    if (inputTextField.getText().matches("[0-9]+"))
                    {
                        textInputListener.setInputListenerOccurred(event);
                    }
                    else
                    {
                        getAppendMainTextArea("You have entered an invalid input, only numbers are allowed.");
                    }
                }
                if (buttonState == 3) //Displays all text in JTextField to JTextArea, mostly for testing purposes.
                {
                    if (textInputListener != null)
                    {
                        textInputListener.setInputListenerOccurred(event);
                    }
                }
                if (buttonState == 4) //Displays all text in JTextField to JTextArea, mostly for testing purposes.
                {
                    if (textInputListener != null)
                    {
                        textInputListener.setInputListenerOccurred(event);
                    }
                }
                inputTextField.setText(null); //This empties inputTextField once answer is submitted.
            }
        });
        playerInputPanelImageLabel.add(inputTextField);

        //This is creating the Enter button to submit user input from text field to text area.
        enterButton = new JButton("ENTER");
        enterButton.setPreferredSize(new Dimension(125,125));
        enterButton.setBorder(noBorder);
        enterButton.setOpaque(false);
        enterButton.setContentAreaFilled(false);
        playerInputPanelImageLabel.add(enterButton);
        enterButton.addActionListener(new ActionListener()
        {   //This is used so when the enter screen button is pressed, it will submit text from text field to text area.

            public void actionPerformed(ActionEvent e)
            {
                String text = inputTextField.getText();
                InputTextFieldEvent event = new InputTextFieldEvent(this, text);

                if (buttonState == 0) //This is used to append next line with no action
                {
                    if (inputTextField.getText().trim().isEmpty())
                    {
                        getAppendMainTextArea(getAppendedStoryLineText);
                    }
                    else
                    {
                        inputTextField.setText(null);
                    }
                }
                if (buttonState == 1) //Only accepts string for answer
                {
                    if (inputTextField.getText().matches("[a-zA-Z]+"))
                    {
                        textInputListener.setInputListenerOccurred(event);
                    }
                    else
                    {
                        getAppendMainTextArea("You have entered an invalid input, only letters are allowed.");
                    }
                }
                if (buttonState == 2) //Only accepts int for answer
                {
                    if (inputTextField.getText().matches("[0-9]+"))
                    {
                        textInputListener.setInputListenerOccurred(event);
                    }
                    else
                    {
                        getAppendMainTextArea("You have entered an invalid input, only numbers are allowed.");
                    }
                }
                if (buttonState == 4) //Displays all text in JTextField to JTextArea, mostly for testing purposes.
                {
                    if (textInputListener != null)
                    {
                        textInputListener.setInputListenerOccurred(event);
                    }
                }
                inputTextField.setText(null); //This empties inputTextField once answer is submitted.
            }
        });
        playerInputPanelImageLabel.add(enterButton);
    }

    //This is used to get the text from the TextInputListeners controller.
    public void setTextInputListener(TextInputListener listener)
    {
        this.textInputListener = listener;
    }

    //This is used to append text not in JTextField to JTextArea (for story mode)
    public void getAppendMainTextArea(String text)
    {
        mainTextScreen.appendMainTextArea(text);
        getAppendedStoryLineText = text;
    }

    //This is used to set text to JTextArea
    public void getSetMainTextArea (String text)
    {
        mainTextScreen.setMainTextArea(text);
        getAppendedStoryLineText = text;
    }

    //This is a object used to set the Button state of what enter does.
    public void setButtonState (int newButtonState)
    {
        buttonState = newButtonState;
    }

    public JButton getEnterButton()
    {
        return enterButton;
    }
}
