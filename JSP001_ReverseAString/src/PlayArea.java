import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlayArea extends JPanel
{
    private JPanel outputJPanel, inputJPanel;
    private JTextField playerInput;
    private Font mainFont = new Font("Times New Roman", Font.PLAIN, 18);
    private JButton enterButton;

    public PlayArea()
    {
        //This is to create default layout for JArea.
        setLayout(null);

        //This is used to display output on screen.
        outputJPanel = new JPanel();
        outputJPanel.setBounds(0,0,400,200);
        outputJPanel.setBackground(Color.LIGHT_GRAY);
        outputJPanel.setLayout(new GridBagLayout());
        add(outputJPanel);

        //This is used for JButton and JTextField.
        inputJPanel = new JPanel();
        inputJPanel.setBounds(0,200,400,200);
        inputJPanel.setBackground(Color.DARK_GRAY);
        inputJPanel.setLayout(new GridBagLayout());
        add(inputJPanel);

        playerInput = new JTextField();
        playerInput.setFont(mainFont);
        playerInput.setHorizontalAlignment(SwingConstants.CENTER);
        playerInput.setPreferredSize(new Dimension(150,100));
        playerInput.setBackground(Color.WHITE);
        inputJPanel.add(playerInput);

        enterButton = new JButton("Reverse!");
        enterButton.setFont(mainFont);
        enterButton.setHorizontalAlignment(SwingConstants.CENTER);
        enterButton.setPreferredSize(new Dimension(100,100));
        inputJPanel.add(enterButton);

        playerInput.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //Need to add code here.
            }
        });
    }
}
