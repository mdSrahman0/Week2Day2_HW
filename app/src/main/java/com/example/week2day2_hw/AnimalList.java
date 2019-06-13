// Will hold an Animal object. An animal object only holds a name and a description.

package com.example.week2day2_hw;

public class AnimalList {
    String name;
    String description;

    public AnimalList() {
    }

    public AnimalList(String name, String description){
        this.description = description;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
