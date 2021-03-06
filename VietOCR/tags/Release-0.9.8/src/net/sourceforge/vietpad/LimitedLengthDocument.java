package net.sourceforge.vietpad;

import java.awt.Toolkit;
import javax.swing.text.*;

/**
 *  Limited Length Document
 *
 *@author     Quan Nguyen
 *@version    1.0.5, 19 April 2003
 *@see        http://vietpad.sourceforge.net
 */
class LimitedLengthDocument extends PlainDocument {
    private int max;

    public LimitedLengthDocument(int max) {
        this.max = max;
    }

    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (getLength() + str.length() <= max) {
            super.insertString(offs, str, a);
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

}
