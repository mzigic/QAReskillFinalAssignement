package com.projectname.api.tests.functional.suites.projects;

import com.projectname.api.client.calls.ProjectsAPI;
import com.projectname.api.client.data.model.projects.create.CreateProjectErrorResponse;
import com.projectname.api.client.data.model.projects.create.CreateProjectRequest;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.data.provider.ProjectProvider;
import com.projectname.api.tests.functional.asserts.CommonErrorAssert;
import com.projectname.api.tests.init.TestBase;
import org.testng.annotations.Test;

public class NegativeFunctionalTests extends TestBase {
    @Test(dataProvider = DataProviderNames.VERIFY_CANNOT_CREATE_PROJECT_WITHOUT_REQUIRED_FIELD,
            dataProviderClass = ProjectProvider.class)
    public void verifyCannotCreateProjectWithoutRequiredField(
            String suffix, CreateProjectRequest projectRequest, CreateProjectErrorResponse expectedError) {
        CreateProjectErrorResponse actualError = ProjectsAPI.
                createProjectError(token, projectRequest);
        CommonErrorAssert commonErrorAssert = new CommonErrorAssert();
        commonErrorAssert.assertRequiredFieldError(actualError, expectedError);
    }
}
