package com.andreibancos;

import com.andreibancos.commands.ShowWelcomeUI;
import com.hypixel.hytale.server.core.command.system.CommandRegistry;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import com.hypixel.hytale.server.core.util.Config;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

public class WelcomeUI extends JavaPlugin {
    private final Config<WelcomeUIConfig> config;

    public WelcomeUI(@NonNullDecl JavaPluginInit init) {
        super(init);
        this.config = this.withConfig("WelcomeUIConfig", WelcomeUIConfig.CODEC);
    }

    @Override
    protected void setup() {
        super.setup();
        this.config.save();

        WelcomeUIEvent welcomeUIEvent = new WelcomeUIEvent(config);

        getEventRegistry().registerGlobal(PlayerReadyEvent.class,
                welcomeUIEvent::onPlayerReady
        );

        CommandRegistry commandRegistry = this.getCommandRegistry();
        commandRegistry.registerCommand(new ShowWelcomeUI(config));
    }
}
