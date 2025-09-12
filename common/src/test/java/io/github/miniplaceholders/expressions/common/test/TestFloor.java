package io.github.miniplaceholders.expressions.common.test;

import io.github.miniplaceholders.expressions.common.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestFloor {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testFloor() {
        Utils.assertExpands("<expr_floor:1.1>", "1");
        Utils.assertExpands("<expr_floor:5.93>", "5");
        Utils.assertExpands("<expr_floor:-2>", "-2");
    }
}
