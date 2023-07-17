package com.sunday;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ZeahRCHelperTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ZeahRCHelperPlugin.class);
		RuneLite.main(args);
	}
}