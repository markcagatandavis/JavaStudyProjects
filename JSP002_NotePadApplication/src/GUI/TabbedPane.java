package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.PopupListener;
import com.inet.jortho.SpellChecker;
import com.inet.jortho.SpellCheckerOptions;

public class TabbedPane extends JPanel
{
    public static JTextArea textArea;
    private JTabbedPane tabbedPane;
    private JScrollPane scroll;
    private Font defaultFont = new Font("Times New Roman", Font.PLAIN, 16);

    public TabbedPane ()
    {
        //Set layout so TabbedPane auto sizes to JFrame size
        setLayout(new BorderLayout());

        //Initialise JTextArea Prior to JTabbedPanel to Initialise JScrollPane.
        textArea();

        //Initialize JTabbedPane and pass through JScrollPane from text area method.
        setTabbedPane(scroll);

        //Initialize auto-dictionary
        dictionaryInitialization();
        spellCheckerOptions();
    }

    public void textArea()
    {
        /*
        * Create JTextArea
        *
         */
        textArea = new JTextArea();
        textArea.setFont(defaultFont);
        textArea.setBackground(Color.white);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setVisible(true);

        //Add scroll pane
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Border scrollBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        scroll.setBorder(BorderFactory.createCompoundBorder(scrollBorder, BorderFactory.createEmptyBorder(1,1,1,1)));
        scroll.setVisible(true);
    }

    public void setTabbedPane(JScrollPane tempScrollPane)
    {
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("New Document", tempScrollPane);
        add(tabbedPane, BorderLayout.CENTER);
    }

    public void newTab (JScrollPane tempScrollPane)
    {
        tabbedPane.addTab("New Document", tempScrollPane);
        add(tabbedPane, BorderLayout.CENTER);
    }


    //Dictionary Menu////
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
