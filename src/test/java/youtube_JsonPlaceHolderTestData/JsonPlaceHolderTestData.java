package youtube_JsonPlaceHolderTestData;

import org.json.JSONObject;

public class JsonPlaceHolderTestData {
    public int successStatusCode = 200;
    public JSONObject expectedData(){

        JSONObject body = new JSONObject();

        body.put("userId", 3);
        body.put("id", 22);
        body.put("title", "dolor sint quo a velit explicabo quia nam");
        body.put("body", "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return body;
    }
}
