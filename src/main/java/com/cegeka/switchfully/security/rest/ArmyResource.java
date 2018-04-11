package com.cegeka.switchfully.security.rest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = ArmyResource.ARMY_RESOURCE_PATH)
public class ArmyResource {

    public static final String ARMY_RESOURCE_PATH = "/armies";

    //@PreAutorise annotation only allows user with any of the given roles to access the method. (you could also place it on class level)
    //advantages: it's right near the code for the actual rest-controller
    //disadvantages: you may have to repeat it for every method.
    @PreAuthorize("hasAuthority('GET_ARMY_INFO')")
    @RequestMapping(method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE, path = "/{country}")
    public ArmyInfoDto getDeployedArmyInfo(@PathVariable(value = "country") String country) {
        return ArmyInfoDto.armyInfoDto()
                .withCountry(country)
                .withNumberOfTroops(2000)
                .withxCoordinateOfBase(15)
                .withyCoordinateOfBase(20);
    }

    @PreAuthorize("hasAuthority('JOIN_ARMY')")
    @RequestMapping(method = RequestMethod.POST)
    public void joinArmy() {
        //TODO
    }

    @PreAuthorize("hasAuthority('PROMOTE_PRIVATE')")
    @RequestMapping(method = RequestMethod.POST, path = "/promote/{name}")
    public void promotePrivate(@PathVariable(value = "name") String name) {
        //TODO
    }

    @PreAuthorize("hasAuthority('DISCHARGE_SOLDIER')")
    @RequestMapping(method = RequestMethod.POST, path = "/discharge/{name}")
    public void dischargeSoldier(@PathVariable(value = "name") String name) {
        //TODO
    }

    @PreAuthorize("hasAuthority('LAUNCH_NUKES')")
    @RequestMapping(method = RequestMethod.GET, path = "/nuke")
    public String launchNukes() {
        return "The world ends. Not with a bang but a whimper";
    }
}
