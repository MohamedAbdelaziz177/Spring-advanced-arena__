package com.abdelaziz26.aop;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {

    @NotNull
    private Long id;

    @Size(min = 5, max = 10)
    @NotBlank
    private String name;

    @Range(min = 10, max = 1000)
    @NotNull
    private Double price;

    private String description;
}
