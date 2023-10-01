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

package com.grottogoblin.otherpixeldungeon.actors.buffs;

import com.grottogoblin.otherpixeldungeon.Dungeon;
import com.grottogoblin.otherpixeldungeon.otherpixeldungeon;
import com.grottogoblin.otherpixeldungeon.actors.Char;
import com.grottogoblin.otherpixeldungeon.items.artifacts.TimekeepersHourglass;
import com.grottogoblin.otherpixeldungeon.plants.Swiftthistle;
import com.grottogoblin.otherpixeldungeon.scenes.GameScene;
import com.grottogoblin.otherpixeldungeon.sprites.CharSprite;
import com.grottogoblin.otherpixeldungeon.ui.BuffIndicator;
import com.watabou.noosa.Image;

public class Levitation extends FlavourBuff {
	
	{
		type = buffType.POSITIVE;
	}

	public static final float DURATION	= 20f;
	
	@Override
	public boolean attachTo( Char target ) {
		if (super.attachTo( target )) {
			target.flying = true;
			Roots.detach( target, Roots.class );
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void detach() {
		target.flying = false;
		super.detach();
		//only press tiles if we're current in the game screen
		if (otherpixeldungeon.scene() instanceof GameScene) {
			Dungeon.level.occupyCell(target );
		}
	}

	//used to determine if levitation is about to end
	public boolean detachesWithinDelay(float delay){
		if (target.buff(Swiftthistle.TimeBubble.class) != null){
			return false;
		}

		if (target.buff(TimekeepersHourglass.timeFreeze.class) != null){
			return false;
		}

		return cooldown() < delay;
	}
	
	@Override
	public int icon() {
		return BuffIndicator.LEVITATION;
	}

	@Override
	public void tintIcon(Image icon) {
		icon.hardlight(1f, 2.1f, 2.5f);
	}

	@Override
	public float iconFadePercent() {
		return Math.max(0, (DURATION - visualcooldown()) / DURATION);
	}
	
	@Override
	public void fx(boolean on) {
		if (on) target.sprite.add(CharSprite.State.LEVITATING);
		else target.sprite.remove(CharSprite.State.LEVITATING);
	}
}
