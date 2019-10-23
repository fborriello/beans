package com.example.beans.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OracleBranch {

    private Long personCode;
    private String personName;
    private String fantasyName;

    private Long branchCode;
    private String branchName;
    private String countryCode;
    private String countryName;
    private String stateCode;
    private String stateName;
    private String stateRegion;
    private Long cityCode;
    private String cityName;
    private String active;

}
