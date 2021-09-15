package test.com.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import test.com.objects.CleaningSessions;


public class Runner {
    public SoftAssert softAssert =new SoftAssert();
    public ExtentUtils repo = ExtentUtils.getInstance();

    @BeforeSuite
    public void setRepoFolder(){
        repo.setReports();
        RestAssured.baseURI= CleaningSessions.BASE_URI;
    }

    public static void main(String[] args) {


    }


}

/*
    String json = "{\n" +
            "  \"roomSize\" : [5, 5],\n" +
            "  \"coords\" : [1, 2],\n" +
            "  \"patches\" : [\n" +
            "    [1, 0],\n" +
            "    [2, 2],\n" +
            "    [2, 3]\n" +
            "  ],\n" +
            "  \"instructions\" : \"NNESEESWNWW\"\n" +
            "}\n";

        RestAssured.baseURI="http://localhost:8080/v1";
                Response response = given()
                .contentType(ContentType.JSON)
                .body(json)
                .when()
                .post("/cleaning-sessions")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract().response();
                System.out.println(response.getBody().asString());*/
