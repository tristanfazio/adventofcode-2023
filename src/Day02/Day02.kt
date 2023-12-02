package Day02

import println
import readInput
import kotlin.math.min

const val DAY = "02"
fun main() {
    // 12 red cubes, 13 green cubes, and 14 blue cubes
    var maxMap = mapOf(
            Pair("red", 12),
            Pair("green", 13),
            Pair("blue", 14))

    fun playGame(line: String): Int {
        //split gameId, gameInput
        //split rounds
        val gameSplit = line.split("Game ", ": ", "; ").drop(1)
        val gameId = gameSplit[0]
        println("Game $gameId")
        //for rounds
        for (i in 1..<gameSplit.size) {
            //check each R G B <= Max
            val round = gameSplit[i]
            print("Round: ")
            round.println()

            val blocks = round.split(",")

            blocks.forEach { block ->
                val blockSplit = block.trimStart().split(" ")
                val num = blockSplit[0]
                val colour = blockSplit[1]
                num.println()
                colour.println()
                if (num.toInt() > maxMap.get(colour)!!) {
                    //false? return 0
                    return 0
                }
            }
        }
        return gameId.toInt()
    }

    fun playGame2(line: String): Int {
        var minMap = mutableMapOf(
                Pair("red", 0),
                Pair("green", 0),
                Pair("blue", 0))

        //split gameId, gameInput
        //split rounds
        val gameSplit = line.split("Game ", ": ", "; ").drop(1)
        val gameId = gameSplit[0]
        println("Game $gameId")
        //for rounds
        for (i in 1..<gameSplit.size) {
            //check each R G B <= Max
            val round = gameSplit[i]
            print("Round: ")
            round.println()

            val blocks = round.split(",")

            blocks.forEach { block ->
                val blockSplit = block.trimStart().split(" ")
                val num = blockSplit[0].toInt()
                val colour = blockSplit[1]
                if (num > minMap.get(colour)!!) {
                    minMap[colour] = num
                }
            }
        }
        minMap.println()
        return minMap["red"]!! * minMap["blue"]!! * minMap["green"]!!
    }

    fun part1(input: List<String>): Int {
        var idSum = 0
        input.forEach { line ->
            idSum += playGame(line)
        }
        return idSum
    }

    fun part2(input: List<String>): Int {
        var powerSum = 0
        input.forEach { line ->
            val power = playGame2(line)
            powerSum += power
            println("Power: $power, PowerSum: $powerSum")
        }
        return powerSum
    }

    val testInput = readInput("Day${DAY}/Day${DAY}_test")

    println("---------------Test Part1---------------")
    val testp1 = part1(testInput)
    check(testp1 == 8)

    println("---------------Test Part2---------------")
    val testp2 = part2(testInput)
    check(testp2 == 2286)

    val input = readInput("Day${DAY}/Day${DAY}")

    println("---------------Part1---------------")
    val p1 = part1(input)

    println("---------------Part2---------------")
    val p2 = part2(input)


    println("=============================")
    print("Test Part1 Answer: ")
    testp1.println()
    print("Test Part2 Answer: ")
    testp2.println()
    print("Part1 Answer: ")
    p1.println()
    print("Part2 Answer: ")
    p2.println()
}
