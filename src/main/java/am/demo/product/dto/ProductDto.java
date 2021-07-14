package am.demo.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ProductDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CreatingDto {
        private String title;
        private String description;
        private float price;
        private Integer discount;
        private Long categoryId;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PreviewDto {
        private String title;
        private String description;
        private float price;
        private Integer discount;
        private Long categoryId;
    }
}