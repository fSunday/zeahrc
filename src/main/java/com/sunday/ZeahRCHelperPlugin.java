package com.sunday;

import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameObject;
import net.runelite.api.GameState;
import net.runelite.api.events.GameObjectSpawned;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@Slf4j
@PluginDescriptor(
	name = "Zeah RC Helper"
)
public class ZeahRCHelperPlugin extends Plugin
{
	@Getter
	@Inject
	private Client client;

	@Inject
	private ZeahRCHelperConfig config;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private ZeahRCHelperHighlightOverlay highlightOverlay;

	private final int soulAltarId = 27980;

	private final int bloodSoulId = 27978;

	@Getter
	private GameObject objectToMark = null;

	@Subscribe
	public void onGameObjectSpawned(GameObjectSpawned event)
	{
		if (event.getGameObject().getId() == soulAltarId || event.getGameObject().getId() == bloodSoulId) {
			objectToMark = event.getGameObject();
		}
	}

	@Override
	protected void startUp() throws Exception
	{
		overlayManager.add(highlightOverlay);
	}

	@Override
	protected void shutDown() throws Exception
	{
		overlayManager.remove(highlightOverlay);
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN) {}
	}

	@Provides
	ZeahRCHelperConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(ZeahRCHelperConfig.class);
	}
}
