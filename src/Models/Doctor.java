package Models;

import Enums.Gender;

public class Doctor {
    private Long id;
    private String firstName;
    private String LastName;
    private Gender gender;
    private int experienceYear;
//**********************************************************************************************************************
    public Doctor() {
    }
    public Doctor(String firstName, String lastName, Gender gender, int experienceYear) {
        this.firstName = firstName;
        LastName = lastName;
        this.gender = gender;
        this.experienceYear = experienceYear;
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
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public int getExperienceYear() {
        return experienceYear;
    }
    public void setExperienceYear(int experienceYear) {
        this.experienceYear = experienceYear;
    }
//**********************************************************************************************************************
    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", gender=" + gender +
                ", experienceYear=" + experienceYear +
                '}';
    }
//**********************************************************************************************************************

}
