package Day01

import println
import readInput


const val DAY = "01"
fun main() {
    val units = mapOf(
            Pair("nineteen", "n19n"),
            Pair("eighteen", "e18n"),
            Pair("seventeen", "s17n"),
            Pair("sixteen", "s16n"),
            Pair("fifteen", "f15n"),
            Pair("fourteen", "f14n"),
            Pair("thirteen", "t13n"),
            Pair("twelve", "t12e"),
            Pair("eleven", "e11n"),
            Pair("ten", "t10n"),
            Pair("nine", "n9e"),
            Pair("eight", "e8t"),
            Pair("seven", "s7n"),
            Pair("six", "s6x"),
            Pair("five", "f5e"),
            Pair("four", "f4r"),
            Pair("three", "t3e"),
            Pair("two", "t2o"),
            Pair("one", "o1e"),
    )

    val tensUnits = mapOf(
            Pair("thirty", "t30y"),
            Pair("forty", "f40y"),
            Pair("fifty", "f50y"),
            Pair("sixty", "s60y"),
            Pair("seventy", "s70y"),
            Pair("eighty", "e80y"),
            Pair("ninety", "n90y")
    )

    fun convertWordsToNumbers(wordString: String): String {
        var resultString = wordString
        for ((word, value) in units) {
            if (resultString.contains(word)) {
                resultString = resultString.replace(word, value)
            }
        }

        for ((word, value) in tensUnits) {
            if (resultString.contains(word)) {
                resultString = resultString.replace(word, value)
            }
        }
        return resultString
    }

    fun firstFromFront(line: String): Int {
        line.forEach { char ->
            if (char.isDigit()) {
                return char.digitToInt()
            }
        }
        return 0
    }

    fun firstFromBack(line: String): Int {
        for (i in line.length - 1 downTo 0) {
            if (line[i].isDigit()) {
                return line[i].digitToInt()
            }
        }
        return 0
    }

    fun part1(input: List<String>): Int {
        val foundValues: MutableList<String> = ArrayList()
        input.forEach { line ->
            println("Line: $line")
            var convertedLine = convertWordsToNumbers(line)
            println("Converted Line: $convertedLine")
            var first = 0
            var last = 0
            //read from front, first digit = first
            first = firstFromFront(convertedLine)
            println("First digit is $first")
            //read from in reverse, first digit = last
            last = firstFromBack(convertedLine)
            println("last digit is $last")
            foundValues.add(first.toString() + last.toString())
        }
        foundValues.println()
        var sum = 0
        foundValues.forEach { value ->
            sum += value.toInt()
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val foundValues: MutableList<String> = ArrayList()
        input.forEach { line ->
            println("Line: $line")
            var convertedLine = convertWordsToNumbers(line)
            println("Converted Line: $convertedLine")
            var first = 0
            var last = 0
            //read from front, first digit = first
            first = firstFromFront(convertedLine)
            println("First digit is $first")
            //read from in reverse, first digit = last
            last = firstFromBack(convertedLine)
            println("last digit is $last")
            foundValues.add(first.toString() + last.toString())
        }
        foundValues.println()
        var sum = 0
        foundValues.forEach { value ->
            sum += value.toInt()
        }
        return sum
    }

    val testInput = readInput("Day${DAY}/Day${DAY}_test")

    println("---------------Test Part1---------------")
    val testp1 = part1(testInput)
    println("Test Part1 InputAnswer:")
    testp1.println()
    check(testp1 == 142)

    val testInput2 = readInput("Day${DAY}/Day${DAY}_test2")

    println("---------------Test Part2---------------")
    val testp2 = part2(testInput2)
    println("Test Part2 InputAnswer:")
    testp2.println()
    check(testp2 == 281)


    val input = readInput("Day${DAY}/Day${DAY}")

    println("---------------Part1---------------")
    val p1 = part1(input)
    println("Part1 InputAnswer:")
    p1.println()

    println("---------------Part2---------------")
    val p2 = part2(input)
    println("Part2 InputAnswer:")
    p2.println()
}
