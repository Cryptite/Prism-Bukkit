package me.botsko.prism.actions.entity;

import me.botsko.prism.utils.MiscUtils;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Entity;

public class CatSerializer extends EntitySerializer {
    protected String var = null;

    @Override
    protected void serializer(Entity entity) {
        var = ((Cat) entity).getCatType().name().toLowerCase();
    }

    @Override
    protected void deserializer(Entity entity) {
        if (var != null) {
            try {
                Cat.Type type = Cat.Type.valueOf(var);
                ((Cat) entity).setCatType(type);
            } catch (Exception ignored) {
                ((Cat) entity).setCatType(Cat.Type.ALL_BLACK);
            }
        }
    }

    @Override
    protected void niceName(StringBuilder sb, int start) {
        if (var != null) {
            sb.insert(start, MiscUtils.niceName(var)).insert(start + var.length(), ' ');
        }
    }
}
