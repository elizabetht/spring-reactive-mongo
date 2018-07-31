package com.target.retail.controller

import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class ProductsController {


    Mono<Map> getProductAndPriceDetails(String productId) {
    }
}
