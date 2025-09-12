package io.github.miniplaceholders.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expressions.Expression;
import io.github.miniplaceholders.expressions.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public final class ExprIf implements Expression {
    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("if", this);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final @NotNull Context context) {
        final String o1 = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_if> requires 3 or 4 arguments").value());
        final String o2 = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_if> requires 3 or 4 arguments").value());
        final String p1 = argumentQueue.popOr("<expr_if> requires 3 or 4 arguments").value();
        final String p2 = argumentQueue.hasNext() ? argumentQueue.pop().value() : "";

        return Tag.preProcessParsed(o1.equals(o2) ? p1 : p2);
    }
}
