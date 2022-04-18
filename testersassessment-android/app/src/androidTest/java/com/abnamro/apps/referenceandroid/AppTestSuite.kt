package com.abnamro.apps.referenceandroid

import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * Bundle of test classes that can be executed as part of Test Suite.
 */

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    MainActivityFragmentTest::class
)
class AppTestSuite