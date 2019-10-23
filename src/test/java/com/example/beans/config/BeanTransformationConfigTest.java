package com.example.beans.config;

import com.example.beans.model.Branch;
import com.example.beans.model.BranchCountry;
import com.example.beans.model.OracleBranch;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BeanTransformationConfigTest {

    private BeanTransformationConfig beanTransformationConfig;

    @Before
    public void setUp() {
        this.beanTransformationConfig = new BeanTransformationConfig();
    }

    @Test
    public void branchTransformer() {
        final OracleBranch oracleBranch = OracleBranch.builder().branchName("GP II").countryCode("BR").countryName("Brasil").build();

        final Branch result = beanTransformationConfig.branchTransformer(this.beanTransformationConfig.beanUtils())
                .transform(oracleBranch, Branch.class);

        assertThat(result.getCountry().getCode()).isEqualTo("BR");
        assertThat(result.getCountry().getName()).isEqualTo("Brasil");
    }

    @Test
    public void oracleBranchTransformer() {
        final Branch branch = Branch.builder().country(BranchCountry.builder().code("BR").name("Brasil").build()).build();

        final OracleBranch result = beanTransformationConfig.oracleBranchTransformer(this.beanTransformationConfig.beanUtils())
                .transform(branch, OracleBranch.class);

        assertThat(result.getCountryCode()).isEqualTo("BR");
        assertThat(result.getCountryName()).isEqualTo("Brasil");
    }
}