package Day02

import println
import readInput

const val DAY = "02";
fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val testInput = readInput("Day${Day01.DAY}/Day${Day01.DAY}_test")

    println("---------------Test Part1---------------")
    val testp1 = part1(testInput)
    println("Test Part1 InputAnswer:")
    testp1.println()
    check(testp1 == 142)

    val input = readInput("Day${Day01.DAY}/Day${Day01.DAY}")

    println("---------------Part1---------------")
    val p1 = part1(input)
    println("Part1 InputAnswer:")
    p1.println()

    println("---------------Part2---------------")
    val p2 = part2(input)
    println("Part2 InputAnswer:")
    p2.println()
}
