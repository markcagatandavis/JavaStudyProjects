package GUI;

import java.util.EventListener;

/**
 * Created by MarkCagatanDavis on 23/07/2017.
 */
//This is used for the TextInputListeners controller.
public interface TextInputListener extends EventListener
{
   void setInputListenerOccurred(InputTextFieldEvent event);
}
