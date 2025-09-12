package io.github.miniplaceholders.expressions.common;

import net.kyori.adventure.audience.Audience;

import java.util.Optional;
import java.util.UUID;

public interface Platform {
    Optional<Audience> getPlayerByUniqueId(UUID uuid);
    Optional<? extends Audience> getPlayerByName(String name);
}
