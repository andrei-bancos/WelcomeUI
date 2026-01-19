package com.andreibancos.commands;

import com.andreibancos.WelcomeUIConfig;
import com.andreibancos.pages.WelcomePage;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractPlayerCommand;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.Config;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class ShowWelcomeUI extends AbstractPlayerCommand {
    private final Config<WelcomeUIConfig> config;

    public ShowWelcomeUI(Config<WelcomeUIConfig> config) {
        super("show-welcome-ui", "Open WelcomeUI");
        this.config = config;
    }

    @Override
    protected void execute(
            @NonNullDecl CommandContext commandContext,
            @NonNullDecl Store<EntityStore> store,
            @NonNullDecl Ref<EntityStore> ref,
            @NonNullDecl PlayerRef playerRef,
            @NonNullDecl World world
    ) {
        Player player = store.getComponent(ref, Player.getComponentType());

        WelcomePage page = new WelcomePage(playerRef, config);
        player.getPageManager().openCustomPage(ref, store, page);
    }
}
