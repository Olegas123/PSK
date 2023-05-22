package com.example.psk_lab.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.util.Random;

///@Specializes
@ApplicationScoped
public class SpecialCredentialsGenerator extends StudentsLoginCredentialsGenerator {

    @Override
    public String generateLoginCredentials(String name, String surname) {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        Integer loginCredentialsEndNumber = new Random().nextInt(9000) + 1000;
        return "special" + name.substring(0, 2) + surname.substring(0, 2) + loginCredentialsEndNumber;
    }
}