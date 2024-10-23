package store.com.application.catalog.usecase

import store.com.adapter.`in`.http.controller.catalog.dto.ProductOutputDto
import store.com.application.catalog.port.dto.ProductDtoMapper
import store.com.application.catalog.port.usecase.GetProductListUseCase
import store.com.domain.catalog.service.ProductService

class GetProductListUseCaseImpl(
    private val productService: ProductService,
    private val productDtoMapper: ProductDtoMapper
) : GetProductListUseCase() {
    override suspend fun internalExecute(inputData: Unit): List<ProductOutputDto> {
        return productService.listProducts().map { productDtoMapper.toDto(it) }
    }

    override fun useCaseDescription(): String {
        return "Get product list"
    }
}