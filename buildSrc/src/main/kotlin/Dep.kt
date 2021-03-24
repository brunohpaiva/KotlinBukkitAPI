object Dep {
    val spigot = "org.spigotmc:spigot-api:${Versions.spigotApi}"
    val bstats = "org.bstats:bstats-bukkit:${Versions.bstats}"
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val skedule = "com.okkero.skedule:skedule:${Versions.skedule}"
    val hikariCp = "com.zaxxer:HikariCP:${Versions.hikari}"
    val kaml = "com.charleskorn.kaml:kaml:${Versions.kaml}"
    val serializationCore = "org.jetbrains.kotlinx:kotlinx-serialization-core:${Versions.serialization}"

    val snakeYml = "org.snakeyaml:snakeyaml-engine:${Versions.snakeYaml}"


    object Exposed {
        val core = "org.jetbrains.exposed:exposed-core:${Versions.exposed}"
        val jdbc = "org.jetbrains.exposed:exposed-jdbc:${Versions.exposed}"
        val dao = "org.jetbrains.exposed:exposed-dao:${Versions.exposed}"
        val javaTime = "org.jetbrains.exposed:exposed-java-time:${Versions.exposed}"
    }

    object Versions {
        val kotlin = "1.4.31"
        val serialization = "1.1.0"
        val exposed = "0.29.1"
        val hikari = "4.0.3"
        val bstats = "1.7"
        val spigotApi = "1.8.8-R0.1-SNAPSHOT"
        val kaml = "0.29.0"
        val coroutines = "1.4.3"
        val skedule = "1.2.6"
        val shadow = "6.0.0"

        val snakeYaml = "2.1"
    }
}