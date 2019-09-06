package com.koduck.ithaca.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Test extends Block {

    public Test() {
        super(Properties.create(Material.IRON)
                .sound(SoundType.ANVIL)
                .hardnessAndResistance(2.0f)
                .lightValue(7)
        );
        setRegistryName("test");
    }
}
