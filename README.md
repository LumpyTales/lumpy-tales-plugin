# lumpy-tales-plugin
Lumpy tales minecraft server (papermc) plugins

# Whats about?
Just a simple projects which contains a software architecture that allows to easily 
create new behaviours on different minecraft entites. So
this project is more or less a software pattern to add faster new
behaviours to your minecraft server.

Behaviours are composed of actions and reactions of two entities. So pretty simple. ;-)

# Current behaviours

## Sheep gets hurt
If a sheep gets hurt it will poop (once an hour), leaves a message to the player and runs away.
## Sheep gets killed
If a sheep gets killed it will be healed and will drop some meat

# How to use
Just clone the project and run the 'build' gradle action. Then take the jar in the build folder
and copy it to your paper-mc server. After restart the new behaviours should be applied.