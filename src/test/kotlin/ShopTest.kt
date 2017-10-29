import fruits.Shop
import org.assertj.core.api.Assertions
import org.junit.Test

class ShopTest {

    @Test
    fun `add several fruits`() {
        val shop = Shop()
        shop.add("pommes")
        Assertions.assertThat(shop.sum()).isEqualTo(100)
        shop.add("pommes")
        Assertions.assertThat(shop.sum()).isEqualTo(200)
        shop.add("cerises")
        Assertions.assertThat(shop.sum()).isEqualTo(275)
        shop.add("bananes")
        Assertions.assertThat(shop.sum()).isEqualTo(425)
    }

    @Test
    fun `reduction on cerises`() {
        val shop = Shop()
        shop.add("cerises")
        Assertions.assertThat(shop.sum()).isEqualTo(75)
        shop.add("cerises")
        Assertions.assertThat(shop.sum()).isEqualTo(130)
    }

    @Test
    fun `reduction on bananes`() {
        val shop = Shop()
        shop.add("bananes")
        Assertions.assertThat(shop.sum()).isEqualTo(150)
        shop.add("bananes")
        Assertions.assertThat(shop.sum()).isEqualTo(150)
        shop.add("bananes")
        Assertions.assertThat(shop.sum()).isEqualTo(300)
        shop.add("bananes")
        Assertions.assertThat(shop.sum()).isEqualTo(300)
    }

    @Test
    fun `add translation`() {
        val shop = Shop()
        shop.add("cerises")
        Assertions.assertThat(shop.sum()).isEqualTo(75)
        shop.add("apples")
        Assertions.assertThat(shop.sum()).isEqualTo(175)
        shop.add("cerises")
        Assertions.assertThat(shop.sum()).isEqualTo(230)
        shop.add("bananes")
        Assertions.assertThat(shop.sum()).isEqualTo(380)
        shop.add("bananes")
        Assertions.assertThat(shop.sum()).isEqualTo(180)
    }

    @Test
    fun `reduction on apples`() {
        val shop = Shop()
        shop.add("pommes")
        Assertions.assertThat(shop.sum()).isEqualTo(100)
        shop.add("pommes")
        Assertions.assertThat(shop.sum()).isEqualTo(200)
        shop.add("apples")
        Assertions.assertThat(shop.sum()).isEqualTo(300)
        shop.add("apples")
        Assertions.assertThat(shop.sum()).isEqualTo(200)
    }

    @Test
    fun `reduction on five fruits`() {
        val shop = Shop()
        shop.add("pommes")
        Assertions.assertThat(shop.sum()).isEqualTo(100)
        shop.add("pommes")
        Assertions.assertThat(shop.sum()).isEqualTo(200)
        shop.add("apples")
        Assertions.assertThat(shop.sum()).isEqualTo(300)
        shop.add("cerises")
        Assertions.assertThat(shop.sum()).isEqualTo(375)
        shop.add("bananes")
        Assertions.assertThat(shop.sum()).isEqualTo(525 - 200)
    }

}

