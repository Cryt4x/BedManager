package de.cryt4x.bm.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NightCommand implements CommandExecutor
{
	@Override
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (player.hasPermission("bbcorecpl.day"))
			{
				if (args.length == 0)
				{
					World world = player.getWorld();
					world.setTime(13000);
					player.sendMessage("§6Time set Night! §a(13000)");
				}
				else
				{
					player.sendMessage("§cPls use §6/cwc§c!");
				}
			}
			else
			{
				player.sendMessage("§cYou don't have permission to do that!");
			}
		}
		else
		{
			sender.sendMessage("This command can only be executed by a player!");
		}
		
		return false;
	}
	
}