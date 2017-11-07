import GUI.MainFrame;
import javax.swing.UIManager.*;
import javax.swing.*;

public class Notepad
{
    public static void main (String[] args)
    {

        ////////////////ADD JAVA LOOK & FEEL////////////////////////
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

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
