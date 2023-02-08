package org.lupus.javalcftest.commands;

import org.bukkit.command.CommandSender;
import org.lupus.commands.core.annotations.clazz.Continuous;

@Continuous
public class ContinousCMD {
    public String yayNoPrefixCMD(CommandSender sender) {
        return "Test lol";
    }
}
