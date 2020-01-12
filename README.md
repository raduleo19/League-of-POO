# League-of-POO

Simple MMO-RPG Game for 
Object Oriented Programming Homework.

## Design and implementation

### Data structure
- I made a class for every type of hero and for every type of ability.
- I also implemented a HeroFactory class that creates heroes.
- I implemented the Map using Singleton Pattern.
- I kept all the constants in Constants class.
- I implemented Angels using Visitor Pattern.
- I implemented Admin aka Big Magician using Observer Pattern.
- I implemented Strategies using Strategy Pattern

### Admin - Observer
- He is notified automatically of any state changes of our subjects(Angels and Heroes)
- He outputs the messages in an output buffer
- Characters implements coresponding Observable Interface that sends messages for every type of
action.

### Strategies
- For the first time I implemented this pattern using 4 strategies, one for each player. 
- Then I concluded that this pattern is useless here and that I could directly make the 
heroes implement the Strategy interface, but to emphasize this pattern I implemented it 
separately with 2 strategies, one aggressive and one defensive.

### Angels - Visitor Pattern
- Angels are visitors(applyBuff is the visit function).
- Heroes are acceptors(requestBuff is the accept function).
- I implemented modifiers buff in Buff Class.


### Double-dispatch
- To get the modifiers I used double-dispatch. I requested the modifiers 
to the ability and ability returns the corresponding modifiers depending 
on the argument type.

### Overtime
- I made an Overtime class to save the extended effects.

### Attack procedure
- Assuming we have a player A that attacks the player B, we first calculate the damage that A gives to
B(raw damage and final damage). Then we apply final damage to B and the overtime. B returns
the deflection damage based on the raw damage and we apply it to A.

## Coding Style

 I followed [google](https://google.github.io/styleguide/javaguide.html) coding style.


## Author

[Rica Radu-Leonard 325CA](https://github.com/raduleo19)

 