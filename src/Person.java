package src;

public class Person {
    String name;
    int age;
    String Gender;

    public Person() {
        name="Unknown";
        age=0;
        Gender="Not specified";
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age=age;
        Gender=gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
