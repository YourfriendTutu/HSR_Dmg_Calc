# HSR_Dmg_Calc
Java CS Team: Star Rail Calculator
All characters are under the assumption of being...
- Trailblazer level 70
- Equilibrium 6
- All Traces level 8 and All Bonus Abilities
- Level 80 Lightcone
- Level 15 Relics

Any other mechanic to the game not mentioned either still needs to be implemented are is not accounted for(Usually explicitly stated).

Stats are stored as floats or integers. Not doubles because it doesn't need to be entirely accurate since the use case for this program is typically for
endgame content like MOC, Apoc. Shadow, or DU Extrapolation.
Ints: HP, ATK, DEF, SPD
Floats: CR, CD, Bonus DMG, Elem Res Break Effect.