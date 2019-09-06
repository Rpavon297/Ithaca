package com.koduck.ithaca.setup;

import net.minecraft.world.World;

public class ServerProxy implements IProxy {
    @Override
    public World getClientWorld() {
        throw new IllegalStateException("Only runnable on client");
    }
}
