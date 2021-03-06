package regalowl.hyperconomy;

import org.bukkit.command.CommandSender;

public class Setfloor {
	Setfloor(String args[], CommandSender sender, String playerecon) {
		HyperConomy hc = HyperConomy.hc;
		HyperEconomy he = hc.getEconomyManager().getEconomy(playerecon);
		InfoSignHandler isign = hc.getInfoSignHandler();
		LanguageFile L = hc.getLanguageFile();
		String name = "";
		try {
			if (args.length == 2) {
				name = args[0];
				double floor = Double.parseDouble(args[1]);
				if (he.objectTest(name)) {
					he.getHyperObject(name).setFloor(floor);
					sender.sendMessage(L.f(L.get("FLOOR_SET"), name));
					isign.updateSigns();
				} else {
					sender.sendMessage(L.get("INVALID_NAME"));
				}
			} else {
				sender.sendMessage(L.get("SETFLOOR_INVALID"));
			}
		} catch (Exception e) {
			sender.sendMessage(L.get("SETFLOOR_INVALID"));
		}
	}
}
