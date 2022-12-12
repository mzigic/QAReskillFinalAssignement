package com.projectname.api.tests.data.provider;

import com.projectname.api.client.data.model.projects.create.CreateProjectErrorResponse;
import com.projectname.api.client.data.model.projects.create.CreateProjectRequest;
import com.projectname.api.client.utils.helpers.RandomDataGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.constants.ErrorMessages;
import org.testng.annotations.DataProvider;

public class ProjectProvider {
    @DataProvider(name = DataProviderNames.VERIFY_CREATE_PROJECT)
    public static Object[][] verifyCreateProject() {
        return new Object[][]{
                {"WithRandomTitle", new CreateProjectRequest(RandomDataGenerator.createRandomStringAlphanumericWithLen(5))},
                {"WithConcreteTitle", new CreateProjectRequest("ProjectTitle")},
        };
    }

    @DataProvider(name = DataProviderNames.VERIFY_CANNOT_CREATE_PROJECT_WITHOUT_REQUIRED_FIELD)
    public static Object[][] verifyCannotCreateCrocodileWithoutRequiredFields() {
        return new Object[][]{
                {"WhenTitleIsNull",
                        new CreateProjectRequest(null),
                        new CreateProjectErrorResponse(ErrorMessages.TITLE_IS_REQUIRED)
                },
                {"WhenTitleIsEmptyString",
                        new CreateProjectRequest(""),
                        new CreateProjectErrorResponse(ErrorMessages.TITLE_IS_REQUIRED)
                }
        };
    }
}
