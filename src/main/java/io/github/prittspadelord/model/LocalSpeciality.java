package io.github.prittspadelord.model;

import org.jspecify.annotations.NonNull;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalSpeciality implements Serializable {

    public enum Nation {
        mondstadt, liyue, inazuma, sumeru, fontaine, natlan, snezhnaya, ;
    }

    int id;
    @NonNull String name = "";
    @NonNull Nation nation = Nation.mondstadt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public Nation getNation() {
        return nation;
    }

    public void setNation(@NonNull Nation nation) {
        this.nation = nation;
    }
}
