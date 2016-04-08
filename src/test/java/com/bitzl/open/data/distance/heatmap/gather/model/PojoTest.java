package com.bitzl.open.data.distance.heatmap.gather.model;

import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import static com.openpojo.reflection.impl.PojoClassFactory.getPojoClass;

public class PojoTest {

    public void testGetterAndSetter(Class<?> clazz) {
        Validator validator = ValidatorBuilder.create()
                .with(new GetterTester())
                .with(new SetterTester())
                .build();
        validator.validate(getPojoClass(clazz));
    }

}
