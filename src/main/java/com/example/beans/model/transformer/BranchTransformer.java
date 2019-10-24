package com.example.beans.model.transformer;


import com.example.beans.model.*;
import com.hotels.beans.transformer.BeanTransformer;
import com.hotels.transformer.model.FieldTransformer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BranchTransformer {

    @Autowired
    BeanTransformer branchTransformer;

    @Autowired
    BeanTransformer countryTransformer;

    @Autowired
    BeanTransformer cityTransformer;

    @Autowired
    BeanTransformer stateTransformer;

    public Branch transform(final OracleBranch oracleBranch) {
        final FieldTransformer<OracleBranch, BranchCountry> countryFieldTransformer =
                new FieldTransformer<>("country", () -> countryTransformer.transform(oracleBranch, BranchCountry.class));
        final FieldTransformer<OracleBranch, BranchState> stateFieldTransformer =
                new FieldTransformer<>("state", () -> cityTransformer.transform(oracleBranch, BranchState.class));
        final FieldTransformer<OracleBranch, BranchCity> cityFieldTransformer =
                new FieldTransformer<>("city", () -> cityTransformer.transform(oracleBranch, BranchCity.class));
        return branchTransformer
                .withFieldTransformer(countryFieldTransformer, stateFieldTransformer, cityFieldTransformer)
                .transform(oracleBranch, Branch.class);
    }
}
