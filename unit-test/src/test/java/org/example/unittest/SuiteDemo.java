package org.example.unittest;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(value = {RectangleTest.class})
@IncludeTags("tag")
public class SuiteDemo {
}
