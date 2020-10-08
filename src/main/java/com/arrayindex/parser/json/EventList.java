package com.arrayindex.parser.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Data
public class EventList {

    @Getter
    @JsonProperty("_embedded")
    private Events events;




    @Data
    public static class Venue {
        @JsonProperty("name")
        public String name;
    }

    @Data
    public static class Classification {
        @JsonProperty("name")
        public String name;
    }

    @Data
    public static class Embedded2 {
        @JsonProperty("venues")
        public List<Venue> venues;
    }

    @Data
    public static class Dates {
        @JsonProperty("start")
        public Start start;
        @JsonProperty("classifications")
        public List<Classification> classifications;
        @JsonProperty("_embedded")
        public Embedded2 _embedded;
    }

    @Data
    public static class EventDetails {
        @JsonProperty("name")
        public String name;
        @JsonProperty("dates")
        public Dates dates;
    }

    @Data
    public static class Events {
        @JsonProperty("events")
        public List<EventDetails> eventsList;
    }

    @Data
    public static class Start {
        @JsonProperty("dateTime")
        public Date dateTime;
    }


}
