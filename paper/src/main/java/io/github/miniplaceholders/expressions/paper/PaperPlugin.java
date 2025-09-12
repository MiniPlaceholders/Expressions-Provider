package io.github.miniplaceholders.expressions.paper;

import io.github.miniplaceholders.expressions.common.Expressions;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

import static net.kyori.adventure.text.Component.text;

public final class PaperPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        final ComponentLogger logger = getComponentLogger();
        logger.info(text("Starting Expressions Provider...", NamedTextColor.GREEN));

        try {
            Expressions.initialize(getDataFolder().toPath(), getResource("config.yml"), new PaperPlatform());
            logger.info(text("Correctly started Expressions Provider", NamedTextColor.GREEN));
        } catch (IOException e) {
            logger.info(text("An error occurred while loading expressions", NamedTextColor.RED), e);
        }
    }
}
