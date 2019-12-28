# League-of-POO

Simple MMO-RPG Game for 
Object Oriented Programming Homework.

## Design and implementation

### Data structure
- I made a class for every type of hero and for every type of ability.
- I also implemented a HeroFactory class that creates heroes.
- I implemented the Map using Singleton Pattern.
- I kept all the constants in Constants class.

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

 