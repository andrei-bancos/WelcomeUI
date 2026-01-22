package com.andreibancos.pages;

import com.andreibancos.WelcomeUIConfig;
import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.protocol.FormattedMessage;
import com.hypixel.hytale.protocol.packets.interface_.CustomPageLifetime;
import com.hypixel.hytale.protocol.packets.interface_.CustomUIEventBindingType;
import com.hypixel.hytale.protocol.packets.interface_.Page;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.entity.entities.player.pages.InteractiveCustomUIPage;
import com.hypixel.hytale.server.core.ui.builder.EventData;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.ui.builder.UIEventBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.Config;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import java.util.ArrayList;
import java.util.List;

public class WelcomePage extends InteractiveCustomUIPage<WelcomePage.WelcomeUIData> {
    private final Config<WelcomeUIConfig> config;
    private final PlayerRef playerRef;

    public WelcomePage(PlayerRef playerRef, Config<WelcomeUIConfig> config) {
        super(playerRef, CustomPageLifetime.CanDismissOrCloseThroughInteraction, WelcomeUIData.CODEC);
        this.config = config;
        this.playerRef = playerRef;
    }

    @Override
    public void build(
            @NonNullDecl Ref<EntityStore> ref,
            @NonNullDecl UICommandBuilder uiCommandBuilder,
            @NonNullDecl UIEventBuilder uiEventBuilder,
            @NonNullDecl Store<EntityStore> store
    ) {
        uiCommandBuilder.append("Pages/WelcomePage.ui");

        uiCommandBuilder.set("#MainTitle.Text", this.formatText(this.config.get().getMainTitle(), playerRef));
        uiCommandBuilder.set("#ServerDescription.Text", this.formatText(this.config.get().getServerDescription(), playerRef));

        uiCommandBuilder.set(
                "#FirstColTitle.Text",
                String.join("\n", this.config.get().getFirstColTitle())
        );
        uiCommandBuilder.set(
                "#FirstColContent.Text",
                String.join("\n", this.config.get().getFirstColContent())
        );

        uiCommandBuilder.set(
                "#SecondColTitle.Text",
                String.join("\n", this.config.get().getSecondColTitle())
        );
        uiCommandBuilder.set(
                "#SecondColContent.Text",
                String.join("\n", this.config.get().getSecondColContent())
        );

        if(this.config.get().getShowLinksBtn().equals(false)) {
            uiCommandBuilder.set("#SpaceBetweenButtons.FlexWeight", 0);
        }
        uiCommandBuilder.set("#LinksBtn.Visible", this.config.get().getShowLinksBtn());
        uiCommandBuilder.set("#LinksBtn.Text", this.config.get().getLinksBtnText());

        uiEventBuilder.addEventBinding(CustomUIEventBindingType.Activating, "#CloseBtn",
                EventData.of("CloseBtnClicked", "true"), false);
        uiEventBuilder.addEventBinding(CustomUIEventBindingType.Activating, "#LinksBtn",
                EventData.of("LinksBtnClicked", "true"), false);
    }

    @Override
    public void handleDataEvent(
            @NonNullDecl Ref<EntityStore> ref,
            @NonNullDecl Store<EntityStore> store,
            @NonNullDecl WelcomeUIData welcomeUIData
    ) {
        super.handleDataEvent(ref, store, welcomeUIData);
        Player player = store.getComponent(ref, Player.getComponentType());

        if(player == null) return;

        this.sendLinksInChat(welcomeUIData, player);

        if(welcomeUIData.closeBtnClicked != null) {
            player.getPageManager().setPage(ref, store, Page.None);
        }
    }

    public static class WelcomeUIData {
        static final String KEY_CLOSE_BTN_CLICKED = "CloseBtnClicked";
        private String closeBtnClicked;

        static final String KEY_LINKS_BTN_CLICKED = "LinksBtnClicked";
        private String linksBtnClicked;

        public static final BuilderCodec<WelcomeUIData> CODEC =
                BuilderCodec.builder(WelcomeUIData.class, WelcomeUIData::new)
                        .addField(new KeyedCodec<>(KEY_CLOSE_BTN_CLICKED, Codec.STRING), (welcomeUIData, s) ->
                                  welcomeUIData.closeBtnClicked = s, welcomeUIData -> welcomeUIData.closeBtnClicked)
                        .addField(new KeyedCodec<>(KEY_LINKS_BTN_CLICKED, Codec.STRING), (welcomeUIData, s) ->
                                welcomeUIData.linksBtnClicked = s, welcomeUIData -> welcomeUIData.linksBtnClicked)
                        .build();
    }

    private String formatText(String text, PlayerRef playerRef) {
        if(playerRef != null) {
            text = text.replace("{PlayerUsername}", playerRef.getUsername());
        }

        return text;
    }

    private void sendLinksInChat(WelcomeUIData welcomeUIData, Player player) {
        if(welcomeUIData.linksBtnClicked != null) {
            UICommandBuilder uiCommandBuilder = new UICommandBuilder();
            uiCommandBuilder.remove("#LinksBtn");
            sendUpdate(uiCommandBuilder);

            Message msg = Message.empty();
            msg.insert(Message.raw("\n" + this.config.get().getChatLinksTitle() + "\n")
                    .bold(true).color(this.config.get().getChatLinksTitleColor()));
            List<Message> linkMessages = new ArrayList<>();

            for (String link : this.config.get().getLinks()) {
                FormattedMessage fm = new FormattedMessage();
                fm.rawText = "• " + link + "\n";
                fm.link = link;
                linkMessages.add(new Message(fm).color(this.config.get().getChatLinksColor()));
            }

            player.sendMessage(msg.insertAll(linkMessages));
        }
    }
}
