package store.com.application.catalog.port.dto

import store.com.adapter.`in`.http.controller.catalog.dto.BrandInputDto
import store.com.adapter.`in`.http.controller.catalog.dto.BrandOutputDto
import store.com.application.core.BaseDtoMapper
import store.com.domain.catalog.model.Brand

abstract class BrandDtoMapper : BaseDtoMapper<BrandInputDto, BrandOutputDto, Brand>() {
}