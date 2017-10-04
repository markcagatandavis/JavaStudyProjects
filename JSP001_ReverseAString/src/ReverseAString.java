import javax.swing.*;

public class ReverseAString
{
    public static void main(String[]args)
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
