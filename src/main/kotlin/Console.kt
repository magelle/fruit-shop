import fruits.Shop
import java.util.*

fun main(args : Array<String>) {
    val shop = Shop()
    val console = Scanner(System.`in`)
    while(true) {
        val text = console.nextLine()
        text.split(",").forEach { shop.add(it) }
        println(shop.sum())
    }
}