package am.demo.product.controller;

import am.demo.product.dto.CategoryDto;
import am.demo.product.dto.ProductDto;
import am.demo.product.entity.Product;
import am.demo.product.repository.CategoryRepository;
import am.demo.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/products/")
@AllArgsConstructor
public class ProductController {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @PostMapping
    @Transactional
    public ProductDto.PreviewDto createProduct(@RequestBody ProductDto.CreatingDto dto) {
        Product product = modelMapper.map(dto, Product.class);
        product.setCategory(categoryRepository.getById(dto.getCategoryId()));
        product = repository.save(product);
        return ProductDto.PreviewDto.builder()
                .categoryId(product.getCategory().getId())
                .price(product.getPrice())
                .discount(product.getDiscount())
                .build();
    }

    @GetMapping
    public Set<Product> getProducts() {
        return new HashSet<>(repository.findAll());
    }

    @GetMapping("category")
    @Transactional
    public Set<CategoryDto.PreviewDto> getCategories() {
        return categoryRepository.findAll().stream()
                .map(c -> CategoryDto.PreviewDto.builder()
                        .id(c.getId())
                        .name(c.getName())
                        .categoryId(c.getParentCategory() != null ? c.getParentCategory().getId() : null)
                        .build()).collect(Collectors.toSet());
    }
}