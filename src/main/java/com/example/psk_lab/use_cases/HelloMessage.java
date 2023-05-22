package com.example.psk_lab.use_cases;

import com.example.psk_lab.decorator.IHello;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

@Model
public class HelloMessage {
    @Inject
    private IHello helloMsg;

    public String helloMessage() {
        return helloMsg.helloMessage("defaultUser1");
    }
}
