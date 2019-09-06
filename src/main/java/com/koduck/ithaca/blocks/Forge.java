package com.koduck.ithaca.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class Forge extends Block {

    public Forge(){
        super(Properties.create(Material.IRON)
        .sound(SoundType.ANVIL)
        .hardnessAndResistance(2.0f)
        .lightValue(7)
        );
        setRegistryName("forge");
    }
}
