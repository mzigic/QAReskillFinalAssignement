package com.projectname.api.client.data.model.sandbox.testcase;

import com.projectname.api.client.data.model.sandbox.common.CommonErrorResponse;

public class GetTestCaseByIdErrorResponse extends CommonErrorResponse {
    public GetTestCaseByIdErrorResponse() {
    }

    public GetTestCaseByIdErrorResponse(String error) {
        super(error);
    }
}
