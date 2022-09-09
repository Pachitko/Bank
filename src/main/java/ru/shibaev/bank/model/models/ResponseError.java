package ru.shibaev.bank.model.models;

public class ResponseError {
    public String Name;
    public String Description;

    public ResponseError(String name, String description) {
        Name = name;
        Description = description;
    }
}
