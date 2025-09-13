package io.github.miniplaceholders.expressions.common.test;

import io.github.miniplaceholders.expressions.common.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class TestCeil {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration(Map.of()));
    }

    @Test
    public void testCeil() {
        Utils.assertExpands("<expr_ceil:1.1>", "2");
        Utils.assertExpands("<expr_ceil:5.93>", "6");
        Utils.assertExpands("<expr_ceil:-2>", "-2");
    }
}
