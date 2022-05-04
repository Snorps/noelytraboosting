package net.snorps.noelytraboosting.mixin;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.FireworkRocketItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireworkRocketItem.class)
public class FireworkRocketItemMixin {

    @Inject(at=@At("HEAD"), method= "use", cancellable=true)
    public void returnEmpty(Level l, Player p, InteractionHand I, CallbackInfoReturnable<InteractionResultHolder<ItemStack>> ci) {
        ci.setReturnValue(InteractionResultHolder.fail(p.getItemInHand(I)));
    }
}
