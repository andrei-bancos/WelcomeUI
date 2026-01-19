package com.andreibancos;

import com.hypixel.hytale.codec.Codec;
import com.hypixel.hytale.codec.KeyedCodec;
import com.hypixel.hytale.codec.builder.BuilderCodec;

public class WelcomeUIConfig {
    private String serverDescription = "Survive Orbis! Explore vast biomes, build epic bases, and conquer dungeons with friends. Enjoy a stable economy, unique custom mods, and a growing community. Ready for the ultimate adventure? Join the most immersive Hytale Survival experience today!";

    private String[] rules = new String[]{
            "1. Respect and Fair Play",
            "2. No Cheating or Third-Party Clients",
            "3. No Exploiting Bugs",
            "4. No Chat Spamming or Advertising",
            "5. No Language Bypassing",
            "6. Follow Staff Instructions"
    };

    private String[] usefulCommands = new String[]{
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

    private String discordLink = "https://discord.gg/hytale";

    public static final BuilderCodec<WelcomeUIConfig> CODEC = BuilderCodec.builder(WelcomeUIConfig.class, WelcomeUIConfig::new)
            .append(new KeyedCodec<String>("ServerDescription", Codec.STRING),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.serverDescription = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.serverDescription).add()
            .append(new KeyedCodec<String[]>("Rules", Codec.STRING_ARRAY),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.rules = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.rules).add()
            .append(new KeyedCodec<String[]>("UsefulCommands", Codec.STRING_ARRAY),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.usefulCommands = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.usefulCommands).add()
            .append(new KeyedCodec<String>("DiscordLink", Codec.STRING),
                    (WelcomeUIConfig, strings) -> WelcomeUIConfig.discordLink = strings,
                    (WelcomeUIConfig) -> WelcomeUIConfig.discordLink).add()
            .build();

    public String getServerDescription() {
        return serverDescription;
    }

    public String[] getRules() {
        return rules;
    }

    public String[] getUsefulCommands() {
        return usefulCommands;
    }

    public String getDiscordLink() {
        return discordLink;
    }
}
