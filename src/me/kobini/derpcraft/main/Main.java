package me.kobini.derpcraft.main;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener{	
	
	Main instance;
	
	public static Main plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	
	
	public void onEnable(){
		logger.info("[DerpcraftMain] has been enabled");
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new Events(), this);
		
		File file = new File(getDataFolder() + File.separator + "config.yml");
		
		if(!file.exists()){
			getLogger().info("Generating config.yml....");
			getConfig().options().copyDefaults(true);
			if(!getConfig().contains("skype")){
				getConfig().addDefault("skype", "There is no Skype given");
			}if(!getConfig().contains("twitter")){
				getConfig().addDefault("twitter", "There is no twitter given");
			}if(!getConfig().contains("jnp")){
				getConfig().addDefault("jnp", "&6[&2+&6]");
			}if(!getConfig().contains("qtp")){
				getConfig().addDefault("qtp", "&6[&4-&6]");
			}
		}
	}
	public void onDisable(){
	    logger.info("[DerpcraftMain] has been disabled");
	    getConfig().options().copyDefaults(true);
	    saveConfig();
	}


	//Strings
	String noperm = ChatColor.DARK_RED + "[DerpCraft] " + ChatColor.RED + "You don't have permission for this!";
	String ahelp = ChatColor.RED + "[Admin][DerpCraft]" + ChatColor.AQUA + " /dc info " + ChatColor.GREEN + "Give's info about DerpCraft";
	String ahelp2 =	ChatColor.RED + "[Admin][DerpCraft]" + ChatColor.AQUA + " /dc kobe " + ChatColor.GREEN + "Give's info about Kobe";
	String ahelp3 = ChatColor.RED + "[Admin][DerpCraft]" + ChatColor.AQUA + " /dc reload " + ChatColor.GREEN + "Reloads the plugin";
	String ahelp4 = ChatColor.RED + "[Admin][DerpCraft]" + ChatColor.AQUA + " /dc clear own " + ChatColor.GREEN + "Clear you're own chat";
	String ahelp5 = ChatColor.RED + "[Admin][DerpCraft]" + ChatColor.AQUA + " /dc clear all " + ChatColor.GREEN + "Clear the chat";
	String ahelp6 = ChatColor.RED + "[Admin][DerpCraft]" + ChatColor.AQUA + " /dc floris " + ChatColor.GREEN + "Give's info about Floris";
	String ahelp7 = ChatColor.RED + "[Admin][DerpCraft]" + ChatColor.AQUA + " /dc jiska " + ChatColor.GREEN + "Give's info about Jiska";
	String ahelp8 = ChatColor.RED + "[Admin][DerpCraft]" + ChatColor.AQUA + " /dc sijmen " + ChatColor.GREEN + "Give's info about Sijmen";
	String ahelp9 = ChatColor.RED + "[Admin][DerpCraft]" + ChatColor.AQUA + " /dc yari " + ChatColor.GREEN + "Give's info about Yari";
	String ahelp10 = ChatColor.RED + "[Admin][DerpCraft]" + ChatColor.AQUA + " /oponly " + ChatColor.GREEN + "Set's everyone or only op's can join!";
	String ahelp11 = ChatColor.RED + "[Admin][DerpCraft]" + ChatColor.AQUA + " /dc kick <targetplayer> <reason> " + ChatColor.GREEN + "Kick a player!";
	String help = ChatColor.RED + "[DerpCraft]" + ChatColor.AQUA + " /dc info " + ChatColor.GREEN + "Give's info about DerpCraft";
	String help2 =	ChatColor.RED + "[DerpCraft]" + ChatColor.AQUA + " /dc kobe " + ChatColor.GREEN + "Give's info about Kobe";
	String help3 = ChatColor.RED + "[DerpCraft]" + ChatColor.AQUA + " /dc clear own " + ChatColor.GREEN + "Clear you're own chat";
	String help4 =	ChatColor.RED + "[DerpCraft]" + ChatColor.AQUA + " /dc prefix see <name> " + ChatColor.GREEN + "See the prefix of a user";
	String info = ChatColor.GOLD + "[Derpcraft]" + ChatColor.BLUE + " Skype: " + ChatColor.DARK_GREEN + getConfig().getString("skype");
	String info2 = ChatColor.GOLD + "[Derpcraft]" + ChatColor.BLUE + " Twitter: " + ChatColor.DARK_GREEN + getConfig().getString("twitter");
	String kobe = ChatColor.GOLD + "[Derpcraft]" + ChatColor.BLUE + " Kobe is the Belgian that maked this plugin!";
	String jiska = ChatColor.GOLD + "[Derpcraft]" + ChatColor.BLUE + " Jiska has build some skywars maps";
	String floris = ChatColor.GOLD + "[Derpcraft]" + ChatColor.BLUE + " Floris is the owner of the server!";
	String sijmen = ChatColor.GOLD + "[Derpcraft]" + ChatColor.BLUE + " Sijmen is the best builder on the server!";
	String yari = ChatColor.GOLD + "[Derpcraft]" + ChatColor.BLUE + " Yari is the best Admin!";
	String reload = ChatColor.YELLOW + "[Derpcraft]" + ChatColor.RED + ChatColor.BOLD + " Plugin Reloaded!";
	String admin = "dc.main.admin";
	String owner = "dc.main.owner";
	
	//Methods
	public void Reload(){
		this.reloadConfig();
		
		PluginManager pm = getServer().getPluginManager();
		Plugin dpc = pm.getPlugin("DerpCraftCustom");
		pm.disablePlugin(dpc);
		pm.enablePlugin(dpc); 
	}
	public String NoPerms(){
		return noperm;
	}
	public String AHelp1(){
		return ahelp;
	}
	public String AHelp2(){
		return ahelp2;
	}
	public String AHelp3(){
		return ahelp3;
	}
	public String AHelp4(){
		return ahelp4;
	}
	public String AHelp5(){
		return ahelp5;
	}
	public String AHelp6(){
		return ahelp6;
	}
	public String AHelp7(){
		return ahelp7;
	}
	public String AHelp8(){
		return ahelp8;
	}
	public String AHelp9(){
		return ahelp9;
	}
	public String AHelp10(){
		return ahelp10;
	}
	public String AHelp11(){
		return ahelp11;
	}
	public String Help1(){
		return help;
	}
	public String Help2(){
		return help2;
	}
	public String Help3(){
		return help3;
	}
	public String Help4(){
		return help4;
	}
	public String Info(){
		return info;
	}
	public String Info2(){
		return info2;
	}
	public String Kobe(){
		return kobe;
	}
	public String Floris(){
		return floris;
	}
	public String Jiska(){
		return jiska;
	}
	public String Sijmen(){
		return sijmen;
	}
	public String Yari(){
		return yari;
	}
	public String Reload2(){
		return reload;
	}
	public String Admin(){
		return admin;
	}
	public String Owner(){
		return owner;
	}
	
	//Commands
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player p = (Player) sender;
		if(commandLabel.equalsIgnoreCase("dc")){
			//Help
			if(args.length == 0){
				if(p.hasPermission(Admin())){
					p.sendMessage(AHelp1());
					p.sendMessage(AHelp2());
					p.sendMessage(AHelp3());
					p.sendMessage(AHelp4());
					p.sendMessage(AHelp5());
					p.sendMessage(AHelp6());
					p.sendMessage(AHelp7());
					p.sendMessage(AHelp8());
					p.sendMessage(AHelp9());
					p.sendMessage(AHelp10());
				}else{
					p.sendMessage(Help1());
					p.sendMessage(Help2());
					p.sendMessage(Help3());
					p.sendMessage(Help4());
				}
			//Info
			}else if(args[0].equalsIgnoreCase("info")){
				Info();
				Info2();
			//Info about Kobe
			}else if(args[0].equalsIgnoreCase("kobe")){
				p.sendMessage(Kobe());
			//Info about Floris
			}else if(args[0].equalsIgnoreCase("floris")){
				p.sendMessage(Floris());
			//Info about Jiska
			}else if(args[0].equalsIgnoreCase("jiska")){
				p.sendMessage(Jiska());
			//Info about Sijmen
			}else if(args[0].equalsIgnoreCase("sijmen")){
				p.sendMessage(Sijmen());
			//Info about Jiska
			}else if(args[0].equalsIgnoreCase("yari")){
				p.sendMessage(Yari());
			//Reload
			}else if(args[0].equalsIgnoreCase("reload")){
				if(p.hasPermission(Admin())){
					Reload();
					p.sendMessage(Reload2());
				}else{
					NoPerms();
				}
			//Clear chat
			}else if(args[0].equalsIgnoreCase("clear")){
				p.sendMessage(ChatColor.DARK_RED + "[DerpCraft] " + ChatColor.RED + "Usage: /dc clear own/all");
				//Clear own chat
				if(args[1].equalsIgnoreCase("own")){
					for(int i = 0; i<100;i++){
					      p.sendMessage("");
					}
				//Clear chat
				}else if(args[1].equalsIgnoreCase("all")){
					if(p.hasPermission(Admin())){
						for(int i = 0; i<100;i++){
						      p.sendMessage("");
						}
					}else{
						p.sendMessage(NoPerms());
					}
				}else{
					p.sendMessage(ChatColor.DARK_RED + "[DerpCraft] " + ChatColor.RED + "Usage: /dc clear own/all");
				}
			}else if(args[0].equalsIgnoreCase("kick")){
				if(p.hasPermission(Owner())){
					if(args.length == 3){
						Player targetPlayer = p.getServer().getPlayer(args[1]);
						String reason = args[2];
						if(targetPlayer != null){
							targetPlayer.kickPlayer(reason);
							p.sendMessage(ChatColor.RED + "[DerpCraft]" + ChatColor.GREEN + "You kicked " + ChatColor.GRAY + ChatColor.UNDERLINE + targetPlayer.getName() + ChatColor.GREEN + " with reason: " + ChatColor.DARK_GRAY + reason + ChatColor.GREEN + " !");
						}else{
							p.sendMessage(ChatColor.DARK_RED + "[DerpCraft] " + ChatColor.RED + "Player isn't online/don't exicts!");
						}
					}else{
						p.sendMessage(ChatColor.DARK_RED + "[DerpCraft] " + ChatColor.RED + "Usage: /dc kick <player> <reason>");
					}
				}else{
					p.sendMessage(NoPerms());
				}
			}
		}if(commandLabel.equalsIgnoreCase("leave")){
			getServer().dispatchCommand(p, "sw leave");
			getServer().dispatchCommand(p, "quake leave");
			p.sendMessage(ChatColor.GOLD + "[DerpCraft] " + ChatColor.BLUE + "You left the game");
		}
		return false;
	}
}