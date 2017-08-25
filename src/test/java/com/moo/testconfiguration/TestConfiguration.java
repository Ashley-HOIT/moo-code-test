package com.moo.testconfiguration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class TestConfiguration {
    private static final Config CONFIG = ConfigFactory.load();

    public static final String BASE_URL = CONFIG.getString("moo-code-test.baseUrl");




}

