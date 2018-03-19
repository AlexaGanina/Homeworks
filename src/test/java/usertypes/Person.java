package usertypes;

public class Person {

    private String firstName;
    private String secondName;
    private String lastName;
    private String age;
    private String sex;
    private String birthDate;
    private String birthCity;
    private String location;

    public Person() {
    }

    public Person(String firstName,     String secondName,      String lastName,        String age,
                  String sex,           String birthDate,       String birthCity,       String location) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.birthDate = birthDate;
        this.birthCity = birthCity;
        this.location = location;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecomdName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String sex) {
        this.birthDate = birthDate;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String sex) {
        this.birthCity = birthCity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String sex) {
        this.location = location;
    }



}
