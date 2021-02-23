package com.example.demo.controllers;

import com.example.demo.models.Astronaut;
import com.example.demo.models.AstronautsInSpace;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//import com.google.gson.Gson;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class AstronautsInSpaceController {
    @GetMapping("/")
    @ResponseBody
    public String renderAstronauts() throws IOException {
        URL catURL= new URL("http://api.open-notify.org/astros.json");
        BufferedReader inputFromCatUrl = new BufferedReader(new InputStreamReader(catURL.openStream()));
        AstronautsInSpace astronautsInSpaceData = new Gson().fromJson(inputFromCatUrl, AstronautsInSpace.class);
        // astronautsInSpaceData is what you will be working with!
        System.out.println(astronautsInSpaceData);

        return "stuff";
    }
}
