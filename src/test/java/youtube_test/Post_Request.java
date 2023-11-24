package youtube_test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post_Request {
    @Test
    public void post(){
//        request url and body
        String url = "https://jsonplaceholder.typicode.com/posts";
        JSONObject reqBody = new JSONObject();
        reqBody.put("title", "API");
        reqBody.put("body", "API öğrenmek ne güzel");
        reqBody.put("userId", 10);

//        expected data
        JSONObject expBody = new JSONObject();
        expBody.put("title", "API");
        expBody.put("body", "API öğrenmek ne güzel");
        expBody.put("userId", 10);

//        save response
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(reqBody.toString()).
                post(url);
//        response.prettyPrint();

        JsonPath actBody = response.jsonPath();

//        Assertion

        response.
                then().
                assertThat().
                statusCode(201).
                contentType(ContentType.JSON);

        Assert.assertEquals(expBody.get("title"), actBody.get("title"));
        Assert.assertEquals(expBody.get("body"), actBody.get("body"));
        Assert.assertEquals(expBody.get("userId"), actBody.get("userId"));
    }
}
