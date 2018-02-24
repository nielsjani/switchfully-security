package com.cegeka.switchfully.security.external.criminalrecord;

import org.springframework.stereotype.Component;

@Component
public class CriminalRecordService {

    public CriminalRecord hasCriminalRecord(String username){
        if(username.equals("MOB") || username.equals("CRIMI")){
            return CriminalRecord.recordForCriminal();
        }
        return CriminalRecord.cleanRecord();
    }
}
