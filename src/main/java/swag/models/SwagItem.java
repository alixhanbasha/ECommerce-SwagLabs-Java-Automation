package swag.models;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.AllArgsConstructor;
import lombok.Data;
import swag.Utils;

import java.io.IOException;

@Data
@AllArgsConstructor
public class SwagItem {

    private String title;
    private String description;
    private String price;
    private String tax;

    public static SwagItem getItemFromDataStore(String key) throws IOException {
        JsonObject data = JsonParser.parseString(
                Utils.readFile("src/test/resources/datastore/items.json")
        ).getAsJsonObject();

        return new Gson().fromJson(data.getAsJsonObject(key), SwagItem.class);
    }
}
