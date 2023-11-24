package youtube_base_url_store;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolder_BaseURL {
    protected RequestSpecification specJson;
    @Before
    public void setUp(){
        specJson = new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com/posts").
                build();
    }
}
