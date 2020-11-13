package space.harbour.java.hw4;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

public class ExampleValue implements Jsonable {
    public Integer myInt = 10;
    private String myString = "ABC";
    protected float myFloat = .9f;
    private InsideClass hiddenClass = new InsideClass();

    class InsideClass implements Jsonable {
        String myString = "XYZ";
        Integer myInt = 1050;

        @Override
        public JsonObject toJsonObject() {
            return Json.createObjectBuilder()
                    .add("myString", myString)
                    .add("myInt", myInt)
                    .build();
        }

        @Override
        public String toJsonString() {
            return toJsonObject().toString();
        }
    }

    @Override
    public JsonObject toJsonObject() {
        return Json.createObjectBuilder()
                .add("myInt", myInt)
                .add("myString", myString)
                .add("myFloat", myFloat)
                .add("hiddenClass", hiddenClass.toJsonObject())
                .build();
    }

    @Override
    public String toJsonString() {
        return toJsonObject().toString();
    }

    public void fromJson(String json) {
        JsonReader reader = Json.createReader(new StringReader(json));
        JsonObject jsonObject = reader.readObject();
        this.myInt = jsonObject.getInt("myInt");
        this.myString = jsonObject.getString("myString");
        this.myFloat = (float) jsonObject.getJsonNumber("myFloat").doubleValue();

        this.hiddenClass = new InsideClass();
        //this.hiddenClass.fromJson(jsonObject.getJsonObject("hiddenClass").toString());
    }

    public static void main(String... args) {
        ExampleValue value = new ExampleValue();
        System.out.println(value.toJsonString());
    }
}
