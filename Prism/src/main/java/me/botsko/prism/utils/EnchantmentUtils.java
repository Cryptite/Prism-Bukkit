package me.botsko.prism.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class EnchantmentUtils {

    /**
     * Given an enchantment, does the current item have any that conflict.
     *
     * @return bool
     */
    @SuppressWarnings("unused")
    public static boolean hasConflictingEnchanment(ItemStack item, Enchantment ench) {
        Map<Enchantment, Integer> enchantments = item.getEnchantments();
        boolean conflict = false;
        for (Enchantment e : enchantments.keySet()) {
            if (ench.conflictsWith(e)) {
                conflict = true;
            }
        }
        return (enchantments.containsKey(ench) || conflict);
    }

    /**
     * Return the enchantment based on a common name.
     *
     * @param name String
     * @return Enchantment
     */
    @SuppressWarnings("unused")
    public static Enchantment getEnchantmentFromCommonName(String name) {
        switch (name.toLowerCase()) {
            case "aquaaffinity":
                return Enchantment.AQUA_AFFINITY;
            case "bane":
                return Enchantment.BANE_OF_ARTHROPODS;
            case "efficiency":
                return Enchantment.EFFICIENCY;
            case "explosion":
                return Enchantment.BLAST_PROTECTION;
            case "fall":
                return Enchantment.FEATHER_FALLING;
            case "fire":
                return Enchantment.FIRE_PROTECTION;
            case "fireaspect":
                return Enchantment.FIRE_ASPECT;
            case "flame":
                return Enchantment.FLAME;
            case "fortune":
                return Enchantment.FORTUNE;
            case "infinity":
                return Enchantment.INFINITY;
            case "knockback":
                return Enchantment.KNOCKBACK;
            case "power":
                return Enchantment.POWER;
            case "looting":
                return Enchantment.LOOTING;
            case "projectile":
                return Enchantment.PROJECTILE_PROTECTION;
            case "protection":
                return Enchantment.PROTECTION;
            case "punch":
                return Enchantment.PUNCH;
            case "respiration":
                return Enchantment.RESPIRATION;
            case "sharpness":
                return Enchantment.SHARPNESS;
            case "silktouch":
                return Enchantment.SILK_TOUCH;
            case "smite":
                return Enchantment.SMITE;
            case "unbreaking":
                return Enchantment.UNBREAKING;
            default:
                String formattedName = name.replace(' ','_');
                NamespacedKey key = NamespacedKey.minecraft(formattedName);
                return Enchantment.getByKey(key);
        }
    }

    /**
     * Return the common name for an enchantment.
     *
     * @param enchantment Keyed
     * @param level int
     * @return String
     */
    public static String getClientSideEnchantmentName(Enchantment enchantment, int level) {

        String enchantName;

        if (enchantment.equals(Enchantment.POWER)) {
            enchantName = "power";
        } else if (enchantment.equals(Enchantment.FLAME)) {
            enchantName = "flame";
        } else if (enchantment.equals(Enchantment.INFINITY)) {
            enchantName = "infinity";
        } else if (enchantment.equals(Enchantment.PUNCH)) {
            enchantName = "punch";
        } else if (enchantment.equals(Enchantment.SHARPNESS)) {
            enchantName = "sharpness";
        } else if (enchantment.equals(Enchantment.BANE_OF_ARTHROPODS)) {
            enchantName = "bane of anthropods";
        } else if (enchantment.equals(Enchantment.SMITE)) {
            enchantName = "damage undead";
        } else if (enchantment.equals(Enchantment.EFFICIENCY)) {
            enchantName = "efficiency";
        } else if (enchantment.equals(Enchantment.UNBREAKING)) {
            enchantName = "unbreaking";
        } else if (enchantment.equals(Enchantment.FORTUNE)) {
            enchantName = "fortune";
        } else if (enchantment.equals(Enchantment.LOOTING)) {
            enchantName = "looting";
        } else if (enchantment.equals(Enchantment.RESPIRATION)) {
            enchantName = "respiration";
        } else if (enchantment.equals(Enchantment.PROTECTION)) {
            enchantName = "protection";
        } else if (enchantment.equals(Enchantment.BLAST_PROTECTION)) {
            enchantName = "blast protection";
        } else if (enchantment.equals(Enchantment.FEATHER_FALLING)) {
            enchantName = "feather falling";
        } else if (enchantment.equals(Enchantment.FIRE_PROTECTION)) {
            enchantName = "fire protection";
        } else if (enchantment.equals(Enchantment.PROJECTILE_PROTECTION)) {
            enchantName = "projectile protection";
        } else if (enchantment.equals(Enchantment.AQUA_AFFINITY)) {
            enchantName = "aqua affinity";
        } else if (enchantment.equals(Enchantment.VANISHING_CURSE)) {
            enchantName = "vanishing curse";
        } else {
            // can leave as-is: SILK_TOUCH, FIRE_ASPECT, KNOCKBACK, THORNS, LUCK, LURE
            enchantName = enchantment.getKey().getKey().toLowerCase().replace("_", " ");
        }
        switch (level) {
            case 1:
                enchantName += " I";
                break;
            case 2:
                enchantName += " II";
                break;
            case 3:
                enchantName += " III";
                break;
            case 4:
                enchantName += " IV";
                break;
            case 5:
                enchantName += " V";
                break;
            default:
                enchantName += " " + level;
        }
        return enchantName;

    }
}
