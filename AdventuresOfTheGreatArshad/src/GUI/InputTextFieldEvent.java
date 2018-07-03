package GUI;

import java.util.EventObject;

/**
 * Created by Sir.Dominar on 23/07/2017.
 */

//This is the InputTextFieldEvent controller used to store user text from PlayerInputScreen to IngameFrame.
public class InputTextFieldEvent extends EventObject
{
    private String text;

    public InputTextFieldEvent(Object source, String text){
        super(source);

        this.text = text;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
}
