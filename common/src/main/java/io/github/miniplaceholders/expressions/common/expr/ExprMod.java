package io.github.miniplaceholders.expressions.common.expr;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expressions.common.Expression;
import io.github.miniplaceholders.expressions.common.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public final class ExprMod implements Expression {
    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("mod", this);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final @NotNull Context context) {
        final String s = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_mod> requires exactly 2 arguments").value());
        final String s2 = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_mod> requires exactly 2 arguments").value());
        if (argumentQueue.hasNext()) {
            throw context.newException("<expr_mod> requires exactly 2 arguments");
        }
        final double n = Utils.parseDouble(context, s);
        final double n2 = Utils.parseDouble(context, s2);

        final boolean isFloat = s.indexOf('.') != -1 || s2.indexOf('.') != -1;
        final String value = isFloat
                ? Double.toString(n % n2)
                : Integer.toString((int) Math.round(n % n2));

        return Tag.preProcessParsed(value);
    }
}
