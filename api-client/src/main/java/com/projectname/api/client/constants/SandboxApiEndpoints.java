package com.projectname.api.client.constants;

//List of endpoint as constants
public class SandboxApiEndpoints {

    private static final String CANDIDATE = "candidate/";
    public static final String CANDIDATE_LOGIN = CANDIDATE + "login/";
    public static final String CANDIDATE_DASHBOARD = CANDIDATE + "dashboard/";
    public static final String CANDIDATE_PROFILE = CANDIDATE + "profile/";
    public static final String CANDIDATE_TESTCASES = CANDIDATE + "testcases/";
    public static final String CANDIDATE_PROJECTS = CANDIDATE + "projects/";
    public static final String CANDIDATE_REPORTS = CANDIDATE + "reports/";
    public static final String CANDIDATE_SCENARIO = CANDIDATE + "scenario/";
    public static final String CANDIDATE_PEOPLE = CANDIDATE + "people/";
    public static final String CANDIDATE_TECHNOLOGIES = CANDIDATE + "technologies/";
    public static final String CANDIDATE_SENIORITIES = CANDIDATE + "seniorities/";
    public static final String CANDIDATE_TEAMS = CANDIDATE + "teams/";

    public static final String projects(Integer id) {
        return CANDIDATE_PROJECTS + id;
    }

    public static final String people(Integer id) {
        return CANDIDATE_PEOPLE + id;
    }

    public static final String technologies(Integer id) {
        return CANDIDATE_TECHNOLOGIES + id;
    }

    public static final String seniorities(Integer id) {
        return CANDIDATE_SENIORITIES + id;
    }

    public static final String teams(Integer id) {
        return CANDIDATE_TEAMS + id;
    }

    public static final String persons(Integer id) {
        return CANDIDATE_PEOPLE + id;
    }

    public static String testCaseBy(String id) {
        return CANDIDATE_TESTCASES + id;
    }


}
