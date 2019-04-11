package de.cryt4x.bm.listeners;

import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedEnterEvent.BedEnterResult;

import de.cryt4x.bm.main.Main;

public class BedListener implements Listener
{

	@EventHandler
	public void onPlayerGoInBed (PlayerBedEnterEvent eventGoInBed) //If someone clicks on bed
	{
		
		Player player = eventGoInBed.getPlayer();
		if (eventGoInBed.getBedEnterResult() == BedEnterResult.OK) //If it's possible to sleep in this bed
		{
			Bukkit.broadcastMessage("§b"+player.getName()+" §awent to bed!"); //Everybody sees who went in bed
		        
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() //20 Tick delay (1 second) (necessary fox next code)
			{
	            public void run()
	            {
	            	double sleepingPlayer = 0; //sleeping online player
	            	double onlinePlayer    = (Bukkit.getServer().getOnlinePlayers().size()); //online-player-amount
	            	double minNeededPlayer = onlinePlayer/2; //Needed player-amount to cut the night
	        		
	            	Object p[] = Bukkit.getServer().getOnlinePlayers().toArray(); //All player in one Array
	            	
	            	
	            	for (int i=0;i<onlinePlayer;i++) //Checking every player if sleeping -> if(true) -> "sleepingPlayer" +=1
	            	{
	                	Player sMütz = (Player)p[i];
	                	if (sMütz.isSleeping())
	                	{
	                		sleepingPlayer++;
	                	}
	            	}
	            	
	            	/*               Debug information for testing          */
	            	//player.sendMessage("SleepingPayer: " + sleepingPlayer);
	            	//player.sendMessage("OnlinePlayer: " + onlinePlayer);
	            	//player.sendMessage("MinNeededPlayer: " + minNeededPlayer);
	            	
	            	if (sleepingPlayer>=minNeededPlayer) //if enough player to cut night -> cut night
	            	{
	            		World mainWelt = Bukkit.getWorld("world");
	            		mainWelt.setTime(1000);
	            		Bukkit.broadcastMessage("§aAt least 50% of all Players could get some sleep!");
	            	}
	            	else
	            	{
		            	player.sendMessage("§b"+(int)sleepingPlayer + " §aof §b" + (int)onlinePlayer + " §aplayers are currently sleeping!");
	            	}
	            } 
			}, 20L);
		}
	}
}
