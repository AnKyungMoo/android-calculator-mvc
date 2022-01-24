package edu.nextstep.camp.calculator.domain

import edu.nextstep.camp.calculator.domain.expression.ExpressionGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

private const val JOIN_DELIMITER = " "

internal class ExpressionGeneratorTest {

    private lateinit var expressionGenerator: ExpressionGenerator

    @BeforeEach
    internal fun setUp() {
        expressionGenerator = ExpressionGenerator(JOIN_DELIMITER)
    }

    @DisplayName(" -> 1 클릭 -> 1")
    @Test
    fun `입력된 피연산자가 없을 때, 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다 (1)`() {
        // when
        val actual = expressionGenerator
            .append("1")
            .generate()

        // then
        Assertions.assertThat(actual).isEqualTo("1")
    }

    @DisplayName("5 + -> 1 클릭 -> 5 + 1")
    @Test
    fun `입력된 피연산자가 없을 때, 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다 (2)`() {
        // when
        val actual = expressionGenerator
            .append("5").append("+").append("1")
            .generate()

        Assertions.assertThat(actual).isEqualTo("5 + 1")
    }

    @DisplayName("8 -> 9 클릭 -> 89")
    @Test
    fun `입력된 피연산자가 있을 때, 기존 숫자 뒤에 해당 숫자가 화면에 보여야 한다, 예를 들면, 8이 입력되어 있을 때 9를 입력하면 89가 보여야 한다`() {
        // when
        val actual = expressionGenerator
            .append("8").append("9")
            .generate()

        // then
        Assertions.assertThat(actual).isEqualTo("89")
    }

    @ParameterizedTest(name = " -> {0} 클릭 -> ")
    @ValueSource(strings = ["+", "-", "×", "÷"])
    fun `입력된 피연산자가 없을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 화면에 아무런 변화가 없어야 한다`(token: String) {
        // when
        val actual = expressionGenerator
            .append(token)
            .generate()

        Assertions.assertThat(actual).isEqualTo("")
    }

    @ParameterizedTest(name = "1 -> {0} 클릭 -> 1 {0}")
    @ValueSource(strings = ["+", "-", "×", "÷"])
    fun `입력된 피연산자가 있을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 해당 기호가 화면에 보여야 한다 (1)`(token: String) {
        // when
        val actual = expressionGenerator
            .append("1").append(token)
            .generate()

        // then
        Assertions.assertThat(actual).isEqualTo("1 $token")
    }

    @ParameterizedTest(name = "1 {0} -> - 클릭 -> 1 -")
    @ValueSource(strings = ["+", "-", "×", "÷"])
    fun `입력된 피연산자가 있을 때, 사용자가 연산자 +, -, ×, ÷ 버튼을 누르면 해당 기호가 화면에 보여야 한다 (2)`(token: String) {
        // when
        val actual = expressionGenerator
            .append("1").append(token).append("-")
            .generate()

        // then
        Assertions.assertThat(actual).isEqualTo("1 -")
    }

    @DisplayName(" -> 지우기 클릭 -> ")
    @Test
    fun `입력된 수식이 없을 때, 사용자가 지우기 버튼을 누르면 화면에 아무런 변화가 없어야 한다`() {
        // when
        expressionGenerator.delete()
        val actual = expressionGenerator.generate()

        // then
        Assertions.assertThat(actual).isEqualTo("")
    }

    @DisplayName("32 + 1 -> 지우기 클릭 -> 32 + -> 지우기 클릭 -> 32 -> 지우기 클릭 -> 3 -> 지우기 클릭 ->  -> 지우기 클릭 -> ")
    @Test
    fun `입력된 수식이 있을 때, 사용자가 지우기 버튼을 누르면 수식에 마지막으로 입력된 연산자 또는 피연산자가 지워져야 한다`() {
        // given
        val expressionGenerator = expressionGenerator
            .append("3").append("2").append("+").append("1")

        // when
        expressionGenerator.delete().delete().delete().delete()
        val actual = expressionGenerator.generate()

        // then
        Assertions.assertThat(actual).isEqualTo("")
    }
}