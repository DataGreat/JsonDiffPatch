package de.recus.jsonDiff;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

class Diff {
    private final Operation operation;
    private final List<Object> path;
    private final JsonNode value;
    private List<Object> toPath; //only to be used in move operation

    Diff(Operation operation, List<Object> path, JsonNode value) {
        this.operation = operation;
        this.path = path;
        this.value = value;
    }

    Diff(Operation operation, List<Object> fromPath, List<Object> toPath) {
        this.operation = operation;
        this.path = fromPath;
        this.toPath = toPath;
        this.value = null;
    }

    public Operation getOperation() {
        return operation;
    }

    public List<Object> getPath() {
        return path;
    }

    public JsonNode getValue() {
        return value;
    }

    public static Diff generateDiff(Operation replace, List<Object> path, JsonNode target) {
        return new Diff(replace, path, target);
    }

    List<Object> getToPath() {
        return toPath;
    }
}