package fruits

class Shop {

    val prices = mapOf<String, FruitsType>(
            "pommes" to FruitsType.pommes,
            "apples" to FruitsType.pommes,
            "cerises" to FruitsType.cerises,
            "bananes" to FruitsType.bananes
    )

    val fruits = mutableMapOf<FruitsType, Int>()

    fun add(fruit: String) {
        if (prices.get(fruit) == null) return
        val fruitType = prices.get(fruit)
        if (fruitType == null) return
        fruits.put(fruitType, fruits.get(fruitType)?.plus(1)?:1)
    }

    fun sum() = fruits.map { it.key.priceFor(it.value) }.sum() - globalReduc()

    private fun globalReduc() = fruits.map { it.value }.sum().div(5) * 200

    private fun computePrice(it: Map.Entry<String, Int>): Int {
        val type = prices.get(it.key) ?: return 0
        return type.priceFor(it.value)
    }

    enum class FruitsType(private val comptePrice: (Int) -> Int) {
        pommes({times -> times * 100 - (200 * times.div(4))}),
        cerises({times -> times * 75 - (20 * times.div(2))}),
        bananes({times -> times * 150 - (150 * times.div(2))});

        fun priceFor(quantity: Int) = comptePrice(quantity)
    }

}