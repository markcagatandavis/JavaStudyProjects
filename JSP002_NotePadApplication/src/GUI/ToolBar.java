package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

//This class is responsible for the toolbar
public class ToolBar extends JPanel
{
    public ToolBar ()

    {

    }

    public JMenuBar createMenuBar ()
    {
        //Create Menu Bar here.
        JMenuBar menuBar = new JMenuBar();

        /////////////////Create File Menu///////////////////////////////
        JMenu fileMenu = new JMenu("File");

        JMenuItem newDataItem = new JMenuItem("New");
        JMenuItem openDataItem = new JMenuItem("Open");
        JMenuItem saveDataItem = new JMenuItem("Save");
        JMenuItem printDataItem = new JMenuItem("Print");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newDataItem);
        fileMenu.add(openDataItem);
        fileMenu.add(saveDataItem);
        fileMenu.addSeparator();
        fileMenu.add(printDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        /////////////////Create font Menu///////////////////////////////
        JMenu fontMenu = new JMenu("Font");


        ////////////////Create Settings Menu////////////////////////////
        JMenu settingsMenu = new JMenu("Settings");

        JMenuItem preferencesMenu = new JMenuItem("Preferences");

        settingsMenu.add(preferencesMenu);

        /////////////////Create Window Menu/////////////////////////////
        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");

        JMenuItem showFormItem = new JMenuItem("Tab Pane");

        windowMenu.add(showMenu);
        showMenu.add(showFormItem);

        /////////////////Adding Mnemonic's & Accelerator's////////////////////////////////
        ////File Menu////
        fileMenu.setMnemonic(KeyEvent.VK_F);
        newDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        openDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        saveDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        printDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        exitItem.addActionListener(e -> System.exit(0));

        ////Font Menu////
        fontMenu.setMnemonic(KeyEvent.VK_T);

        ////Settings Menu////
        settingsMenu.setMnemonic(KeyEvent.VK_S);
        preferencesMenu.setMnemonic(KeyEvent.VK_P);

        ////Windows Menu////
        windowMenu.setMnemonic(KeyEvent.VK_W);

        /////////////////Add Menu to JPanel/////////////////////////////
        menuBar.add(fileMenu);
        menuBar.add(fontMenu);
        menuBar.add(settingsMenu);
        menuBar.add(windowMenu);
        
        return menuBar;
    }
}
