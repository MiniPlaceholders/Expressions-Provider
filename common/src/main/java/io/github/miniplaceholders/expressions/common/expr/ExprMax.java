package io.github.miniplaceholders.expressions.common.expr;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expressions.common.Expression;
import io.github.miniplaceholders.expressions.common.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public final class ExprMax implements Expression {
    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("max", this);
    }

    @Override
    public Tag tag(ArgumentQueue argumentQueue, @NotNull Context context) {
        final String s1 = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_max> requires at least 1 argument").value());
        boolean isFloat = s1.indexOf('.') != -1;
        double max = Utils.parseDouble(context, s1);
        while (argumentQueue.hasNext()) {
            final String s = Utils.parseToPlainText(context, argumentQueue.pop().value());
            if (s.indexOf('.') != -1) {
                isFloat = true;
            }
            max = Math.max(max, Utils.parseDouble(context, s));
        }
        final String value = isFloat
                ? Double.toString(max)
                : Integer.toString((int) Math.round(max));
        return Tag.preProcessParsed(value);
    }
}
