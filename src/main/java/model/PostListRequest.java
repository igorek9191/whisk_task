package model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostListRequest {
    private String name;
    private boolean primary;
}
