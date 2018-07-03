package GUI;

import Model.ChapterOne;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MarkCagatanDavis on 20/07/2017.
 */
public class IngameFrame extends JPanel
{
    private MainTextScreen mainTextScreen;
    private PlayerInputScreen playerInputScreen;
    private PlayerStatsScreen playerStatsScreen;
    private StoryImageScreen storyImageScreen;

    //This is the main Ingame "Control Center" all panels call here which are
    //Displayed onto the MainFrame.
    public IngameFrame() throws InterruptedException
    {
        //This is setting default background settings.
        setLayout(null);
        setBackground(Color.black);

        //This is adding the Main Text screen class to the Ingame frame.
        mainTextScreen = new MainTextScreen();
        mainTextScreen.setBounds(0, 0, 480, 510);
        mainTextScreen.setLayout(null);
        mainTextScreen.setBackground(Color.gray);
        add(mainTextScreen);

        //This is adding the player input panel to the screen.
        playerInputScreen = new PlayerInputScreen(mainTextScreen);
        playerInputScreen.setBounds(0, 510, 480, 210);
        playerInputScreen.setLayout(new GridBagLayout());
        add(playerInputScreen);
        //This is calling the players input from TextInputListeners buffer to the screen.
        playerInputScreen.setTextInputListener((InputTextFieldEvent event) -> {
            String text = event.getText();
            mainTextScreen.appendMainTextArea(text);
        });

        //This is calling the StoryImageScreen Class and adding to the main in game frame.
        storyImageScreen = new StoryImageScreen();
        storyImageScreen.setBounds(480, 0, 800, 510);
        storyImageScreen.setLayout(new GridBagLayout());
        add(storyImageScreen);

        //This is calling the PlayerStatsFrame class and applying to the main in game Frame.
        playerStatsScreen = new PlayerStatsScreen();
        playerStatsScreen.setBounds(480, 510, 800, 210);
        playerStatsScreen.setLayout(new GridBagLayout());
        add(playerStatsScreen);

        Thread ChapterOne = new Thread(new ChapterOne(playerInputScreen));
        ChapterOne.start();
    }
}