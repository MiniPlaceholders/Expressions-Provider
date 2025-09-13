package io.github.miniplaceholders.expressions.common;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.expressions.common.expr.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class Expressions {
    public static final String EXPRESSIONS_FILE = "expressions.properties";
    public static void initialize(
            final Path dataFolder,
            final InputStream configYml,
            final Platform platform
    ) throws IOException {
        if (Files.notExists(dataFolder)) {
            Files.createDirectory(dataFolder);
        }
        final Path configFile = dataFolder.resolve(EXPRESSIONS_FILE);
        try (configYml) {
            if (Files.notExists(configFile)) {
                Files.copy(configYml, configFile);
            }
        }
        try (final BufferedReader reader = Files.newBufferedReader(configFile)) {
            Properties properties = new Properties();
            properties.load(reader);
            final Map<String, String> expressions = new HashMap<>();
            properties.forEach((key, expression) ->
                expressions.put(key.toString(), expression.toString())
            );
            registerPlaceholders(new Configuration(expressions), platform);
        } catch (IOException e) {
            throw new IOException("Unable to read expressions.properties from " + configFile + "file", e);
        }
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
