package com.cegeka.switchfully.security;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = ArmyResource.ARMY_RESOURCE_PATH)
public class ArmyResource {

    public static final String ARMY_RESOURCE_PATH = "/armies";

    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE ,path = "/{country}")
    public ArmyInfoDto getDeployedArmyInfo(@PathVariable(value = "country") String country){
        return ArmyInfoDto.armyInfoDto()
                .withCountry(country)
                .withNumberOfTroops(2000)
                .withxCoordinateOfBase(15)
                .withyCoordinateOfBase(20);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void joinArmy(){
        //TODO
    }

    @RequestMapping(method = RequestMethod.POST, path = "/promote/{name}")
    public void promotePrivate(@PathVariable(value = "name") String name){
        //TODO
    }

    @RequestMapping(method = RequestMethod.POST, path = "/discharge/{name}")
    public void dischargeSoldier(@PathVariable(value = "name") String name){
        //TODO
    }

    @RequestMapping(method = RequestMethod.GET, path = "/nuke")
    public String launchNukes(){
        return "The world ends. Not with a bang but a whimper";
    }
}
