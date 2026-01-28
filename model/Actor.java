package model;

import java.time.LocalDate;
import java.time.Period;

public class Actor {
    private int actorId;
    private String name;
    private LocalDate dob;

    public Actor(int actorId, String name, LocalDate dob) {
        this.actorId = actorId;
        this.name = name;
        this.dob = dob;
    }

    public int getActorId() { return actorId; }
    public String getName() { return name; }
    public LocalDate getDob() { return dob; }

    public int getAge(LocalDate onDate) {
        return Period.between(dob, onDate).getYears();
    }
}
