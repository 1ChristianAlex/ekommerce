package store.com.application.catalog.port.dto

import store.com.adapter.`in`.http.controller.catalog.dto.CategoryInputDto
import store.com.adapter.`in`.http.controller.catalog.dto.CategoryOutputDto
import store.com.application.core.BaseDtoMapper
import store.com.domain.catalog.model.Category

abstract class CategoryDtoMapper : BaseDtoMapper<CategoryInputDto, CategoryOutputDto, Category>() {
}