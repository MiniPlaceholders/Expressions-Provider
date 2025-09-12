package io.github.miniplaceholders.expressions.velocity;

import com.velocitypowered.api.proxy.ProxyServer;
import io.github.miniplaceholders.expressions.common.Platform;
import net.kyori.adventure.audience.Audience;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

public record VelocityPlatform(ProxyServer server) implements Platform {

    @Override
    public Optional<Audience> getPlayerByUniqueId(UUID uuid) {
        return server.getPlayer(uuid).map(Function.identity());
    }

    @Override
    public Optional<? extends Audience> getPlayerByName(String name) {
        return server.getPlayer(name);
    }
}
