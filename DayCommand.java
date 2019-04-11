package de.cryt4x.bm.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayCommand implements CommandExecutor
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
					world.setTime(1000);
					player.sendMessage("񘬒Time set Day! (1000)");
				}
				else
				{
					player.sendMessage("Pls use �6/cwc!");
				}
			}
			else
			{
				player.sendMessage("You don't have permission to do that!");
			}
		}
		else
		{
			sender.sendMessage("This command can only be executed by a player!");
		}
		
		return false;
	}
	
}