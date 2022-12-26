package com.projectname.e2e.tests.data.provider.projects;

import com.projectname.api.client.utils.helpers.RandomDataGenerator;
import com.projectname.e2e.tests.data.model.projects.CreateProjectRequest;
import org.apache.commons.text.RandomStringGenerator;

public class ProjectProvider {

    public static CreateProjectRequest prepareCreateProjectRequest() {
        CreateProjectRequest projectRequest = new CreateProjectRequest();

        projectRequest.setTitle(RandomDataGenerator.createRandomStringAlphanumericWithLen(8));

        return projectRequest;
    }
}
