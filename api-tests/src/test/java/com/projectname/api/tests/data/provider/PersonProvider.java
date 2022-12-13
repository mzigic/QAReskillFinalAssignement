package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.people.create.CreatePersonRequest;
import com.projectname.api.client.utils.helpers.RandomDataGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;

public class PersonProvider {
    @DataProvider(name = DataProviderNames.VERIFY_CREATE_PERSON)
    public static Object[][] verifyCreatePersonWithName() {
        return new Object[][]{
                {"WithRandomName", new CreatePersonRequest(RandomDataGenerator.createRandomStringAlphabeticWithLen(5))},
                {"WithConcreteName", new CreatePersonRequest("Person Name")},
        };
    }
}
