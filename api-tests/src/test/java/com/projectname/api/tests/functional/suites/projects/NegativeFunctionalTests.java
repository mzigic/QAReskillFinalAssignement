package com.projectname.api.tests.functional.suites.projects;

import com.projectname.api.client.calls.ProjectsAPI;
import com.projectname.api.client.data.model.projects.ProjectRequiredFieldErrorResponse;
import com.projectname.api.client.data.model.projects.create.CreateProjectRequest;
import com.projectname.api.client.data.model.projects.create.CreateProjectResponse;
import com.projectname.api.client.data.model.projects.update.UpdateProjectRequest;
import com.projectname.api.client.utils.helpers.RandomDataGenerator;
import com.projectname.api.tests.constants.DataProviderNames;
import com.projectname.api.tests.constants.ErrorMessages;
import com.projectname.api.tests.data.provider.ProjectProvider;
import com.projectname.api.tests.functional.asserts.CommonErrorAssert;
import com.projectname.api.tests.init.TestBase;
import org.testng.annotations.Test;

public class NegativeFunctionalTests extends TestBase {
    @Test(dataProvider = DataProviderNames.VERIFY_CANNOT_CREATE_PROJECT_WITHOUT_REQUIRED_FIELD,
            dataProviderClass = ProjectProvider.class)
    public void verifyCannotCreateProjectWithoutRequiredField(
            String suffix, CreateProjectRequest projectRequest, ProjectRequiredFieldErrorResponse expectedError) {
        ProjectRequiredFieldErrorResponse actualError = ProjectsAPI.
                createProjectTitleError(token, projectRequest);
        CommonErrorAssert commonErrorAssert = new CommonErrorAssert();
        commonErrorAssert.assertProjectTitleError(actualError, expectedError);
    }

    @Test
    public void verifyCannotCreateProjectWithSameTitle() {
        CreateProjectRequest createProjectRequest = new CreateProjectRequest("title1");
        CreateProjectResponse createdProject = ProjectsAPI.createProject(token, createProjectRequest);
        ProjectRequiredFieldErrorResponse actualError = ProjectsAPI.
                createProjectTitleError(token, createProjectRequest);

        CommonErrorAssert commonErrorAssert = new CommonErrorAssert();
        ProjectRequiredFieldErrorResponse expectedError = new ProjectRequiredFieldErrorResponse(ErrorMessages.PROJECT_TITLE_ALREADY_EXISTS);
        commonErrorAssert.assertProjectTitleError(actualError, expectedError);

        ProjectsAPI.deleteProject(token, createdProject.getId());
    }

    @Test(dataProvider = DataProviderNames.VERIFY_CANNOT_UPDATE_PROJECT_WITHOUT_REQUIRED_FIELD,
            dataProviderClass = ProjectProvider.class)
    public void verifyCannotUpdateProjectWithoutRequiredField(String suffix, UpdateProjectRequest updateRequest, ProjectRequiredFieldErrorResponse expectedError) {
        CreateProjectRequest createProjectRequest = new CreateProjectRequest(RandomDataGenerator.createRandomStringAlphabeticWithLen(8));
        CreateProjectResponse createdProject = ProjectsAPI.createProject(token, createProjectRequest);

        ProjectRequiredFieldErrorResponse actualError = ProjectsAPI.updateProjectTitleError(token, updateRequest, createdProject.getId());

        CommonErrorAssert commonErrorAssert = new CommonErrorAssert();

        commonErrorAssert.assertProjectTitleError(actualError, expectedError);

        ProjectsAPI.deleteProject(token, createdProject.getId());
    }
}
