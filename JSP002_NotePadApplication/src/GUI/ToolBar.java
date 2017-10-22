package GUI;

import javax.swing.*;
import java.awt.*;

//This class is responsible for the toolbar
public class ToolBar extends JPanel
{
    private JButton fileButton;
    private JButton editButton;


    public ToolBar ()
    {
        //This section create's Button's
        fileButton = new JButton("File");
        editButton = new JButton("Edit");

        //Set's layout of the toolbar.
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.darkGray);

        //This section adds components to toolbar.
        add(fileButton);
        add(editButton);
    }
}
