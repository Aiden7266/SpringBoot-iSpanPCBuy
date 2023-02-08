package com.ispan.pcbuy.controller;

import com.ispan.pcbuy.constant.ProductCategory;
import com.ispan.pcbuy.dto.*;
import com.ispan.pcbuy.model.Product;
import com.ispan.pcbuy.service.ProductService;
import com.ispan.pcbuy.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Valid
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            // 查詢條件 Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,

            //  排序 Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc")         String sort,

            //分頁 (要加@Valid註解才能使用@Min@Max)
            @RequestParam(defaultValue = "8") @Min(0) @Max(100) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0)           Integer offset
    ){
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category);
        productQueryParams.setSearch(search);
        productQueryParams.setOrderBy(orderBy);
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        //取得 product list
        List<Product> productList = productService.getProducts(productQueryParams);

        //取得 product 總數
        Integer total = productService.countProduct(productQueryParams);

        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResult(productList);

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){

        Product product = productService.getProductById(productId);
        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<Product>> getProductsFromCategory(
            @PathVariable(required = true) String category){
        System.out.println("我是Category = " + category);
        List<Product> productList = productService.getProductsFromCategory(category);
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping("/products/MB")
    public ResponseEntity<List<Product>> getMbBySocket(
            @RequestParam(required = true) String socket){
        System.out.println("我是Socket = " + socket);
        List<Product> productList = productService.getMbBySocket(socket);
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @PostMapping("/products")
    public  ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){
        Integer productId = productService.createProduct(productRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PostMapping("/products/CPU")
    public  ResponseEntity<Product> createProduct(@RequestBody @Valid CpuRequest cpuRequest){
            Integer productId = productService.createProduct(cpuRequest);
            Product product = productService.getProductById(productId);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PostMapping("/products/DRAM")
    public  ResponseEntity<Product> createProduct(@RequestBody @Valid DramRequest dramRequest){
        Integer productId = productService.createProduct(dramRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PostMapping("/products/MB")
    public  ResponseEntity<Product> createProduct(@RequestBody @Valid MbRequest mbRequest){
        Integer productId = productService.createProduct(mbRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PostMapping("/products/GPU")
    public  ResponseEntity<Product> createProduct(@RequestBody @Valid GpuRequest gpuRequest){
        Integer productId = productService.createProduct(gpuRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PostMapping("/products/COOLER")
    public  ResponseEntity<Product> createProduct(@RequestBody @Valid CoolerRequest coolerRequest){
        Integer productId = productService.createProduct(coolerRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PostMapping("/products/STORAGE")
    public  ResponseEntity<Product> createProduct(@RequestBody @Valid StorageRequest storageRequest){
        Integer productId = productService.createProduct(storageRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PostMapping("/products/POWER")
    public  ResponseEntity<Product> createProduct(@RequestBody @Valid PowerRequest powerRequest){
        Integer productId = productService.createProduct(powerRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @PostMapping("/products/CASE")
    public  ResponseEntity<Product> createProduct(@RequestBody @Valid CaseRequest caseRequest){
        Integer productId = productService.createProduct(caseRequest);
        Product product = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid CpuRequest cpuRequest){
        Product product = productService.getProductById(productId);

        if(product != null) {
            productService.updateProduct(productId, cpuRequest);
            Product updatedProduct = productService.getProductById(productId);
            return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){

        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
