package io.github.miniplaceholders.expressions.common.test;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.api.MiniPlaceholders;
import io.github.miniplaceholders.expressions.common.Configuration;
import io.github.miniplaceholders.expressions.common.Expressions;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Utils {
    private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();
    private static final PlainTextComponentSerializer PLAIN_SERIALIZER = PlainTextComponentSerializer.plainText();

    public static void assertExpands(final String placeholderRequest, final String expectedResult) {
        final Component component = MINI_MESSAGE.deserialize(placeholderRequest, MiniPlaceholders.globalPlaceholders());
        final String actualResult = PLAIN_SERIALIZER.serialize(component);

        assertEquals(expectedResult, actualResult, "Placeholder request: `%s`. Expected: `%s`, got: `%s`".formatted(placeholderRequest, expectedResult, actualResult));
    }

    public static void registerPlaceholders(final Configuration configuration) {
        try {
            for (Expansion expansion : MiniPlaceholders.expansionsAvailable()) {
                expansion.unregister();
            }
        } catch (Throwable exception) {
            exception.printStackTrace();
        }
        Expressions.registerPlaceholders(configuration, new TestPlatform());
    }
}
