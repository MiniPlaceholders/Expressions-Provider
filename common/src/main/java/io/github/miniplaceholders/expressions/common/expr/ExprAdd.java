package io.github.miniplaceholders.expressions.common.expr;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expressions.common.Expression;
import io.github.miniplaceholders.expressions.common.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public final class ExprAdd implements Expression {
    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("add", this);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final @NotNull Context context) {
        double n = 0;
        boolean isFloat = false;
        while (argumentQueue.hasNext()) {
            final String s = Utils.parseToPlainText(context, argumentQueue.pop().value());
            if (!isFloat && s.indexOf('.') != -1) {
                isFloat = true;
            }
            n += Utils.parseDouble(context, s);
        }
        return Tag.preProcessParsed(isFloat ? Double.toString(n) : Integer.toString((int) Math.round(n)));
    }
}
