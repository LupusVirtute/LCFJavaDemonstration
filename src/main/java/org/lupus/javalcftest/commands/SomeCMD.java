package org.lupus.javalcftest.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.lupus.commands.core.annotations.clazz.HelpCMD;
import org.lupus.commands.core.annotations.general.Conditions;
import org.lupus.commands.core.annotations.general.Desc;
import org.lupus.commands.core.annotations.general.NoPerm;

@HelpCMD
@NoPerm
public class SomeCMD {

    @Desc(desc = "There should be something fo sho")
    public String somethingFoSho(CommandSender sender) {
        return "lol";
    }

    @Conditions(conditions = "survival")
    public String conditionTest(Player sender) {
        return "You are in survival";
    }
}
