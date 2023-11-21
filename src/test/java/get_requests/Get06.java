package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.is;

public class Get06 extends HerOkuAppBaseUrl {
        /*
        Given
            https://restful-booker.herokuapp.com/booking/11
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
                        {
                            "firstname": "John",
                            "lastname": "Smith",
                            "totalprice": 111,
                            "depositpaid": true,
                            "bookingdates": {
                                "checkin": "2018-01-01",
                                "checkout": "2019-01-01"
                            },
                            "additionalneeds": "Breakfast"
                        }
     */


    @Test
    public void get(){
       //i) Set the Url
        spec.pathParams("first","booking"
                    ,"second",41);

       //ii) Set the Expected Data
       //iii) Send Request And Get Response
        Response response = given(spec).when().get("{first}/{second}");   //  "{}/{}/{}"
        response.prettyPrint();
       //iv)  Do Assertions

        // First Way:
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",is("Josh")
                ,"lastname",is("Allen")
                ,"totalprice",is(111)
                ,"depositpaid",is(true)
                ,"bookingdates.checkin",is("2018-01-01")
                ,"bookingdates.checkout", is("2019-01-01")
                ,"additionalneeds",is("midnight snack"));


        // Second Way: -----> JsonPath ----> It helps you to work with body as you wish.
        // First you need to change response to JsonPath data format and save it as a variable
        JsonPath json = response.jsonPath();
        System.out.println("json.getInt(\"totalprice\") = " + json.getInt("totalprice"));
        System.out.println("json.getBoolean(\"depositpaid\") = " + json.getBoolean("depositpaid"));
        System.out.println("json.getString(\"bookingdates.checkin\") = " + json.getString("bookingdates.checkin"));
        System.out.println("json.getString(\"firstname\") = " + json.getString("firstname"));

        assertEquals("Josh",json.getString("firstname"));
        assertEquals("Allen",json.getString("lastname"));
        assertEquals(111,json.getInt("totalprice"));
        assertEquals(true,json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        assertEquals("midnight snack",json.getString("additionalneeds"));

        // Home Work :
        //  Do Assertion with soft Assertion -----> Soft assertion can be done by TestNg Library
        // There are three steps to make TestNg Softassert:
        //1st Create SoftAssert object:
        SoftAssert softAssert = new SoftAssert();
        // 2nd Do assertions by softAssert object:
        softAssert.assertEquals(json.getString("firstname"),"John");
        softAssert.assertEquals(json.getString("lastname"),"Smith");
        softAssert.assertEquals(json.getInt("totalprice"),111);
        softAssert.assertEquals(json.getBoolean("depositpaid"),true);
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01");
        softAssert.assertEquals(json.getString("bookingdates.checkout"),"2019-01-01");
        softAssert.assertEquals(json.getString("additionalneeds"),"Breakfast");
        // 3rd finish All assertions by assertAll() method
        softAssert.assertAll();


    }
}
