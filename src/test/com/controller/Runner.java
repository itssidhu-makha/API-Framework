package test.com.controller;

import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import test.com.objects.CleaningSessions;


public class Runner {
    public SoftAssert softAssert =new SoftAssert();
    public  ExtentUtils repo = ExtentUtils.getInstance();;

    @BeforeSuite
    public void setRepoFolder(){
        repo.setReports();
        RestAssured.baseURI= CleaningSessions.BASE_URI;
    }

    @BeforeMethod
    public void setReporter(ITestContext context){

        repo.setTest(context.getCurrentXmlTest().getName());

    }

    @AfterMethod
    public void flushReporter(){
        repo.getReports().endTest(repo.getTest());
        repo.getReports().flush();
    }

    @AfterSuite
    public void killThreadLocal(){
        repo.getInstance().removeThreadLocals();
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
