package dev.example.taskList.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWebController {


    @RequestMapping("/helloweb")
    public String helloHandler(){

        return "hello.html";

    }


}
