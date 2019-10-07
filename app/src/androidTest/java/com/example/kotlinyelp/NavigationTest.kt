package com.example.kotlinyelp

import org.junit.Test

import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun searchTest() {
        activityRule.launchActivity(null)

        onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())
        Thread.sleep(2000);
        onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())
        Thread.sleep(2000);
        onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())
        Thread.sleep(2000);
        onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())
        Thread.sleep(2000);
        onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())
        Thread.sleep(4000);
    }
}

