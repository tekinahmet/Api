package youtube_test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import youtube_JsonPlaceHolderTestData.JsonPlaceHolderTestData;
import youtube_base_url_store.JsonPlaceHolder_BaseURL;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class BaseURL_TestData extends JsonPlaceHolder_BaseURL {
/*
{
"userId": 3,
"id": 22,
"title": "dolor sint quo a velit explicabo quia nam",
"body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
}
*/
    @Test
    public void test(){

//      Set the Url
        specJson.pathParam("pp1", 22);

//      Set the Expected Data
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();

        JSONObject expBody = jsonPlaceHolderTestData.expectedData();
//        System.out.println("expBody = " + expBody);

//      Send Request And Get Response
        Response response = given().spec(specJson).when().get("{pp1}");
        response.prettyPrint();

//      Do Assertions
        JsonPath respJSsonPath = response.jsonPath();

        assertEquals(jsonPlaceHolderTestData.successStatusCode, response.getStatusCode());
        assertEquals(expBody.getInt("userId"), respJSsonPath.getInt("userId"));
        assertEquals(expBody.getInt("id"), respJSsonPath.getInt("id"));
        assertEquals(expBody.getString("title"), respJSsonPath.getString("title"));
        assertEquals(expBody.getString("body"), respJSsonPath.getString("body"));


    }
}
