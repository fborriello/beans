package com.example.beans.model.transformer;

import com.example.beans.config.BeanTransformationConfig;
import com.example.beans.model.Branch;
import com.example.beans.model.OracleBranch;
import com.hotels.beans.BeanUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@RunWith(MockitoJUnitRunner.class)
public class BranchTransformerTest {

    @InjectMocks
    private BranchTransformer branchTransformer;

    @Test
    public void transform() {
        //injectBeans();
        final OracleBranch oracleBranch = OracleBranch.builder().branchName("GP II").countryCode("BR").countryName("Brasil").build();

        final Branch result = branchTransformer.transform(oracleBranch);

        assertEquals("BR", result.getCountry().getCode());
        assertEquals("Brasil", result.getCountry().getName());
    }

    @Before
    public void injectBeans() {
        BeanTransformationConfig beanTransformationConfig = new BeanTransformationConfig();
        setField(branchTransformer, "branchTransformer", beanTransformationConfig.branchTransformer(new BeanUtils()));
        setField(branchTransformer, "countryTransformer", beanTransformationConfig.countryTransformer(new BeanUtils()));
        setField(branchTransformer, "cityTransformer", beanTransformationConfig.cityTransformer(new BeanUtils()));
        setField(branchTransformer, "stateTransformer", beanTransformationConfig.stateTransformer(new BeanUtils()));
    }
}