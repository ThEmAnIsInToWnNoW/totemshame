# Totem Shame — Meme Pop Animations (Fabric, client-only)

Totem Shame displays a short animated meme caption overlay whenever *you* (the local player) pop a Totem of Undying.

Supported Minecraft versions: 1.21.1 — 1.21.10 (target Yarn mappings in `build.gradle`; adjust versions if needed)

Features
- Random captions from a configurable list
- Simple fade / slide animation overlay rendered on the HUD
- Configurable duration, position, fonts, colors, and sound toggle (config/totemshame.json)
- Client-side only: no server changes, no gameplay modifications

Build / run
1. Install Java 17+ and Git.
2. Adjust versions in `gradle.properties` if needed.
3. Build:
   - Linux/macOS: `./gradlew build`
   - Windows: `gradlew.bat build`
4. Output JAR: `build/libs/totemshame-<version>.jar` — put that into your Minecraft `mods/` folder with Fabric Loader + Fabric API installed.

Project layout (key files)
- build.gradle, gradle.properties, settings.gradle
- src/main/java/com/totemshame/* — mod classes & mixin
- src/main/resources/fabric.mod.json
- src/main/resources/mixins.totemshame.json
- src/main/resources/assets/totemshame/sounds.json (register custom sounds)
- config/totemshame.json (generated on first run or copy `config.example.json`)

Configuration
- Edit `config/totemshame.json` to change captions, duration, animation, colors, and whether sounds are enabled.
- Example config included as `config.example.json` in this repo.

Extending
- Add custom caption packs, images, or sound assets in `src/main/resources/assets/totemshame/`.
- Add Mod Menu / Cloth Config integration to allow in-game editing.

License
- MIT recommended.

Author
- Maintainer: ThEmAnIsInToWnNoW