package io.github.miniplaceholders.expressions.common.test;

import io.github.miniplaceholders.expressions.common.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class TestUser {
    @BeforeEach
    public void init() {
        final Map<String, String> expressions = Map.of(
                "add_and_multiply", "<expr_add:'<arg1>':'<expr_mul:\\'<arg2>\\':\\'<arg3>\\'>'>"
        );
        Utils.registerPlaceholders(new Configuration(expressions));
    }
    
    @Test
    public void testFloor() {
        Utils.assertExpands("<expr_user:add_and_multiply:2:3:4>", String.valueOf(2 + (3 * 4)));
    }
}
