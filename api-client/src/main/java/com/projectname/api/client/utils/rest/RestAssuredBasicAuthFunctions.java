package com.projectname.api.client.utils.rest;

import com.google.gson.GsonBuilder;
import com.projectname.api.client.utils.rest.model.BasicAuth;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredBasicAuthFunctions {

    public static Response get(BasicAuth loginUser, String uri) {
        return given().auth().preemptive()
                .basic(loginUser.getUserName(), loginUser.getPassword()).header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON).when().get(uri).then().extract().response();
    }

    public static Response get(Object body, BasicAuth loginUser, String uri) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().auth().preemptive()
                .basic(loginUser.getUserName(), loginUser.getPassword()).header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON).body(json).when().get(uri).then().extract().response();
    }

    public static Response post(Object body, BasicAuth loginUser, String uri) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().auth().preemptive()
                .basic(loginUser.getUserName(), loginUser.getPassword()).header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON).body(json).when().post(uri).then().extract().response();
    }

    public static Response post(BasicAuth loginUser, String uri) {
        return given().auth().preemptive()
                .basic(loginUser.getUserName(), loginUser.getPassword()).header("Accept", ContentType.JSON.getAcceptHeader())
                .contentType(ContentType.JSON).when().post(uri).then().extract().response();
    }

    //filepath should target resources folder; example: "src/test/resources/approved.jpg"
    //IMPORTANT: .multiPart("files[]", file) - "files[]" needs to replaced with parameter in your project
    public static Response post(Map<String, Object> bodyMap, BasicAuth loginUser, String uri, String filePath) {
        File file = new File(filePath);
        return given().auth().preemptive()
                .basic(loginUser.getUserName(), loginUser.getPassword()).multiPart("files[]", file)
                .formParams(bodyMap).when().post(uri).then().extract().response();
    }

    public static Response delete(BasicAuth loginUser, String uri) {
        return given().auth().preemptive()
                .basic(loginUser.getUserName(), loginUser.getPassword())
                .when().delete(uri).then().extract().response();
    }

    public static Response delete(Object body, BasicAuth loginUser, String uri) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().auth().preemptive()
                .basic(loginUser.getUserName(), loginUser.getPassword()).contentType(ContentType.JSON)
                .body(json).when().delete(uri).then().extract().response();
    }

    public static Response patch(Object body, BasicAuth loginUser, String uri) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().auth().preemptive()
                .basic(loginUser.getUserName(), loginUser.getPassword()).contentType(ContentType.JSON).body(json).when()
                .patch(uri).then().extract().response();
    }

    public static Response put(BasicAuth loginUser, String uri) {
        return given().auth().preemptive()
                .basic(loginUser.getUserName(), loginUser.getPassword()).contentType(ContentType.JSON)
                .when().put(uri).then().extract().response();
    }

    public static Response put(Object body, BasicAuth loginUser, String uri) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(body);
        return given().auth().preemptive()
                .basic(loginUser.getUserName(), loginUser.getPassword()).contentType(ContentType.JSON).body(json).when()
                .put(uri).then().extract().response();
    }

}
