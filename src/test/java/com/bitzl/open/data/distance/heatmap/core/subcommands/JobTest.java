package com.bitzl.open.data.distance.heatmap.core.subcommands;


import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.Test;

import static com.openpojo.reflection.impl.PojoClassFactory.getPojoClass;

public class JobTest {

    @Test
    public void testGetterAndSetter() {
        Validator validator = ValidatorBuilder.create()
                .with(new GetterTester())
                .with(new SetterTester())
                .build();
        validator.validate(getPojoClass(YamlJob.class));
    }

}