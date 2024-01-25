package ru.gb.hw;

import java.time.LocalDate;

public class Customer {
    private String FIO;
    private LocalDate dateOfBirth;
    private String phone;

    public Customer(String FIO, LocalDate dateOfBirth, String phone) {
        this.FIO = FIO;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
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
}
