package store.com.application.catalog.port.dto

import store.com.adapter.`in`.http.controller.catalog.dto.ProductInputDto
import store.com.adapter.`in`.http.controller.catalog.dto.ProductOutputDto
import store.com.application.core.BaseDtoMapper
import store.com.domain.catalog.model.Product

abstract class ProductDtoMapper : BaseDtoMapper<ProductInputDto, ProductOutputDto, Product>() {
}