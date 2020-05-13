// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.
package com.mojang.datafixers.types.constant;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.DynamicOps;
import com.mojang.datafixers.types.templates.Const;

import java.util.Optional;

public final class IntType extends Const.ConstType<Integer> {
    @Override
    public <T> Pair<T, Optional<Integer>> read(final DynamicOps<T> ops, final T input) {
        return ops
            .getNumberValue(input)
            .map(v -> Pair.of(ops.empty(), Optional.of(v.intValue())))
            .orElseGet(() -> Pair.of(input, Optional.empty()));
    }

    @Override
    public <T> T write(final DynamicOps<T> ops, final T rest, final Integer value) {
        return ops.createInt(value);
    }

    @Override
    public String toString() {
        return "Int";
    }
}
