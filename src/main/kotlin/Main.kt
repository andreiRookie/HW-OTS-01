import kotlin.random.Random

const val SIZE = 100

fun main() {

    val list = List(SIZE) { Random.nextInt(0, SIZE)}

    println("____list____")
    println(list)

    val handledList = list
        .filter { it % 2 == 0 }
        .slice(10 until 20)
        .sumOf { it + 1 }

    println("____handledList____")
    println(handledList)

    fun List<Person>.ageDescendingSort(): List<Person> {
        return this.sortedByDescending {  it.age }
    }

    fun List<Person>.alphabeticSort(): List<Person> {
        val comparator = Comparator<Person> { o1, o2 ->
            val namesComparison = compareValues(o1.name, o2.name)

            if (namesComparison == 0) {
                compareValues(o1.surname, o2.surname)
            } else {
                namesComparison
            }
        }
        return this.sortedWith(comparator)
    }


    val personList = listOf(
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


    println("____AgeDescendingSorted____")
    println(personList.ageDescendingSort())

    println("____AlphabeticSorted w my comparator by name/surname____")
    println(personList.alphabeticSort())

    println("____AlphabeticSorted using list.sortedWith(compareBy({name},{surname} )____")
    println(personList.sortedWith(compareBy( {person -> person.name}, {person-> person.surname})))


    fun getFunExecutionTime(action: () -> Unit): Long {
        val startTime = System.nanoTime()

        action()
        val endTime =System.nanoTime()

        return endTime - startTime
    }

    println("____getFunExecutionTime of personList.ageDescendingSort()____")
    println(getFunExecutionTime { personList.ageDescendingSort() })
    println("____getFunExecutionTime of my comparator by name/surname____")
    println(getFunExecutionTime { personList.alphabeticSort() })
    println("____getFunExecutionTime of list.sortedWith(compareBy({name},{surname} )____")
    println(getFunExecutionTime { (personList.sortedWith(compareBy( {person -> person.name}, {person-> person.surname} ))) })

}