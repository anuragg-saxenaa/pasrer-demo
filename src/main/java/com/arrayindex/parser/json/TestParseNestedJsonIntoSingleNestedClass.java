package com.arrayindex.parser.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

public class TestParseNestedJsonIntoSingleNestedClass {
    public static void main(String[] args) {
        List<EventList.EventDetails> anyCity = findEventByCity("any city");
        anyCity.stream().forEach(p-> {
            System.out.println(p);
        });

    }

    @SneakyThrows
    static List<EventList.EventDetails> findEventByCity(String city) {
        ObjectMapper objectMapper = new ObjectMapper();
        EventList eventList = objectMapper.readValue(new File("src/main/java/com/arrayindex/parser/json/test.json"), EventList.class);
        List<EventList.EventDetails> eventsList = eventList.getEvents().getEventsList();
        return eventsList;
    }

    }



