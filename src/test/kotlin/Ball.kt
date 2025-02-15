import Nothing
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableMapOf as mutableMapOf1

data class Ball(
    val sourceNumber: String,
    val targetNumber: String
) {

    fun getCount(): Int {
        var count: Int = 0
        val sourceNumberArray = sourceNumber.toCharArray()

        targetNumber.toCharArray().forEachIndexed { index, char ->
            if (sourceNumberArray.contains(char) && sourceNumberArray[index] != char) {
                count++
            }
        }

        return count
    }
}

data class Strike(
    val sourceNumber: String,
    val targetNumber: String
) {

    fun getCount(): Int {
        var count: Int = 0
        val sourceNumberArray = sourceNumber.toCharArray()

        targetNumber.toCharArray().forEachIndexed { index, char ->
            if (char == sourceNumberArray[index]) {
                count++
            }
        }

        return count
    }
}

data class Nothing(
    val sourceNumber: String,
    val targetNumber: String
) {

    fun isNothing(): Boolean {
        val sourceNumberArray = sourceNumber.toCharArray()

        sourceNumberArray.forEach {
            if (targetNumber.contains(it)) {
                return false
            }
        }

        return true
    }
}

class GameExecutor {

    fun execute(sourceNumber: String, targetNumber: String): Map<Types, Int> {
        val nothing = Nothing(sourceNumber, targetNumber)
        val isNothing = nothing.isNothing()

        if (isNothing) return emptyMap()

        val ball = Ball(sourceNumber, targetNumber)
        val strike = Strike(sourceNumber, targetNumber)

        val ballCount = ball.getCount()
        val strikeCount = strike.getCount()

        val resultMap = mutableMapOf<Types, Int>()

        if (ballCount != 0) {
            resultMap[Types.BALL] = ballCount
        }
        if (strikeCount != 0) {
            resultMap[Types.STRIKE] = strikeCount
        }

        return resultMap
    }
}

class NumberValidator {

    fun validate(number: String) {
        throw IllegalArgumentException("Invalid number input, $number")
    }
}

enum class Types {
    BALL,
    STRIKE,
}