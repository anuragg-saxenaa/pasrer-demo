package com.arrayindex.parser.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

@Slf4j
public class ParseNestedJsonTest {

    public static void main(String[] args) {
        String jsonResponse = "{\n" +
                "    \"expand\": \"schema,names\",\n" +
                "    \"startAt\": 0,\n" +
                "    \"maxResults\": 50,\n" +
                "    \"total\": 37875,\n" +
                "     \"issues\": [\n" +
                "            {\n" +
                "                \"id\": \"1190\",\n" +
                "                \"key\": \"GDS-81\",\n" +
                "                \"fields\": {\n" +
                "                    \"issuetype\": {\n" +
                "                        \"id\": \"2170\",\n" +
                "                        \"name\": \"Service Request with Approvals\",\n" +
                "                        \"subtask\": false\n" +
                "                    },\n" +
                "                    \"customfield_29805\": {\n" +
                "                        \"id\": \"26\",\n" +
                "                        \"name\": \"Issue - First Response\",\n" +
                "                        \"completedCycles\": []\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "     }";

        JsonObject object = (JsonObject) new JsonParser().parse(jsonResponse);
        JsonArray issuesArray = object.getAsJsonArray("issues");
        String expand = object.get("expand").toString();
        String startAt = object.get("startAt").toString();
        String maxResults = object.get("maxResults").toString();
        String total = object.get("total").toString();
        System.out.println(String.format("expand %s , startAt %s, maxResults %s, total %s", expand, startAt, maxResults, total));
        IntStream.range(0, issuesArray.size()).mapToObj(i -> (JsonObject) issuesArray.get(i)).forEach(currentissues -> {
            String Issue_Id = (String) currentissues.get("id").toString().replace("\"", "");
            String Issue_Key = (String) currentissues.get("key").toString().replace("\"", "");
            String Issue_Type = (String) currentissues.get("fields").getAsJsonObject().get("issuetype").getAsJsonObject().get("name").getAsString();
            JsonObject customfield = (JsonObject) currentissues.get("fields").getAsJsonObject().get("customfield_29805");
            JsonArray completedCyclesArray = customfield.getAsJsonArray("completedCycles");
            String Issue_FirstResponseStartTime = (completedCyclesArray.size() > 0) ? completedCyclesArray.getAsString() : "NULL";
            System.out.println(String.format("Issue_Id %s , Issue_Key %s, Issue_Type %s, Issue_FirstResponseStartTime %s", Issue_Id, Issue_Key, Issue_Type, Issue_FirstResponseStartTime));
        });

    }
}
