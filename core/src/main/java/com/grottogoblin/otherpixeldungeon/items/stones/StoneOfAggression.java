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

package com.grottogoblin.otherpixeldungeon.items.stones;

import com.grottogoblin.otherpixeldungeon.Assets;
import com.grottogoblin.otherpixeldungeon.Dungeon;
import com.grottogoblin.otherpixeldungeon.actors.Actor;
import com.grottogoblin.otherpixeldungeon.actors.Char;
import com.grottogoblin.otherpixeldungeon.actors.buffs.Buff;
import com.grottogoblin.otherpixeldungeon.actors.buffs.FlavourBuff;
import com.grottogoblin.otherpixeldungeon.actors.mobs.Mob;
import com.grottogoblin.otherpixeldungeon.effects.CellEmitter;
import com.grottogoblin.otherpixeldungeon.effects.Speck;
import com.grottogoblin.otherpixeldungeon.items.Heap;
import com.grottogoblin.otherpixeldungeon.sprites.ItemSpriteSheet;
import com.grottogoblin.otherpixeldungeon.ui.BuffIndicator;
import com.watabou.noosa.audio.Sample;

public class StoneOfAggression extends Runestone {
	
	{
		image = ItemSpriteSheet.STONE_AGGRESSION;
	}
	
	@Override
	protected void activate(int cell) {
		
		Char ch = Actor.findChar( cell );
		
		if (ch != null) {
			if (ch.alignment == Char.Alignment.ENEMY) {
				Buff.prolong(ch, Aggression.class, Aggression.DURATION / 4f);
			} else {
				Buff.prolong(ch, Aggression.class, Aggression.DURATION);
			}
			CellEmitter.center(cell).start( Speck.factory( Speck.SCREAM ), 0.3f, 3 );
			Sample.INSTANCE.play( Assets.Sounds.READ );
		} else {
			//Item.onThrow
			Heap heap = Dungeon.level.drop( this, cell );
			if (!heap.isEmpty()) {
				heap.sprite.drop( cell );
			}
		}
		
	}

	public static class Aggression extends FlavourBuff {
		
		public static final float DURATION = 20f;
		
		{
			type = buffType.NEGATIVE;
			announced = true;
		}

		@Override
		public int icon() {
			return BuffIndicator.TARGETED;
		}

		@Override
		public float iconFadePercent() {
			if (target.alignment == Char.Alignment.ENEMY){
				return Math.max(0, (DURATION/4f - visualcooldown()) / (DURATION/4f));
			} else {
				return Math.max(0, (DURATION - visualcooldown()) / DURATION);
			}
		}

		@Override
		public void detach() {
			//if our target is an enemy, reset the aggro of any enemies targeting it
			if (target.isAlive()) {
				if (target.alignment == Char.Alignment.ENEMY) {
					for (Mob m : Dungeon.level.mobs) {
						if (m.alignment == Char.Alignment.ENEMY && m.isTargeting(target)) {
							m.aggro(null);
						}
						if (target instanceof Mob && ((Mob) target).isTargeting(m)){
							((Mob) target).aggro(null);
						}
					}
				}
			}
			super.detach();
			
		}

	}
	
}
