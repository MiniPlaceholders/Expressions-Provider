package io.github.miniplaceholders.expressions.paper;

import io.github.miniplaceholders.expressions.common.Platform;
import net.kyori.adventure.audience.Audience;
import org.bukkit.Bukkit;

import java.util.Optional;
import java.util.UUID;

public class PaperPlatform implements Platform {
    @Override
    public Optional<Audience> getPlayerByUniqueId(final UUID uuid) {
        return Optional.ofNullable(Bukkit.getPlayer(uuid));
    }

    @Override
    public Optional<Audience> getPlayerByName(final String name) {
        return Optional.ofNullable(Bukkit.getPlayer(name));
    }
}
