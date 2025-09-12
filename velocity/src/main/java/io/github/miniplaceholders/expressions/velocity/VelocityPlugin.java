package io.github.miniplaceholders.expressions.velocity;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Dependency;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import io.github.miniplaceholders.expressions.common.Constants;
import io.github.miniplaceholders.expressions.common.Expressions;
import io.github.miniplaceholders.expressions.common.Platform;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.logger.slf4j.ComponentLogger;

import java.io.IOException;
import java.nio.file.Path;

import static net.kyori.adventure.text.Component.text;

@Plugin(
        name = "ExpressionsProvider",
        id = "expressionsprovider",
        version = Constants.VERSION,
        authors = {"Sliman4", "4drian3d"},
        dependencies = {
                @Dependency(id = "miniplaceholders")
        }
)
public final class VelocityPlugin {
    private final ComponentLogger logger;
    private final Path dataFolder;
    private final Platform platform;

    @Inject
    public VelocityPlugin(
            final ComponentLogger logger,
            final ProxyServer server,
            @DataDirectory final Path dataFolder
    ) {
        this.logger = logger;
        this.dataFolder = dataFolder;
        this.platform = new VelocityPlatform(server);
    }

    @Subscribe
    public void onProxyInitialize(ProxyInitializeEvent event) {
        logger.info(text("Starting Expressions Provider...", NamedTextColor.GREEN));

        try {
            Expressions.initialize(dataFolder, getClass().getClassLoader().getResourceAsStream("config.yml"), platform);
            logger.info(text("Correctly started Expressions Provider", NamedTextColor.GREEN));
        } catch (IOException e) {
            logger.info(text("An error occurred while loading expressions", NamedTextColor.RED), e);
        }
    }
}
