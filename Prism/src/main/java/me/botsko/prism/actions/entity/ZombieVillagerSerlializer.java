package me.botsko.prism.actions.entity;

import me.botsko.prism.utils.MiscUtils;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.entity.ZombieVillager;

public class ZombieVillagerSerlializer extends EntitySerializer {
    protected String profession = null;

    @Override
    protected void serializer(Entity entity) {
        profession = ((ZombieVillager) entity).getVillagerProfession().name().toLowerCase();
    }

    @Override
    protected void deserializer(Entity entity) {
        if (profession != null) {
            try {
                Profession prof = Profession.valueOf(profession);
                ((ZombieVillager) entity).setVillagerProfession(prof);
            } catch (Exception ignored) {
                ((ZombieVillager) entity).setVillagerProfession(Profession.FARMER);
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
