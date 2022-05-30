package com.projectname.e2e.tests.utils;

import java.time.Duration;

public class StrategyConfig {
    public static final Duration ELEMENT_WAIT_SECONDS = Duration.ofSeconds(20);
    public static final Duration CHECK_FOR_ELEMENT = Duration.ofSeconds(2);
    public static final Duration BROWSER_TIMEOUT = Duration.ofMillis(20000L);
    public static final Duration PAGE_LOAD_TIMEOUT = Duration.ofSeconds(30);
    public static final Duration SLEEP_IN_MILLIS = Duration.ofMillis(500);
}