package com.example.psk_lab.decorator;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SimpleHelloMessage implements IHello {
    @Override
    public String helloMessage(String name) {
        return "Hello " + name + "!";
    }
}
