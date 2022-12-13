package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.technology.create.CreateTechnologyRequest;
import com.projectname.api.client.utils.helpers.RandomDataGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;

public class TechnologyProvider {
    @DataProvider(name = DataProviderNames.VERIFY_CREATE_TECHNOLOGY)
    public static Object[][] verifyCreateTechnology() {
        return new Object[][]{
                {"WithRandomTitle", new CreateTechnologyRequest(RandomDataGenerator.createRandomStringAlphanumericWithLen(5))},
                {"WithConcreteTitle", new CreateTechnologyRequest("TechnologyTitle")},
        };
    }
}
