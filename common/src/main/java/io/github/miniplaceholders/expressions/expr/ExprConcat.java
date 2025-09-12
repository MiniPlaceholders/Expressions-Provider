package io.github.miniplaceholders.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expressions.Expression;
import io.github.miniplaceholders.expressions.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import org.jetbrains.annotations.NotNull;

public final class ExprConcat implements Expression {
    @Override
    public void register(Expansion.Builder builder) {
        builder.globalPlaceholder("concat", this);
    }

    @Override
    public Tag tag(ArgumentQueue argumentQueue, @NotNull Context context) {
        final StringBuilder s = new StringBuilder();
        while (argumentQueue.hasNext()) {
            s.append(Utils.parseToPlainText(context, argumentQueue.pop().value()));
        }
        return Tag.preProcessParsed(s.toString());
    }
}
