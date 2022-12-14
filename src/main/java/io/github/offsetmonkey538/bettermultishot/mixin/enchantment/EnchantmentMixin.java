package io.github.offsetmonkey538.bettermultishot.mixin.enchantment;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import io.github.offsetmonkey538.bettermultishot.item.IMultishotThrowableItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.MultishotEnchantment;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Enchantment.class)
public abstract class EnchantmentMixin {

    @ModifyReturnValue(
            method = "isAcceptableItem",
            at = @At("RETURN")
    )
    @SuppressWarnings({"ConstantConditions", "unused"})
    public boolean bettermultishot$makeBowsAndThrowableIItemsAcceptableItemsForMultishot(boolean original, ItemStack item) {
        return original ||
                ((Object)this instanceof MultishotEnchantment && (item.getItem() instanceof IMultishotThrowableItem || item.getItem() instanceof BowItem));
    }
}
