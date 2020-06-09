package controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerMapper {

    private static final Map<String, Controller> MAPPER = new HashMap<>();

    static {
        MAPPER.put("/user/create", new UserCreateController());
    }

    public Controller findController(String path) {
        return MAPPER.get(path);
    }
}