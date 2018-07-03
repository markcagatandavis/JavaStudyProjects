package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Sir.Dominar on 22/07/2017.
 */
public class StoryImageScreen extends JPanel
{
    private JPanel storyDisplayPanel;
    private JLabel storyDisplayImageLabel;
    private ImageIcon storyDisplayAreaImage;

    public StoryImageScreen()
    {
        //This is where the story images will display.
        storyDisplayPanel = new JPanel();
        storyDisplayPanel.setBounds(480, 0, 800, 510);
        storyDisplayPanel.setBackground(Color.LIGHT_GRAY);
        storyDisplayPanel.setLayout(new GridBagLayout());
        add(storyDisplayPanel);

        storyDisplayImageLabel = new JLabel();
        storyDisplayAreaImage = new ImageIcon(".//res//Map Creation.png");
        storyDisplayImageLabel.setIcon(storyDisplayAreaImage);
        storyDisplayPanel.add(storyDisplayImageLabel);
    }
}
