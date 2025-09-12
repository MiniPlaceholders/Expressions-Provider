package io.github.miniplaceholders.expressions.fabric;

import io.github.miniplaceholders.expressions.common.Platform;
import net.kyori.adventure.audience.Audience;
import net.minecraft.server.MinecraftServer;

import java.util.Optional;
import java.util.UUID;

record FabricPlatform(MinecraftServer server) implements Platform {

    @Override
    public Optional<Audience> getPlayerByUniqueId(final UUID uuid) {
        return Optional.ofNullable(server.getPlayerList().getPlayer(uuid));
    }

    @Override
    public Optional<Audience> getPlayerByName(final String name) {
        return Optional.ofNullable(server.getPlayerList().getPlayerByName(name));
    }
}
