package io.github.miniplaceholders.expressions.common.test;

import io.github.miniplaceholders.expressions.common.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestLength {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testLength() {
        Utils.assertExpands("<expr_length:hello>", String.valueOf("hello".length()));
        Utils.assertExpands("<expr_length:'hello world'>", String.valueOf("hello world".length()));
        Utils.assertExpands("<expr_length:>", "0");
    }
}
