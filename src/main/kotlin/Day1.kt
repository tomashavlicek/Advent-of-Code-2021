import java.io.File

val depths = File("src/main/resources/input_day_1")
    .readText()
    .split("\n")
    .map { it.toInt() }

fun main() {
    println(solvePart1())
    println(solvePart2())
}

private fun solvePart2(): Int {
    val sums = depths.windowed(3, partialWindows = false) { it.sum() }
    return (0 until sums.lastIndex).count { sums[it] < sums[it + 1] }
}

private fun solvePart1(): Int = (0 until depths.lastIndex).count { index: Int -> depths[index] < depths[index + 1] }