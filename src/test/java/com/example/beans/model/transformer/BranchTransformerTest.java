package com.example.beans.model.transformer;

import com.example.beans.model.Branch;
import com.example.beans.model.OracleBranch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BranchTransformerTest {

    @InjectMocks
    private BranchTransformer branchTransformer;

    @Test
    public void transform() {
        final OracleBranch oracleBranch = OracleBranch.builder().branchName("GP II").countryCode("BR").countryName("Brasil").build();

        final Branch result = branchTransformer.transform(oracleBranch);

        assertThat(result.getCountry().getCode()).isEqualTo("BR");
        assertThat(result.getCountry().getName()).isEqualTo("Brasil");
    }
}