package ru.gb.hw;

import java.time.LocalDate;

public class Customer {
    private String FIO;
    private LocalDate dateOfBirth;
    private String phone;
    private Gender gender;

    public Customer(String FIO, LocalDate dateOfBirth, String phone, Gender gender) {
        this.FIO = FIO;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.gender = gender;
    }

    public String getFIO() {
        return FIO;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhone() {
        return phone;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
}
