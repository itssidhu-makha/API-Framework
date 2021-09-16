package test.com.tests.cleaningsessions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.*;
import test.com.controller.Runner;
import test.com.data.cleaning.PositiveDataProviders;


public class PositiveTests extends Runner {




    @Test(groups = {"cleaning-positive"},dataProvider = "baseData",dataProviderClass = PositiveDataProviders.class)
    public void testBaseCase(String[] data){


        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .extract().response();


            compareResult(response.jsonPath().getString("patches"),data[3]);
            compareResult(response.jsonPath().getString("coords").replaceAll(" ",""),data[2]);
        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("The Test failed without a response::"+e.getMessage());
        }
    }

    @Test(groups = {"cleaning-positive"},dataProvider = "rectangleRoom",dataProviderClass = PositiveDataProviders.class)
    public void testRectangularRoom(String[] data){


        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .extract().response();


            compareResult(response.jsonPath().getString("patches"),data[3]);
            compareResult(response.jsonPath().getString("coords").replaceAll(" ",""),data[2]);
        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("The Test failed without a response::"+e.getMessage());
        }
    }

    @Test(groups = {"cleaning-positive"},dataProvider = "positionDecimals",dataProviderClass = PositiveDataProviders.class)
    public void testRoboAtDecimalPosition(String[] data){

        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .extract().response();


            compareResult(response.jsonPath().getString("patches"),data[3]);
            compareResult(response.jsonPath().getString("coords").replaceAll(" ",""),data[2]);
        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("The Test failed without a response::"+e.getMessage());
        }
    }

    @Test(groups = {"cleaning-positive"},dataProvider = "repeatedPatches",dataProviderClass = PositiveDataProviders.class)
    public void repeatedPatchesTest(String[] data){

        Response response=null;
        try {
           response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .extract().response();

            compareResult(response.jsonPath().getString("patches"),data[3]);
            compareResult(response.jsonPath().getString("coords").replaceAll(" ",""),data[2]);
        }catch(Exception e){

            repo.reportInfo(data[0]);
            repo.reportFail("The Test failed without a response::"+e.getMessage());
            //softAssert.fail("The Test failed without a response::"+e.getMessage());
        }
    }

    @Test(groups = {"cleaning-positive"},dataProvider = "decimalPatches",dataProviderClass = PositiveDataProviders.class)
    public void decimalPatchesTest(String[] data){

        Response response=null;
        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .extract().response();

            compareResult(response.jsonPath().getString("patches"),data[3]);
            compareResult(response.jsonPath().getString("coords").replaceAll(" ",""),data[2]);
        }catch(Exception e){

            repo.reportInfo(data[0]);
            repo.reportFail("The Test failed without a response::"+e.getMessage());
            //softAssert.fail("The Test failed without a response::"+e.getMessage());
        }
    }


    private void compareResult(String actual, String expected) {
         if(expected.equalsIgnoreCase(actual)){
             repo.reportPass("Actual::"+actual+" matches with the expected::"+expected);

         }else{
             repo.reportFail("Actual::"+actual+" does matches with the exepected - Run Again ::"+expected);
         }
    }

}
