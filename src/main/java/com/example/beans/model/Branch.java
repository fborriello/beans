package com.example.beans.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Branch implements Serializable {

    private Long code;
    private String name;

    private Long personCode;
    private String personName;
    private String fantasyName;

    private BranchCountry country;
    private BranchState state;
    private BranchCity city;

}
