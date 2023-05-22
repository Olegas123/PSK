package com.example.psk_lab.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public class HelloDecorator implements IHello {
    @Inject
    @Delegate
    private IHello helloMsg;

    @Override
    public String helloMessage(String name) {
        return helloMsg.helloMessage(name) + " Have a nice day!";
    }
}
