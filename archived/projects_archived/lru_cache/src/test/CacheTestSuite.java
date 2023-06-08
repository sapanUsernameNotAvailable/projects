package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ CacheAvailableTest.class, CacheNotAvailableTest.class })
public class CacheTestSuite {
}
