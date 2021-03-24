package br.com.devsrsouza.kotlinbukkitapi.plugins.vault

import net.milkbowl.vault.chat.Chat
import net.milkbowl.vault.economy.Economy
import net.milkbowl.vault.permission.Permission
import org.bukkit.Bukkit
import org.bukkit.OfflinePlayer
import org.bukkit.World
import org.bukkit.entity.Player

val hasVault by lazy { Bukkit.getServer().pluginManager.getPlugin("Vault") != null }
val economy by lazy { Bukkit.getServer().servicesManager.getRegistration(Economy::class.java)?.provider }
val chat by lazy { Bukkit.getServer().servicesManager.getRegistration(Chat::class.java)?.provider }
val permission by lazy { Bukkit.getServer().servicesManager.getRegistration(Permission::class.java)?.provider }

val Player.vault get() = Vault(this)
val OfflinePlayer.vault get() = VaultOffline(this)

open class VaultOffline(player: OfflinePlayer) {
    val economy = Economy(player)
    val permission = Permission(player)
}

class Vault(player: Player) : VaultOffline(player) {
    val chat = Chat(player)
}

inline class Economy(private val player: OfflinePlayer) {
    val balance get() = economy!!.getBalance(player)
    val hasAccount get() = economy!!.hasAccount(player)

    fun has(amount: Double) = economy!!.has(player, amount)
    fun withdraw(amount: Double) = economy!!.withdrawPlayer(player, amount)
    fun deposit(amount: Double) = economy!!.depositPlayer(player, amount)
}

inline class Chat(private val player: Player) {
    var prefix: String
        get() = chat!!.getPlayerPrefix(player)
        set(value) = chat!!.setPlayerPrefix(player, value)

    var suffix: String
        get() = chat!!.getPlayerSuffix(player)
        set(value) = chat!!.setPlayerSuffix(player, value)

    val groups: Array<String> get() = chat!!.getPlayerGroups(player)
    val primaryGroup: String get() = chat!!.getPrimaryGroup(player)

    fun inGroup(group: String) = chat!!.playerInGroup(player, group)
}

inline class Permission(private val player: OfflinePlayer) {
    fun has(permission_: String) = permission!!.playerHas(null, player, permission_)
    fun has(world: World, permission_: String) = permission!!.playerHas(world.name, player, permission_)
}