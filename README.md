<img width="1000" height="150" alt="WelcomeUIBanner" src="https://github.com/user-attachments/assets/20ec04a0-b50e-4532-aa49-9ff85002daf9" />

# WelcomeUI
This is a mod for hytale servers that displays a configurable Welcome UI for players entering the server.

<img width="1171" height="1009" alt="Hytale2026-01-19_23-06-04-cropped" src="https://github.com/user-attachments/assets/06ec2561-a532-4c17-8d97-2e283128f159" />

## Commands
- `/show-welcome-ui` - Open WelcomeUI

## Config file
```json
{
  "OpenJustOneTimeForNewPlayers": false,
  "MainTitle": "Welcome {PlayerUsername} to the server!",
  "ServerDescription": "Survive Orbis! Explore vast biomes, build epic bases, and conquer dungeons with friends. Enjoy a stable economy, unique custom mods, and a growing community. Ready for the ultimate adventure? Join the most immersive Hytale Survival experience today!",
  "FirstColTitle": "• SERVER RULES",
  "FirstColContent": [
    "1. Respect and Fair Play",
    "2. No Cheating or Third-Party Clients",
    "3. No Exploiting Bugs",
    "4. No Chat Spamming or Advertising",
    "5. No Language Bypassing",
    "6. Follow Staff Instructions"
  ],
  "SecondColTitle": "• Useful commands",
  "SecondColContent": [
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
  ],
  "ShowLink": true,
  "LinkTitle": "Join the discord: ",
  "LinkContent": "https://discord.gg/hytale"
}
```

### Text format
`{PlayerUsername}` - Can be use in MainTitle and ServerDescription
