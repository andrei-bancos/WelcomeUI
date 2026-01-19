package com.andreibancos.pages;

import com.andreibancos.WelcomeUIConfig;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.protocol.packets.interface_.CustomPageLifetime;
import com.hypixel.hytale.protocol.packets.interface_.CustomUIEventBindingType;
import com.hypixel.hytale.protocol.packets.interface_.Page;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.entity.entities.player.pages.InteractiveCustomUIPage;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.ui.builder.UIEventBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.Config;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class WelcomePage extends InteractiveCustomUIPage<WelcomePage.WelcomeUIData> {
    private final Config<WelcomeUIConfig> config;
    private final String playerName;

    public WelcomePage(PlayerRef playerRef, Config<WelcomeUIConfig> config) {
        super(playerRef, CustomPageLifetime.CanDismissOrCloseThroughInteraction, WelcomeUIData.CODEC);
        this.config = config;
        this.playerName = playerRef.getUsername();
    }

    @Override
    public void build(
            @NonNullDecl Ref<EntityStore> ref,
            @NonNullDecl UICommandBuilder uiCommandBuilder,
            @NonNullDecl UIEventBuilder uiEventBuilder,
            @NonNullDecl Store<EntityStore> store
    ) {
        uiCommandBuilder.append("Pages/WelcomePage.ui");

        uiCommandBuilder.set("#TitleWelcome.Text", "Welcome " + playerName + " to the server!");
        uiCommandBuilder.set("#ServerDescription.Text", this.config.get().getServerDescription());
        uiCommandBuilder.set(
                "#RulesText.Text",
                String.join("\n", this.config.get().getRules())
        );
        uiCommandBuilder.set(
                "#UsefulCommandsText.Text",
                String.join("\n", this.config.get().getUsefulCommands())
        );
        uiCommandBuilder.set("#DiscordLink.Text", this.config.get().getDiscordLink());

        uiEventBuilder.addEventBinding(CustomUIEventBindingType.Activating, "#CloseBtn");
    }

    @Override
    public void handleDataEvent(
            @NonNullDecl Ref<EntityStore> ref,
            @NonNullDecl Store<EntityStore> store,
            @NonNullDecl WelcomeUIData welcomeUIData
    ) {
        super.handleDataEvent(ref, store, welcomeUIData);
        Player player = (Player) store.getComponent(ref, Player.getComponentType());
        player.getPageManager().setPage(ref, store, Page.None);
    }

    public static class WelcomeUIData {
        public static final BuilderCodec<WelcomeUIData> CODEC =
                BuilderCodec.builder(WelcomeUIData.class, WelcomeUIData::new).build();
    }
}
