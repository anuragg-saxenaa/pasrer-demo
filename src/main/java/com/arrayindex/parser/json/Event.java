package com.arrayindex.parser.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Event {
    public String name;
    public List<Action> actions;


    @Data
    public static class Action {
        public String name;
        Map<String, Object> payload;
    }


}
