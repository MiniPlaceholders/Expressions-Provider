
package io.github.miniplaceholders.expressions.expr;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.api.MiniPlaceholders;
import io.github.miniplaceholders.expressions.Expression;
import io.github.miniplaceholders.expressions.Platform;
import io.github.miniplaceholders.expressions.Utils;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.minimessage.Context;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.Tag;
import net.kyori.adventure.text.minimessage.tag.resolver.ArgumentQueue;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public final class ExprPlayer implements Expression {
    private final Platform platform;

    public ExprPlayer(final Platform platform) {
        this.platform = platform;
    }

    @Override
    public void register(final Expansion.Builder builder) {
        builder.globalPlaceholder("player", this);
    }

    @Override
    public Tag tag(final ArgumentQueue argumentQueue, final @NotNull Context context) {
        final String player = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_player> requires exactly 2 arguments").value());
        final String text = Utils.parseToPlainText(context, argumentQueue.popOr("<expr_player> requires exactly 2 arguments").value());

        if (argumentQueue.hasNext()) {
            throw context.newException("<expr_player> requires exactly 2 arguments");
        }

        Audience audience;
        try {
            UUID uuid = UUID.fromString(player);
            audience = platform.getPlayerByUniqueId(uuid).orElseGet(() -> platform.getPlayerByName(player).orElse(null));
        } catch (IllegalArgumentException exception) {
            audience = platform.getPlayerByName(player).orElse(null);
        }
        final TagResolver placeholders = audience == null
                ? MiniPlaceholders.getGlobalPlaceholders()
                : MiniPlaceholders.getAudienceGlobalPlaceholders(audience);

        return Tag.inserting(MiniMessage.miniMessage().deserialize(text, placeholders));
    }
}
