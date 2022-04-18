package com.abnamro.apps.referenceandroid

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    // SETUP
    @get: Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)


    /**
     * Given app is launched
     * When container is initialized
     * And mainActivity view is loaded
     * Then activityFragment is in view
     */
    @Test
    fun test_is_activityInView() {

        // GIVEN
        // When
        // Then
        Espresso.onView(ViewMatchers.withId(R.id.fragment))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }


    /**
     * Given app is launched
     * When container is initialized
     * And mainActivity view is loaded
     * Then toolbar is visible
     */
    @Test
    fun test_visibility_of_toolbar() {

        // GIVEN
        // When
        // Then
        Espresso.onView(ViewMatchers.withId(R.id.toolbar))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }


    /**
     * Given app is launched
     * When container is initialized
     * And mainActivity view is loaded
     * Then application home title is visible
     */
    @Test
    fun test_visibility_of_titleText() {

        // GIVEN
        // When

        Espresso.onView(ViewMatchers.withId(R.id.toolbar))

            // Then
            .check(ViewAssertions.matches(ViewMatchers.hasDescendant(ViewMatchers.withText(AppTitle))))//comparison of text without inner textview

    }


    /**
     * Given app is launched
     * When container is initialized
     * And mainActivity view is loaded
     * Then floating action button is visible
     */
    @Test
    fun test_visibility_of_floatingButton() {

        // GIVEN
        // When
        // Then
        Espresso.onView(ViewMatchers.withId(R.id.fab))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

    }


    /**
     * Given app is launched
     * When container is initialized
     * And mainActivity view is loaded
     * Then floating action button is visible
     * And on button click the message is displayed
     */
    @Test
    fun test_visibility_of_text_on_floatingButton_click() {

        // GIVEN
        // When
        Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())

        // THEN
        Espresso.onView(ViewMatchers.withText(snackbarMessage))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

    }

}