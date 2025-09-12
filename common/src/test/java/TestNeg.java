import io.github.miniplaceholders.expressions.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNeg {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testNeg() {
        Utils.assertExpands("<expr_neg:1>", "-1");
        Utils.assertExpands("<expr_neg:5.1>", "-5.1");
        Utils.assertExpands("<expr_neg:-2>", "2");
    }
}
