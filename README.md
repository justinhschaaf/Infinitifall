# Infinitifall

*Falling, Forever.*

## What does it do?

When any entity takes damage from falling in the void, they get teleported upwards, effectively making them fall forever... or at least until they die of void damage.

## How do I configure it?

| Key               | Type    | Default | Description                                                        |
|-------------------|---------|---------|--------------------------------------------------------------------|
| `tpY`             | double  | -64.0   | Teleports the entity when their Y level is below this level.       |
| `addY`            | double  | 246.0   | How much to add to the entity's Y position.                        |
| `damage`          | double  | 4.0     | How much damage to deal upon teleporting the entity.               |
| `removeNonLiving` | boolean | true    | Whether to remove non-living entities that can't take void damage. |

## How do I use this?

Drop it into the `/plugins` folder of your [PaperMC](https://papermc.io) server.
This plugin relies on paper specifically, it won't work on Bukkit or Spigot.

## [License](/LICENSE.md)
