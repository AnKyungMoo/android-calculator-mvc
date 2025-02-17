package edu.nextstep.camp.calculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    // 사용자가 피연산자 0 ~ 9 버튼을 누르면 화면에 해당 숫자가 화면에 보여야 한다.
    @Test
    fun `버튼_0을_누르면_화면에_0이_보여야_한다`() {
        // when: 0 버튼을 누르면
        버튼을_누른다(R.id.button0)

        // then: 화면에 0이 보여야 한다
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("0")))
    }

    @Test
    fun `버튼_1을_누르면_화면에_1이_보여야_한다`() {
        // when: 1 버튼을 누르면
        버튼을_누른다(R.id.button1)

        // then: 화면에 1이 보여야 한다
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("1")))
    }

    @Test
    fun `버튼_2을_누르면_화면에_2이_보여야_한다`() {
        // when: 2 버튼을 누르면
        버튼을_누른다(R.id.button2)

        // then: 화면에 2이 보여야 한다
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("2")))
    }

    @Test
    fun `버튼_3을_누르면_화면에_3이_보여야_한다`() {
        // when: 3 버튼을 누르면
        버튼을_누른다(R.id.button3)

        // then: 화면에 3이 보여야 한다
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("3")))
    }

    @Test
    fun `버튼_4을_누르면_화면에_4이_보여야_한다`() {
        // when: 4 버튼을 누르면
        버튼을_누른다(R.id.button4)

        // then: 화면에 4이 보여야 한다
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("4")))
    }

    @Test
    fun `버튼_5을_누르면_화면에_5이_보여야_한다`() {
        // when: 5 버튼을 누르면
        버튼을_누른다(R.id.button5)

        // then: 화면에 5이 보여야 한다
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("5")))
    }

    @Test
    fun `버튼_6을_누르면_화면에_6이_보여야_한다`() {
        // when: 6 버튼을 누르면
        버튼을_누른다(R.id.button6)

        // then: 화면에 6이 보여야 한다
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("6")))
    }

    @Test
    fun `버튼_7을_누르면_화면에_7이_보여야_한다`() {
        // when: 7 버튼을 누르면
        버튼을_누른다(R.id.button7)

        // then: 화면에 7이 보여야 한다
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("7")))
    }

    @Test
    fun `버튼_8을_누르면_화면에_8이_보여야_한다`() {
        // when: 8 버튼을 누르면
        버튼을_누른다(R.id.button8)

        // then: 화면에 8이 보여야 한다
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("8")))
    }

    @Test
    fun `버튼_9을_누르면_화면에_9이_보여야_한다`() {
        // when: 9 버튼을 누르면
        버튼을_누른다(R.id.button9)

        // then: 화면에 9이 보여야 한다
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("9")))
    }

    @Test
    fun `입력된_피연산자가_있을_때_기존_숫자_뒤에_해당_숫자가_화면에_보여야_한다`() {
        버튼을_누른다(R.id.button9)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("9")))
        버튼을_누른다(R.id.button9)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("99")))
        버튼을_누른다(R.id.button5)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("995")))
    }

    @Test
    fun `입력된_피연산자가_없을_때_사용자가_연산자_덧셈_뺄셈_곱셈_나눗셈_버튼을_누르면_화면에_아무런_변화가_없어야_한다`() {
        버튼을_누른다(R.id.buttonPlus)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("")))

        버튼을_누른다(R.id.buttonMinus)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("")))

        버튼을_누른다(R.id.buttonMultiply)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("")))

        버튼을_누른다(R.id.buttonDivide)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("")))
    }

    @Test
    fun `입력된_피연산자가_있을_때_사용자가_연산자_덧셈_뺄셈_곱셈_나눗셈_버튼을_누르면_해당_기호가_화면에_보여야_한다`() {
        버튼을_누른다(R.id.button9)

        버튼을_누른다(R.id.buttonPlus)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("9 +")))
    }

    @Test
    fun `입력된_수식이_없을_때_사용자가_지우기_버튼을_누르면_화면에_아무런_변화가_없어야_한다`() {
        버튼을_누른다(R.id.buttonDelete)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("")))
    }

    @Test
    fun `입력된_수식이_있을_때_사용자가_지우기_버튼을_누르면_수식에_마지막으로_입력된_연산자_또는_피연산자가_지워져야_한다`() {
        버튼을_누른다(R.id.button9)

        버튼을_누른다(R.id.buttonPlus)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("9 +")))

        버튼을_누른다(R.id.buttonMinus)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("9 -")))

        버튼을_누른다(R.id.buttonMultiply)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("9 *")))

        버튼을_누른다(R.id.buttonDivide)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("9 /")))
    }

    @Test
    fun `입력된_수신이_완전할_때_사용자가_이퀄_버튼을_누르면_입력된_수식의_결과가_화면에_보여야_한다`() {
        버튼을_누른다(R.id.button9)
        버튼을_누른다(R.id.button9)
        버튼을_누른다(R.id.buttonPlus)
        버튼을_누른다(R.id.button7)
        버튼을_누른다(R.id.buttonMultiply)
        버튼을_누른다(R.id.button2)
        버튼을_누른다(R.id.buttonEquals)
        onView(withId(R.id.textView)).check(matches(ViewMatchers.withText("212")))
    }

    private fun `버튼을_누른다`(resId: Int) {
        onView(withId(resId)).perform(ViewActions.click())
    }
}
