import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readLines

/**
 * Reads lines from the given input txt file.
 */
fun readInput(path: String) = Path("src/$path.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)

/**
 * Convert a binary number, 1010; to a decimal number, 10.
 */
fun convertBinaryToDecimal(num: Long): Int {
    var num = num
    var decimalNumber = 0
    var i = 0
    var remainder: Long

    while (num.toInt() != 0) {
        remainder = num % 10
        num /= 10
        decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
        ++i
    }
    return decimalNumber
}

typealias Grid = Array<Array<String>>

fun Grid.canTraverse(currentPosition: Pair<Int, Int>, direction: Pair<Int, Int>): Boolean {
    try {
        //first = x, second = y
        this[currentPosition.second + direction.second][currentPosition.first + direction.first]
    } catch (exception: IndexOutOfBoundsException) {
        return false;
    }
    return true;
}

fun Grid.traverse(currentPosition: Pair<Int, Int>, direction: Pair<Int, Int>): String {
        //first = x, second = y
        return this[currentPosition.second + direction.second][currentPosition.first + direction.first]

}

fun parseMap(input: List<String>): Grid {
    val xSize  = input[0].length
    val ySize = input.size
    val map = initMap(ySize, xSize)
    input.forEachIndexed { y, row ->
        val cells = row.map { it.toString() }
        cells.forEachIndexed { x, cell ->
            map[y][x] = cell
        }
    }
    return map
}

fun initMap(y: Int, x: Int): Grid {
    return Array(y) { Array(x) { "" } }
}