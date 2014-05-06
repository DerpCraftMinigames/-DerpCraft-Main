package me.kobini.derpcraft.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

@SuppressWarnings("deprecation")
public class Events implements Listener{
	
	//Strings
	String derpbot = ChatColor.DARK_GREEN + "<===|- [DerpBot] ";
	
	//Methods
	public String DerpBot(){
		return derpbot;
	}
	
	//Death Message
	@EventHandler
    public void Death(PlayerDeathEvent e){
		Player p = ((OfflinePlayer) e).getPlayer();
		e.setDeathMessage("");
		p.chat("/pet remove");
	}
	//Block BedEnter
	@EventHandler 
	public void EnterBed(PlayerBedEnterEvent e){
		e.setCancelled(true);
	}
	//Block /plugins,/pl en /jail
	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		String[] split = e.getMessage().split(" ");
		if (split.length < 1) return;
		String cmd = split[0].trim().substring(1).toLowerCase();
		if (cmd.equalsIgnoreCase("plugins") || cmd.equalsIgnoreCase("pl")){
			if(!p.isOp()){
				e.setCancelled(true);
				p.sendMessage(ChatColor.RED + "Custom made plugins voor" + ChatColor.BLUE + " DerpCraft");
			}
		}if (cmd.equalsIgnoreCase("jail")){
				e.setCancelled(true);
			if(p.isOp()){
				p.sendMessage(ChatColor.DARK_RED + "[DerpCraft] " + ChatColor.RED + "Why do you want to jail?Ban him.");
			}else{
				p.sendMessage(ChatColor.DARK_RED + "[DerpCraft] " + ChatColor.RED + "Why do you try to jail?Ask to ban him.");
			}
		}
	}
	//DerpBot
	@EventHandler
	public void Chat(PlayerChatEvent e){
		Player p = e.getPlayer();
		String name = p.getName();
		if(e.getMessage().toLowerCase().contains("!cute")){
			e.setCancelled(true);
			Bukkit.broadcastMessage(DerpBot() + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Cutness OVERLOAD");
		}else if(e.getMessage().toLowerCase().contains("!host")){
			e.setCancelled(true);
			Bukkit.broadcastMessage(DerpBot() + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "The host is: http://wdmsh.nl/");
		}else if(e.getMessage().toLowerCase().contains("!hunger")){
			e.setCancelled(true);
			Bukkit.broadcastMessage(DerpBot() + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "I'm a bot, I don't eat!");
		}else if(e.getMessage().toLowerCase().contains("!derpy")){
			e.setCancelled(true);
			Bukkit.broadcastMessage(DerpBot() + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + ChatColor.UNDERLINE + name + ChatColor.LIGHT_PURPLE + " is a derp!");
		}else if(e.getMessage().toLowerCase().contains("!mail")){
			e.setCancelled(true);
			Bukkit.broadcastMessage(DerpBot() + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "derpcraftminigames@gmail.com");
		}else if(e.getMessage().toLowerCase().contains("!ip")){
			e.setCancelled(true);
			Bukkit.broadcastMessage(DerpBot() + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "The ip is: '37.187.78.163:25591' <3");
		}else if(e.getMessage().toLowerCase().contains("!noob")){
			e.setCancelled(true);
			Bukkit.broadcastMessage(DerpBot() + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + ChatColor.UNDERLINE + name + ChatColor.LIGHT_PURPLE + " is a noob");
		}else if(e.getMessage().toLowerCase().contains("!support")){
			e.setCancelled(true);
			Bukkit.broadcastMessage(DerpBot() + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "If you want to support the server, please donate! <DonateDingeLink>");
		}else if(e.getMessage().toLowerCase().contains("!command")){
			e.setCancelled(true);
			p.sendMessage(DerpBot() + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "host,hunger,derpy,mail,ip,noob and support!");
		}
	}
}
	

