package comboCode

class Product(val id: Int, val name: String)

class Order(val id: Int, val productIds: List<Int>)

class Recommendation(val orders: List<Order>, val products: List<Product>) {
    private val coOccurrence = mutableMapOf<Int, MutableMap<Int, Int>>()

    fun train() {
        for (order in orders) {
            val ids = order.productIds
            for (i in ids.indices) {
                val productA = ids[i]
                for (j in ids.indices) {
                    val productB = ids[j]
                    if (i == j) continue

                    val innerMap = coOccurrence.getOrPut(productA) { mutableMapOf() }
                    innerMap[productB] = innerMap.getOrDefault(productB, 0) + 1
                }
            }

        }
    }

    fun getRecommendations(productId: Int): List<Product> {
        if (!coOccurrence.containsKey(productId)) {
            return emptyList()
        }

        val stats = coOccurrence[productId]!!
        val entries = stats.entries.toList()
        val sorted = entries.sortedByDescending { it.value }.take(3)

        val result = mutableListOf<Product>()
        for (entry in sorted) {
            val product = products.find { it.id == entry.key }
            if (product != null) {
                result.add(product)
            }
        }
        return result
    }
}

fun main() {
    val products = listOf(
        Product(1, "Молоко"),
        Product(2, "Хлеб"),
        Product(3, "Яйца"),
        Product(4, "Масло"),
        Product(5, "Сыр")
    )

    val orders = listOf(
        Order(1, listOf(1, 2, 3)),
        Order(2, listOf(1, 2)),
        Order(3, listOf(2, 3, 5)),
        Order(4, listOf(1, 3, 5)),
        Order(5, listOf(1, 5))
    )

    val recommender = Recommendation(orders, products)
    recommender.train()

    val recs = recommender.getRecommendations(1)
    println("Рекомендации для товара 'Молоко':")
    for (product in recs) {
        println("  - ${product.name}")
    }
}
