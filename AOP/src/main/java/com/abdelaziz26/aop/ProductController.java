package com.abdelaziz26.aop;

import com.abdelaziz26.aop.Annotations.AbdelazizLogger;
import com.abdelaziz26.aop.Annotations.AbdelazizValidator;
import com.abdelaziz26.aop.Annotations.EnsureHeIsAbdelaziz;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @AbdelazizLogger
    @AbdelazizValidator
    @PostMapping
    public void addProduct(@RequestBody Product productRequest) {
        DbStore.products.add(productRequest);
    }

    @AbdelazizLogger
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(DbStore.products);
    }

    @AbdelazizLogger
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        return ResponseEntity.ok(DbStore
                .products
                .stream()
                .filter(p -> p.getId().equals(id))
                .findFirst().orElse(new Product()));
    }

    @AbdelazizLogger
    @EnsureHeIsAbdelaziz
    //@EnsureHeIsAbdelaziz(secret = "Samir")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@RequestParam String username, @PathVariable Long id) {
        DbStore.products.removeIf(p -> p.getId().equals(id));
        return ResponseEntity.ok().build();
    }
}
