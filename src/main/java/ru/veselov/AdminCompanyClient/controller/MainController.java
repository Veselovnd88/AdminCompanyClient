package ru.veselov.AdminCompanyClient.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/")
@Slf4j
public class MainController {

    @GetMapping("/admin")
    public String adminMainPage(){
        return "adminPage";
    }
}
