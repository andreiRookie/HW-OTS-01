import kotlin.random.Random
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

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

    fun List<Person>.ageDescendingSort(): List<Person> {
        return this.sortedByDescending {  it.age }
    }

    fun List<Person>.alphabeticSort(): List<Person> {
        val comparator = Comparator<Person> { o1, o2 ->
            if (o1.name == o2.name) {
                compareValues(o1.surname, o2.surname)
            } else {
                compareValues(o1.name, o2.name)
            }
        }
        return this.sortedWith(comparator)
    }


    val personList = listOf<Person>(
        Person("Ivan", "Pertov", 35),
        Person("Petr", "Ivanov", 30),
        Person("Pavel", "Sidorov", 27),
        Person("Sergei", "Pavlov", 47),
        Person("Artem", "Sergeev", 52),
        Person("Ivan", "Andreev", 21),
        Person("Anton", "Sidorov", 41),
        Person("Anton", "Barinov", 32),
        Person("Andrei", "Barinov", 28),
    )


    println(personList.ageDescendingSort())
    println(personList.alphabeticSort())



}