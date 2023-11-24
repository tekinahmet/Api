package youtube_base_url_store;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuappBaseURL {
    protected RequestSpecification specHerokuapp;
    @Before
    public void setup(){
        specHerokuapp = new RequestSpecBuilder().
                setBaseUri("https://restful-booker.herokuapp.com").
                build();
    }
}
