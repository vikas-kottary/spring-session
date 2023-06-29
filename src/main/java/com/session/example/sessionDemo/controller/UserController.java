package com.session.example.sessionDemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    private String COUNTER = "COUNTER";

    @GetMapping
    public String getData(Principal principal, HttpSession session) {
        incrementCounter(session);
        return "data: " + principal.getName() + " counter: " + session.getAttribute(COUNTER);
    }

    private int incrementCounter(HttpSession session) {
        Integer counter = session.getAttribute(COUNTER) == null ? 0 : (Integer) session.getAttribute(COUNTER);
        session.setAttribute(COUNTER, counter + 1);
        return counter;
    }

}
