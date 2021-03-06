package GUI;

import com.ozten.font.JFontChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;

//This class is responsible for the toolbar
public class ToolBar
{
    JFileChooser fileChooser;
    MainTextArea mainTextArea = new MainTextArea();

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
        JMenu formatmenu = new JMenu("Format");

        JMenuItem fontMenuItem = new JMenuItem("Font");

        formatmenu.add(fontMenuItem);

        ////////////////Create Settings Menu////////////////////////////
        JMenu settingsMenu = new JMenu("Settings");

        JMenuItem preferencesMenu = new JMenuItem("Preferences");

        settingsMenu.add(preferencesMenu);

        /////////////////Create Window Menu/////////////////////////////
        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");

        JMenuItem showTabItem = new JMenuItem("Tab Pane");

        windowMenu.add(showMenu);
        showMenu.add(showTabItem);

        /////////////////Adding Mnemonic's & Accelerator's////////////////////////////////

        ////File Menu////
        formatmenu.setMnemonic(KeyEvent.VK_O);
        fileMenu.setMnemonic(KeyEvent.VK_F);

        //New File
        newDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        newDataItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                TabbedPane tabbedPane = new TabbedPane();
                tabbedPane.addTabbedPane();
                System.out.println("Reaching end of method");
            }
        });


        //Open File
        openDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openDataItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) ;
                System.out.println(fileChooser.getSelectedFile());

                try {
                    File file = fileChooser.getSelectedFile();
                    String filename = file.getAbsolutePath();
                    FileReader fileReader = new FileReader(filename);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    mainTextArea.getTextArea().read(bufferedReader, null);
                    bufferedReader.close();
                    mainTextArea.getTextArea().requestFocus();
                } catch (Exception ev) {
                    System.out.println("DBUG: Open File either cancelled or error on open.");
                }
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
                mainTextArea.getTextArea().write(bufferedWriter);
                bufferedWriter.close();
                mainTextArea.getTextArea().setText("");
                mainTextArea.getTextArea().requestFocus();
            }
            catch(Exception ev)
            {
                System.out.println("DBUG: Save file either cancelled or error on save.");
            }
        });

        //Print File
        printDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        printDataItem.addActionListener(e -> {

            PrinterJob printJob = PrinterJob.getPrinterJob();
            printJob.setJobName(" Print Component ");

            printJob.setPrintable ((pg, pf, pageNum) -> {
                if (pageNum > 0) return Printable.NO_SUCH_PAGE;

                Graphics2D g2 = (Graphics2D) pg;
                g2.translate(pf.getImageableX(), pf.getImageableY());
                mainTextArea.getTextArea().paint(g2);
                return Printable.PAGE_EXISTS;
            });

            if (printJob.printDialog() == false) return;

            try
            {
                printJob.print();
            }
            catch (PrinterException ex)
            {
                // handle exception
            }
        });

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
        fontMenuItem.setMnemonic(KeyEvent.VK_T);
        fontMenuItem.addActionListener(e -> {

            JFontChooser fontChooser = new JFontChooser();
            JOptionPane.showMessageDialog(null, fontChooser, "Font Options", JOptionPane.PLAIN_MESSAGE);
            mainTextArea.getTextArea().setFont(fontChooser.getPreviewFont());
        });

        ////Settings Menu////
        settingsMenu.setMnemonic(KeyEvent.VK_S);
        preferencesMenu.setMnemonic(KeyEvent.VK_P);

        ////Windows Menu////
        windowMenu.setMnemonic(KeyEvent.VK_W);

        showTabItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

            }
        });

        /////////////////Add Menu to JPanel/////////////////////////////
        menuBar.add(fileMenu);
        menuBar.add(formatmenu);
        menuBar.add(settingsMenu);
        menuBar.add(windowMenu);

        return menuBar;
    }
}