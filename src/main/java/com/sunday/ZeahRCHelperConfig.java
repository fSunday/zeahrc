package com.sunday;

import net.runelite.client.config.Alpha;
import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.awt.*;

@ConfigGroup("example")
public interface ZeahRCHelperConfig extends Config
{
	@Alpha
	@ConfigItem(
			keyName = "highlightColor",
			name = "Highlight Color",
			description = "Configures the color that the altar will be highlighted",
			position = 2
	)
	default Color highlightColor()
	{
		return new Color(0, 255, 0, 50);
	}
}
