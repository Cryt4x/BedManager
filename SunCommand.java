package de.cryt4x.bm.commands;

import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SunCommand implements CommandExecutor
{
	@Override
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args)
	{
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (player.hasPermission("bbcorecpl.sun"))
			{
				if (args.length == 0)
				{
					World world = player.getWorld();
					world.setStorm(false);
					player.sendMessage("�6Weather set to clear!");
				}
				else
				{
					player.sendMessage("�cPls use �6/cwc�c!");
				}
			}
			else
			{
				player.sendMessage("�cYou don't have permission to do that!");
			}
		}
		else
		{
			sender.sendMessage("This command can only be executed by a player!");
		}
		
		return false;
	}
	
}