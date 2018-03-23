package utils;

import java.util.*;

import static utils.ReadFileUtil.reader;

public abstract class GenerateUtil {

    /** Генератор цифр от 0 до 9
     * @return String
     */
    public static String generateNumber() {
        return Integer.toString((int)(Math.random()*10));
    }

    /** Генератор числа в промежутке
     * @param from от
     * @param to до
     * @return String
     */
    public static String generateNumber(int from, int to ) {
        return Integer.toString((int)(Math.random()*(to-from))+from);
    }

    /** Генератор числа в промежутке
     * @param from от
     * @param to до
     * @return int
     */
    public static int generateInt(int from, int to ) {
        return (int)(Math.random()*(to-from))+from;
    }

    /** Генератор последовательности цифр
     * @param lenght длина
     * @return String
     */
    public static String generateNumber(int lenght ) {
        String number = "";
        for (int i = 0; i < lenght; i++)
            number = number + generateNumber();
        return number;
    }

    /** Генератор женского имени
     * @return String
     */
    public static String generateFirstNameWoman() {
        ArrayList<String> firstNames = reader("WomanFirstName.txt");
        return firstNames.get((int)(Math.random()*firstNames.size()));
    }

    /** Генератор женской фамилии
     * @return String
     */
    public static String generateSecondNameWoman(){
        ArrayList<String> secondNames = reader("SecondName.txt");
        return secondNames.get((int)(Math.random()*secondNames.size()))+"а";
    }

    /** Генератор женского отчества
     * @return String
     */
    public static String generateLastNameWoman(){
        ArrayList<String> lastNames = reader("LastName.txt");
        return lastNames.get((int)(Math.random()*lastNames.size()))+"на";
    }

    /** Генератор мужского имени
     * @return String
     */
    public static String generateFirstNameMan(){
        ArrayList<String> firstNames = reader("ManFirstName.txt");
        return firstNames.get((int)(Math.random()*firstNames.size()));
    }

    /** Генератор мужской фамилии
     * @return String
     */
    public static String generateSecondNameMan(){
        ArrayList<String> secondNames = reader("SecondName.txt");
        return secondNames.get((int)(Math.random()*secondNames.size()));
    }

    /** Генератор мужского отчества
     * @return String
     */
    public static String generateLastNameMan(){
        ArrayList<String> lastNames = reader("LastName.txt");
        return lastNames.get((int)(Math.random()*lastNames.size()))+"ич";
    }

    /** Генератор города
     * @return String
     */
    public static String generateCity(){
        ArrayList<String> cities = reader("City.txt");
        return cities.get((int)(Math.random()*cities.size()));
    }

    /** Генератор области
     * @return String
     */
    public static String generateRegion(){
        ArrayList<String> regions = reader("Region.txt");
        return regions.get((int)(Math.random()*regions.size()));
    }

    /** Генератор улицы
     * @return String
     */
    public static String generateStreet(){
        ArrayList<String> streets = reader("Street.txt");
        return streets.get((int)(Math.random()*streets.size()));
    }

    /** Генератор места жительства в формате:
     * почтовый индекс (6-ти значный), страна, область, город, улица, дом, квартира
     * @return String
     */
    public static String generateLocation() {
        ArrayList<String> cities = reader("City.txt");
        ArrayList<String> streets = reader("Street.txt");

        String index = generateNumber(6);
        String country = "Россия";
        String region = generateRegion();
        String city = generateCity();
        String street = generateStreet();
        String house = generateNumber(1,50);
        String flat = generateNumber(1,200);
        return index + ", " + country + ", " + region + ", " + city + ", " + street + ", " + house + ", " + flat;

    }

    /** Генератор пола
     * @return String
     */
    public static String generateSex(){
        Random rand = new Random();
        if(rand.nextBoolean()==true)
            return "Женский";
        else
            return "Мужской";
    }

    /** Генератор даты
     * @return Date
     */
    public static Calendar generateDate() {
        Calendar date = new GregorianCalendar();
        int year = generateInt(1999, 1949);
        date.set(date.YEAR, year);
        int dayOfYear = generateInt(1, date.getActualMaximum(date.DAY_OF_YEAR));
        date.set(date.DAY_OF_YEAR, dayOfYear);
        return date;
    }

    /** Генератор возроста
     * @return Date
     */
    public static int generateAge(Calendar now, Calendar birth){
        int year1 = now.get(Calendar.YEAR);
        int year2 = birth.get(Calendar.YEAR);
        int age = year1 - year2;
        int month1 = now.get(Calendar.MONTH);
        int month2 = birth.get(Calendar.MONTH);
        if (month2 > month1) {
            age--;
        } else if (month1 == month2) {
            int day1 = now.get(Calendar.DAY_OF_MONTH);
            int day2 = birth.get(Calendar.DAY_OF_MONTH);
            if (day2 > day1) {
                age--;
            }
        }
        return age;
    }
}
