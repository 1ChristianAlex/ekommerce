package store.com.application.catalog.port.dto

import store.com.adapter.`in`.http.controller.catalog.dto.ProductImageInputDto
import store.com.adapter.`in`.http.controller.catalog.dto.ProductImageOutputDto
import store.com.application.core.BaseDtoMapper
import store.com.domain.catalog.model.ProductImage

abstract class ProductImagesDtoMapper : BaseDtoMapper<ProductImageInputDto, ProductImageOutputDto, ProductImage>() {
}