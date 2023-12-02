
private const val DAY = "01";
fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
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
