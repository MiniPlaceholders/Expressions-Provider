package io.github.miniplaceholders.expressions.common.test;

import io.github.miniplaceholders.expressions.common.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class TestConcat {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration(Map.of()));
    }

    @Test
    public void testConcat() {
        Utils.assertExpands("<expr_concat:hello:world>", "helloworld");
        Utils.assertExpands("<expr_concat:a:b:c:d>", "abcd");
        Utils.assertExpands("<expr_concat:3:-1>", "3-1");
        Utils.assertExpands("<expr_concat>", "");
    }
}
