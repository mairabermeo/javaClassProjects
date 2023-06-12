
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * The FileMenuHandler class implements the ActionListener interface and serves as a listener 
 * for the file menu of the Roman Numeral GUI application. It provides methods for reading a file 
 * containing a list of Roman numerals and returning the parsed numerals as a String array.
 */
public class FileMenuHandler implements ActionListener {

    private String[] romanNumerals;
    private RomanNumeralGUI romanNumeralGUI;

    /**
     * Constructs a FileMenuHandler object with the specified RomanNumeralGUI instance.
     *
     * @param romanNumeralGUI the RomanNumeralGUI instance
     */
    public FileMenuHandler(RomanNumeralGUI romanNumeralGUI) {
        this.romanNumeralGUI = romanNumeralGUI;
    }

    /**
     * Reads a file containing a list of Roman numerals and stores the numerals as an array of Strings.
     *
     * @param file the file containing the Roman numerals
     */
    public void readFile(File file) {
    	// create a list to store the roman numerals that are read 
        List<String> romanList = new ArrayList<>();
        TextFileInput in = new TextFileInput(file.getAbsolutePath());
        String line = in.readLine();
        while (line != null) {
            String[] romanArray = line.split(",");
            for (String numeral : romanArray) {
                romanList.add(numeral.trim());
            }
            line = in.readLine();
        }
        // make the list into an array 
        romanNumerals = romanList.toArray(new String[0]);
    }

    /**
     * Returns the array of Roman numerals read from the file.
     *
     * @return the array of Roman numerals
     */
    public String[] getRomanNumerals() {
        return romanNumerals;
    }

    /**
     * Opens a file chooser dialog and prompts the user to select a file to open.
     * If the user selects a file, the readFile method is called to read and parse the file.
     */
    void openFile() {
        JFileChooser chooser = new JFileChooser();
        int returnFile = chooser.showOpenDialog(null);
        if (returnFile == JFileChooser.APPROVE_OPTION) {
            File romanFile = chooser.getSelectedFile();
            readFile(romanFile);
        }
    }

    /**
     * Performs an action in response to an ActionEvent.
     * If the action command is "Open", calls the openFile method to open a file.
     * If the action command is "Quit", terminates the application.
     *
     * @param event the ActionEvent object
     */
    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        if (menuName.equals("Open")) {
            openFile();
        } else if (menuName.equals("Quit")) {
            System.exit(0);
        }
    }
}








