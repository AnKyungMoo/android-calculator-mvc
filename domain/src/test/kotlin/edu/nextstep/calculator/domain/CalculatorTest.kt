package edu.nextstep.calculator.domain

import org.junit.Assert.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {
    @Test
    fun `빈 문자열이나 null을 input하면 IllegalArgumentException이 나온다`() {
        assertThrows<IllegalArgumentException> {
            Calculator.calculate("")
        }
        assertThrows<IllegalArgumentException> {
            Calculator.calculate(null)
        }
    }

    @Test
    fun `숫자나 사칙연산 기호가 입력되지 않은 경우 IllegalArgumentException이 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Calculator.calculate("1 a 2 * 1")
        }

        assertThrows(IllegalArgumentException::class.java) {
            Calculator.calculate("a + 5 + 2")
        }
    }

    @Test
    fun `피연산자 자리에 연산자가 들어가는 경우 IllegalArgumentException가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Calculator.calculate("+ + 5")
        }
    }

    @Test
    fun `연산자와 피연산자를 구분하지 않는 경우 IllegalArgumentException가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Calculator.calculate("5+5")
        }
    }
}
