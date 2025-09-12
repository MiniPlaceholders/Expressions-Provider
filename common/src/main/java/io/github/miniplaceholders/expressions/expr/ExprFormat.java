package io.github.miniplaceholders.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expressions.Expression;
import io.github.miniplaceholders.expressions.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public final class ExprFormat implements Expression {
    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("format", this);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final @NotNull Context context) {
        final String format = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_format> requires at least 1 argument").value());
        final List<Object> arguments = new ArrayList<>();
        while (argumentQueue.hasNext()) {
            final String argument = Utils.parseToPlainText(context, argumentQueue.pop().value());
            try {
                arguments.add(Integer.parseInt(argument));
            } catch (NumberFormatException exception1) {
                try {
                    arguments.add(Double.parseDouble(argument));
                } catch (NumberFormatException exception2) {
                    arguments.add(argument);
                }
            }
        }
        return Tag.preProcessParsed(String.format(format, arguments.toArray(Object[]::new)));
    }
}
