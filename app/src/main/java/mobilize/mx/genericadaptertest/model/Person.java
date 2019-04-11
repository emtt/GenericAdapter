package mobilize.mx.genericadaptertest.model;

public class Person {
    public String Name;
    public int Age;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return ""+Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
