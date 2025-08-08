# Prince_Xares 🤖

**Prince_Xares** is a multi-feature Discord bot built using [JDA (Java Discord API)](https://github.com/DV8FromTheWorld/JDA). It introduces an interactive collectible coin system called **Vault**, with powerful administrative tools, statistics tracking, and custom image generation — all backed by SQLite.

## ✨ Features

- 🧠 Slash Commands with rich options
- 💰 Vault System: collectible coins with rarity, levels, and graphical display
- 🎨 Dynamic vault image generation with profile avatars
- 📊 Role and Membership Statistics
- 🛡 Server-specific permission checks
- 🗃 SQLite DB per-server (automatically cleaned on leave)

## 🛠 Commands Overview

| Command      | Description |
|-------------|-------------|
| `/say`       | Bot repeats your message (admin only) |
| `/leave`     | Forces bot to leave the server |
| `/stats`     | Shows member roles or membership duration |
| `/vault`     | Manage/view your coin vault |
| `/add`       | Admin-only coin injection |
| `/crystara`  | Shows the amount of crystara that someone has |
| `/event`     | To set the event time for collecting Crystara


| Subcommand   | Description                                                                                  |
|--------------|----------------------------------------------------------------------------------------------|
| `view`       | View your vault as an image showing up to 10 coins with their levels and rarities.          |
| `levelup`    | Level up a specific coin in your vault if you have enough Crystara.                         |
| `adminview`  | (Admin only + Owner of the Vault) View detailed vault info of any user, including internal coin IDs.             |
| `remove`     | Remove a coin from your vault by specifying its Coin ID.                                    |
| `clear`      | Clear your entire vault (can be restricted to admins or the vault owner).                   |
### Crystara_usage for upgrading each Coin:
![crystara_usage](https://github.com/user-attachments/assets/f90e8dce-96aa-4b30-a641-23247e60eccb)

    
### Shop Feature
- The bot includes a **shop system** where admins can select a channel for the shop.
- The shop automatically creates **two messages**:
  1. **Pouch Shop** — Users can buy pouches using **Crystara** currency.
    - Visual Example : <img width="1069" height="503" alt="image" src="https://github.com/user-attachments/assets/35bb9553-9bd8-4563-8eaa-85c43f587804" />
  2. **Role Shop** — Users can purchase roles using either **Crystara** or **coins**.
      - Visual Example :
        <img width="1103" height="806" alt="image" src="https://github.com/user-attachments/assets/49bc56ad-c9ad-4475-b94d-7da3c2096896" />
        <img width="1100" height="595" alt="image" src="https://github.com/user-attachments/assets/feb197fa-8c87-4819-ba09-ce57b73c74fa" />


        
- This setup allows users to interact with the shop messages to make purchases directly.

### Notes:
- Some subcommands require additional parameters such as:
  - `user` — Target another user’s vault (admin permissions required).
  - `id` — Specify the coin ID for actions like level up or removal.
  - `view` generates a dynamic image showing coins with stats and the user’s profile picture.


## 🖼 Vault System

Vaults are represented as in-memory image files generated dynamically using `BufferedImage`. No file writes or persistent image caching are used — everything is built and sent in real-time with profile pictures and layout logic.(All the images are AI generated)

Example output (visualized):
<img width="1012" height="610" alt="image" src="https://github.com/user-attachments/assets/3fa0f298-d61a-45ba-bd23-694e94eeacf3" />


## To install the bot in your server:
Click on [Install](https://discord.com/oauth2/authorize?client_id=1389683347420221714)

### License

This bot is licensed under the MIT License.

It uses [JDA (Java Discord API)](https://github.com/DV8FromTheWorld/JDA) licensed under Apache License 2.0.
