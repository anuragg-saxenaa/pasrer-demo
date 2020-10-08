package com.arrayindex;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ParserApplicationTests {

	@Test
	void contextLoads() {

		String jsonResponse ="\"issues\": [\n" +
				"        {\n" +
				"            \"id\": \"1190\",\n" +
				"            \"key\": \"GDS-81\",\n" +
				"            \"fields\": {\n" +
				"                \"issuetype\": {\n" +
				"                    \"id\": \"2170\",\n" +
				"                    \"name\": \"Service Request with Approvals\",\n" +
				"                    \"subtask\": false\n" +
				"                },\n" +
				"                \"customfield_29805\": {\n" +
				"                    \"id\": \"26\",\n" +
				"                    \"name\": \"Issue - First Response\",\n" +
				"                    \"completedCycles\": []\n" +
				"                }\n" +
				"            }\n" +
				"        }\n" +
				"    ]";

		JsonObject object = (JsonObject) new JsonParser().parse(jsonResponse);
		JsonArray issuesArray = object.getAsJsonArray("issues");
		for(int i=0; i<issuesArray.size(); i++) {
			JsonObject currentissues = (JsonObject) issuesArray.get(i);
			String Issue_Id = (String) currentissues.get("id").toString().replace("\"", "");
			String Issue_Key =  (String) currentissues.get("key").toString().replace("\"", "");
			String Issue_Type = (String) currentissues.get("fields").getAsJsonObject().get("issuetype").getAsJsonObject().get("name").getAsString();
			JsonObject customfield = (JsonObject) currentissues.get("fields").getAsJsonObject().get("customfield_29805");
			JsonArray completedCyclesArray= customfield.getAsJsonArray("completedCycles");
			String Issue_FirstResponseStartTime = (completedCyclesArray.size() > 0) ? completedCyclesArray.getAsString() : "NULL";
		}

	}


}
