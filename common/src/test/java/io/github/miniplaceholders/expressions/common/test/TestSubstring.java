package io.github.miniplaceholders.expressions.common.test;

import io.github.miniplaceholders.expressions.common.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSubstring {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testSubstring() {
        Utils.assertExpands("<expr_substring:hello:0:5>", "hello".substring(0, 5));
        Utils.assertExpands("<expr_substring:hello:1:4>", "hello".substring(1, 4));
        Utils.assertExpands("<expr_substring:hello:2:2>", "hello".substring(2, 2));
        Utils.assertExpands("<expr_substring:hello:1:3>", "hello".substring(1, 3));
    }
}
