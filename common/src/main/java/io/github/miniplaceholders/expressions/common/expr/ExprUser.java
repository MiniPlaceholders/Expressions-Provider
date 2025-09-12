
package io.github.miniplaceholders.expressions.common.expr;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expressions.common.Configuration;
import io.github.miniplaceholders.expressions.common.Expression;
import io.github.miniplaceholders.expressions.common.Utils;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;

public final class ExprUser implements Expression {
    private final Configuration config;

    public ExprUser(final Configuration config) {
        this.config = config;
    }

    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("user", this);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final @NotNull Context context) {
        final String expressionName = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_user> requires at least 1 argument").value());
        final TagResolver.Builder resolverBuilder = TagResolver.builder();
        for (int i = 1; argumentQueue.hasNext(); i++) {
            resolverBuilder.resolver(Placeholder.parsed("arg" + i, Utils.parseToPlainText(context, argumentQueue.pop().value())));
        }
        final String expression = config.getUserExpressions().get(expressionName);
        return Tag.inserting(context.deserialize(expression, resolverBuilder.build()));
    }
}
