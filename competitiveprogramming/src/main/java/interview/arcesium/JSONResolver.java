package interview.arcesium;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


class Result {

    public static final String JSON_URL = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
    public static final String ID_FIELD = "id";
    public static final String DOT_SEPARATOR = "\\.";
    public static final String COMMA_SEPARATOR = ",";

    public static List<Integer> apiResponseParser(List<String> inputList, int size) throws IOException {
        List<Integer> result = new ArrayList<>();
        if (null != inputList
                && inputList.size() == size) {
            JsonElement jsonElement = getJSONFromUrl();
            SearchCondition condition = getSearchCondition(inputList);
            filterSearchCriteria(result, jsonElement, condition);
        }
        if (result.isEmpty()) {
            result.add(-1);
        }
        return result;
    }

    private static void filterSearchCriteria(List<Integer> result, JsonElement jsonElement, SearchCondition condition) {
        jsonElement.getAsJsonArray()
                .forEach(e -> {
                    JsonObject jsonObject = e.getAsJsonObject();
                    int id = jsonObject.get(ID_FIELD).getAsInt();

                    //find nested json element
                    String[] fields = condition.field.split(DOT_SEPARATOR);
                    JsonElement fieldElement = getFinalJsonElement(jsonObject, fields);

                    //if filter is successful set id
                    if (filterByOperator(condition, fieldElement)) {
                        result.add(id);
                    }
                });
    }

    private static JsonElement getFinalJsonElement(JsonObject jsonObject, String[] fields) {
        JsonElement finalElement = null;
        for (String field : fields) {
            if (jsonObject.has(field)) {
                finalElement = jsonObject.get(field);
                if (finalElement.isJsonObject()) {
                    jsonObject = finalElement.getAsJsonObject();
                }
            }
        }
        return finalElement;
    }

    private static boolean filterByOperator(SearchCondition condition, JsonElement element) {
        //actual data from json
        String dataForField = Optional.ofNullable(element).map(JsonElement::getAsString).orElse("");
        switch (condition.operator.toUpperCase()) {
            case "EQUALS":
            case "IN":
                return condition.values.stream().
                        anyMatch(dataForField::equalsIgnoreCase);
            case "NOT EQUALS":
            case "NOT IN":
                return condition.values.stream().
                        noneMatch(dataForField::equalsIgnoreCase);
            case "LIKE":
                return condition.values.stream().
                        anyMatch(dataForField::contains);
            case "NOT LIKE":
                return condition.values.stream().
                        noneMatch(dataForField::contains);
        }
        return false;
    }

    private static SearchCondition getSearchCondition(List<String> inputList) {
        List<String> values = Arrays.stream(inputList.get(2).split(COMMA_SEPARATOR)).collect(Collectors.toList());
        return new SearchCondition(inputList.get(0), inputList.get(1), values);
    }

    public static JsonElement getJSONFromUrl() throws IOException {
        JsonElement jsonElement = null;
        URL url = new URL(JSON_URL);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            jsonElement = JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonElement;
    }

}

class User {
    public Integer id;
    public String name;
    public String username;
    public String email;
    public Address address;
    public String website;
    public Company company;

}

class Address {
    public String street;
    public String suite;
    public String city;
    public String zipcode;
    public GeoLocation geo;
}

class Company {
    public String name;
    public String basename;
}

class GeoLocation {
    public String lat;
    public String lng;

}

class SearchCondition {
    public String field;
    public String operator;
    public List<String> values;

    public SearchCondition(String field, String operator, List<String> values) {
        this.field = field;
        this.operator = operator;
        this.values = values;
    }
}

public class JSONResolver {
    public static void main(String[] args) throws IOException {
        var input = new ArrayList<String>();
        input.add("address.geo.lng");
        input.add("NOT IN");
        input.add("91.1496");

        List<Integer> result = Result.apiResponseParser(input, 3);
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }
}
