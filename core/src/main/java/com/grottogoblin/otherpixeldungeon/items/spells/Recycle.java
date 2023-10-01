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

import com.grottogoblin.otherpixeldungeon.Challenges;
import com.grottogoblin.otherpixeldungeon.Dungeon;
import com.grottogoblin.otherpixeldungeon.effects.Speck;
import com.grottogoblin.otherpixeldungeon.effects.Transmuting;
import com.grottogoblin.otherpixeldungeon.items.Generator;
import com.grottogoblin.otherpixeldungeon.items.Item;
import com.grottogoblin.otherpixeldungeon.items.potions.AlchemicalCatalyst;
import com.grottogoblin.otherpixeldungeon.items.potions.Potion;
import com.grottogoblin.otherpixeldungeon.items.potions.brews.Brew;
import com.grottogoblin.otherpixeldungeon.items.potions.elixirs.Elixir;
import com.grottogoblin.otherpixeldungeon.items.potions.exotic.ExoticPotion;
import com.grottogoblin.otherpixeldungeon.items.scrolls.Scroll;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfTransmutation;
import com.grottogoblin.otherpixeldungeon.items.scrolls.exotic.ExoticScroll;
import com.grottogoblin.otherpixeldungeon.items.stones.Runestone;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.darts.TippedDart;
import com.grottogoblin.otherpixeldungeon.messages.Messages;
import com.grottogoblin.otherpixeldungeon.plants.Plant;
import com.grottogoblin.otherpixeldungeon.sprites.ItemSpriteSheet;
import com.grottogoblin.otherpixeldungeon.utils.GLog;
import com.watabou.utils.Reflection;

public class Recycle extends InventorySpell {
	
	{
		image = ItemSpriteSheet.RECYCLE;
	}

	@Override
	protected boolean usableOnItem(Item item) {
		return (item instanceof Potion && !(item instanceof Elixir || item instanceof Brew || item instanceof AlchemicalCatalyst)) ||
				item instanceof Scroll ||
				item instanceof Plant.Seed ||
				item instanceof Runestone ||
				item instanceof TippedDart;
	}

	@Override
	protected void onItemSelected(Item item) {
		Item result;
		do {
			if (item instanceof Potion) {
				result = Generator.randomUsingDefaults(Generator.Category.POTION);
				if (item instanceof ExoticPotion){
					result = Reflection.newInstance(ExoticPotion.regToExo.get(result.getClass()));
				}
			} else if (item instanceof Scroll) {
				result = Generator.randomUsingDefaults(Generator.Category.SCROLL);
				if (item instanceof ExoticScroll){
					result = Reflection.newInstance(ExoticScroll.regToExo.get(result.getClass()));
				}
			} else if (item instanceof Plant.Seed) {
				result = Generator.randomUsingDefaults(Generator.Category.SEED);
			} else if (item instanceof Runestone) {
				result = Generator.randomUsingDefaults(Generator.Category.STONE);
			} else {
				result = TippedDart.randomTipped(1);
			}
		} while (result.getClass() == item.getClass() || Challenges.isItemBlocked(result));
		
		item.detach(curUser.belongings.backpack);
		GLog.p(Messages.get(this, "recycled", result.name()));
		if (!result.collect()){
			Dungeon.level.drop(result, curUser.pos).sprite.drop();
		}
		Transmuting.show(curUser, item, result);
		curUser.sprite.emitter().start(Speck.factory(Speck.CHANGE), 0.2f, 10);
	}
	
	@Override
	public int value() {
		//prices of ingredients, divided by output quantity, rounds down
		return (int)((50 + 40) * (quantity/12f));
	}
	
	public static class Recipe extends com.grottogoblin.otherpixeldungeon.items.Recipe.SimpleRecipe {
		
		{
			inputs =  new Class[]{ScrollOfTransmutation.class, ArcaneCatalyst.class};
			inQuantity = new int[]{1, 1};
			
			cost = 8;
			
			output = Recycle.class;
			outQuantity = 12;
		}
		
	}
}
