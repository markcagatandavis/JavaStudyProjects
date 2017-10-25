package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

//This class is responsible for the toolbar
public class ToolBar extends JPanel
{
    private JButton fileButton;
    private JButton editButton;
    private JButton fontButton;
    private JButton toolsButton;

    public ToolBar ()
    {
        //Set's border around toolbar.
        setBorder(BorderFactory.createEtchedBorder());

        //This section create's Button's
        fileButton = new JButton("File");
        editButton = new JButton("Edit");
        fontButton = new JButton("Font");
        toolsButton = new JButton("Tools");

        //Set's layout of the toolbar.
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.LIGHT_GRAY);

        //This section adds components to toolbar.
        add(fileButton);
        add(editButton);
        add(fontButton);
        add(toolsButton);

    }
}
