package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    //    // Handle request at path /hello
    //    @GetMapping("hello")
    //    @ResponseBody
    //    public String hello() {
    //        return "Hello, Spring!";
    //    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) { //Model class is not the same as MVC.
        //  Used to pass data between controller and view.
        String theGreeting = "Hello, " + name + "!";
        //in order to handle greeting it needs to be passed into model object
        model.addAttribute("greeting", theGreeting); //first param is name of the variable (the one in brackets in
        // the Thymeleaf template).  Second is object that
        // variable should have (local variable).
        return "hello"; //returns template name
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    @GetMapping("form")
    public String helloForm() {
        return "form"; //this tells springboot to find the template called form.  @Response body tells springboot NOT
        // to look for a template
    }

    //handler to return hello list that goes wtih for each loop
    @GetMapping("hello-names")
    public String helloNames(Model model){ //pass list of names into template via Model object
        List<String> names = new ArrayList<>();
        names.add("Melanie");
        names.add("Doodles");
        names.add("Sophie");
        names.add("Anthony");
        names.add("Eleanore");
        model.addAttribute("names", names); //first param is name of the variable (the one in brackets in
        // the Thymeleaf template).  Second is object that
        // variable should have (local variable).
        return "hello-list";
    }



}
