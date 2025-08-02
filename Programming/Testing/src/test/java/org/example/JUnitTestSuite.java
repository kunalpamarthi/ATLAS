package org.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("My Suit")
@SelectClasses({
        JUnitAddTest.class,
        JUnitDiffTest.class,
        JUnitProdTest.class,
        JUnitQuotTest.class
})

public class JUnitTestSuite {

}
