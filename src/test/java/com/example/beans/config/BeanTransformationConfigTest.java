package com.example.beans.config;

import com.example.beans.model.Branch;
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
}