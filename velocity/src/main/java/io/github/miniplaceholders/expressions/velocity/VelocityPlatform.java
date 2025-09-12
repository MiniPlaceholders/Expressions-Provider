package io.github.miniplaceholders.expressions.velocity;

import com.velocitypowered.api.proxy.ProxyServer;
import io.github.miniplaceholders.expressions.common.Platform;
import net.kyori.adventure.audience.Audience;

import java.util.Optional;
import java.util.UUID;

public class VelocityPlatform implements Platform {
    private final ProxyServer server;

    public VelocityPlatform(final ProxyServer server) {
        this.server = server;
    }

    @Override
    public Optional<Audience> getPlayerByUniqueId(UUID uuid) {
        return server.getPlayer(uuid).map(player -> player);
    }

    @Override
    public Optional<Audience> getPlayerByName(String name) {
        return server.getPlayer(name).map(player -> player);
    }
}
