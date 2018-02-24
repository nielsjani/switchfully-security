package com.cegeka.switchfully.security.external.criminalrecord;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class CriminalRecord {
    private boolean didJailTime;
    private List<String> offenses = newArrayList();

    private CriminalRecord(boolean didJailTime, List<String> offenses) {
        this.didJailTime = didJailTime;
        this.offenses = offenses;
    }

    public static CriminalRecord recordForCriminal() {
        return new CriminalRecord(true, newArrayList("THEFT", "STEALY WHEELY AUTOMOBILEY"));
    }

    public static CriminalRecord cleanRecord() {
        return new CriminalRecord(false, newArrayList());
    }

    public boolean isDidJailTime() {
        return didJailTime;
    }

    public List<String> getOffenses() {
        return offenses;
    }
}
