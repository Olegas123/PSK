package com.example.psk_lab.services;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.Random;

@Alternative
@ApplicationScoped
public class StudentsLoginCredentialsAlternativeGenerator implements Serializable, ICredentialsGenerator {

    public String generateLoginCredentials(String name, String surname) {
        try {
            Thread.sleep(3000); // Simulate intensive work
        } catch (InterruptedException e) {
        }
        Integer loginCredentialsEndNumber = new Random().nextInt(9000) + 1000;
        return loginCredentialsEndNumber + name.substring(0, 2) + surname.substring(0, 2);
    }
}
