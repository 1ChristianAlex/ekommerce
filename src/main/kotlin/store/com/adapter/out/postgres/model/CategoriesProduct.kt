package store.com.adapter.out.postgres.model


object CategoriesProductTable : BaseTable("catalog.categories_products") {
    val product = reference("productId", ProductTable)
    val categories = reference("categoryId", CategoriesTable)
}
