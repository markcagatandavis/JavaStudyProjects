package GUI;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.PopupListener;
import com.inet.jortho.SpellChecker;
import com.inet.jortho.SpellCheckerOptions;

import javax.swing.*;
import java.awt.*;

public class MainTextArea extends JScrollPane {

    public static JTextArea textArea;

    public MainTextArea()
    {
        createTextArea();
    }

    private JTextArea createTextArea()
    {
        /*
         * Create main notepad text area.
         * Initializes Dictionary and spell checker.
         */
        Font defaultFont = new Font("Times New Roman", Font.PLAIN, 16);

        textArea = new JTextArea();
        textArea.setFont(defaultFont);
        textArea.setBackground(Color.white);
        textArea.setEditable(true);
        textArea.setLineWrap(true);
        textArea.setVisible(true);

        dictionaryInitialization();
        spellCheckerOptions();

        return textArea;
    }

    public static JTextArea getTextArea() {
        return textArea;
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