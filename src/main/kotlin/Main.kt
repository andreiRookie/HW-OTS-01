import kotlin.random.Random

const val SIZE = 100

fun main() {

    val list = List(SIZE) { Random.nextInt(0, SIZE)}

    println(list)

    val handledList = list
        .filter { it % 2 ==0 }
        .slice(10 until 20)
        .map { it + 1 }
        .sum()

    println(handledList)

}