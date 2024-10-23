package store.com.application.catalog.port.usecase

import store.com.adapter.`in`.http.controller.catalog.dto.ProductOutputDto
import store.com.application.core.BaseUseCase

abstract class GetProductListUseCase : BaseUseCase<Unit, List<ProductOutputDto>>()