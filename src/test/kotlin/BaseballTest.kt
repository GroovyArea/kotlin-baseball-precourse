import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class BaseballTest {

    @Test
    fun testThatShouldBeTwoBall() {
        val ball = Ball("123", "234")

        val count = ball.getCount()

        assert(count == 2)
    }

    @Test
    fun twoStrikeTest() {
        val strike = Strike("123", "124")

        val count = strike.getCount()

        assert(count == 2)
    }

    @Test
    fun isNothingTest() {
        val nothing = Nothing("123", "456")

        val isNothing = nothing.isNothing()

        assert(isNothing == true)
    }

    @Test
    fun oneStrikeGameResultTest() {
        val gameExecutor = GameExecutor()

        val gameResult = gameExecutor.execute("123", "145")

        assert(gameResult.containsKey(Types.STRIKE))
        assert(gameResult[Types.STRIKE] == 1)
    }

    @Test
    fun numberValidateFailedTest() {
        val numberValidator = NumberValidator()

        assertDoesNotThrow {
            numberValidator.validate("123")
        }
    }
}