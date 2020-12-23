package fr.extasio.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import fr.extasio.listeners.OtherListener;



public class Main extends JavaPlugin {

	private static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		Bukkit.getServer().getPluginManager().registerEvents(new OtherListener(), this);
		System.out.println("LC-Perl - V1");

	}
	
	@Override
    public void onDisable(){
    }

	public static Main getInstance() {
		return instance; 
	}
	
}
