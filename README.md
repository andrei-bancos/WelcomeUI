<img width="1000" height="150" alt="WelcomeUIBanner" src="https://github.com/user-attachments/assets/20ec04a0-b50e-4532-aa49-9ff85002daf9" />

# WelcomeUI
This is a mod for Hytale servers that displays a configurable welcome interface that also contains a button for displaying useful links in chat for players entering the server.

## Features
- Configurable main title.
- 2 fully configurable columns containing a title and multi-row content, both benefiting from scroll container.
- Possibility to set it to open only for new players once or always for all players.
- Button to display useful links in chat (this button is also fully configurable), as well as the message with the links in the chat are fully configurable.

## Commands
- `/show-welcome-ui` - Open WelcomeUI

<img width="850" height="650" alt="WelcomeUIMain 1 2 0" src="https://github.com/user-attachments/assets/9779bb42-8402-48a7-9ddc-8d5464a452bf" />

After clicking the button to display useful links in the chat

<img width="850" height="650" alt="WelcomeUIMain 1 2 0 - links" src="https://github.com/user-attachments/assets/bb95249d-3136-4150-9f11-2c9f2e018603" />

The close button is centered in the interface if you choose not to display showLinkBtn.

<img width="850" height="650" alt="WelcomeUIMain 1 2 0 show linksBtn flase" src="https://github.com/user-attachments/assets/6813d484-2274-484b-9738-90fa9dcd8518" />


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
  "ShowLinksBtn": true,
  "LinksBtnText": "Show useful links in chat",
  "ChatLinksTitle": "Useful links:",
  "Links": [
    "https://hytale.com",
    "https://discord.gg/hytale",
    "https://vote1.tld",
    "https://vote2.tld",
    "https://vote3.tld"
  ],
  "ChatLinksTitleColor": "#197dff",
  "ChatLinksColor": "#ffffff"
}
```

### Text format
`{PlayerUsername}` - Can be use in MainTitle and ServerDescription
