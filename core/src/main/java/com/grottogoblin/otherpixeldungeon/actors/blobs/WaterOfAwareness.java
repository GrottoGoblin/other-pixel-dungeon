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

package com.grottogoblin.otherpixeldungeon.actors.blobs;

import com.grottogoblin.otherpixeldungeon.Assets;
import com.grottogoblin.otherpixeldungeon.Badges;
import com.grottogoblin.otherpixeldungeon.Dungeon;
import com.grottogoblin.otherpixeldungeon.actors.buffs.Awareness;
import com.grottogoblin.otherpixeldungeon.actors.buffs.Buff;
import com.grottogoblin.otherpixeldungeon.actors.hero.Hero;
import com.grottogoblin.otherpixeldungeon.effects.BlobEmitter;
import com.grottogoblin.otherpixeldungeon.effects.Identification;
import com.grottogoblin.otherpixeldungeon.effects.Speck;
import com.grottogoblin.otherpixeldungeon.items.Item;
import com.grottogoblin.otherpixeldungeon.journal.Notes.Landmark;
import com.grottogoblin.otherpixeldungeon.levels.Terrain;
import com.grottogoblin.otherpixeldungeon.messages.Messages;
import com.grottogoblin.otherpixeldungeon.scenes.GameScene;
import com.grottogoblin.otherpixeldungeon.tiles.DungeonTilemap;
import com.grottogoblin.otherpixeldungeon.utils.GLog;
import com.watabou.noosa.audio.Sample;

public class WaterOfAwareness extends WellWater {

	@Override
	protected boolean affectHero( Hero hero ) {
		
		Sample.INSTANCE.play( Assets.Sounds.DRINK );
		emitter.parent.add( new Identification( hero.sprite.center() ) );
		
		hero.belongings.observe();
		
		for (int i=0; i < Dungeon.level.length(); i++) {
			
			int terr = Dungeon.level.map[i];
			if ((Terrain.flags[terr] & Terrain.SECRET) != 0) {
				
				Dungeon.level.discover( i );
				
				if (Dungeon.level.heroFOV[i]) {
					GameScene.discoverTile( i, terr );
				}
			}
		}
		
		Buff.affect( hero, Awareness.class, Awareness.DURATION );
		Dungeon.observe();

		Dungeon.hero.interrupt();
	
		GLog.p( Messages.get(this, "procced") );
		
		return true;
	}
	
	@Override
	protected Item affectItem( Item item, int pos ) {
		if (item.isIdentified()) {
			return null;
		} else {
			item.identify();
			Badges.validateItemLevelAquired( item );
			
			Sample.INSTANCE.play( Assets.Sounds.DRINK );
			emitter.parent.add( new Identification( DungeonTilemap.tileCenterToWorld( pos ) ) );
			
			return item;
		}
	}
	
	@Override
	protected Landmark record() {
		return Landmark.WELL_OF_AWARENESS;
	}
	
	@Override
	public void use( BlobEmitter emitter ) {
		super.use( emitter );
		emitter.pour( Speck.factory( Speck.QUESTION ), 0.3f );
	}
	
	@Override
	public String tileDesc() {
		return Messages.get(this, "desc");
	}
}
