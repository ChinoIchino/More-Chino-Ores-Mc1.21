package com.Chino.MoreChinoOres.util;

import com.Chino.MoreChinoOres.MoreChinoOresApp;
import com.Chino.MoreChinoOres.item.ModItems;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = MoreChinoOresApp.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class DropEvents {

    @SubscribeEvent
    public static void onLivingDrops(LivingDropsEvent event){
        Entity source = event.getSource().getEntity();
        
        if(!(source instanceof Player player)){
            return;
        } 

        if(player.getItemBySlot(EquipmentSlot.HEAD).is(ModItems.RAG_BLINDFOLD.get())){
            //using my own random drop, because the drop chance of forge doesnt work as intended
            int rndDrop = (int) (Math.random() * 100) + 1;
            // System.out.println("Is Mob Not Friendly = " + !event.getEntity().getType().getCategory().isFriendly() + "\nChance Got = " + rndDrop + "\nGot in if = " + (!event.getEntity().getType().getCategory().isFriendly() && (rndDrop <= 50)));
            //if the mob is aggresive and have a 2% chance to drop
            if(!event.getEntity().getType().getCategory().isFriendly() && (rndDrop <= 2)){
                int whatShardToDrop = (int) (Math.random() * 4) + 1;
                RegistryObject<Item> shardRef;

                //System.out.println("Got the number: " + whatShardToDrop);

                switch (whatShardToDrop) {
                    case 1:
                        shardRef = ModItems.SHARD_WIND;
                        break;
                    case 2:
                        shardRef = ModItems.SHARD_FIRE;
                        break;
                    case 3:
                        shardRef = ModItems.SHARD_LIGHTNING;
                        break;
                    case 4:
                        shardRef = ModItems.SHARD_WATER;
                        break;
                    //default should never happen, but because i have a error im gonna override shardRef here too
                    default:
                        shardRef = ModItems.SHARD_WIND;
                        break;
                }

                event.getDrops().add(new ItemEntity(
                    player.level(),
                    event.getEntity().getX(),
                    event.getEntity().getY(),
                    event.getEntity().getZ(),
                    new ItemStack(shardRef.get())
                ));
            }
        }
    }
    
}
