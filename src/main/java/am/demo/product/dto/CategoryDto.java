package am.demo.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CategoryDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PreviewDto {
        private Long id;
        private Long categoryId;
        private String name;
    }
}
