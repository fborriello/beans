package com.example.beans.model.transformer;


import com.example.beans.model.*;
import org.springframework.stereotype.Component;

@Component
public class BranchTransformer {

    public Branch transform(final OracleBranch oracleBranch) {
        return Branch.builder()
                .code(oracleBranch.getBranchCode())
                .name(oracleBranch.getBranchName())
                .personCode(oracleBranch.getPersonCode())
                .personName(oracleBranch.getPersonName())
                .country(BranchCountry.builder()
                        .code(oracleBranch.getCountryCode())
                        .name(oracleBranch.getCountryName())
                        .build())
                .state(BranchState
                        .builder()
                        .code(oracleBranch.getStateCode())
                        .name(oracleBranch.getStateCode())
                        .region(oracleBranch.getStateRegion())
                        .build())
                .city(BranchCity.builder()
                        .code(oracleBranch.getCityCode())
                        .name(oracleBranch.getCityName())
                        .build())
                .fantasyName(oracleBranch.getFantasyName())
                .active("I".equalsIgnoreCase(oracleBranch.getActive()))
                .build();
    }
}
