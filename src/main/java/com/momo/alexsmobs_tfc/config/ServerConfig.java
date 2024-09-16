package com.momo.alexsmobs_tfc.config;

import net.dries007.tfc.config.ConfigBuilder;
import net.dries007.tfc.config.animals.MammalConfig;

// UNIMPLEMENTED

public class ServerConfig {

    public final MammalConfig mooseConfig;

    ServerConfig(ConfigBuilder builder) {

        builder.push("test");

        builder.swap("moose");
        mooseConfig = MammalConfig.build(builder, "moose", 0.35, 80, 60, false, 19, 1);

    }
}
