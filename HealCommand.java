package de.cryt4x.bm.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor
{


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (player.hasPermission("cryt4xPL.cHeal"))
			{
				if (args.length == 0)
				{
		   			player.setHealth(20);
					player.setFoodLevel(20);
					player.sendMessage("§aYou've been healed!");
				}
				else if (args.length == 1)
				{
					Player target = Bukkit.getPlayer(args[0]);
					if (target != null)
					{
						target.setHealth(20);
						target.setFoodLevel(20);
						target.sendMessage("§aYou've been healed!");
						player.sendMessage("§a" + target.getName() + " has been healed!");
					}
					else
					{
						player.sendMessage("§cPlayer \"" + args[0] + "\" isn't on this server!");
					}
				}
				else
				{
					player.sendMessage("§cPls use §6/heal <PLAYER>§c!");
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