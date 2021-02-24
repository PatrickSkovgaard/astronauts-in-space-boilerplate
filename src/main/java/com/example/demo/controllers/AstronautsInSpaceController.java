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
    public AstronautsInSpace astronautsInSpaceData;

    public AstronautsInSpaceController() throws IOException {
        URL catURL= new URL("http://api.open-notify.org/astros.json");
        BufferedReader inputFromCatUrl = new BufferedReader(new InputStreamReader(catURL.openStream()));
        this.astronautsInSpaceData = new Gson().fromJson(inputFromCatUrl, AstronautsInSpace.class);

    }

    @GetMapping("/")
    @ResponseBody
    public String renderAstronauts() throws IOException {
        // this.astronautsInSpaceData is what you will be working with!
        System.out.println(this.astronautsInSpaceData);

        return "stuff";
    }
}
