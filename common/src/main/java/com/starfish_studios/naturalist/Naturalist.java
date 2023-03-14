package com.starfish_studios.naturalist;

import com.starfish_studios.naturalist.entity.*;
import com.starfish_studios.naturalist.platform.CommonPlatformHelper;
import com.starfish_studios.naturalist.registry.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

public class Naturalist {
    public static final String MOD_ID = "naturalist";
    public static final CreativeModeTab TAB = CommonPlatformHelper.registerCreativeModeTab(new ResourceLocation(MOD_ID, "tab"), () -> new ItemStack(Items.FERN));
    public static final Logger LOGGER = LogManager.getLogger();

    public static void init() {
        GeckoLib.initialize();
        NaturalistBlocks.init();
        NaturalistItems.init();
        NaturalistSoundEvents.init();
        NaturalistEntityTypes.init();
        NaturalistPotions.init();
    }
    
    public static void registerBrewingRecipes() {
        CommonPlatformHelper.registerBrewingRecipe(Potions.AWKWARD, NaturalistItems.ANTLER.get(), NaturalistPotions.FOREST_DASHER.get());
        CommonPlatformHelper.registerBrewingRecipe(NaturalistPotions.FOREST_DASHER.get(), Items.REDSTONE, NaturalistPotions.LONG_FOREST_DASHER.get());
        CommonPlatformHelper.registerBrewingRecipe(NaturalistPotions.FOREST_DASHER.get(), Items.GLOWSTONE_DUST, NaturalistPotions.STRONG_FOREST_DASHER.get());
        CommonPlatformHelper.registerBrewingRecipe(Potions.AWKWARD, NaturalistItems.GLOW_GOOP.get(), NaturalistPotions.GLOWING.get());
        CommonPlatformHelper.registerBrewingRecipe(NaturalistPotions.GLOWING.get(), Items.REDSTONE, NaturalistPotions.LONG_GLOWING.get());
    }

    public static void registerSpawnPlacements() {
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.SNAIL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.BEAR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.BUTTERFLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Animal::checkAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.FIREFLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Firefly::checkFireflySpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.SNAKE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Snake::checkSnakeSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.CORAL_SNAKE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Snake::checkSnakeSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.RATTLESNAKE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Snake::checkSnakeSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.DEER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.BLUEJAY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Bird::checkBirdSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.CANARY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Bird::checkBirdSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.CARDINAL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Bird::checkBirdSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.ROBIN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Bird::checkBirdSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.RHINO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.LION.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.ELEPHANT.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.ZEBRA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.GIRAFFE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.HIPPO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Hippo::checkHippoSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.VULTURE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Vulture::checkVultureSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.BOAR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.DRAGONFLY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Dragonfly::checkDragonflySpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.CATFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.ALLIGATOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Naturalist::checkSwampAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.BASS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.LIZARD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Naturalist::checkSwampAnimalSpawnRules);
        CommonPlatformHelper.registerSpawnPlacement(NaturalistEntityTypes.TORTOISE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
    }

    public static boolean checkSwampAnimalSpawnRules(EntityType<? extends Animal> type, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.getBlockState(pos.below()).is(BlockTags.FROGS_SPAWNABLE_ON) && level.getRawBrightness(pos, 0) > 8;
    }

    public static void registerCompostables() {
        CommonPlatformHelper.registerCompostable(0.65F, NaturalistItems.SNAIL_SHELL.get());
    }
}
