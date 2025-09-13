package io.github.miniplaceholders.expressions.common.test;

import io.github.miniplaceholders.expressions.common.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class TestNeg {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration(Map.of()));
    }

    @Test
    public void testNeg() {
        Utils.assertExpands("<expr_neg:1>", "-1");
        Utils.assertExpands("<expr_neg:5.1>", "-5.1");
        Utils.assertExpands("<expr_neg:-2>", "2");
    }
}
