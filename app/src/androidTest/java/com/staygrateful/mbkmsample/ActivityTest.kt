package com.staygrateful.mbkmsample

import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ActivityTest {

    lateinit var activityScenario: ActivityScenario<TestingActivity>

    @Before
    fun setup() {
        activityScenario = ActivityScenario.launch(TestingActivity::class.java)
    }

    @Test
    fun test() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext

        Espresso.onView(ViewMatchers.withId(R.id.input_1)).perform(ViewActions.typeText("100"))
        Espresso.onView(ViewMatchers.withId(R.id.input_2)).perform(ViewActions.typeText("200"))
        Espresso.onView(ViewMatchers.withId(R.id.btn_sum)).perform(ViewActions.click())

        val expectedResult = appContext.getString(R.string.calculator_result, "300")

        Espresso.onView(ViewMatchers.withId(R.id.result)).check(
            ViewAssertions.matches(ViewMatchers.withText(expectedResult))
        )
    }

    @After
    fun tearDown() {
        activityScenario.close()
    }
}