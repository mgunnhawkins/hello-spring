package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //tells SpringBoot that this class represents a web controller. AKA there are methods in this class
// that are setup to handle HTTP requests.
@ResponseBody
@RequestMapping("hello")//all methods are at backslash hello
public class HelloController {




    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST}) //handles both GET and POST
    // requests
    public String gatherInfo(@RequestParam String name, @RequestParam String language){
        return createMessage(name,language);
    }
    public String createMessage(String name, String language) { //try redoing with switch case
        String greeting = "";
        if (language.equalsIgnoreCase("english")) {
            greeting = "Hello";
        } else if (language.equalsIgnoreCase("french")){
            greeting = "Bonjour";
        } else if (language.equalsIgnoreCase("spanish")) {
            greeting = "Hola";
        }else if (language.equalsIgnoreCase("hebrew")) {
            greeting = "Shalom";
        }else if (language.equalsIgnoreCase("italian")) {
            greeting = "Ciao";
        }

        return greeting + ", " + name + "!";
    }


    @GetMapping("form") //method to display form
    public String helloForm(){
        return "<html>" +
                    "<style>" +
                        "input{" +
                            "border: solid #A9A9A9 2px;" +
                            "border-radius: 10px;" +
                            "padding: 5px;" +
                            "margin: 10px;" +
                        "}" +
                        "select{" +
                        "border: solid #A9A9A9 2px;" +
                        "border-radius: 10px;" +
                        "padding: 5px;" +
                        "margin: 10px;" +
                        "}" +
                    "</style>" +
                    "<body>" +
                        "<form action='hello'>" + //submit a request to /hello(method we created with queryParam)
                            "<input type='text' name='name'>" + //for text in a form
                            "<select name='language' id='language'>" +
                                "<option value='english'>English</option>" +
                                "<option value='french'>French</option>" +
                                "<option value='spanish'>Spanish</option>" +
                                "<option value='hebrew'>Hebrew</option>" +
                                "<option value='italian'>Italian</option>" +
                            "</select>" +
                            "<input type='submit' value='Greet me!'>" + //creates input button
                        "</form>" +
                "   </body>" +
                "</html>";
    }



}
