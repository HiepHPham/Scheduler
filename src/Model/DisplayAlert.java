package Model;

import javax.swing.*;

/**
 * DisplayAlert methods for quick Alert boxes
 */
public class DisplayAlert {
    /**
     *
     * @param message message to be outputted as an error
     */
    public static void ErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     *
     * @param message message to be outputted as an error
     */
    public static void InfoMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }

}
