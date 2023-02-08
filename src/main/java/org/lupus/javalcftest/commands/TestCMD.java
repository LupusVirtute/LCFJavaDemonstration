package org.lupus.javalcftest.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.lupus.commands.core.annotations.NamedDependency;
import org.lupus.commands.core.annotations.general.*;
import org.lupus.commands.core.annotations.method.Cooldown;
import org.lupus.commands.core.annotations.method.Default;
import org.lupus.commands.core.annotations.method.Filter;
import org.lupus.commands.core.annotations.parameters.Optional;
import org.lupus.commands.core.annotations.parameters.ParamName;
import org.lupus.commands.core.annotations.parameters.WildCard;
import org.lupus.commands.core.messages.I18nMessage;

@Aliases(aliases = "t|testing|tester|somethingsomething")
public class TestCMD {
    @NamedDependency
    JavaPlugin plugin;

    public String noAnnotationsTest(CommandSender sender) {
        return "Lol";
    }

    @Async
    public String asyncTest(CommandSender sender) {
        return "Is Async : " + Bukkit.isPrimaryThread();
    }

    @CMDName(name = "test-i18n")
    public String testI18n(CommandSender sender) {
        return "<test-i18n>";
    }

    @Default
    public String testDefault(CommandSender sender) {
        return "this is default cmd";
    }

    @CMDName(name = "plugin-name")
    public String pluginName(CommandSender sender) {
        return plugin.getName();
    }

    @CMDName(name = "test-i18n-msg-handler")
    public I18nMessage testI18nMessageHandling(CommandSender sender) {
        return new I18nMessage(plugin, "test-18n-wrapper");
    }

    @CMDName(name = "wildcard-test")
    public String testWildcard(CommandSender sender, @WildCard World world) {
        return world.getName();
    }

    @Filter(filters = "world-filter")
    @CMDName(name = "filter-test")
    public String testFiltering(CommandSender sender, World world) {
        return world.getName();
    }

    @CMDName(name = "test-optional")
    public String testOptional(CommandSender sender, @Optional(defaultValue = "1") int optionalX) {
        return "Your value: " + optionalX;
    }

    @CMDName(name = "param-name-test")
    public String paramNameTest(CommandSender sender, @ParamName(paramName = "DEFINITELY A PARAMETER") int someSomethingSome) {
        return someSomethingSome + "";
    }

    @Cooldown(time = "10s")
    @CMDName(name = "cooldown-test")
    public String cooldownTest(CommandSender sender) {
        return "Coooooooll down";
    }

    @Perm(permission = "test.permission")
    @CMDName(name = "permission-test")
    public String permissionTest(CommandSender sender) {
        return "YOU HAVE PERMISSION YAY";
    }


    private String privacyCheckShouldntBeCMD(CommandSender sender) {
        return "LOL";
    }
}
