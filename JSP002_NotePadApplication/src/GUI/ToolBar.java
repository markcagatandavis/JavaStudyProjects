package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

import static GUI.MainFrame.textArea;

//This class is responsible for the toolbar
public class ToolBar  extends JMenuBar
{
    private MainFrame mainFrame;

    private JFileChooser fileChooser;


    public JMenuBar createMenuBar ()
    {

        JMenuBar menuBar = new JMenuBar(); //Create menu bar Instances
        fileChooser = new JFileChooser(); //Create generic fileChooser


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

        //New File
        newDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newDataItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
            }
        });

        //Open File
        openDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openDataItem.addActionListener((ActionEvent e) -> {

            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION);
            System.out.println(fileChooser.getSelectedFile());

            try
            {
                File file = fileChooser.getSelectedFile();
                String filename = file.getAbsolutePath();
                FileReader fileReader = new FileReader(filename);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                textArea.read(bufferedReader,null);
                bufferedReader.close();
                textArea.requestFocus();
            }
            catch(Exception ev)
            {
                JOptionPane.showMessageDialog(null,ev);
            }
        });

        //Save File
        saveDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveDataItem.addActionListener(e -> {
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION);
            System.out.println(fileChooser.getSelectedFile());

            try
            {
                FileWriter fileWriter = new FileWriter(fileChooser.getSelectedFile() + ".txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                textArea.write(bufferedWriter);
                bufferedWriter.close();
                textArea.setText("");
                textArea.requestFocus();
            }
            catch(Exception ev)
            {
                JOptionPane.showMessageDialog(null,ev);
            }
        });

        //Print File
        printDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

        //Exit Application
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        exitItem.addActionListener((ActionEvent e) -> {
            int action = JOptionPane.showConfirmDialog(null,
                    "Confirmation: Close Application?",
                    "EXIT APPLICATION?", JOptionPane.OK_CANCEL_OPTION);

            if (action == JOptionPane.OK_OPTION)
            {
                System.exit(0);
            }
        });

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
