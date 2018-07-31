package com.target.retail.controller

import com.blogspot.toomuchcoding.spock.subjcollabs.Collaborator
import com.blogspot.toomuchcoding.spock.subjcollabs.Subject
import com.target.retail.service.ProductsService
import reactor.core.publisher.Mono
import spock.lang.Specification


class ProductsControllerSpec extends Specification {

    @Subject
    ProductsController productsController

    @Collaborator
    ProductsService productsService

    def "test get products aggregates product and price details"() {
        given:
        String productId = 'some product id'
        Map productDetails = [
                product: [
                        item: [
                                product_description: [
                                        title: 'some title'
                                ]
                        ]
                ]
        ]

        Map expectedResult = [
                id: 'some product id',
                name: 'some title'
        ]

        when:
        Map actualResult = productsController.getProductAndPriceDetails(productId).block()

        then:
        1 * productsService.getProductDetails(productId) >> Mono.just(productDetails)

        actualResult == expectedResult
    }
}
