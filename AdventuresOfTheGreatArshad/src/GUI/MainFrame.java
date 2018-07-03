package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by MarkCagatanDavis on 18/07/2017.
 */
public class MainFrame extends JFrame
{
    private TitleScreen titleScreen;
    private IngameFrame ingameFrame;

    public MainFrame()
    {
        super("The Adventure's of the Great Arshad!"); //This is super for title name on title bar

        //This is setting a naked mainFrame size of the game
        setSize(1286, 749);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        titleScreen = new TitleScreen();
        add(titleScreen);

        TitleScreen.startButton.addActionListener(e -> {
            try
            {
                ingameFrame = new IngameFrame();
            } catch (InterruptedException e1)
            {
                e1.printStackTrace();
            }
            add(ingameFrame);
            ingameFrame.setVisible(true);
            titleScreen.setVisible(false);
        });
    }
}