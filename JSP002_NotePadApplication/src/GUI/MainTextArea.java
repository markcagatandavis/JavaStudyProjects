package GUI;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.PopupListener;
import com.inet.jortho.SpellChecker;
import com.inet.jortho.SpellCheckerOptions;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainTextArea extends JScrollPane {

    public static JTextArea textArea;
    private JScrollPane scroll;
    private Font defaultFont = new Font("Times New Roman", Font.PLAIN, 16);

    public MainTextArea()
    {
        /*
        * Create main notepad text area.
        * Initializes Dictionary and spell checker.
         */
        textArea = new JTextArea();
        textArea.setFont(defaultFont);
        textArea.setBackground(Color.white);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setVisible(true);

        dictionaryInitialization();
        spellCheckerOptions();
    }

    public JScrollPane setScroll()
    {
        /*
        * Adding scroll pane into it's own method so it can be called in other classes
         */
        //Add scroll pane
        scroll = new JScrollPane(textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Border scrollBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        scroll.setBorder(BorderFactory.createCompoundBorder(scrollBorder, BorderFactory.createEmptyBorder(1,1,1,1)));
        scroll.setVisible(true);

        return scroll;
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
