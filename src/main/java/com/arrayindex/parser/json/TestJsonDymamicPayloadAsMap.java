package com.arrayindex.parser.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

public class TestJsonDymamicPayloadAsMap {

    private static String json = "{\n" +
            "  \"name\":\"Workflow\",\n" +
            "  \"actions\": [\n" +
            "    {\n" +
            "      \"name\": \"EDIT_PROPERTY\",\n" +
            "      \"payload\": {\n" +
            "        \"name\": \"city\",\n" +
            "        \"value\": \"Pune\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\":\"SEND_EMAIL\",\n" +
            "      \"payload\":{\n" +
            "        \"from\":\"no-reply@yaho.com\",\n" +
            "        \"to\":\"alpesh@yahoo.com\",\n" +
            "        \"subject\":\"Try email\",\n" +
            "        \"body\":\"content\"\n" +
            "      }\n" +
            "    },\n" +
            "    {\n" +
            "      \"name\":\"CREATE_TASK\",\n" +
            "      \"payload\":{\n" +
            "        \"user\":1,\n" +
            "        \"type\":\"call\",\n" +
            "        \"status\":\"open\",\n" +
            "        \"note\":\"This is  note content\"\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        Event event = objectMapper.readValue(json, Event.class);
        System.out.println(event);

    }


}


