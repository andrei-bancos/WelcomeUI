package com.andreibancos;

import com.andreibancos.pages.WelcomePage;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.Config;

public class WelcomeUIEvent {
    private final Config<WelcomeUIConfig> config;

    WelcomeUIEvent(Config<WelcomeUIConfig> config) {
        this.config = config;
    }

    public void onPlayerReady(PlayerReadyEvent event) {
        Player player = event.getPlayer();
        Ref<EntityStore> ref = event.getPlayerRef();
        assert player.getWorld() != null;
        EntityStore store = player.getWorld().getEntityStore();

        WelcomePage page = new WelcomePage(player.getPlayerRef(), config);
        player.getPageManager().openCustomPage(ref, store.getStore(), page);
    }

}
