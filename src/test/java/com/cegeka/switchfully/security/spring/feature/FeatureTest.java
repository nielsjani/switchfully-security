package com.cegeka.switchfully.security.spring.feature;

import org.assertj.core.api.Assertions;
import org.junit.Test;


import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class FeatureTest {

    @Test
    public void getFeaturesForRoles_GivenFeatureContainsOneOfTheRoles_ThenReturnAllFaturesContainingOneOfThoseRoles() {
        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList(ArmyRole.GENERAL.name(), ArmyRole.CIVILIAN.name()));

        Assertions.assertThat(actual).contains(Feature.LAUNCH_NUKES, Feature.GET_ARMY_INFO, Feature.JOIN_ARMY);
        Assertions.assertThat(actual).doesNotContain(Feature.DISCHARGE_SOLDIER, Feature.PROMOTE_PRIVATE);
    }

    @Test
    public void getFeaturesForRoles_GivenNoRolesSupplied_ThenReturnNoFeatures() {

        List<Feature> actual = Feature.getFeaturesForRoles(newArrayList());

        Assertions.assertThat(actual).isEmpty();
    }
}