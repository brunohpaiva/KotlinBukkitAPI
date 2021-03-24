package br.com.devsrsouza.kotlinbukkitapi.plugins.dvdwplaceholderapi

import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import be.maximvdw.placeholderapi.PlaceholderAPI as MVdWPlaceholderAPI

val hasMVdWPlaceholderAPI by lazy { MVdWPlaceholder != null }

val MVdWPlaceholder by lazy {
    Bukkit.getPluginManager().getPlugin("MVdWPlaceholderAPI") as? MVdWPlaceholderAPI
}

val OfflinePlayer.mvdWPlaceholderAPI get() = MVdWPlaceholderAPI(this)

inline class MVdWPlaceholderAPI(val player: OfflinePlayer) {
    fun replacePlaceholders(input: String) = MVdWPlaceholderAPI.replacePlaceholders(player, input)
}