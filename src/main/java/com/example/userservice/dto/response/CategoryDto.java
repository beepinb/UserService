package com.example.userservice.dto.response;

import java.util.List;

public class CategoryDto {
    private Long id;
    private String name;
    private Long parentId;
    private CategoryDto parent;
    private List<ProductDTO> products;
}