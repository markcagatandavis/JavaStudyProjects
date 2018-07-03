package Model;

import GUI.PlayerInputScreen;

public class NarratorReaders
{
    private PlayerInputScreen playerInputScreen;
    private String theGreatNarrator;
    private String userChoiceSelection;
    private String oldMan;
    private boolean gotInput;
    private int counter = 1;

    public NarratorReaders(PlayerInputScreen getPlayerInputScreen)
    {
        this.playerInputScreen = getPlayerInputScreen;
    }

    //This is used for player selection
    public void userSelection(String options, String text)
    {
        userChoiceSelection = "["+options+"]: "+text;
        playerInputScreen.getAppendMainTextArea(userChoiceSelection);
    }

    //This "pauses" the JTextArea pending enter press to append next line.
    public void pendingEnterPress()
    {
        while (counter > 0 && gotInput == false)
        {
            System.out.println("DEBUG: This is testing pendingEnterPress");
            System.out.println("Counter is " + counter);
            counter++;

            try
            {
                Thread.sleep(400);
                playerInputScreen.getEnterButton().addActionListener(e ->
                {
                    System.out.println("DEBUG: This is reaching inside ActionListener");
                    gotInput = true;
                    System.out.println("DEBUG: Input Received, exiting while loop.");
                    return;
                });
            }
            catch (InterruptedException el)
            {
                el.printStackTrace();
            }
        }
        counter = 1; //Resets counter for when loop is called again.
    }

    //This displays text without Press enter
    public void theGreatNarratorReader (String text)
    {
        theGreatNarrator = "[" + ChapterOne.playerName + "]\n" + text + "\n";
        playerInputScreen.getAppendMainTextArea(theGreatNarrator);
    }

    //This appends displays text and pends enter input before continuing.
    public void theGreatNarratorReaderAppendCont(String text)
    {
            theGreatNarrator = "[" + ChapterOne.playerName + "]\n" + text + "\n[PRESS ENTER]";
            playerInputScreen.getAppendMainTextArea(theGreatNarrator);
            gotInput = false;
            playerInputScreen.getAppendMainTextArea("");
            pendingEnterPress();
    }

    //This set displays text and pends enter input before continuing.
    public void theGreatNarratorReaderSetCont(String text)
    {
        theGreatNarrator = "[" + ChapterOne.playerName + "]\n" + text + "\n[PRESS ENTER]";
        playerInputScreen.getSetMainTextArea(theGreatNarrator);
        gotInput = false;
        playerInputScreen.getSetMainTextArea("");
        pendingEnterPress();
    }

    //This displays text for Old man without press enter
    public void oldManReader(String text)
    {
        oldMan = "["+ ChapterOne.oldManName +"]\n"+ text + "\n";
        playerInputScreen.getAppendMainTextArea(oldMan);
    }

    //This appends display text for Old man and pends enter input before continuing.
    public void oldManReaderAppendCont(String text)
    {
        oldMan = "["+ ChapterOne.oldManName +"]\n"+ text;
        playerInputScreen.getAppendMainTextArea(oldMan);
        gotInput = false;
        playerInputScreen.getAppendMainTextArea("");
        pendingEnterPress();
    }

    //This set display text for Old man and pends enter input before continuing.
    public void oldManReaderSetCont(String text)
    {
        oldMan = "["+ ChapterOne.oldManName +"]\n"+ text;
        playerInputScreen.getAppendMainTextArea(oldMan);
        gotInput = false;
        playerInputScreen.getAppendMainTextArea("");
        pendingEnterPress();
    }

    //This appends display text for Old man and pends enter input before continuing.
    public void mainCharacterAppendCont(String text)
    {

    }

}
