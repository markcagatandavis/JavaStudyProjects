import GUI.MainFrame;

import javax.swing.*;

public class Notepad
{
    public static void main (String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new MainFrame();
            }
        });
    }
}
