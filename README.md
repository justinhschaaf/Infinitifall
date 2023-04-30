# Infinitifall

*Falling, Forever.*

## What does it do?

When any entity takes damage from falling in the void, they get teleported upwards, effectively making them fall forever... or at least until they die of void damage.

## How do I configure it?

| Key                        | Type    | Default                                                                            | Description                                                                               |
|----------------------------|---------|------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------|
| `tpY`                      | double  | -64.0                                                                              | Teleports the entity when their Y level is below this level.                              |
| `addY`                     | double  | 246.0                                                                              | How much to add to the entity's Y position.                                               |
| `damage`                   | double  | 4.0                                                                                | How much damage to deal upon teleporting the entity.                                      |
| `removeNonLiving`          | boolean | true                                                                               | Whether to remove non-living entities that can't take void damage.                        |
| `messages.errorNoPerms`    | String  | "&4You don't have permission to execute this command."                             | The message sent when attempting to execute a command without permissions.                |
| `messages.errorUnknownCmd` | String  | "&4Unknown command. Usage: /infinitifall (reload)"                                 | The message sent when attempting to run a subcommand that doesn't exist (or none at all). |
| `messages.reloadConfirmed` | String  | "&aInfinitifall reloaded."                                                         | The message returned when the plugin was successfully reloaded via command.               |
| `messages.reloadErrored`   | String  | "&4Something went wrong reloading Infinitifall, see the console for more details." | The message returned when the plugin reload didn't work.                                  |

You can reload the config using `/infinitifall reload`.

## How do I use it?

Drop it into the `/plugins` folder of your [PaperMC](https://papermc.io) server.
This plugin relies on Paper or Folia specifically, it won't work on Bukkit or Spigot.

## Where can I get it?

- [Curseforge](https://curseforge.com/minecraft/bukkit-plugins/infinitifall)
- [GitHub Releases](https://github.com/justinhschaaf/Infinitifall/releases)
- [Modrinth](https://modrinth.com/plugin/infinitifall)

## [License](/LICENSE.md)
