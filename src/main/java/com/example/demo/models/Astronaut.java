package com.example.demo.models;

public class Astronaut {
    public String craft;
    public String name;

    @Override
    public String toString (){
        return "Astronaut: > Name: " + name + " | Craft: " + craft;
    }
}
