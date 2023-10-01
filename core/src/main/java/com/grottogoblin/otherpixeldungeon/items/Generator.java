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

package com.grottogoblin.otherpixeldungeon.items;

import com.grottogoblin.otherpixeldungeon.Dungeon;
import com.grottogoblin.otherpixeldungeon.items.armor.Armor;
import com.grottogoblin.otherpixeldungeon.items.armor.ClothArmor;
import com.grottogoblin.otherpixeldungeon.items.armor.DuelistArmor;
import com.grottogoblin.otherpixeldungeon.items.armor.HuntressArmor;
import com.grottogoblin.otherpixeldungeon.items.armor.LeatherArmor;
import com.grottogoblin.otherpixeldungeon.items.armor.MageArmor;
import com.grottogoblin.otherpixeldungeon.items.armor.MailArmor;
import com.grottogoblin.otherpixeldungeon.items.armor.PlateArmor;
import com.grottogoblin.otherpixeldungeon.items.armor.RogueArmor;
import com.grottogoblin.otherpixeldungeon.items.armor.ScaleArmor;
import com.grottogoblin.otherpixeldungeon.items.armor.WarriorArmor;
import com.grottogoblin.otherpixeldungeon.items.artifacts.AlchemistsToolkit;
import com.grottogoblin.otherpixeldungeon.items.artifacts.Artifact;
import com.grottogoblin.otherpixeldungeon.items.artifacts.ChaliceOfBlood;
import com.grottogoblin.otherpixeldungeon.items.artifacts.CloakOfShadows;
import com.grottogoblin.otherpixeldungeon.items.artifacts.DriedRose;
import com.grottogoblin.otherpixeldungeon.items.artifacts.EtherealChains;
import com.grottogoblin.otherpixeldungeon.items.artifacts.HornOfPlenty;
import com.grottogoblin.otherpixeldungeon.items.artifacts.MasterThievesArmband;
import com.grottogoblin.otherpixeldungeon.items.artifacts.SandalsOfNature;
import com.grottogoblin.otherpixeldungeon.items.artifacts.TalismanOfForesight;
import com.grottogoblin.otherpixeldungeon.items.artifacts.TimekeepersHourglass;
import com.grottogoblin.otherpixeldungeon.items.artifacts.UnstableSpellbook;
import com.grottogoblin.otherpixeldungeon.items.food.Food;
import com.grottogoblin.otherpixeldungeon.items.food.MysteryMeat;
import com.grottogoblin.otherpixeldungeon.items.food.Pasty;
import com.grottogoblin.otherpixeldungeon.items.potions.Potion;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfExperience;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfFrost;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfHaste;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfHealing;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfInvisibility;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfLevitation;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfLiquidFlame;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfMindVision;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfParalyticGas;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfPurity;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfStrength;
import com.grottogoblin.otherpixeldungeon.items.potions.PotionOfToxicGas;
import com.grottogoblin.otherpixeldungeon.items.rings.Ring;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfAccuracy;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfArcana;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfElements;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfEnergy;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfEvasion;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfForce;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfFuror;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfHaste;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfMight;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfSharpshooting;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfTenacity;
import com.grottogoblin.otherpixeldungeon.items.rings.RingOfWealth;
import com.grottogoblin.otherpixeldungeon.items.scrolls.Scroll;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfIdentify;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfLullaby;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfMirrorImage;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfRage;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfRecharging;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfRetribution;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfTerror;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfTransmutation;
import com.grottogoblin.otherpixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.grottogoblin.otherpixeldungeon.items.stones.Runestone;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfAggression;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfAugmentation;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfBlast;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfBlink;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfClairvoyance;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfDeepSleep;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfDisarming;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfEnchantment;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfFear;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfFlock;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfIntuition;
import com.grottogoblin.otherpixeldungeon.items.stones.StoneOfShock;
import com.grottogoblin.otherpixeldungeon.items.wands.Wand;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfBlastWave;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfCorrosion;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfCorruption;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfDisintegration;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfFireblast;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfFrost;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfLightning;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfLivingEarth;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfMagicMissile;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfPrismaticLight;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfRegrowth;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfTransfusion;
import com.grottogoblin.otherpixeldungeon.items.wands.WandOfWarding;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.AssassinsBlade;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.BattleAxe;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Crossbow;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Dagger;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Dirk;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Flail;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Gauntlet;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Glaive;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Gloves;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Greataxe;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Greatshield;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Greatsword;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.HandAxe;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Katana;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Longsword;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Mace;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.MagesStaff;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.MeleeWeapon;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Quarterstaff;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Rapier;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.RoundShield;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.RunicBlade;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Sai;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Scimitar;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Shortsword;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Sickle;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Spear;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Sword;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.WarHammer;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.WarScythe;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.Whip;
import com.grottogoblin.otherpixeldungeon.items.weapon.melee.WornShortsword;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.Bolas;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.FishingSpear;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.ForceCube;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.HeavyBoomerang;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.Javelin;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.Kunai;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.MissileWeapon;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.Shuriken;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.ThrowingClub;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.ThrowingHammer;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.ThrowingKnife;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.ThrowingSpear;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.ThrowingSpike;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.ThrowingStone;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.Tomahawk;
import com.grottogoblin.otherpixeldungeon.items.weapon.missiles.Trident;
import com.grottogoblin.otherpixeldungeon.plants.Blindweed;
import com.grottogoblin.otherpixeldungeon.plants.Earthroot;
import com.grottogoblin.otherpixeldungeon.plants.Fadeleaf;
import com.grottogoblin.otherpixeldungeon.plants.Firebloom;
import com.grottogoblin.otherpixeldungeon.plants.Icecap;
import com.grottogoblin.otherpixeldungeon.plants.Mageroyal;
import com.grottogoblin.otherpixeldungeon.plants.Plant;
import com.grottogoblin.otherpixeldungeon.plants.Rotberry;
import com.grottogoblin.otherpixeldungeon.plants.Sorrowmoss;
import com.grottogoblin.otherpixeldungeon.plants.Starflower;
import com.grottogoblin.otherpixeldungeon.plants.Stormvine;
import com.grottogoblin.otherpixeldungeon.plants.Sungrass;
import com.grottogoblin.otherpixeldungeon.plants.Swiftthistle;
import com.watabou.utils.Bundle;
import com.watabou.utils.GameMath;
import com.watabou.utils.Random;
import com.watabou.utils.Reflection;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Generator {

	public enum Category {
		WEAPON	( 2, 2, MeleeWeapon.class),
		WEP_T1	( 0, 0, MeleeWeapon.class),
		WEP_T2	( 0, 0, MeleeWeapon.class),
		WEP_T3	( 0, 0, MeleeWeapon.class),
		WEP_T4	( 0, 0, MeleeWeapon.class),
		WEP_T5	( 0, 0, MeleeWeapon.class),
		
		ARMOR	( 2, 1, Armor.class ),
		
		MISSILE ( 1, 2, MissileWeapon.class ),
		MIS_T1  ( 0, 0, MissileWeapon.class ),
		MIS_T2  ( 0, 0, MissileWeapon.class ),
		MIS_T3  ( 0, 0, MissileWeapon.class ),
		MIS_T4  ( 0, 0, MissileWeapon.class ),
		MIS_T5  ( 0, 0, MissileWeapon.class ),
		
		WAND	( 1, 1, Wand.class ),
		RING	( 1, 0, Ring.class ),
		ARTIFACT( 0, 1, Artifact.class),
		
		FOOD	( 0, 0, Food.class ),
		
		POTION	( 8, 8, Potion.class ),
		SEED	( 1, 1, Plant.Seed.class ),
		
		SCROLL	( 8, 8, Scroll.class ),
		STONE   ( 1, 1, Runestone.class),
		
		GOLD	( 10, 10,   Gold.class );
		
		public Class<?>[] classes;

		//some item types use a deck-based system, where the probs decrement as items are picked
		// until they are all 0, and then they reset. Those generator classes should define
		// defaultProbs. If defaultProbs is null then a deck system isn't used.
		//Artifacts in particular don't reset, no duplicates!
		public float[] probs;
		public float[] defaultProbs = null;
		//These variables are used as a part of the deck system, to ensure that drops are consistent
		// regardless of when they occur (either as part of seeded levelgen, or random item drops)
		public Long seed = null;
		public int dropped = 0;

		//game has two decks of 35 items for overall category probs
		//one deck has a ring and extra armor, the other has an artifact and extra thrown weapon
		//Note that pure random drops only happen as part of levelgen atm, so no seed is needed here
		public float firstProb;
		public float secondProb;
		public Class<? extends Item> superClass;
		
		private Category( float firstProb, float secondProb, Class<? extends Item> superClass ) {
			this.firstProb = firstProb;
			this.secondProb = secondProb;
			this.superClass = superClass;
		}
		
		public static int order( Item item ) {
			for (int i=0; i < values().length; i++) {
				if (values()[i].superClass.isInstance( item )) {
					return i;
				}
			}

			//items without a category-defined order are sorted based on the spritesheet
			return Short.MAX_VALUE+item.image();
		}

		static {
			GOLD.classes = new Class<?>[]{
					Gold.class };
			GOLD.probs = new float[]{ 1 };
			
			POTION.classes = new Class<?>[]{
					PotionOfStrength.class, //2 drop every chapter, see Dungeon.posNeeded()
					PotionOfHealing.class,
					PotionOfMindVision.class,
					PotionOfFrost.class,
					PotionOfLiquidFlame.class,
					PotionOfToxicGas.class,
					PotionOfHaste.class,
					PotionOfInvisibility.class,
					PotionOfLevitation.class,
					PotionOfParalyticGas.class,
					PotionOfPurity.class,
					PotionOfExperience.class};
			POTION.defaultProbs = new float[]{ 0, 6, 4, 3, 3, 3, 2, 2, 2, 2, 2, 1 };
			POTION.probs = POTION.defaultProbs.clone();
			
			SEED.classes = new Class<?>[]{
					Rotberry.Seed.class, //quest item
					Sungrass.Seed.class,
					Fadeleaf.Seed.class,
					Icecap.Seed.class,
					Firebloom.Seed.class,
					Sorrowmoss.Seed.class,
					Swiftthistle.Seed.class,
					Blindweed.Seed.class,
					Stormvine.Seed.class,
					Earthroot.Seed.class,
					Mageroyal.Seed.class,
					Starflower.Seed.class};
			SEED.defaultProbs = new float[]{ 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 2 };
			SEED.probs = SEED.defaultProbs.clone();
			
			SCROLL.classes = new Class<?>[]{
					ScrollOfUpgrade.class, //3 drop every chapter, see Dungeon.souNeeded()
					ScrollOfIdentify.class,
					ScrollOfRemoveCurse.class,
					ScrollOfMirrorImage.class,
					ScrollOfRecharging.class,
					ScrollOfTeleportation.class,
					ScrollOfLullaby.class,
					ScrollOfMagicMapping.class,
					ScrollOfRage.class,
					ScrollOfRetribution.class,
					ScrollOfTerror.class,
					ScrollOfTransmutation.class
			};
			SCROLL.defaultProbs = new float[]{ 0, 6, 4, 3, 3, 3, 2, 2, 2, 2, 2, 1 };
			SCROLL.probs = SCROLL.defaultProbs.clone();
			
			STONE.classes = new Class<?>[]{
					StoneOfEnchantment.class,   //1 is guaranteed to drop on floors 6-19
					StoneOfIntuition.class,     //1 additional stone is also dropped on floors 1-3
					StoneOfDisarming.class,
					StoneOfFlock.class,
					StoneOfShock.class,
					StoneOfBlink.class,
					StoneOfDeepSleep.class,
					StoneOfClairvoyance.class,
					StoneOfAggression.class,
					StoneOfBlast.class,
					StoneOfFear.class,
					StoneOfAugmentation.class  //1 is sold in each shop
			};
			STONE.defaultProbs = new float[]{ 0, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0 };
			STONE.probs = STONE.defaultProbs.clone();

			WAND.classes = new Class<?>[]{
					WandOfMagicMissile.class,
					WandOfLightning.class,
					WandOfDisintegration.class,
					WandOfFireblast.class,
					WandOfCorrosion.class,
					WandOfBlastWave.class,
					WandOfLivingEarth.class,
					WandOfFrost.class,
					WandOfPrismaticLight.class,
					WandOfWarding.class,
					WandOfTransfusion.class,
					WandOfCorruption.class,
					WandOfRegrowth.class };
			WAND.defaultProbs = new float[]{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
			WAND.probs = WAND.defaultProbs.clone();
			
			//see generator.randomWeapon
			WEAPON.classes = new Class<?>[]{};
			WEAPON.probs = new float[]{};
			
			WEP_T1.classes = new Class<?>[]{
					WornShortsword.class,
					MagesStaff.class,
					Dagger.class,
					Gloves.class,
					Rapier.class
			};
			WEP_T1.defaultProbs = new float[]{ 2, 0, 2, 2, 2 };
			WEP_T1.probs = WEP_T1.defaultProbs.clone();
			
			WEP_T2.classes = new Class<?>[]{
					Shortsword.class,
					HandAxe.class,
					Spear.class,
					Quarterstaff.class,
					Dirk.class,
					Sickle.class
			};
			WEP_T2.defaultProbs = new float[]{ 2, 2, 2, 2, 2, 2 };
			WEP_T2.probs = WEP_T2.defaultProbs.clone();
			
			WEP_T3.classes = new Class<?>[]{
					Sword.class,
					Mace.class,
					Scimitar.class,
					RoundShield.class,
					Sai.class,
					Whip.class
			};
			WEP_T3.defaultProbs = new float[]{ 2, 2, 2, 2, 2, 2 };
			WEP_T3.probs = WEP_T1.defaultProbs.clone();
			
			WEP_T4.classes = new Class<?>[]{
					Longsword.class,
					BattleAxe.class,
					Flail.class,
					RunicBlade.class,
					AssassinsBlade.class,
					Crossbow.class,
					Katana.class
			};
			WEP_T4.defaultProbs = new float[]{ 2, 2, 2, 2, 2, 2, 2 };
			WEP_T4.probs = WEP_T4.defaultProbs.clone();
			
			WEP_T5.classes = new Class<?>[]{
					Greatsword.class,
					WarHammer.class,
					Glaive.class,
					Greataxe.class,
					Greatshield.class,
					Gauntlet.class,
					WarScythe.class
			};
			WEP_T5.defaultProbs = new float[]{ 2, 2, 2, 2, 2, 2, 2 };
			WEP_T5.probs = WEP_T5.defaultProbs.clone();
			
			//see Generator.randomArmor
			ARMOR.classes = new Class<?>[]{
					ClothArmor.class,
					LeatherArmor.class,
					MailArmor.class,
					ScaleArmor.class,
					PlateArmor.class,
					WarriorArmor.class,
					MageArmor.class,
					RogueArmor.class,
					HuntressArmor.class,
					DuelistArmor.class
			};
			ARMOR.probs = new float[]{ 1, 1, 1, 1, 1, 0, 0, 0, 0, 0 };
			
			//see Generator.randomMissile
			MISSILE.classes = new Class<?>[]{};
			MISSILE.probs = new float[]{};
			
			MIS_T1.classes = new Class<?>[]{
					ThrowingStone.class,
					ThrowingKnife.class,
					ThrowingSpike.class
			};
			MIS_T1.defaultProbs = new float[]{ 3, 3, 3 };
			MIS_T1.probs = MIS_T1.defaultProbs.clone();
			
			MIS_T2.classes = new Class<?>[]{
					FishingSpear.class,
					ThrowingClub.class,
					Shuriken.class
			};
			MIS_T2.defaultProbs = new float[]{ 3, 3, 3 };
			MIS_T2.probs = MIS_T2.defaultProbs.clone();
			
			MIS_T3.classes = new Class<?>[]{
					ThrowingSpear.class,
					Kunai.class,
					Bolas.class
			};
			MIS_T3.defaultProbs = new float[]{ 3, 3, 3 };
			MIS_T3.probs = MIS_T3.defaultProbs.clone();
			
			MIS_T4.classes = new Class<?>[]{
					Javelin.class,
					Tomahawk.class,
					HeavyBoomerang.class
			};
			MIS_T4.defaultProbs = new float[]{ 3, 3, 3 };
			MIS_T4.probs = MIS_T4.defaultProbs.clone();
			
			MIS_T5.classes = new Class<?>[]{
					Trident.class,
					ThrowingHammer.class,
					ForceCube.class
			};
			MIS_T5.defaultProbs = new float[]{ 3, 3, 3 };
			MIS_T5.probs = MIS_T5.defaultProbs.clone();
			
			FOOD.classes = new Class<?>[]{
					Food.class,
					Pasty.class,
					MysteryMeat.class };
			FOOD.defaultProbs = new float[]{ 4, 1, 0 };
			FOOD.probs = FOOD.defaultProbs.clone();
			
			RING.classes = new Class<?>[]{
					RingOfAccuracy.class,
					RingOfArcana.class,
					RingOfElements.class,
					RingOfEnergy.class,
					RingOfEvasion.class,
					RingOfForce.class,
					RingOfFuror.class,
					RingOfHaste.class,
					RingOfMight.class,
					RingOfSharpshooting.class,
					RingOfTenacity.class,
					RingOfWealth.class};
			RING.defaultProbs = new float[]{ 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 };
			RING.probs = RING.defaultProbs.clone();
			
			ARTIFACT.classes = new Class<?>[]{
					AlchemistsToolkit.class,
					ChaliceOfBlood.class,
					CloakOfShadows.class,
					DriedRose.class,
					EtherealChains.class,
					HornOfPlenty.class,
					MasterThievesArmband.class,
					SandalsOfNature.class,
					TalismanOfForesight.class,
					TimekeepersHourglass.class,
					UnstableSpellbook.class
			};
			ARTIFACT.defaultProbs = new float[]{ 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 };
			ARTIFACT.probs = ARTIFACT.defaultProbs.clone();
		}
	}

	private static final float[][] floorSetTierProbs = new float[][] {
			{0, 75, 20,  4,  1},
			{0, 25, 50, 20,  5},
			{0,  0, 40, 50, 10},
			{0,  0, 20, 40, 40},
			{0,  0,  0, 20, 80}
	};

	private static boolean usingFirstDeck = false;
	private static HashMap<Category,Float> defaultCatProbs = new LinkedHashMap<>();
	private static HashMap<Category,Float> categoryProbs = new LinkedHashMap<>();

	public static void fullReset() {
		usingFirstDeck = Random.Int(2) == 0;
		generalReset();
		for (Category cat : Category.values()) {
			reset(cat);
			if (cat.defaultProbs != null) {
				cat.seed = Random.Long();
				cat.dropped = 0;
			}
		}
	}

	public static void generalReset(){
		for (Category cat : Category.values()) {
			categoryProbs.put( cat, usingFirstDeck ? cat.firstProb : cat.secondProb );
			defaultCatProbs.put( cat, cat.firstProb + cat.secondProb );
		}
	}

	public static void reset(Category cat){
		if (cat.defaultProbs != null) cat.probs = cat.defaultProbs.clone();
	}
	
	public static Item random() {
		Category cat = Random.chances( categoryProbs );
		if (cat == null){
			usingFirstDeck = !usingFirstDeck;
			generalReset();
			cat = Random.chances( categoryProbs );
		}
		categoryProbs.put( cat, categoryProbs.get( cat ) - 1);

		if (cat == Category.SEED) {
			//We specifically use defaults for seeds here because, unlike other item categories
			// their predominant source of drops is grass, not levelgen. This way the majority
			// of seed drops still use a deck, but the few that are spawned by levelgen are consistent
			return randomUsingDefaults(cat);
		} else {
			return random(cat);
		}
	}

	public static Item randomUsingDefaults(){
		return randomUsingDefaults(Random.chances( defaultCatProbs ));
	}
	
	public static Item random( Category cat ) {
		switch (cat) {
			case ARMOR:
				return randomArmor();
			case WEAPON:
				return randomWeapon();
			case MISSILE:
				return randomMissile();
			case ARTIFACT:
				Item item = randomArtifact();
				//if we're out of artifacts, return a ring instead.
				return item != null ? item : random(Category.RING);
			default:
				if (cat.defaultProbs != null && cat.seed != null){
					Random.pushGenerator(cat.seed);
					for (int i = 0; i < cat.dropped; i++) Random.Long();
				}

				int i = Random.chances(cat.probs);
				if (i == -1) {
					reset(cat);
					i = Random.chances(cat.probs);
				}
				if (cat.defaultProbs != null) cat.probs[i]--;

				if (cat.defaultProbs != null && cat.seed != null){
					Random.popGenerator();
					cat.dropped++;
				}

				return ((Item) Reflection.newInstance(cat.classes[i])).random();
		}
	}

	//overrides any deck systems and always uses default probs
	// except for artifacts, which must always use a deck
	public static Item randomUsingDefaults( Category cat ){
		if (cat == Category.WEAPON){
			return randomWeapon(true);
		} else if (cat == Category.MISSILE){
			return randomMissile(true);
		} else if (cat.defaultProbs == null || cat == Category.ARTIFACT) {
			return random(cat);
		} else {
			return ((Item) Reflection.newInstance(cat.classes[Random.chances(cat.defaultProbs)])).random();
		}
	}
	
	public static Item random( Class<? extends Item> cl ) {
		return Reflection.newInstance(cl).random();
	}

	public static Armor randomArmor(){
		return randomArmor(Dungeon.depth / 5);
	}
	
	public static Armor randomArmor(int floorSet) {

		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);
		
		Armor a = (Armor)Reflection.newInstance(Category.ARMOR.classes[Random.chances(floorSetTierProbs[floorSet])]);
		a.random();
		return a;
	}

	public static final Category[] wepTiers = new Category[]{
			Category.WEP_T1,
			Category.WEP_T2,
			Category.WEP_T3,
			Category.WEP_T4,
			Category.WEP_T5
	};

	public static MeleeWeapon randomWeapon(){
		return randomWeapon(Dungeon.depth / 5);
	}

	public static MeleeWeapon randomWeapon(int floorSet) {
		return randomWeapon(floorSet, false);
	}

	public static MeleeWeapon randomWeapon(boolean useDefaults) {
		return randomWeapon(Dungeon.depth / 5, useDefaults);
	}
	
	public static MeleeWeapon randomWeapon(int floorSet, boolean useDefaults) {

		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);

		MeleeWeapon w;
		if (useDefaults){
			w = (MeleeWeapon) randomUsingDefaults(wepTiers[Random.chances(floorSetTierProbs[floorSet])]);
		} else {
			w = (MeleeWeapon) random(wepTiers[Random.chances(floorSetTierProbs[floorSet])]);
		}
		return w;
	}
	
	public static final Category[] misTiers = new Category[]{
			Category.MIS_T1,
			Category.MIS_T2,
			Category.MIS_T3,
			Category.MIS_T4,
			Category.MIS_T5
	};
	
	public static MissileWeapon randomMissile(){
		return randomMissile(Dungeon.depth / 5);
	}

	public static MissileWeapon randomMissile(int floorSet) {
		return randomMissile(floorSet, false);
	}

	public static MissileWeapon randomMissile(boolean useDefaults) {
		return randomMissile(Dungeon.depth / 5, useDefaults);
	}

	public static MissileWeapon randomMissile(int floorSet, boolean useDefaults) {
		
		floorSet = (int)GameMath.gate(0, floorSet, floorSetTierProbs.length-1);

		MissileWeapon w;
		if (useDefaults){
			w = (MissileWeapon)randomUsingDefaults(misTiers[Random.chances(floorSetTierProbs[floorSet])]);
		} else {
			w = (MissileWeapon)random(misTiers[Random.chances(floorSetTierProbs[floorSet])]);
		}
		return w;
	}

	//enforces uniqueness of artifacts throughout a run.
	public static Artifact randomArtifact() {

		Category cat = Category.ARTIFACT;

		if (cat.defaultProbs != null && cat.seed != null){
			Random.pushGenerator(cat.seed);
			for (int i = 0; i < cat.dropped; i++) Random.Long();
		}

		int i = Random.chances( cat.probs );

		if (cat.defaultProbs != null && cat.seed != null){
			Random.popGenerator();
			cat.dropped++;
		}

		//if no artifacts are left, return null
		if (i == -1){
			return null;
		}

		cat.probs[i]--;
		return (Artifact) Reflection.newInstance((Class<? extends Artifact>) cat.classes[i]).random();

	}

	public static boolean removeArtifact(Class<?extends Artifact> artifact) {
		Category cat = Category.ARTIFACT;
		for (int i = 0; i < cat.classes.length; i++){
			if (cat.classes[i].equals(artifact) && cat.probs[i] > 0) {
				cat.probs[i] = 0;
				return true;
			}
		}
		return false;
	}

	private static final String FIRST_DECK = "first_deck";
	private static final String GENERAL_PROBS = "general_probs";
	private static final String CATEGORY_PROBS = "_probs";
	private static final String CATEGORY_SEED = "_seed";
	private static final String CATEGORY_DROPPED = "_dropped";

	public static void storeInBundle(Bundle bundle) {
		bundle.put(FIRST_DECK, usingFirstDeck);

		Float[] genProbs = categoryProbs.values().toArray(new Float[0]);
		float[] storeProbs = new float[genProbs.length];
		for (int i = 0; i < storeProbs.length; i++){
			storeProbs[i] = genProbs[i];
		}
		bundle.put( GENERAL_PROBS, storeProbs);

		for (Category cat : Category.values()){
			if (cat.defaultProbs == null) continue;

			bundle.put(cat.name().toLowerCase() + CATEGORY_PROBS,   cat.probs);
			if (cat.seed != null) {
				bundle.put(cat.name().toLowerCase() + CATEGORY_SEED, cat.seed);
				bundle.put(cat.name().toLowerCase() + CATEGORY_DROPPED, cat.dropped);
			}
		}
	}

	public static void restoreFromBundle(Bundle bundle) {
		fullReset();

		usingFirstDeck = bundle.getBoolean(FIRST_DECK);

		if (bundle.contains(GENERAL_PROBS)){
			float[] probs = bundle.getFloatArray(GENERAL_PROBS);
			for (int i = 0; i < probs.length; i++){
				categoryProbs.put(Category.values()[i], probs[i]);
			}
		}

		for (Category cat : Category.values()){
			if (bundle.contains(cat.name().toLowerCase() + CATEGORY_PROBS)){
				float[] probs = bundle.getFloatArray(cat.name().toLowerCase() + CATEGORY_PROBS);
				if (cat.defaultProbs != null && probs.length == cat.defaultProbs.length){
					cat.probs = probs;
				}
				if (bundle.contains(cat.name().toLowerCase() + CATEGORY_SEED)){
					cat.seed = bundle.getLong(cat.name().toLowerCase() + CATEGORY_SEED);
					cat.dropped = bundle.getInt(cat.name().toLowerCase() + CATEGORY_DROPPED);
				}
			}
		}
		
	}
}
