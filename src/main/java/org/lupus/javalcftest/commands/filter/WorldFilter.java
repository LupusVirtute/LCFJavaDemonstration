package org.lupus.javalcftest.commands.filter;

import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.lupus.commands.core.arguments.ArgumentType;
import org.lupus.commands.core.data.CommandLupi;
import org.lupus.commands.core.data.FilterFun;

import java.util.List;
import java.util.stream.Collectors;

public class WorldFilter extends FilterFun {
    @NotNull
    @Override
    public List<String> filterTabComplete(@NotNull CommandSender sender, @NotNull CommandLupi commandLupi, @NotNull ArgumentType argType, @NotNull List<String> tabCompleteResult) {
        if(!argType.isTheArgumentOfThisType(World.class))
            return tabCompleteResult;
        return tabCompleteResult.stream().filter((it) -> it.endsWith("world")).collect(Collectors.toList());
    }
}
