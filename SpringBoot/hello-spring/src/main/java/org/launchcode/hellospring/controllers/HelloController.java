package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //tells SpringBoot that this class represents a web controller. AKA there are methods in thiis class
// that are setup to handle HTTP requests.
@ResponseBody
@RequestMapping("hello")
public class HelloController {
//    @GetMapping("hello") //tells SpringBoot that this method should handle GET requests
//    @ResponseBody //tells SpringBoot that this will return a plain text response
//    public String hello(){
//        return "Hello, Spring";
//    }


    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello") //handles both GET and POST
    // requests
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!"; //dynamic response
    }

    // Handles request of the form /hello/LaunchCode
    //now LaunchCode is not part of the query string it is part of the path itself
    //@PathVariable- tells SpringBoot that this handler method is looking for a request to /hello/name where name can
    // be an ytiing and we are going to be taking that anything and place it in the method paramater name.  method we
    // define in "hello/{name}" needs to be tthe exact same as what we define in pathVariable list.
    @GetMapping("{name}") //handles GET requests
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }


//    //creates a form with GET request
//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm(){
//        return "<html>" +
//                "<body>" +
//                "<form action='hello'>" + //submit a request to /hello(method we created with queryParam)
//                "<input type='text' name='name'>" +
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='/hello' method='post'>" + //submit a request to /hello(method we created with queryParam)
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }



}
