package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //tells SpringBoot that this class represents a web controller. AKA there are methods in this class
// that are setup to handle HTTP requests.
@ResponseBody
@RequestMapping
public class HelloController {

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }
    @GetMapping("hello")
    public String createMessage(String name, String language){
        String greeting = "";
        if (language.equalsIgnoreCase("English")) {
            greeting = "Hello";
        } else if (language.equalsIgnoreCase("French")){
            greeting = "Bonjour";
        }

        return language + ", " + name + "!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}) //handles both GET and POST
    // requests
    public String helloWithQueryParam(@RequestParam String name) {

        return "Hello, " + name + "!"; //dynamic response
    }

    // Handles request of the form /hello/LaunchCode
    @GetMapping("{name}") //handles GET requests
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }


    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='get'>" + //submit a request to /hello(method we created with queryParam)
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }



}
