package com.example.recyclerview;

class Person {
   private String name, surname, prefrence;

    public Person(String name, String surname, String prefrence) {
        this.name = name;
        this.surname = surname;
        this.prefrence = prefrence;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPrefrence() {
        return prefrence;
    }

    public void setPrefrence(String prefrence) {
        this.prefrence = prefrence;
    }
}
