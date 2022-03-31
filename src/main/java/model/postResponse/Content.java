package model.postResponse;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonAnySetter;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class Content {
    private Map<String, Object> details = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        details.put(key, value);
    }
}
