package test.com.tests.cleaningsessions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.com.controller.Runner;
import test.com.data.cleaning.NegativeDataProviders;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class NegativeTests extends Runner {

    @BeforeTest
    public void setReporter(ITestContext context){

        repo.setTest(context.getCurrentXmlTest().getName());
    }

    @AfterTest
    public void flushReporter(){
        repo.getReports().endTest(repo.getTest());
        repo.getReports().flush();
    }




    @Test(groups = {"cleaning-negative"},dataProvider = "roomSizeNil",dataProviderClass = NegativeDataProviders.class)
    public void negative_RoomSize(String[] data){

        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)//over here as well we are verifying though
                    .extract().response();


            compareResult(response.getBody().asString(),data[2]);

        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("Exception occured while hitting the service :: "+e.getMessage());
            //softAssert.fail("The Test failed without a response::"+e.getMessage());
        }
    }

    @Test(groups = {"cleaning-negative"},dataProvider = "multiRoomDimension",dataProviderClass = NegativeDataProviders.class)
    public void multi_roomDimensions(String[] data){

        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)//over here as well we are verifying though
                    .extract().response();


            compareResult(response.getBody().asString(),data[2]);

        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("Exception occured while hitting the service :: "+e.getMessage());
            //softAssert.fail("The Test failed without a response::"+e.getMessage());
        }
    }

    @Test(groups = {"cleaning-negative"},dataProvider = "yOutsideRoom",dataProviderClass = NegativeDataProviders.class)
    public void position_Yaxis_GTRoom(String[] data){

        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .statusCode(HttpStatus.SC_CREATED)//over here as well we are verifying though
                    .extract().response();


            compareResult(response.getBody().asString(),data[2]);

        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("Exception occured while hitting the service :: "+e.getMessage() +" :: JSON"+data[0]);
            //softAssert.fail("The Test failed without a response::"+e.getMessage());
        }
    }

    @Test(groups = {"cleaning-negative"},dataProvider = "positionNegative",dataProviderClass = NegativeDataProviders.class)
    public void position_NegativeCoords(String[] data){

        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)//over here as well we are verifying though
                    .extract().response();


            compareResult(response.getBody().asString(),data[2]);

        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("Exception occured while hitting the service :: "+e.getMessage() +" :: JSON"+data[0]);
            //softAssert.fail("The Test failed without a response::"+e.getMessage());
        }
    }
    //validDataTypesPosition
    @Test(groups = {"cleaning-negative"},dataProvider = "validDataTypesPosition",dataProviderClass = NegativeDataProviders.class)
    public void invalid_PositionDataTypes(String[] data){

        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .statusCode(HttpStatus.SC_CREATED)//over here as well we are verifying though
                    .extract().response();


            compareResult(response.getBody().asString(),data[2]);

        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("Exception occured while hitting the service :: "+e.getMessage() +" :: JSON"+data[0]);
            //softAssert.fail("The Test failed without a response::"+e.getMessage());
        }
    }
    //roboAtMultiplePositions
    @Test(groups = {"cleaning-negative"},dataProvider = "roboAtMultiplePositions",dataProviderClass = NegativeDataProviders.class)
    public void robo_MultiplePositions(String[] data){

        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)//over here as well we are verifying though
                    .extract().response();


            compareResult(response.getBody().asString(),data[2]);

        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("Exception occured while hitting the service :: "+e.getMessage() +" :: JSON"+data[0]);
            //softAssert.fail("The Test failed without a response::"+e.getMessage());
        }
    }

    @Test(groups = {"cleaning-negative"},dataProvider = "pathAtTopRightCornerOfRoom",dataProviderClass = NegativeDataProviders.class)
    public void pathAtTopRightCornerOfRoom(String[] data){

        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .statusCode(HttpStatus.SC_BAD_REQUEST)//over here as well we are verifying though
                    .extract().response();


            compareResult(response.getBody().asString(),data[2]);

        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("Exception occured while hitting the service :: "+e.getMessage() +" :: JSON"+data[0]);
            //softAssert.fail("The Test failed without a response::"+e.getMessage());
        }
    }
    //robo_CannotClean_OutsideRoom
    @Test(groups = {"cleaning-negative"},dataProvider = "robo_CannotClean_OutsideRoom",dataProviderClass = NegativeDataProviders.class)
    public void robo_CannotClean_OutsideRoom(String[] data){

        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .post(data[1])
                    .then()
                    .statusCode(HttpStatus.SC_CREATED)//over here as well we are verifying though
                    .extract().response();


            compareResult(response.getBody().asString(),data[2]);

        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("Exception occured while hitting the service :: "+e.getMessage() +" :: JSON"+data[0]);
            //softAssert.fail("The Test failed without a response::"+e.getMessage());
        }
    }

    @Test(groups = {"cleaning-negative"},dataProvider = "timeStamp_InvalidTest",dataProviderClass = NegativeDataProviders.class)
    public void timeStamp_InvalidTest(String[] data){

        try {
            Response response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(data[0])
                    .when()
                    .get(data[1])
                    .then()
                    .statusCode(HttpStatus.SC_METHOD_NOT_ALLOWED)//over here as well we are verifying though
                    .extract().response();


            compareTimeStamp(response.jsonPath().getString("timestamp"));

        }catch(Exception e){
            //TestNG Reporter
            repo.reportFail("Exception occured while hitting the service :: "+e.getMessage() +" :: JSON"+data[0]);
            //softAssert.fail("The Test failed without a response::"+e.getMessage());
        }
    }

    private void compareTimeStamp(String timestamp) {
        String timeStampTime = timestamp.substring(timestamp.indexOf('T')+1,timestamp.indexOf('T')+6);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String timeNow = format.format(Calendar.getInstance().getTime());
        if(timeStampTime.equalsIgnoreCase(timeNow)){
            repo.reportPass("Actual::"+timeStampTime+" matches with the expected::"+timeNow);
        }else{
            repo.reportFail("Actual::"+timeStampTime+" does matches with the exepected - Run Again ::"+timeNow);
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
