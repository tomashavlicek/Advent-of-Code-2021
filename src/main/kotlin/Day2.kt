import java.io.File

val course = File("src/main/resources/input_day_2")
    .readText()
    .split("\n")

fun main() {
    val position1 = solvePart1()
    println("SolvePart1: ${position1.first * position1.second}")

    val position2 = solvePart2()
    println("SolvePart2: ${position2.first * position2.second}")
}

private fun solvePart2(): Pair<Int, Int> {
    var horizontalPosition = 0
    var depth = 0
    var aim = 0
    for (instruction in course) {
        val (command, modify) = instruction.split(" ", limit = 2)
        val modifyValue = modify.toInt()
        when (command) {
            "forward" -> {
                horizontalPosition += modifyValue
                depth += aim * modifyValue
            }
            "up" -> aim -= modifyValue
            "down" -> aim += modifyValue
        }
    }
    return Pair(horizontalPosition, depth)
}

private fun solvePart1(): Pair<Int, Int> {
    var horizontalPosition = 0
    var depth = 0
    for (instruction in course) {
        val (command, modify) = instruction.split(" ", limit = 2)
        val modifyValue = modify.toInt()
        when (command) {
            "forward" -> horizontalPosition += modifyValue
            "up" -> depth -= modifyValue
            "down" -> depth += modifyValue
        }
    }
    return Pair(horizontalPosition, depth)
}
