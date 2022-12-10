package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.projects.create.CreateProjectRequest;
import com.projectname.api.client.data.model.users.common.Data;
import com.projectname.api.client.utils.helpers.RandomDataGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import org.testng.annotations.DataProvider;

public class ProjectProvider {
    @DataProvider(name = DataProviderNames.VERIFY_CREATE_PROJECT)
    public static Object[][] verifyCreateProject() {
        return new Object[][]{
                {"WithRandomTitle", new CreateProjectRequest(RandomDataGenerator.createRandomStringAlphanumericWithLen(5))},
                {"WithConcreteTitle", new CreateProjectRequest("ProjectTitle")},
        };
    }
}
