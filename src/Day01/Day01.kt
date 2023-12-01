package Day01

import println
import readInput

const val DAY = "01";
fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day${DAY}_test")
    check(part1(testInput) == 1)

    val input = readInput("Day${DAY}")

    part1(input).println()
    part2(input).println()
}
