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

package com.grottogoblin.otherpixeldungeon.actors.hero.abilities.warrior;

import com.grottogoblin.otherpixeldungeon.Assets;
import com.grottogoblin.otherpixeldungeon.Dungeon;
import com.grottogoblin.otherpixeldungeon.actors.Actor;
import com.grottogoblin.otherpixeldungeon.actors.Char;
import com.grottogoblin.otherpixeldungeon.actors.buffs.Buff;
import com.grottogoblin.otherpixeldungeon.actors.buffs.Combo;
import com.grottogoblin.otherpixeldungeon.actors.buffs.FlavourBuff;
import com.grottogoblin.otherpixeldungeon.actors.buffs.Invisibility;
import com.grottogoblin.otherpixeldungeon.actors.hero.Hero;
import com.grottogoblin.otherpixeldungeon.actors.hero.Talent;
import com.grottogoblin.otherpixeldungeon.actors.hero.abilities.ArmorAbility;
import com.grottogoblin.otherpixeldungeon.effects.Speck;
import com.grottogoblin.otherpixeldungeon.effects.SpellSprite;
import com.grottogoblin.otherpixeldungeon.items.armor.ClassArmor;
import com.grottogoblin.otherpixeldungeon.messages.Messages;
import com.grottogoblin.otherpixeldungeon.ui.BuffIndicator;
import com.grottogoblin.otherpixeldungeon.ui.HeroIcon;
import com.watabou.noosa.Image;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Bundle;

public class Endure extends ArmorAbility {

	{
		baseChargeUse = 50f;
	}

	@Override
	protected void activate(ClassArmor armor, Hero hero, Integer target) {

		Buff.prolong(hero, EndureTracker.class, 13f);

		Combo combo = hero.buff(Combo.class);
		if (combo != null){
			combo.addTime(3f);
		}
		hero.sprite.operate(hero.pos);

		armor.charge -= chargeUse(hero);
		armor.updateQuickslot();
		Invisibility.dispel();
		hero.spendAndNext(3f);
	}

	public static class EndureTracker extends FlavourBuff {

		{
			type = buffType.POSITIVE;
		}

		public boolean enduring = true;

		public int damageBonus = 0;
		public int hitsLeft = 0;

		@Override
		public int icon() {
			return enduring ? BuffIndicator.NONE : BuffIndicator.ARMOR;
		}

		@Override
		public void tintIcon(Image icon) {
			super.tintIcon(icon);
		}

		@Override
		public float iconFadePercent() {
			return Math.max(0, (10f - visualcooldown()) / 10f);
		}

		@Override
		public String desc() {
			return Messages.get(this, "desc", damageBonus, hitsLeft);
		}

		public float adjustDamageTaken(float damage){
			if (enduring) {
				damageBonus += damage/2;

				float damageMulti = 0.5f;
				if (Dungeon.hero.hasTalent(Talent.SHRUG_IT_OFF)){
					//total damage reduction is 60%/68%/74%/80%, based on points in talent
					damageMulti *= Math.pow(0.8f, Dungeon.hero.pointsInTalent(Talent.SHRUG_IT_OFF));
				}

				return damage*damageMulti;
			}
			return damage;
		}

		public void endEnduring(){
			if (!enduring){
				return;
			}

			enduring = false;
			damageBonus *= 1f + 0.15f*Dungeon.hero.pointsInTalent(Talent.SUSTAINED_RETRIBUTION);

			int nearby = 0;
			for (Char ch : Actor.chars()){
				if (ch.alignment == Char.Alignment.ENEMY && Dungeon.level.distance(target.pos, ch.pos) <= 2){
					nearby ++;
				}
			}
			damageBonus *= 1f + (nearby*0.05f*Dungeon.hero.pointsInTalent(Talent.EVEN_THE_ODDS));

			hitsLeft = 1+Dungeon.hero.pointsInTalent(Talent.SUSTAINED_RETRIBUTION);
			damageBonus /= hitsLeft;

			if (damageBonus > 0) {
				target.sprite.centerEmitter().start( Speck.factory( Speck.SCREAM ), 0.3f, 3 );
				Sample.INSTANCE.play(Assets.Sounds.CHALLENGE);
				SpellSprite.show(target, SpellSprite.BERSERK);
			} else {
				detach();
			}
		}

		public float damageFactor(float damage){
			if (enduring){
				return damage;
			} else {
				int bonusDamage = damageBonus;
				hitsLeft--;

				if (hitsLeft <= 0){
					detach();
				}
				return damage + bonusDamage;
			}
		}

		public static String ENDURING       = "enduring";
		public static String DAMAGE_BONUS   = "damage_bonus";
		public static String HITS_LEFT      = "hits_left";

		@Override
		public void storeInBundle(Bundle bundle) {
			super.storeInBundle(bundle);
			bundle.put(ENDURING, enduring);
			bundle.put(DAMAGE_BONUS, damageBonus);
			bundle.put(HITS_LEFT, hitsLeft);
		}

		@Override
		public void restoreFromBundle(Bundle bundle) {
			super.restoreFromBundle(bundle);
			enduring = bundle.getBoolean(ENDURING);
			damageBonus = bundle.getInt(DAMAGE_BONUS);
			hitsLeft = bundle.getInt(HITS_LEFT);
		}
	};

	@Override
	public int icon() {
		return HeroIcon.ENDURE;
	}

	@Override
	public Talent[] talents() {
		return new Talent[]{Talent.SUSTAINED_RETRIBUTION, Talent.SHRUG_IT_OFF, Talent.EVEN_THE_ODDS, Talent.HEROIC_ENERGY};
	}
}
