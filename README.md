# Compact OmegaT Glossary Layout 

This is an alternative glossary layout for OmegaT created using 
[glossary-renderer-plugin-skeleton](https://github.com/omegat-org/glossary-renderer-plugin-skeleton) by Hiroshi Miura. 


## Building

To build the plugin, run `./gradlew installDist` (Kotlin DSL is used)

## Dependencies

OmegaT and dependencies are located on remote maven repositories.
It is necessary to connect the internet to compile your project.

This plugin uses OmegaT 5.7.0.

## Where is a built artifact?

You can find distribution files you built in `build/distributions/install` of your local copy.

You can also download binaries in [Releases](https://github.com/kosivantsov/omegat-plugin-glossay-compact/releases)


## Installation

You can get a plugin jar file from zip distribution file.
OmegaT plugin should be placed in `plugins` subfolder of your OmegaT user config folder (menu **Options** → **Access Configuration Folder** in OmegaT, create `plugins` subfolder if it's not there).
OmegaT searches for plugins in that folder recursively, so if you have more than one plugin, you may create a subfolder for each of them to contain the plugin's files. It might be convenient, but it's not necessary.

## License

This project is distributed under the GNU general public license version 3 or later.

## Coffee

If you want to say thank you

<a href="https://www.buymeacoffee.com/verdakafo" target="_blank"><img src="https://cdn.buymeacoffee.com/buttons/default-green.png" alt="Coffee would be great" height="41" width="196"></a>
