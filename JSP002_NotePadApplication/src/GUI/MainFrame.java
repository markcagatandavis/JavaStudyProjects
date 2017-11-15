package GUI;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.PopupListener;
import com.inet.jortho.SpellChecker;
import com.inet.jortho.SpellCheckerOptions;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame
{
    private ToolBar toolBar;
    public static JTextArea textArea;
    public static JTabbedPane tabbedPane;
    private Font defaultFont = new Font("Times New Roman", Font.PLAIN, 16);

    public MainFrame()
    {
        /*
            *
            * This section creates the main JFrame and add's components to JFrame.
            *
        */

        //MainFrame Configurations.
        super("Notepad Express");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                int action = JOptionPane.showConfirmDialog(null,
                        "Confirmation: Close Application?",
                        "EXIT APPLICATION?", JOptionPane.OK_CANCEL_OPTION);

                if (action == JOptionPane.OK_OPTION)
                {
                    System.exit(0);
                }
            }
        });
        setResizable(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setMinimumSize(new Dimension(800,800));
        setLocationRelativeTo(null);

        //Add menu to main area.
        toolBar = new ToolBar();
        setJMenuBar(toolBar.createMenuBar());

        //Add Main Text Area to JFrame
        MainTextArea();

        //Initialize auto-dictionary
        dictionaryInitialization();
        spellCheckerOptions();

        //Set all above visible and packs.
        pack();
        setVisible(true);
    }

    public void MainTextArea()
    {
        /*
            * This section creates the main Text Area component.
        */
        textArea = new JTextArea();
        textArea.setFont(defaultFont);
        textArea.setBackground(Color.white);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setVisible(true);

        //Add scroll pane
        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Border scrollBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        scroll.setBorder(BorderFactory.createCompoundBorder(scrollBorder, BorderFactory.createEmptyBorder(1,1,1,1)));
        scroll.setVisible(true);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("New Document", scroll);

        add(tabbedPane);
    }

    ////Dictionary Menu////
    private void dictionaryInitialization ()
    {
        //FILE LOCATION OF DICTIONARY
        String userDictionaryPath = "src\\model\\dictionary\\";
        //SET DICTIONARY PROVIDER FROM DICTIONARY PATH
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary(userDictionaryPath));
        //REGISTER DICTIONARY
        SpellChecker.registerDictionaries(getClass().getResource(userDictionaryPath), "en");
        //REGISTER JTEXTAREA TO SPELLCHECKER.
        SpellChecker.register(textArea);
    }

    private void spellCheckerOptions()
    {
        SpellCheckerOptions spellCheckerOptions = new SpellCheckerOptions();
        spellCheckerOptions.setCaseSensitive(false);
        spellCheckerOptions.setSuggestionsLimitMenu(10);
        spellCheckerOptions.setLanguageDisableVisible(false);
        spellCheckerOptions.setIgnoreAllCapsWords(true);
        spellCheckerOptions.setIgnoreWordsWithNumbers(true);
        JPopupMenu popupMenu = SpellChecker.createCheckerPopup(spellCheckerOptions);

        textArea.addMouseListener(new PopupListener(popupMenu));
    }
}
