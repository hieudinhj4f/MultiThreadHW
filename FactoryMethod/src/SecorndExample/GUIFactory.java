package SecorndExample;

import SecorndExample.Button.Button;
import SecorndExample.CheckBox.CheckBox;

public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
