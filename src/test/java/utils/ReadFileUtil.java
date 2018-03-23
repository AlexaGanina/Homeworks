package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static directories.Directories.TEST_DATA_DIRECTORY;

public abstract class ReadFileUtil {

    /** Чтение данных из файла построчно
     * @return ArrayList<String>
     */
    public static ArrayList<String> reader(String file) {
        String line;
        ArrayList<String> mass = new ArrayList<String>();
        BufferedReader readFromFile = null;
        try {
            readFromFile = new BufferedReader(new FileReader(TEST_DATA_DIRECTORY + file));
            while ((line = readFromFile.readLine()) != null) {
                String newString = new String();
                newString = line;
                mass.add(newString);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (readFromFile != null)
                try {
                    readFromFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return mass;
    }
}
