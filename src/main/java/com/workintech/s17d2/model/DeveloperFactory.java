package com.workintech.s17d2.model;

public class DeveloperFactory {

    public static Developer create(int id, String name, double salary, Experience experience) {
        if(experience == Experience.JUNIOR) {
            return new JuniorDeveloper(id, name, salary);
        } else if(experience == Experience.MID) {
            return new MidDeveloper(id, name, salary);
        } else {
            return new SeniorDeveloper(id, name, salary);
        }
    }
}
