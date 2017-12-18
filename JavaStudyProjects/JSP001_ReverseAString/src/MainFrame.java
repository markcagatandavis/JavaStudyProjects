import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame
{
    private PlayArea playArea;

    public MainFrame()
    {
        setSize(400,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);
        setLayout(new BorderLayout());
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        playArea = new PlayArea();
        add(playArea);
    }
}
