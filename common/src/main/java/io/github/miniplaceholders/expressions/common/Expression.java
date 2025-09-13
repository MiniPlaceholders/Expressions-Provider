package io.github.miniplaceholders.expressions.common;

import io.github.miniplaceholders.api.Expansion;
import io.github.miniplaceholders.api.resolver.GlobalTagResolver;
import io.github.miniplaceholders.expressions.common.expr.*;

public sealed interface Expression extends GlobalTagResolver
        permits ExprAdd,
                ExprCeil,
                ExprConcat,
                ExprDiv,
                ExprFloor,
                ExprFormat,
                ExprIf,
                ExprLength,
                ExprMax,
                ExprMin,
                ExprMod,
                ExprMul,
                ExprNeg,
                ExprPlayer,
                ExprRandom,
                ExprRound,
                ExprSub,
                ExprSubstring,
                ExprUser
{
    void register(final Expansion.Builder builder);
}
