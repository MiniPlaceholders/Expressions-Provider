import io.github.miniplaceholders.expressions.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSub {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testSub() {
        Utils.assertExpands("<expr_sub:2:1>", "1");
        Utils.assertExpands("<expr_sub:-2:1>", "-3");
        Utils.assertExpands("<expr_sub:1:2.0>", "-1.0");
    }
}
