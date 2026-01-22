package com.andreibancos;

import com.andreibancos.pages.WelcomePage;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.PlayerConnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.Config;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class WelcomeUIEvent {
    private final Config<WelcomeUIConfig> config;
    private final Set<UUID> firstReady = new HashSet<>();

    WelcomeUIEvent(Config<WelcomeUIConfig> config) {
        this.config = config;
    }

    public void onPlayerConnect(PlayerConnectEvent event) {
        this.firstReady.add(event.getPlayerRef().getUuid());
    }

    public void onPlayerReady(PlayerReadyEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUuid();

        if(!player.isFirstSpawn() && this.config.get().openJustOneTimeForNewPlayers()) {
            return;
        }

        if(firstReady.remove(playerUUID)) {
            Ref<EntityStore> ref = event.getPlayerRef();
            assert player.getWorld() != null;
            EntityStore store = player.getWorld().getEntityStore();

            WelcomePage page = new WelcomePage(player.getPlayerRef(), config);
            player.getPageManager().openCustomPage(ref, store.getStore(), page);
        }
    }

}
