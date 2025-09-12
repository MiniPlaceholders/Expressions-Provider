package io.github.miniplaceholders.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expressions.Expression;
import io.github.miniplaceholders.expressions.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public final class ExprCeil implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("ceil", this);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final @NotNull Context context) {
        final String s = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_ceil> requires exactly 1 argument").value());
        if (argumentQueue.hasNext()) {
            throw context.newException("<expr_ceil> requires exactly 1 argument");
        }
        double n = Utils.parseDouble(context, s);
        return Tag.preProcessParsed(Integer.toString((int) Math.ceil(n)));
    }
}
