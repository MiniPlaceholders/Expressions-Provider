package io.github.miniplaceholders.expressions.common.test;

import io.github.miniplaceholders.expressions.common.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class TestRound {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration(Map.of()));
    }

    @Test
    public void testRound() {
        Utils.assertExpands("<expr_round:1.1>", "1");
        Utils.assertExpands("<expr_round:5.93>", "6");
        Utils.assertExpands("<expr_round:-2>", "-2");
    }
}
