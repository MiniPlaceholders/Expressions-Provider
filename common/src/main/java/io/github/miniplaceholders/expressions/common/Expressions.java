package io.github.miniplaceholders.expressions.common;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expressions.common.expr.*;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Expressions {
    public static void initialize(
            final Path dataFolder,
            final InputStream configYml,
            final Platform platform
    ) throws IOException {
        if (Files.notExists(dataFolder)) {
            Files.createDirectory(dataFolder);
        }
        final Path configFile = dataFolder.resolve("config.yml");
        try (configYml) {
            if (Files.notExists(configFile)) {
                Files.copy(configYml, configFile);
            }
        }
        final Yaml yaml = new Yaml(new Constructor(new LoaderOptions()) {
            @Override
            protected Class<?> getClassForName(String name) throws ClassNotFoundException {
                if (name.equals(Configuration.class.getName())) {
                    return Configuration.class;
                }
                return super.getClassForName(name);
            }
        });
        final Configuration config = yaml.loadAs(Files.newInputStream(configFile), Configuration.class);
        registerPlaceholders(config, platform);
    }

    public static void registerPlaceholders(final Configuration config, final Platform platform) {
        final Expansion.Builder builder = Expansion.builder("expr")
                .author("MiniPlaceholders Contributors")
                .version(Constants.VERSION);
        final Expression[] expressions = {
                new ExprAdd(),
                new ExprCeil(),
                new ExprConcat(),
                new ExprDiv(),
                new ExprFloor(),
                new ExprFormat(),
                new ExprIf(),
                new ExprLength(),
                new ExprMax(),
                new ExprMin(),
                new ExprMod(),
                new ExprMul(),
                new ExprNeg(),
                new ExprPlayer(platform),
                new ExprRandom(),
                new ExprRound(),
                new ExprSub(),
                new ExprSubstring(),
                new ExprUser(config)
        };
        for (final Expression expression : expressions) {
            expression.register(builder);
        }
        builder.build().register();
    }
}
