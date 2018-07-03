package Model;


import GUI.PlayerInputScreen;

import javax.swing.*;

import static GUI.ThreadColor.ANSI_YELLOW;
import static Model.LocationMonitor.Introduction;
import static Model.LocationMonitor.mapLocation;

public class ChapterOne extends NarratorReaders implements Runnable
{
    LocationMonitor locationMonitor;
    public static int playerChoice;
    private PlayerInputScreen playerInputScreen;
    public static String playerName;
    public static String oldManName;


    public ChapterOne(PlayerInputScreen getPlayerInputScreen)
    {
        super(getPlayerInputScreen);
        this.playerInputScreen = getPlayerInputScreen;
    }

    //This is used to set the function of enter button and key.
    // 0 = Append no action, 1 = Append only string answers, 2 = Append only int answers, 3 = Append all
    private void setButtonState (int buttonOption)
    {
        playerInputScreen.setButtonState(buttonOption);
    }

    @Override
    public void run()
    {
        System.out.println(ANSI_YELLOW + "DEBUG Second Thread: Chapter One Activated.");

        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>()
        {

            @Override
            protected Boolean doInBackground() throws Exception
            {
                for (int i = 0; i < 1; i++)
                {
                    Thread.sleep(10);

                    System.out.println("DEBUG: Sleep Completed.");

                    mapLocation = Introduction;

                    playerName = "The Great Arshad";
                    oldManName = "Old Man";

                    setButtonState(0);

                    theGreatNarratorReaderAppendCont("The night was young in its deep dark depths of the midnight sky." +
                                                    "\nWarmth filled the air from a lit camp fire that sizzled and cracked to the burning oak. ");

                    oldManReaderAppendCont("Why hello there, you are finally awake! You have been out for days, I'd never thought you'd awaken.");

                    oldManReaderAppendCont("I found this diary on you, it says your name is " + playerName + ", is that correct?");
                    userSelection("PRESS 1 & ENTER","Yes.");
                    userSelection("PRESS 2 & ENTER","No.");
                    userSelection("PRESS 3 & ENTER","Who do you think you are going through my things!!");
                }
                return  true;
            }
        };
        worker.execute();
    }
}