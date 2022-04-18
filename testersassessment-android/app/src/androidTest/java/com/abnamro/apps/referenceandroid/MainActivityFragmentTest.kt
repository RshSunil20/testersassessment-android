package com.abnamro.apps.referenceandroid

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityFragmentTest {

    // SETUP
    @get: Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)


    /**
     * Given user is in MainActivityFragment
     * When clicking on context menu in the top right
     * Then main menu list items are seen
     */
    @Test
    fun test_click_on_context_menu_and_list_items() {

        // GIVEN
        // WHEN
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)

        // Validate context menu list
        Espresso.onView(ViewMatchers.withId(R.id.title))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

    }


    /**
     * Given user is in MainActivityFragment
     * Then content on the screen are displayed
     */
    @Test
    fun test_is_home_text_visible() {

        // GIVEN
        Espresso.onView(ViewMatchers.withId(R.id.fragment))

        // THEN
        .check(ViewAssertions.matches(hasDescendant(withText("Hello World!")))) //comparison of text without inner textview

    }


    /**
     * Given user is in MainActivityFragment
     * When clicking on context menu in the top right
     * Then Settings in seen in menu list
     * And Settings option is clickable
     */
    @Test
    fun test_is_context_menu_settings_option_accessible() {
        // GIVEN
        // WHEN
        openActionBarOverflowOrOptionsMenu(getInstrumentation().targetContext)

        // THEN
        Espresso.onView(ViewMatchers.withId(R.id.title))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))

        // AND
        Espresso.onView(withId(R.id.title)).perform(ViewActions.click())

    }

}