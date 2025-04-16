# HSR_Dmg_Calc
Java CS Team: Star Rail Calculator
All characters are under the assumption of being...
- Trailblazer level 70
- Equilibrium 6
- Level 8 Traces
- Level 80 Lightcone
- Level 15 Relics

All enemies are under the assumption of being..
- Level 95

Any other mechanic to the game not mentioned either still needs to be implemented are is not accounted for(Usually explicitly stated).
Additional Mechanics to be considered and added...
- Enemy level ranges
- Relic implementation
- Bonus Abilities
- Trace level ranges?

Stats are stored as floats or integers. Not doubles because it doesn't need to be entirely accurate since the use case for this program is typically for
endgame content like MOC, Apoc. Shadow, or DU Extrapolation(Minimum damage for DU because of complications from blessings, equations, and curios).
Ints: HP, ATK, DEF, SPD
Floats: CR, CD, Bonus DMG, Elem Res Break Effect.