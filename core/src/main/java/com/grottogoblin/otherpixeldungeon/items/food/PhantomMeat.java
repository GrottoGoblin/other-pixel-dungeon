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

package com.grottogoblin.otherpixeldungeon.items.food;

import com.grottogoblin.otherpixeldungeon.actors.buffs.Barkskin;
import com.grottogoblin.otherpixeldungeon.actors.buffs.Buff;
import com.grottogoblin.otherpixeldungeon.actors.buffs.Hunger;
import com.grottogoblin.otherpixeldungeon.actors.buffs.Invisibility;
import com.grottogoblin.otherpixeldungeon.actors.hero.Hero;
import com.grottogoblin.otherpixeldungeon.effects.Speck;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfHealing;
import com.grottogoblin.otherpixeldungeon.sprites.ItemSpriteSheet;

public class PhantomMeat extends Food {

	{
		image = ItemSpriteSheet.PHANTOM_MEAT;
		energy = Hunger.STARVING;
	}

	@Override
	protected void satisfy(Hero hero) {
		super.satisfy(hero);
		effect(hero);
	}

	public int value() {
		return 30 * quantity;
	}

	public static void effect(Hero hero){

		Barkskin.conditionallyAppend( hero, hero.HT / 4, 1 );
		Buff.affect( hero, Invisibility.class, Invisibility.DURATION );
		if (hero.HP < hero.HT) {
			hero.HP = Math.min( hero.HP + hero.HT / 4, hero.HT );
		}
		hero.sprite.emitter().burst( Speck.factory( Speck.HEALING ), 1 );
		PotionOfHealing.cure(hero);

	}


}
