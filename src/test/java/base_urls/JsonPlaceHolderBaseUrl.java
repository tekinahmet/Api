package base_urls;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
public class JsonPlaceHolderBaseUrl {
    protected RequestSpecification spec;
    @Before  // This method will work before @Test annotation
    public void setUp(){
        String baseUrl = "https://jsonplaceholder.typicode.com";
        spec = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .addHeader("token","1234")
                .setContentType(ContentType.JSON)
                .build();
    }
}