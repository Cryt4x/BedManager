package de.cryt4x.bm.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class SeeInventory implements CommandExecutor
{

	@Override
	public boolean onCommand (CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player)
		{
			Player player = (Player) sender;
			if (player.hasPermission("bbcorecpl.cinv"))
			{
				if (args.length == 1)
				{
					Player target = Bukkit.getPlayer(args[0]);
					Inventory inventory = target.getInventory();
					player.openInventory(inventory);
					player.sendMessage("§6Inventory of "+target.getName()+" was opened!");
				}
				else
				{
					player.sendMessage("§cPls use §6/cinv <PLAYER>$c!");
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
