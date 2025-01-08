package org.kitri.system.dualdata;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DtoParser {
    public Map<String, String> parse(Object dto) {
        String toStringResult = dto.toString();
        Map<String, String> fieldMap = new HashMap<>();

        int start = toStringResult.indexOf("[");
        int end = toStringResult.lastIndexOf("]");
        if (start == -1 || end == -1) {
            throw new IllegalArgumentException("Invalid toString format: " + toStringResult);
        }

        String[] fields = toStringResult.substring(start + 1, end).split(", ");
        for (String field : fields) {
            String[] keyValue = field.split("=");
            fieldMap.put(keyValue[0], keyValue[1]);
        }
        return fieldMap;
    }
}
