package org.example.lab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/textBox")
public class ControllerLab {
    @GetMapping()
    public String getTextBox() {
        return "textBox/input";
    }
}
