/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2023 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.grottogoblin.otherpixeldungeon.items.spells;

import com.grottogoblin.otherpixeldungeon.Dungeon;
import com.grottogoblin.otherpixeldungeon.actors.Actor;
import com.grottogoblin.otherpixeldungeon.actors.Char;
import com.grottogoblin.otherpixeldungeon.actors.buffs.Buff;
import com.grottogoblin.otherpixeldungeon.actors.buffs.Paralysis;
import com.grottogoblin.otherpixeldungeon.actors.hero.Hero;
import com.grottogoblin.otherpixeldungeon.actors.mobs.Mob;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.grottogoblin.otherpixeldungeon.mechanics.Ballistica;
import com.grottogoblin.otherpixeldungeon.messages.Messages;
import com.grottogoblin.otherpixeldungeon.sprites.ItemSpriteSheet;
import com.grottogoblin.otherpixeldungeon.utils.GLog;

public class PhaseShift extends TargetedSpell {
	
	{
		image = ItemSpriteSheet.PHASE_SHIFT;

		usesTargeting = true;
	}
	
	@Override
	protected void affectTarget(Ballistica bolt, Hero hero) {
		final Char ch = Actor.findChar(bolt.collisionPos);
		
		if (ch != null) {
			if (ScrollOfTeleportation.teleportChar(ch)){

				if (ch instanceof Mob) {
					if (((Mob) ch).state == ((Mob) ch).HUNTING) ((Mob) ch).state = ((Mob) ch).WANDERING;
					((Mob) ch).beckon(Dungeon.level.randomDestination( ch ));
				}
				if (!Char.hasProp(ch, Char.Property.BOSS) && !Char.hasProp(ch, Char.Property.MINIBOSS)) {
					Buff.affect(ch, Paralysis.class, Paralysis.DURATION);
				}
				
			}
		} else {
			GLog.w( Messages.get(this, "no_target") );
		}
	}
	
	@Override
	public int value() {
		//prices of ingredients, divided by output quantity, rounds down
		return (int)((30 + 40) * (quantity/8f));
	}
	
	public static class Recipe extends com.grottogoblin.otherpixeldungeon.items.Recipe.SimpleRecipe {
		
		{
			inputs =  new Class[]{ScrollOfTeleportation.class, ArcaneCatalyst.class};
			inQuantity = new int[]{1, 1};
			
			cost = 4;
			
			output = PhaseShift.class;
			outQuantity = 8;
		}
		
	}
	
}
