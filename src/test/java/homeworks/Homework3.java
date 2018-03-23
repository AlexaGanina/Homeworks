package homeworks;

import org.junit.Test;
import usertypes.Person;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.SimpleFormatter;

import static utils.GenerateUtil.*;
import static utils.WriteFileUtil.*;


public class Homework3 {

    @Test
    public void createTestData(){
        int lines = generateInt(1, 30);
        ArrayList<Person> persons = new ArrayList<Person>();
        for (int i = 0; i < lines; i ++){
            String sex = generateSex();
            Calendar birth = generateDate();
            Calendar now = new GregorianCalendar();
            Integer age = generateAge(now,birth);
            if(sex.equals("Мужской"))
            persons.add(new Person(generateFirstNameMan(), generateSecondNameMan(), generateLastNameMan(), Integer.toString(age), sex, new SimpleDateFormat("dd-MM-yyyy").format(birth.getTime()), generateCity(), generateLocation()));
            else persons.add(new Person(generateFirstNameWoman(), generateSecondNameWoman(), generateLastNameWoman(), Integer.toString(age), sex, new SimpleDateFormat("dd-MM-yyyy").format(birth.getTime()), generateCity(), generateLocation()));
        }
        createExeleFile(persons);
    }
}
