import java.io.File

private val input = File("src/main/resources/input_day_3")
    .readText()
    .split("\n")

private val comparator: Comparator<Map.Entry<Char, Int>> = compareBy({ it.value }, { it.key })
private fun String.invertBinaryString() = this.map { if (it == '0') '1' else '0' }.joinToString("")

fun main() {
    solvePart1()
    solvePart2()
}

private fun solvePart2() {

    val ox = input.toMutableList()
    val co2 = input.toMutableList()

    for (position in 0 until input.first().length) {
        val mostCommon = ox.groupingBy { it[position] }.eachCount().entries.maxWithOrNull(comparator)
        val leastCommon = co2.groupingBy { it[position] }.eachCount().entries.minWithOrNull(comparator)
        ox.retainAll { it[position] == mostCommon!!.key }
        co2.retainAll { it[position] == leastCommon!!.key }
    }

    println(ox.single().toInt(2) * co2.single().toInt(2))
}

private fun solvePart1() {
    var gammaBits = ""

    for (position in 0 until input.first().length) {
        val mostCommon = input.groupingBy { it[position] }.eachCount().entries.maxWithOrNull(comparator)
        gammaBits += mostCommon!!.key
    }

    val epsilonBits = gammaBits.invertBinaryString()


    println(gammaBits.toInt(2) * epsilonBits.toInt(2))
}