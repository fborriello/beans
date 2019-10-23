package com.example.beans.config;

import com.hotels.beans.BeanUtils;
import com.hotels.beans.transformer.BeanTransformer;
import com.hotels.transformer.model.FieldMapping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class BeanTransformationConfig {

    @Bean
    public BeanUtils beanUtils() {
        return new BeanUtils();
    }

    @Bean
    public BeanTransformer transformer(final BeanUtils beanUtils) {
        return beanUtils.getTransformer().setDefaultValueForMissingField(true);
    }

    @Bean
    public BeanTransformer beanTransformer(final BeanUtils beanUtils) {
        return beanUtils.getTransformer().setDefaultValueForMissingField(true);
    }

    @Bean
    public BeanTransformer branchTransformer(final BeanUtils beanUtils) {
        return beanUtils.getTransformer()
                .setDefaultValueForMissingField(true)
                .skipTransformationForField("country")
                .skipTransformationForField("state")
                .skipTransformationForField("city")
                .setDefaultValueSetEnabled(true)
                .withFieldMapping(new FieldMapping("branchCode", "code"))
                .withFieldMapping(new FieldMapping("branchName", "name"))
                .withFieldMapping(new FieldMapping("personCode", "personCode"))
                .withFieldMapping(new FieldMapping("personName", "personName"))
                .withFieldMapping(new FieldMapping("fantasyName", "fantasyName"))
                .withFieldMapping(new FieldMapping("countryCode", "country.code"))
                .withFieldMapping(new FieldMapping("countryName","country.name" ))
                .withFieldMapping(new FieldMapping("stateCode", "state.code"))
                .withFieldMapping(new FieldMapping("stateName", "state.name"))
                .withFieldMapping(new FieldMapping("stateRegion", "state.region"))
                .withFieldMapping(new FieldMapping("cityCode", "city.code"))
                .withFieldMapping(new FieldMapping("cityName", "city.name"))
                .withFieldMapping(new FieldMapping("active", "active"));
    }

    @Bean
    public BeanTransformer oracleBranchTransformer(final BeanUtils beanUtils) {
        return beanUtils.getTransformer()
                .setDefaultValueForMissingField(true)
                .skipTransformationForField("country")
                .skipTransformationForField("state")
                .skipTransformationForField("city")
                .setDefaultValueSetEnabled(true)
                .withFieldMapping(new FieldMapping("branchCode", "code"))
                .withFieldMapping(new FieldMapping("branchName", "name"))
                .withFieldMapping(new FieldMapping("personCode", "personCode"))
                .withFieldMapping(new FieldMapping("personName", "personName"))
                .withFieldMapping(new FieldMapping("fantasyName", "fantasyName"))
                .withFieldMapping(new FieldMapping("country.code", "countryCode"))
                .withFieldMapping(new FieldMapping("country.name","countryName" ))
                .withFieldMapping(new FieldMapping("state.code", "stateCode"))
                .withFieldMapping(new FieldMapping("state.name", "stateName"))
                .withFieldMapping(new FieldMapping("state,region", "stateRegion"))
                .withFieldMapping(new FieldMapping("city.code", "cityCode"))
                .withFieldMapping(new FieldMapping("city.name", "cityName"))
                .withFieldMapping(new FieldMapping("active", "active"));
    }

}
