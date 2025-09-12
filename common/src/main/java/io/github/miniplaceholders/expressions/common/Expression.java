package io.github.miniplaceholders.expressions.common;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.api.resolver.GlobalTagResolver;

public interface Expression extends GlobalTagResolver {
    void register(final Expansion.Builder builder);
}
