// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.
package com.mojang.datafixers.types.constant;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.DynamicOps;
import com.mojang.datafixers.types.templates.Const;

import java.util.Optional;

public final class ByteType extends Const.ConstType<Byte> {
    @Override
    public <T> Pair<T, Optional<Byte>> read(final DynamicOps<T> ops, final T input) {
        return ops
            .getNumberValue(input)
            .map(v -> Pair.of(ops.empty(), Optional.of(v.byteValue())))
            .orElseGet(() -> Pair.of(input, Optional.empty()));
    }

    @Override
    public <T> T write(final DynamicOps<T> ops, final T rest, final Byte value) {
        return ops.createByte(value);
    }

    @Override
    public String toString() {
        return "Byte";
    }
}
