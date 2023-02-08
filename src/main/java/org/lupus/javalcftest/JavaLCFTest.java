package org.lupus.javalcftest;

import kotlin.text.Regex;
import org.bukkit.plugin.java.JavaPlugin;
import org.lupus.commands.core.managers.FilterManager;
import org.lupus.commands.core.managers.NamedDependencyInjectorMap;
import org.lupus.commands.core.scanner.Scanner;
import org.lupus.commands.core.utils.LogUtil;
import org.lupus.javalcftest.commands.filter.WorldFilter;

import java.util.HashMap;

public final class JavaLCFTest extends JavaPlugin {

    @Override
    public void onEnable() {
        var namingSchema = new Regex("Command|CMD");
        var lcfScanner = new Scanner(this, "", namingSchema);

        var dependencies = new HashMap<String, Object>();

        dependencies.put("plugin", this);

        NamedDependencyInjectorMap.INSTANCE.addDependencies(this, dependencies);
        FilterManager.INSTANCE.put("world-filter", new WorldFilter());

        LogUtil.INSTANCE.setDebug(true);

        lcfScanner.scan("org.lupus.javalcftest.commands", true);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
