package com.hospital.patient.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PatientRequest {
    private int id;
    @NotBlank(message = "name must not be blank")
    private String name;
    @Min(value =1, message="Age must be at least 1")
    private int age;
    @NotBlank(message = "please select your gender")
    private String gender;
    @NotBlank(message = "please enter city where you are living")
    private String city;
    @NotBlank(message = "enter your blood group")
    private String bloodGroup;

    public PatientRequest() {
    }

    public PatientRequest(int id ,String name, int age, String gender, String city, String bloodGroup) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.bloodGroup = bloodGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString() {
        return "PatientRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                '}';
    }
}
