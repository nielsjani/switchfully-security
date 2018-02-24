package com.cegeka.switchfully.security.spring.access;

import com.cegeka.switchfully.security.external.criminalrecord.CriminalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArmyPromotionCheckerService {

    @Autowired
    private CriminalRecordService criminalRecordService;

    public boolean doesNotHaveCriminalRecord(String username) {
        return criminalRecordService.hasCriminalRecord(username).getOffenses().isEmpty();
    }
}
