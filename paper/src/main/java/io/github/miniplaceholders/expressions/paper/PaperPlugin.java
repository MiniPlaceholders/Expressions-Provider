package io.github.miniplaceholders.expressions.paper;

import io.github.miniplaceholders.expressions.Expressions;
import org.bukkit.plugin.java.JavaPlugin;

public final class PaperPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Starting Expressions Expansion for Paper");

        Expressions.initialize(getDataFolder().toPath(), getResource("config.yml"), new PaperPlatform());
    }
}
