import io.github.miniplaceholders.expressions.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDiv {
    @BeforeEach
    public void init() {
        Utils.registerPlaceholders(new Configuration());
    }

    @Test
    public void testDiv() {
        Utils.assertExpands("<expr_div:10:5>", "2");
        Utils.assertExpands("<expr_div:5:2>", "2.5");
        Utils.assertExpands("<expr_div:0:4>", "0");
        Utils.assertExpands("<expr_div:5:0>", "<expr_div:5:0>");
        Utils.assertExpands("<expr_div:5:-2>", "-2.5");
    }
}
