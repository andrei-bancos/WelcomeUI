package com.andreibancos;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class WelcomeUIConfig {
    private Boolean openJustOneTimeForNewPlayers = false;

    private String mainTitle = "Welcome {PlayerUsername} to the server!";
    private String serverDescription = "Survive Orbis! Explore vast biomes, build epic bases, and conquer dungeons with friends. Enjoy a stable economy, unique custom mods, and a growing community. Ready for the ultimate adventure? Join the most immersive Hytale Survival experience today!";

    private String firstColTitle = "• SERVER RULES";
    private String[] firstColContent = new String[]{
            "1. Respect and Fair Play",
            "2. No Cheating or Third-Party Clients",
            "3. No Exploiting Bugs",
            "4. No Chat Spamming or Advertising",
            "5. No Language Bypassing",
            "6. Follow Staff Instructions"
    };

    private String secondColTitle = "• Useful commands";
    private String[] secondColContent = new String[]{
            "1. /spawn – Teleports you to the server's main starting point.",
            "2. /sethome – Saves your current location as your personal home base.",
            "3. /home – Instantly teleports you back to your saved home location.",
            "4. /tpa [player] – Sends a request to teleport yourself to another player.",
            "5. /tpaccept – Grants permission for another player to teleport to you.",
            "6. /whereami – Displays your current X, Y, and Z coordinates.",
            "7. /unstuck – Safely teleports you to nearby solid ground if you are trapped.",
            "8. /who – Shows a list of all players currently online.",
            "9. /warp [location] – Teleports you to a specific public area or landmark.",
            "10. /help – Provides a full list of available commands and their usage."
    };

    private Boolean showLink = true;
    private String linkTitle = "Join the discord: ";
    private String linkContent = "https://discord.gg/hytale";

    public static final BuilderCodec<WelcomeUIConfig> CODEC = BuilderCodec.builder(WelcomeUIConfig.class, WelcomeUIConfig::new)
            .append(new KeyedCodec<Boolean>("OpenJustOneTimeForNewPlayers", Codec.BOOLEAN),
                    (WelcomeUIConfig, trueOrFalse) -> WelcomeUIConfig.openJustOneTimeForNewPlayers = trueOrFalse,
                    (WelcomeUIConfig) -> WelcomeUIConfig.openJustOneTimeForNewPlayers).add()
            .append(new KeyedCodec<String>("MainTitle", Codec.STRING),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.mainTitle = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.mainTitle).add()
            .append(new KeyedCodec<String>("ServerDescription", Codec.STRING),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.serverDescription = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.serverDescription).add()

            .append(new KeyedCodec<String>("FirstColTitle", Codec.STRING),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.firstColTitle = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.firstColTitle).add()
            .append(new KeyedCodec<String[]>("FirstColContent", Codec.STRING_ARRAY),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.firstColContent = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.firstColContent).add()

            .append(new KeyedCodec<String>("SecondColTitle", Codec.STRING),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.secondColTitle = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.secondColTitle).add()
            .append(new KeyedCodec<String[]>("SecondColContent", Codec.STRING_ARRAY),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.secondColContent = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.secondColContent).add()

            .append(new KeyedCodec<Boolean>("ShowLink", Codec.BOOLEAN),
                    (WelcomeUIConfig, trueOrFalse) -> WelcomeUIConfig.showLink = trueOrFalse,
                    (WelcomeUIConfig) -> WelcomeUIConfig.showLink).add()
            .append(new KeyedCodec<String>("LinkTitle", Codec.STRING),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.linkTitle = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.linkTitle).add()
            .append(new KeyedCodec<String>("LinkContent", Codec.STRING),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.linkContent = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.linkContent).add()
            .build();

    public Boolean openJustOneTimeForNewPlayers() {
        return openJustOneTimeForNewPlayers;
    }

    public String getMainTitle() {
        return mainTitle;
    }

    public String getServerDescription() {
        return serverDescription;
    }

    public String getFirstColTitle() {
        return firstColTitle;
    }

    public String[] getFirstColContent() {
        return firstColContent;
    }

    public String getSecondColTitle() {
        return secondColTitle;
    }

    public String[] getSecondColContent() {
        return secondColContent;
    }

    public Boolean getShowLink() {
        return showLink;
    }

    public String getLinkTitle() {
        return linkTitle;
    }

    public String getLinkContent() {
        return linkContent;
    }
}
