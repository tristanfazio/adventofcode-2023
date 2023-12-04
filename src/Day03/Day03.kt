import kotlin.math.E

private const val DAY = "03";
fun main() {
    //Pair(x,y)
    val NORTHWEST = Pair(-1,-1)
    val NORTH = Pair(0,-1)
    val NORTHEAST = Pair(1,-1)
    val EAST = Pair(1,0)
    val SOUTHEAST = Pair(1,1)
    val SOUTH = Pair(0,1)
    val SOUTHWEST = Pair(-1,1)
    val WEST = Pair(-1,0)

    fun String.isInteger() = this.toIntOrNull()?.let { true } ?: false
    fun String.isSymbol() = (!this.isInteger() && this != ".")
    fun String.isStar() = (this == "*")

    fun part1(input: List<String>): Int {
        val map = parseMap(input)

        //sum
        var sum = 0
        //start traversing rows(y)
        input.forEachIndexed { y_index, row ->
            var x_index = 0
            while(x_index < row.length) {
                var cell = map[y_index][x_index]
                if(cell.isInteger()) {
                    var num = cell
                    val peg1 = x_index
                    var peg2 = x_index
                    if(x_index + 1 < row.length) {
                        if(map[y_index][x_index + 1].isInteger()) {
                            peg2 = x_index + 1
                            num += map[y_index][x_index + 1]

                            if(x_index + 2 < row.length) {
                                if(map[y_index][x_index + 2].isInteger()) {
                                    peg2 = x_index + 2
                                    num += map[y_index][x_index + 2]
                                }
                            }
                        }
                    }

                    loop@ for(peg in peg1..peg2) {
                        val cursor = Pair(peg, y_index)
                        if(map.canTraverse(cursor, NORTHWEST)) {
                            val cellToCheck = map.traverse(cursor, NORTHWEST)
                            if (cellToCheck.isSymbol()) {
                                sum += num.toInt()
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, NORTH)) {
                            val cellToCheck = map.traverse(cursor, NORTH)
                            if (cellToCheck.isSymbol()) {
                                sum += num.toInt()
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, NORTHEAST)) {
                            val cellToCheck = map.traverse(cursor, NORTHEAST)
                            if (cellToCheck.isSymbol()) {
                                sum += num.toInt()
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, EAST )) {
                            val cellToCheck = map.traverse(cursor, EAST)
                            if (cellToCheck.isSymbol()) {
                                sum += num.toInt()
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, SOUTHEAST )) {
                            val cellToCheck = map.traverse(cursor, SOUTHEAST)
                            if (cellToCheck.isSymbol()) {
                                sum += num.toInt()
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, SOUTH )) {
                            val cellToCheck = map.traverse(cursor, SOUTH)
                            if (cellToCheck.isSymbol()) {
                                sum += num.toInt()
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, SOUTHWEST )) {
                            val cellToCheck = map.traverse(cursor, SOUTHWEST)
                            if (cellToCheck.isSymbol()) {
                                sum += num.toInt()
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, WEST )) {
                            val cellToCheck = map.traverse(cursor, WEST)
                            if (cellToCheck.isSymbol()) {
                                sum += num.toInt()
                                break@loop
                            }
                        }
                    }
                    x_index = peg2 + 1
                    continue
                }
                x_index++
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        val map = parseMap(input)

        //sum
        val starMap = mutableMapOf<String, ArrayList<String>>()

        //start traversing rows(y)
        input.forEachIndexed { y_index, row ->
            var x_index = 0
            while(x_index < row.length) {
                var cell = map[y_index][x_index]
                if(cell.isInteger()) {
                    var num = cell
                    val peg1 = x_index
                    var peg2 = x_index
                    if(x_index + 1 < row.length) {
                        if(map[y_index][x_index + 1].isInteger()) {
                            peg2 = x_index + 1
                            num += map[y_index][x_index + 1]

                            if(x_index + 2 < row.length) {
                                if(map[y_index][x_index + 2].isInteger()) {
                                    peg2 = x_index + 2
                                    num += map[y_index][x_index + 2]
                                }
                            }
                        }
                    }

                    loop@ for(peg in peg1..peg2) {
                        val cursor = Pair(peg, y_index)
                        if(map.canTraverse(cursor, NORTHWEST)) {
                            val cellToCheck = map.traverse(cursor, NORTHWEST)
                            if (cellToCheck.isStar()) {
                                //save star
                                val starKey = (peg + NORTHWEST.first).toString() + (y_index + NORTHWEST.second).toString()
                                if(starMap.containsKey(starKey)) {
                                    starMap[starKey]?.add(num)
                                } else {
                                    starMap[starKey] = arrayListOf(num)
                                }
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, NORTH)) {
                            val cellToCheck = map.traverse(cursor, NORTH)
                            if (cellToCheck.isStar()) {
                                //save star
                                val starKey = (peg + NORTH.first).toString() + (y_index + NORTH.second).toString()
                                if(starMap.containsKey(starKey)) {
                                    starMap[starKey]?.add(num)
                                } else {
                                    starMap[starKey] = arrayListOf(num)
                                }
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, NORTHEAST)) {
                            val cellToCheck = map.traverse(cursor, NORTHEAST)
                            if (cellToCheck.isStar()) {
                                //save star
                                val starKey = (peg + NORTHEAST.first).toString() + (y_index + NORTHEAST.second).toString()
                                if(starMap.containsKey(starKey)) {
                                    starMap[starKey]?.add(num)
                                } else {
                                    starMap[starKey] = arrayListOf(num)
                                }
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, EAST )) {
                            val cellToCheck = map.traverse(cursor, EAST)
                            if (cellToCheck.isStar()) {
                                //save star
                                val starKey = (peg + EAST.first).toString() + (y_index + EAST.second).toString()
                                if(starMap.containsKey(starKey)) {
                                    starMap[starKey]?.add(num)
                                } else {
                                    starMap[starKey] = arrayListOf(num)
                                }
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, SOUTHEAST )) {
                            val cellToCheck = map.traverse(cursor, SOUTHEAST)
                            if (cellToCheck.isStar()) {
                                //save star
                                val starKey = (peg + SOUTHEAST.first).toString() + (y_index + SOUTHEAST.second).toString()
                                if(starMap.containsKey(starKey)) {
                                    starMap[starKey]?.add(num)
                                } else {
                                    starMap[starKey] = arrayListOf(num)
                                }
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, SOUTH )) {
                            val cellToCheck = map.traverse(cursor, SOUTH)
                            if (cellToCheck.isStar()) {
                                //save star
                                val starKey = (peg + SOUTH.first).toString() + (y_index + SOUTH.second).toString()
                                if(starMap.containsKey(starKey)) {
                                    starMap[starKey]?.add(num)
                                } else {
                                    starMap[starKey] = arrayListOf(num)
                                }
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, SOUTHWEST )) {
                            val cellToCheck = map.traverse(cursor, SOUTHWEST)
                            if (cellToCheck.isStar()) {
                                //save star
                                val starKey = (peg + SOUTHWEST.first).toString() + (y_index + SOUTHWEST.second).toString()
                                if(starMap.containsKey(starKey)) {
                                    starMap[starKey]?.add(num)
                                } else {
                                    starMap[starKey] = arrayListOf(num)
                                }
                                break@loop
                            }
                        }
                        if(map.canTraverse(cursor, WEST )) {
                            val cellToCheck = map.traverse(cursor, WEST)
                            if (cellToCheck.isStar()) {
                                //save star
                                val starKey = (peg + WEST.first).toString() + (y_index + WEST.second).toString()
                                if(starMap.containsKey(starKey)) {
                                    starMap[starKey]?.add(num)
                                } else {
                                    starMap[starKey] = arrayListOf(num)
                                }
                                break@loop
                            }
                        }
                    }
                    x_index = peg2 + 1
                    continue
                }
                x_index++
            }
        }
        return starMap
            .filter { entry ->
                entry.value.size == 2 }
            .map { it.value }
            .map { parts -> parts[0].toInt() * parts[1].toInt() }
            .reduce {
                acc, gears -> acc + gears
             }
    }

    val testInput = readInput("Day${DAY}/Day${DAY}_test")

    println("---------------Test Part1---------------")
//    val testp1 = part1(testInput)

    println("---------------Test Part2---------------")
    val testp2 = part2(testInput)

    println("=============================")
    print("Test Part1 Answer: ")
//    testp1.println()
    print("Test Part2 Answer: ")
    testp2.println()

//    check(testp1 == 4361)
    check(testp2 == 467835)

    val input = readInput("Day${DAY}/Day${DAY}")

    println("---------------Part1---------------")
    val p1 = part1(input)

    println("---------------Part2---------------")
    val p2 = part2(input)


    println("=============================")
    print("Part1 Answer: ")
    p1.println()
    print("Part2 Answer: ")
    p2.println()
}