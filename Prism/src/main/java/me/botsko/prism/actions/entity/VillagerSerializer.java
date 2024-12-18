package me.botsko.prism.actions.entity;

import me.botsko.prism.utils.MiscUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;

public class VillagerSerializer extends EntitySerializer {
    protected String profession = null;

    @Override
    protected void serializer(Entity entity) {
        profession = ((Villager) entity).getProfession().name().toLowerCase();
    }

    @Override
    protected void deserializer(Entity entity) {
        if (profession != null) {
            try {
                Profession prof = Profession.valueOf(profession);
                ((Villager) entity).setProfession(prof);
            } catch (Exception ignored) {
                ((Villager) entity).setProfession(Profession.FARMER);
            }
        }
    }

    @Override
    protected void niceName(StringBuilder sb, int start) {
        if (profession != null) {
            sb.insert(start, MiscUtils.niceName(profession)).insert(start + profession.length(), ' ');
        }
    }
}
