package Models;

import Enums.Gender;

public class Patient {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private Gender gender;
//**********************************************************************************************************************
    public Patient() {
    }
    public Patient(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }
//**********************************************************************************************************************
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        try {
            if(age > 0 && age < 100) {
                this.age = age;
            }else throw new Exception();
        }catch (Exception e){
            System.out.println("Siz tuura emes jashty kirgizdiniz !");
        }
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
//**********************************************************************************************************************
    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
//**********************************************************************************************************************

}
