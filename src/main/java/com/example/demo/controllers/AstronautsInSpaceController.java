package com.example.demo.controllers;

import com.example.demo.models.Astronaut;
import com.example.demo.models.AstronautsInSpace;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

@Controller
public class AstronautsInSpaceController {
    public AstronautsInSpace astronautsInSpaceData;
    public Astronaut astronautData;

    public AstronautsInSpaceController() throws IOException {
        URL astronautsURL= new URL("http://api.open-notify.org/astros.json");
        BufferedReader inputFromAstronautsUrl = new BufferedReader(new InputStreamReader(astronautsURL.openStream()));
        this.astronautsInSpaceData = new Gson().fromJson(inputFromAstronautsUrl, AstronautsInSpace.class);
    }

    @GetMapping("/")
    public String renderAstronauts(Model model) throws IOException {

        Integer numberOfPeopleinSpace = this.astronautsInSpaceData.number;

        // Investigate what properties can be found on the individual Astronaut
        ArrayList<Astronaut> astronautsInSpace = this.astronautsInSpaceData.people;

        model.addAttribute("astronautsNumber", numberOfPeopleinSpace);

        model.addAttribute("astronauts", astronautsInSpace);



        System.out.println(numberOfPeopleinSpace);
        System.out.println(astronautsInSpace);

        return "index.html";
    }
}
