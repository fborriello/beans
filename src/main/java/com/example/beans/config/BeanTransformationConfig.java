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
    public BeanTransformer branchTransformer(final BeanUtils beanUtils) {
        return beanUtils.getTransformer()
                .setDefaultValueForMissingField(true)
                .withFieldMapping(new FieldMapping("branchCode", "code"))
                .withFieldMapping(new FieldMapping("branchName", "name"));
    }

    @Bean
    public BeanTransformer countryTransformer(final BeanUtils beanUtils) {
        return beanUtils.getTransformer()
                .setDefaultValueForMissingField(true)
                .withFieldMapping(new FieldMapping("countryCode", "code"))
                .withFieldMapping(new FieldMapping("countryName","name" ));
    }

    @Bean
    public BeanTransformer cityTransformer(final BeanUtils beanUtils) {
        return beanUtils.getTransformer()
                .setDefaultValueForMissingField(true)
                .withFieldMapping(new FieldMapping("cityCode", "code"))
                .withFieldMapping(new FieldMapping("cityName","name"));
    }

    @Bean
    public BeanTransformer stateTransformer(final BeanUtils beanUtils) {
        return beanUtils.getTransformer()
                .setDefaultValueForMissingField(true)
                .withFieldMapping(new FieldMapping("stateCode", "code"))
                .withFieldMapping(new FieldMapping("stateName","name"))
                .withFieldMapping(new FieldMapping("stateRegion","region"));
    }
}
