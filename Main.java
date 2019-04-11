package de.cryt4x.bm.main;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.cryt4x.bm.commands.BurgerBudeCryT4xPluginInfoCommand;
import de.cryt4x.bm.commands.DayCommand;
import de.cryt4x.bm.commands.HealCommand;
import de.cryt4x.bm.commands.NightCommand;
import de.cryt4x.bm.commands.SeeInventory;
import de.cryt4x.bm.commands.SuDaCommand;
import de.cryt4x.bm.commands.SunCommand;
import de.cryt4x.bm.listeners.BedListener;

public class Main extends JavaPlugin
{
	
	private static Main plugin;
	
	public void onEnable ()
	{
		plugin = this;
		
		//Server-Console Output
		System.out.println("[BedManager] BedManager (ctpl2) loaded!");
		
		//Plugin-Info
		getCommand("bedmanagerinfo").setExecutor(new BurgerBudeCryT4xPluginInfoCommand());
		
		//Commands		e.g.:	getCommand("cheal").setExecutor(new HealCommand());
		//getCommand("XXX").setExecutor(new XXX());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("night").setExecutor(new NightCommand());
		getCommand("suda").setExecutor(new SuDaCommand());
		getCommand("seeinventory").setExecutor(new SeeInventory());
		getCommand("day").setExecutor(new DayCommand());
		getCommand("sun").setExecutor(new SunCommand());
		
		//Listeners
		PluginManager pluginManager = Bukkit.getPluginManager();
		pluginManager.registerEvents(new BedListener(), this);
	}
	
	public static Main getPlugin() {
		return plugin;
	}
	
}
