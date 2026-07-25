package org.silverbreezed.macefaahsfx.client.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.silverbreezed.macefaahsfx.client.config.ModConfig;
import org.silverbreezed.macefaahsfx.platform.Services; // Import Service Universal

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConfigManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private static final Path CONFIG_PATH = Services.PLATFORM.getConfigDirectory().resolve("macememe_config.json");

    private static ModConfig config = new ModConfig();

    public static void load() throws IOException {
        if (Files.exists(CONFIG_PATH)) {
            try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                config = GSON.fromJson(reader, ModConfig.class);

                if (config == null) {
                    config = new ModConfig();
                }
            } catch (Exception e) {
                System.out.println("No existing config file exist. Creating new...");
                save();
            }
        } else {
            save();
        }
    }

    public static void save() throws IOException {
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            GSON.toJson(config, writer);
        } catch (Exception e) {
            System.out.println("Failed to save config.");
            e.printStackTrace();
        }
    }

    public static ModConfig getConfig() {
        return config;
    }
}
