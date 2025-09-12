package io.github.miniplaceholders.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expressions.Expression;
import io.github.miniplaceholders.expressions.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public final class ExprMul implements Expression {
    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("mul", this);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final @NotNull Context context) {
        double n = 1;
        boolean isFloat = false;
        while (argumentQueue.hasNext()) {
            String s = Utils.parseToPlainText(context, argumentQueue.pop().value());
            if (s.indexOf('.') != -1) {
                isFloat = true;
            }
            n *= Utils.parseDouble(context, s);
        }

        final String value = isFloat
                ? Double.toString(n)
                : Integer.toString((int) Math.round(n));
        return Tag.preProcessParsed(value);
    }
}
