package io.github.miniplaceholders.expressions.common.test;

import io.github.miniplaceholders.expressions.common.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestMax {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testMax() {
        Utils.assertExpands("<expr_max:10:5>", "10");
        Utils.assertExpands("<expr_max:5:2>", "5");
        Utils.assertExpands("<expr_max:0:4>", "4");
        Utils.assertExpands("<expr_max:5:-2>", "5");
        Utils.assertExpands("<expr_max:5.6:1.2>", "5.6");
        Utils.assertExpands("<expr_max:-5:-2>", "-2");
    }
}
