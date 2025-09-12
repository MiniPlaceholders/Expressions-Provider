package io.github.miniplaceholders.expressions.fabric;

import io.github.miniplaceholders.expressions.common.Expressions;
import net.fabricmc.api.DedicatedServerModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;

import java.io.IOException;
import java.nio.file.Path;

import static net.kyori.adventure.text.Component.text;

public final class FabricMod implements DedicatedServerModInitializer {
    public static final ComponentLogger LOGGER = ComponentLogger.logger("expressions-provider");

    @Override
    public void onInitializeServer() {
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            LOGGER.info(text("Starting Expressions Provider...", NamedTextColor.GREEN));
            final FabricPlatform platform = new FabricPlatform(server);
            final Path dataFolder = FabricLoader.getInstance().getConfigDir().resolve("Expressions-Expansion");
            try {
                Expressions.initialize(dataFolder, getClass().getClassLoader().getResourceAsStream("config.yml"), platform);
                LOGGER.info(text("Correctly started Expressions Provider", NamedTextColor.GREEN));
            } catch (IOException e) {
                LOGGER.info(text("An error occurred while loading expressions", NamedTextColor.RED));
            }
        });
    }
}
