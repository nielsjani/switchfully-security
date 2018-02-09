package com.cegeka.switchfully.security;

import java.io.Serializable;

public class ArmyInfoDto implements Serializable{

    public String country;
    public int numberOfTroops;
    public int xCoordinateOfBase;
    public int yCoordinateOfBase;

    public static ArmyInfoDto armyInfoDto() {
        return new ArmyInfoDto();
    }

    public ArmyInfoDto withCountry(String country) {
        this.country = country;
        return this;
    }

    public ArmyInfoDto withNumberOfTroops(int numberOfTroops) {
        this.numberOfTroops = numberOfTroops;
        return this;
    }

    public ArmyInfoDto withxCoordinateOfBase(int xCoordinateOfBase) {
        this.xCoordinateOfBase = xCoordinateOfBase;
        return this;
    }

    public ArmyInfoDto withyCoordinateOfBase(int yCoordinateOfBase) {
        this.yCoordinateOfBase = yCoordinateOfBase;
        return this;
    }
}
