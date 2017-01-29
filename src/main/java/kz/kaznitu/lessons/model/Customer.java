package kz.kaznitu.lessons.model;

public class Customer {
    private int custId ;
    private String name ;
    private int age ;

    public Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Customer(int custId, String name, int age) {
        this.custId = custId;
        this.name = name;
        this.age = age;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
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
}
