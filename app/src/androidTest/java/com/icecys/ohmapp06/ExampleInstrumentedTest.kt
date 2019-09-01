package com.icecys.ohmapp06

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.platform.app.InstrumentationRegistry
//import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.icecys.ohmapp06", appContext.packageName)
    }

    @Test
    fun user_can_enter_first_name() {
        onView(withId(R.id.firstName)).perform(typeText("Ekasit"))
    }

    @Test
    fun user_can_enter_last_name() {
        onView(withId(R.id.lastName)).perform(typeText("Saichompu"))
    }

    @Test
    fun when_user_enters_first_and_last_name_check_to_comfirm_that_message_is_correct() {
        onView(withId(R.id.firstName)).perform(typeText("Kingkaew"))
        onView(withId(R.id.lastName)).perform(typeText("Arayanantapong"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.message)).check(matches(withText("Welcome, Kingkaew Arayanantapong!")))
    }

    @Test
    fun first_message_again() {
        onView(withId(R.id.firstName)).perform(typeText("Ekasit"))
        onView(withId(R.id.lastName)).perform(typeText("Saichompu"))
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.message)).check(matches(withText("Welcome, Ekasit Saichompu!")))

    }
}
