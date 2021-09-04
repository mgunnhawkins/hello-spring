package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.launchcode.skillstracker.Person;

import javax.servlet.http.HttpServletRequest;

@Controller
@ResponseBody

public class SkillsController {

    // methods
    //TODO: shows text that state three possible programming languages someone could be working on.
    @GetMapping
    public String displayHomePage(){
        return "<html>" +
                    "<body>" +
                        "<h1>Skills Tracker</h1>" +
                        "<h2> We have a few skills we would like to learn.  Here is the list! </h2>" +
                            "<ol>" +
                                "<li>Java</li>" +
                                "<li>JavaScript</li>" +
                                "<li>Python</li>" +
                            "</ol>"+
                    "</body>" +
                "</html>";
    }

    //TODO:  add a form that lets the user enter their name and choose their favorite second favorite and third
    // favorite programming languages on your list.  Use select elements for each of the rankings.  Use @GetMapping

   @GetMapping("form")//when we put a string into GetMapping it lets get request know where the root path should be
   public String languageChoiceForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='/form' method='post'>" + //action tells the form data when you submit it it will
                // submit to
                // the URL on that server
                            "<p>Name:</p>" +
                            "<br>" +
                            "<input type='text' name='name'>" +//name is the variable declaration within HTML
                            "<br>" +
                            "<p>My first favorite language: </p>" +
                            "<label for='firstLanguage'></label>" +
                            "<select name='firstLanguage' id='languages'>" +
                                "<option value=''>--Please choose an option--</option>" +
                                "<option value= 'Java'>Java</option>" +
                                "<option value= 'JavaScript'>JavaScript</option>" +
                                "<option value= 'Python'>Python</option>" +
                            "</select>" +
                            "<br>" +
                            "<p>My second favorite language: </p>" +
                            "<label for='secondLanguage'></label>" +
                            "<select name='secondLanguage' id='languages'>" +
                                "<option value=''>--Please choose an option--</option>" +
                                "<option value= 'Java'>Java</option>" +
                                "<option value= 'JavaScript'>JavaScript</option>" +
                                "<option value= 'Python'>Python</option>" +
                            "</select>" +
                            "<br>" +
                            "<p>My third favorite language: </p>" +
                            "<label for='thirdLanguage'></label>" +
                            "<select name='thirdLanguage' id='languages'>" +
                                "<option value=''>--Please choose an option--</option>" +
                                "<option value= 'Java'>Java</option>" +
                                "<option value= 'JavaScript'>JavaScript</option>" +
                                "<option value= 'Python'>Python</option>" +
                            "</select>" +
                            "<br>" +
                            "<input type='submit' value='Submit'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
   }


    //TODO:  use @PostMapping and Request param to update the HTML with an h1 stating the user's name and an ol
    // showing the three programming languages in the order they chose
    //processes form data
    //generate new URL to issue 301 redirect with query param

    @PostMapping("/form")
    public String gatherInfo(@RequestParam String name, @RequestParam String firstLanguage,
                             @RequestParam String secondLanguage, @RequestParam String thirdLanguage) {
        String newHTML = String.format("<html>" +
                "<body>" +
                "<h1>%s</h1>" +
                "<ol>" +
                "<li>%s</li>" +
                "<li>%s</li>" +
                "<li>%s</li>" +
                "</ol>"+
                "</body>" +
                "</html>", name, firstLanguage, secondLanguage, thirdLanguage) ;
        return newHTML;
    }









}


//google springboot check for query parameters
    //@GetMapping()


