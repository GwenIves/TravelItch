package com.foundry.app.stockton.travelitchbase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.foundry.app.stockton.travelitchbase.R;

import android.content.Context;
import android.location.Location;

public class StampsManager {
	private static StampsManager sStampsManager = null;

	private Context mContext;

	private List<StampGroup> mContinents;
	private List<StampGroup> mCountries;
	private List<StampGroup> mFeatures;
	private List<Stamp> mStamps;

	private int mScore;
	private int mVisitedLocations;
	private int mVisitedCountries;
	private int mVisitedContinents;

	public static StampsManager get (Context c) {
		if (sStampsManager == null)
			sStampsManager = new StampsManager (c);

		return sStampsManager;
	}

	private StampsManager (Context c) {
		mContext = c.getApplicationContext();

		createFeatures ();
		createContinents ();
		createCountries ();
		createStamps ();

		mScore = 0;
		mVisitedLocations = 0;
		mVisitedCountries = 0;
		mVisitedContinents = 0;
	}

	private void createFeature (int name, int feature, int icon) {
		mFeatures.add(new StampGroup (name, feature, icon));
	}

	private void createFeatures () {
		mFeatures = new ArrayList<StampGroup> (6);

		createFeature (R.string.capitals, Stamp.FEATURE_CAPITAL, R.drawable.ic_feature_capital);
		createFeature (R.string.cities, Stamp.FEATURE_CITY, R.drawable.ic_feature_city);
		createFeature (R.string.outdoor, Stamp.FEATURE_OUTDOOR, R.drawable.ic_feature_outdoor);
		createFeature (R.string.heritage_sites, Stamp.FEATURE_WHS, R.drawable.ic_feature_whs);
		createFeature (R.string.mountains, Stamp.FEATURE_MOUNTAIN, R.drawable.ic_feature_mountain);
		createFeature (R.string.sights, Stamp.FEATURE_SIGHTS, R.drawable.ic_feature_sights);

		Collections.sort(mFeatures, StampGroup.getByNameComparator(mContext));
	}

	private void createContinent (int name, int icon) {
		mContinents.add(new StampGroup (name, 0, icon));
	}

	private void createContinents () {
		mContinents = new ArrayList<StampGroup> (8);

		createContinent (R.string.antarctica, R.drawable.ic_continent_antarctica);
		createContinent (R.string.north_america, R.drawable.ic_continent_north_america);
		createContinent (R.string.central_america, R.drawable.ic_continent_central_america);
		createContinent (R.string.south_america, R.drawable.ic_continent_south_america);
		createContinent (R.string.europe, R.drawable.ic_continent_europe);
		createContinent (R.string.africa, R.drawable.ic_continent_africa);
		createContinent (R.string.asia, R.drawable.ic_continent_asia);
		createContinent (R.string.australia_continent, R.drawable.ic_continent_australia);

		Collections.sort(mContinents, StampGroup.getByNameComparator(mContext));
	}

	private void createCountry (int name, int icon) {
		mCountries.add(new StampGroup (name, 0, icon));
	}

	private void createCountries () {
		mCountries = new ArrayList<StampGroup> (247);

		createCountry (R.string.afghanistan, R.drawable.ic_country_afghanistan);
		createCountry (R.string.aland, R.drawable.ic_country_aland);
		createCountry (R.string.albania, R.drawable.ic_country_albania);
		createCountry (R.string.algeria, R.drawable.ic_country_algeria);
		createCountry (R.string.american_samoa, R.drawable.ic_country_american_samoa);
		createCountry (R.string.andorra, R.drawable.ic_country_andorra);
		createCountry (R.string.angola, R.drawable.ic_country_angola);
		createCountry (R.string.anguilla, R.drawable.ic_country_anguilla);
		createCountry (R.string.antigua_and_barbuda, R.drawable.ic_country_antigua_and_barbuda);
		createCountry (R.string.argentina, R.drawable.ic_country_argentina);
		createCountry (R.string.armenia, R.drawable.ic_country_armenia);
		createCountry (R.string.aruba, R.drawable.ic_country_aruba);
		createCountry (R.string.australia, R.drawable.ic_country_australia);
		createCountry (R.string.austria, R.drawable.ic_country_austria);
		createCountry (R.string.azerbaijan, R.drawable.ic_country_azerbaijan);
		createCountry (R.string.bahamas, R.drawable.ic_country_bahamas);
		createCountry (R.string.bahrain, R.drawable.ic_country_bahrain);
		createCountry (R.string.bangladesh, R.drawable.ic_country_bangladesh);
		createCountry (R.string.barbados, R.drawable.ic_country_barbados);
		createCountry (R.string.belarus, R.drawable.ic_country_belarus);
		createCountry (R.string.belgium, R.drawable.ic_country_belgium);
		createCountry (R.string.belize, R.drawable.ic_country_belize);
		createCountry (R.string.benin, R.drawable.ic_country_benin);
		createCountry (R.string.bermuda, R.drawable.ic_country_bermuda);
		createCountry (R.string.bhutan, R.drawable.ic_country_bhutan);
		createCountry (R.string.bolivia, R.drawable.ic_country_bolivia);
		createCountry (R.string.bonaire_sint_eustatius_and_saba, R.drawable.ic_country_netherlands);
		createCountry (R.string.bosnia_and_herzegovina, R.drawable.ic_country_bosnia_and_herzegovina);
		createCountry (R.string.botswana, R.drawable.ic_country_botswana);
		createCountry (R.string.bouvet_island, R.drawable.ic_country_norway);
		createCountry (R.string.brazil, R.drawable.ic_country_brazil);
		createCountry (R.string.british_indian_ocean_territory, R.drawable.ic_country_british_indian_ocean_territory);
		createCountry (R.string.brunei_darussalam, R.drawable.ic_country_brunei_darussalam);
		createCountry (R.string.bulgaria, R.drawable.ic_country_bulgaria);
		createCountry (R.string.burkina_faso, R.drawable.ic_country_burkina_faso);
		createCountry (R.string.burundi, R.drawable.ic_country_burundi);
		createCountry (R.string.cambodia, R.drawable.ic_country_cambodia);
		createCountry (R.string.cameroon, R.drawable.ic_country_cameroon);
		createCountry (R.string.canada, R.drawable.ic_country_canada);
		createCountry (R.string.cape_verde, R.drawable.ic_country_cape_verde);
		createCountry (R.string.cayman_islands, R.drawable.ic_country_cayman_islands);
		createCountry (R.string.central_african_republic, R.drawable.ic_country_central_african_republic);
		createCountry (R.string.chad, R.drawable.ic_country_chad);
		createCountry (R.string.chile, R.drawable.ic_country_chile);
		createCountry (R.string.china, R.drawable.ic_country_china);
		createCountry (R.string.christmas_island_country, R.drawable.ic_country_christmas_island);
		createCountry (R.string.cocos_islands_country, R.drawable.ic_country_cocos_islands);
		createCountry (R.string.colombia, R.drawable.ic_country_colombia);
		createCountry (R.string.comoros, R.drawable.ic_country_comoros);
		createCountry (R.string.congo_brazzaville, R.drawable.ic_country_congo_brazzaville);
		createCountry (R.string.congo_kinshasa, R.drawable.ic_country_congo_kinshasa);
		createCountry (R.string.cook_islands, R.drawable.ic_country_cook_islands);
		createCountry (R.string.costa_rica, R.drawable.ic_country_costa_rica);
		createCountry (R.string.cote_divoire, R.drawable.ic_country_cote_divoire);
		createCountry (R.string.croatia, R.drawable.ic_country_croatia);
		createCountry (R.string.cuba, R.drawable.ic_country_cuba);
		createCountry (R.string.curacao, R.drawable.ic_country_curacao);
		createCountry (R.string.cyprus, R.drawable.ic_country_cyprus);
		createCountry (R.string.czech_republic, R.drawable.ic_country_czech_republic);
		createCountry (R.string.denmark, R.drawable.ic_country_denmark);
		createCountry (R.string.djibouti, R.drawable.ic_country_djibouti);
		createCountry (R.string.dominica, R.drawable.ic_country_dominica);
		createCountry (R.string.dominican_republic, R.drawable.ic_country_dominican_republic);
		createCountry (R.string.ecuador, R.drawable.ic_country_ecuador);
		createCountry (R.string.egypt, R.drawable.ic_country_egypt);
		createCountry (R.string.el_salvador, R.drawable.ic_country_el_salvador);
		createCountry (R.string.equatorial_guinea, R.drawable.ic_country_equatorial_guinea);
		createCountry (R.string.eritrea, R.drawable.ic_country_eritrea);
		createCountry (R.string.estonia, R.drawable.ic_country_estonia);
		createCountry (R.string.ethiopia, R.drawable.ic_country_ethiopia);
		createCountry (R.string.falkland_islands, R.drawable.ic_country_falkland_islands);
		createCountry (R.string.faroe_islands, R.drawable.ic_country_faroe_islands);
		createCountry (R.string.fiji, R.drawable.ic_country_fiji);
		createCountry (R.string.finland, R.drawable.ic_country_finland);
		createCountry (R.string.france, R.drawable.ic_country_france);
		createCountry (R.string.french_guiana, R.drawable.ic_country_french_guiana);
		createCountry (R.string.french_polynesia, R.drawable.ic_country_french_polynesia);
		createCountry (R.string.french_southern_lands, R.drawable.ic_country_french_southern_lands);
		createCountry (R.string.gabon, R.drawable.ic_country_gabon);
		createCountry (R.string.gambia, R.drawable.ic_country_gambia);
		createCountry (R.string.georgia, R.drawable.ic_country_georgia);
		createCountry (R.string.germany, R.drawable.ic_country_germany);
		createCountry (R.string.ghana, R.drawable.ic_country_ghana);
		createCountry (R.string.gibraltar, R.drawable.ic_country_gibraltar);
		createCountry (R.string.greece, R.drawable.ic_country_greece);
		createCountry (R.string.greenland, R.drawable.ic_country_greenland);
		createCountry (R.string.grenada, R.drawable.ic_country_grenada);
		createCountry (R.string.guadeloupe, R.drawable.ic_country_guadeloupe);
		createCountry (R.string.guam, R.drawable.ic_country_guam);
		createCountry (R.string.guatemala, R.drawable.ic_country_guatemala);
		createCountry (R.string.guernsey, R.drawable.ic_country_guernsey);
		createCountry (R.string.guinea, R.drawable.ic_country_guinea);
		createCountry (R.string.guinea_bissau, R.drawable.ic_country_guinea_bissau);
		createCountry (R.string.guyana, R.drawable.ic_country_guyana);
		createCountry (R.string.haiti, R.drawable.ic_country_haiti);
		createCountry (R.string.heard_and_mcdonald_islands, R.drawable.ic_country_australia);
		createCountry (R.string.honduras, R.drawable.ic_country_honduras);
		createCountry (R.string.hong_kong, R.drawable.ic_country_hong_kong);
		createCountry (R.string.hungary, R.drawable.ic_country_hungary);
		createCountry (R.string.iceland, R.drawable.ic_country_iceland);
		createCountry (R.string.india, R.drawable.ic_country_india);
		createCountry (R.string.indonesia, R.drawable.ic_country_indonesia);
		createCountry (R.string.iran, R.drawable.ic_country_iran);
		createCountry (R.string.iraq, R.drawable.ic_country_iraq);
		createCountry (R.string.ireland, R.drawable.ic_country_ireland);
		createCountry (R.string.isle_of_man, R.drawable.ic_country_isle_of_man);
		createCountry (R.string.israel, R.drawable.ic_country_israel);
		createCountry (R.string.italy, R.drawable.ic_country_italy);
		createCountry (R.string.jamaica, R.drawable.ic_country_jamaica);
		createCountry (R.string.japan, R.drawable.ic_country_japan);
		createCountry (R.string.jersey, R.drawable.ic_country_jersey);
		createCountry (R.string.jordan, R.drawable.ic_country_jordan);
		createCountry (R.string.kazakhstan, R.drawable.ic_country_kazakhstan);
		createCountry (R.string.kenya, R.drawable.ic_country_kenya);
		createCountry (R.string.kiribati, R.drawable.ic_country_kiribati);
		createCountry (R.string.korea_north, R.drawable.ic_country_korea_north);
		createCountry (R.string.korea_south, R.drawable.ic_country_korea_south);
		createCountry (R.string.kuwait, R.drawable.ic_country_kuwait);
		createCountry (R.string.kyrgyzstan, R.drawable.ic_country_kyrgyzstan);
		createCountry (R.string.laos, R.drawable.ic_country_laos);
		createCountry (R.string.latvia, R.drawable.ic_country_latvia);
		createCountry (R.string.lebanon, R.drawable.ic_country_lebanon);
		createCountry (R.string.lesotho, R.drawable.ic_country_lesotho);
		createCountry (R.string.liberia, R.drawable.ic_country_liberia);
		createCountry (R.string.libya, R.drawable.ic_country_libya);
		createCountry (R.string.liechtenstein, R.drawable.ic_country_liechtenstein);
		createCountry (R.string.lithuania, R.drawable.ic_country_lithuania);
		createCountry (R.string.luxembourg, R.drawable.ic_country_luxembourg);
		createCountry (R.string.macau, R.drawable.ic_country_macau);
		createCountry (R.string.macedonia, R.drawable.ic_country_macedonia);
		createCountry (R.string.madagascar, R.drawable.ic_country_madagascar);
		createCountry (R.string.malawi, R.drawable.ic_country_malawi);
		createCountry (R.string.malaysia, R.drawable.ic_country_malaysia);
		createCountry (R.string.maldives, R.drawable.ic_country_maldives);
		createCountry (R.string.mali, R.drawable.ic_country_mali);
		createCountry (R.string.malta, R.drawable.ic_country_malta);
		createCountry (R.string.marshall_islands, R.drawable.ic_country_marshall_islands);
		createCountry (R.string.martinique, R.drawable.ic_country_martinique);
		createCountry (R.string.mauritania, R.drawable.ic_country_mauritania);
		createCountry (R.string.mauritius, R.drawable.ic_country_mauritius);
		createCountry (R.string.mayotte, R.drawable.ic_country_france);
		createCountry (R.string.mexico, R.drawable.ic_country_mexico);
		createCountry (R.string.micronesia, R.drawable.ic_country_micronesia);
		createCountry (R.string.moldova, R.drawable.ic_country_moldova);
		createCountry (R.string.monaco, R.drawable.ic_country_monaco);
		createCountry (R.string.mongolia, R.drawable.ic_country_mongolia);
		createCountry (R.string.montenegro, R.drawable.ic_country_montenegro);
		createCountry (R.string.montserrat, R.drawable.ic_country_montserrat);
		createCountry (R.string.morocco, R.drawable.ic_country_morocco);
		createCountry (R.string.mozambique, R.drawable.ic_country_mozambique);
		createCountry (R.string.myanmar, R.drawable.ic_country_myanmar);
		createCountry (R.string.namibia, R.drawable.ic_country_namibia);
		createCountry (R.string.nauru, R.drawable.ic_country_nauru);
		createCountry (R.string.nepal, R.drawable.ic_country_nepal);
		createCountry (R.string.netherlands, R.drawable.ic_country_netherlands);
		createCountry (R.string.new_caledonia, R.drawable.ic_country_new_caledonia);
		createCountry (R.string.new_zealand, R.drawable.ic_country_new_zealand);
		createCountry (R.string.nicaragua, R.drawable.ic_country_nicaragua);
		createCountry (R.string.niger, R.drawable.ic_country_niger);
		createCountry (R.string.nigeria, R.drawable.ic_country_nigeria);
		createCountry (R.string.niue, R.drawable.ic_country_niue);
		createCountry (R.string.norfolk_island, R.drawable.ic_country_norfolk_island);
		createCountry (R.string.northern_mariana_islands, R.drawable.ic_country_northern_mariana_islands);
		createCountry (R.string.norway, R.drawable.ic_country_norway);
		createCountry (R.string.oman, R.drawable.ic_country_oman);
		createCountry (R.string.pakistan, R.drawable.ic_country_pakistan);
		createCountry (R.string.palau, R.drawable.ic_country_palau);
		createCountry (R.string.palestine, R.drawable.ic_country_palestine);
		createCountry (R.string.panama, R.drawable.ic_country_panama);
		createCountry (R.string.papua_new_guinea, R.drawable.ic_country_papua_new_guinea);
		createCountry (R.string.paraguay, R.drawable.ic_country_paraguay);
		createCountry (R.string.peru, R.drawable.ic_country_peru);
		createCountry (R.string.philippines, R.drawable.ic_country_philippines);
		createCountry (R.string.pitcairn, R.drawable.ic_country_pitcairn);
		createCountry (R.string.poland, R.drawable.ic_country_poland);
		createCountry (R.string.portugal, R.drawable.ic_country_portugal);
		createCountry (R.string.puerto_rico, R.drawable.ic_country_puerto_rico);
		createCountry (R.string.qatar, R.drawable.ic_country_qatar);
		createCountry (R.string.reunion, R.drawable.ic_country_france);
		createCountry (R.string.romania, R.drawable.ic_country_romania);
		createCountry (R.string.russian_federation, R.drawable.ic_country_russian_federation);
		createCountry (R.string.rwanda, R.drawable.ic_country_rwanda);
		createCountry (R.string.saint_barthelemy, R.drawable.ic_country_france);
		createCountry (R.string.saint_helena, R.drawable.ic_country_saint_helena);
		createCountry (R.string.saint_kitts_and_nevis, R.drawable.ic_country_saint_kitts_and_nevis);
		createCountry (R.string.saint_lucia, R.drawable.ic_country_saint_lucia);
		createCountry (R.string.saint_martin_french_part, R.drawable.ic_country_france);
		createCountry (R.string.saint_pierre_and_miquelon, R.drawable.ic_country_saint_pierre_and_miquelon);
		createCountry (R.string.saint_vincent_and_the_grenadines, R.drawable.ic_country_saint_vincent_and_the_grenadines);
		createCountry (R.string.samoa, R.drawable.ic_country_samoa);
		createCountry (R.string.san_marino, R.drawable.ic_country_san_marino);
		createCountry (R.string.sao_tome_and_principe, R.drawable.ic_country_sao_tome_and_principe);
		createCountry (R.string.saudi_arabia, R.drawable.ic_country_saudi_arabia);
		createCountry (R.string.senegal, R.drawable.ic_country_senegal);
		createCountry (R.string.serbia, R.drawable.ic_country_serbia);
		createCountry (R.string.seychelles, R.drawable.ic_country_seychelles);
		createCountry (R.string.sierra_leone, R.drawable.ic_country_sierra_leone);
		createCountry (R.string.singapore, R.drawable.ic_country_singapore);
		createCountry (R.string.sint_maarten, R.drawable.ic_country_sint_maarten);
		createCountry (R.string.slovakia, R.drawable.ic_country_slovakia);
		createCountry (R.string.slovenia, R.drawable.ic_country_slovenia);
		createCountry (R.string.solomon_islands, R.drawable.ic_country_solomon_islands);
		createCountry (R.string.somalia, R.drawable.ic_country_somalia);
		createCountry (R.string.south_africa, R.drawable.ic_country_south_africa);
		createCountry (R.string.south_georgia_and_south_sandwich_islands, R.drawable.ic_country_south_georgia_and_south_sandwich_islands);
		createCountry (R.string.south_sudan, R.drawable.ic_country_south_sudan);
		createCountry (R.string.spain, R.drawable.ic_country_spain);
		createCountry (R.string.sri_lanka, R.drawable.ic_country_sri_lanka);
		createCountry (R.string.sudan, R.drawable.ic_country_sudan);
		createCountry (R.string.suriname, R.drawable.ic_country_suriname);
		createCountry (R.string.svalbard_and_jan_mayen_islands, R.drawable.ic_country_norway);
		createCountry (R.string.swaziland, R.drawable.ic_country_swaziland);
		createCountry (R.string.sweden, R.drawable.ic_country_sweden);
		createCountry (R.string.switzerland, R.drawable.ic_country_switzerland);
		createCountry (R.string.syria, R.drawable.ic_country_syria);
		createCountry (R.string.taiwan, R.drawable.ic_country_taiwan);
		createCountry (R.string.tajikistan, R.drawable.ic_country_tajikistan);
		createCountry (R.string.tanzania, R.drawable.ic_country_tanzania);
		createCountry (R.string.thailand, R.drawable.ic_country_thailand);
		createCountry (R.string.timor_leste, R.drawable.ic_country_timor_leste);
		createCountry (R.string.togo, R.drawable.ic_country_togo);
		createCountry (R.string.tokelau, R.drawable.ic_country_tokelau);
		createCountry (R.string.tonga, R.drawable.ic_country_tonga);
		createCountry (R.string.trinidad_and_tobago, R.drawable.ic_country_trinidad_and_tobago);
		createCountry (R.string.tunisia, R.drawable.ic_country_tunisia);
		createCountry (R.string.turkey, R.drawable.ic_country_turkey);
		createCountry (R.string.turkmenistan, R.drawable.ic_country_turkmenistan);
		createCountry (R.string.turks_and_caicos_islands, R.drawable.ic_country_turks_and_caicos_islands);
		createCountry (R.string.tuvalu, R.drawable.ic_country_tuvalu);
		createCountry (R.string.uganda, R.drawable.ic_country_uganda);
		createCountry (R.string.ukraine, R.drawable.ic_country_ukraine);
		createCountry (R.string.united_arab_emirates, R.drawable.ic_country_united_arab_emirates);
		createCountry (R.string.united_kingdom, R.drawable.ic_country_united_kingdom);
		createCountry (R.string.united_states_of_america, R.drawable.ic_country_united_states_of_america);
		createCountry (R.string.uruguay, R.drawable.ic_country_uruguay);
		createCountry (R.string.uzbekistan, R.drawable.ic_country_uzbekistan);
		createCountry (R.string.vanuatu, R.drawable.ic_country_vanuatu);
		createCountry (R.string.vatican_city, R.drawable.ic_country_vatican_city);
		createCountry (R.string.venezuela, R.drawable.ic_country_venezuela);
		createCountry (R.string.vietnam, R.drawable.ic_country_vietnam);
		createCountry (R.string.virgin_islands_british, R.drawable.ic_country_virgin_islands_british);
		createCountry (R.string.virgin_islands_us, R.drawable.ic_country_virgin_islands_us);
		createCountry (R.string.wallis_and_futuna_islands, R.drawable.ic_country_wallis_and_futuna_islands);
		createCountry (R.string.western_sahara, R.drawable.ic_country_western_sahara);
		createCountry (R.string.yemen, R.drawable.ic_country_yemen);
		createCountry (R.string.zambia, R.drawable.ic_country_zambia);
		createCountry (R.string.zimbabwe, R.drawable.ic_country_zimbabwe);
	}

	private void createStamp (int id, int name, int description, int country, int continent, double lat, double lon, int radius, int weight, String icon, int features) {
		Stamp s = new Stamp (id, name, description, country, continent, features, lat, lon, radius, weight, icon);

		mStamps.add (s);

		for (StampGroup group : mContinents) {
			if (group.getName() == continent) {
				group.addStamp(s);
				break;
			}
		}

		for (StampGroup group : mCountries) {
			if (group.getName() == country) {
				group.addStamp(s);
				break;
			}
		}

		for (StampGroup group : mFeatures) {
			if (group.isFeature(features))
				group.addStamp(s);
		}
	}

	private void createStamps () {
		mStamps = new ArrayList<Stamp> (1131);

		createStamp(1, R.string.kabul, R.string.kabul_desc, R.string.afghanistan, R.string.asia, 34.533, 69.166, 5000, 2, "afg_kabul", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(2, R.string.bamiyan, R.string.bamiyan_desc, R.string.afghanistan, R.string.asia, 34.824,67.826, 5000, 1, "afg_bamiyan", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(3, R.string.jam, R.string.jam_desc, R.string.afghanistan, R.string.asia, 34.397,64.516, 200, 1, "afg_jam", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(4, R.string.balkh, R.string.balkh_desc, R.string.afghanistan, R.string.asia, 36.758,66.898, 1000, 1, "afg_balkh", Stamp.F_CITY | Stamp.FEATURE_WHS);
		createStamp(5, R.string.panjshir, R.string.panjshir_desc, R.string.afghanistan, R.string.asia, 35.976,70.413, 30000, 1, "afg_panjshir", Stamp.F_MNT);

		createStamp(6, R.string.mariehamn, R.string.mariehamn_desc, R.string.aland, R.string.europe, 60.105,19.937, 2000, 1, "ala_mariehamn", Stamp.F_CAP);

		createStamp(7, R.string.tirana, R.string.tirana_desc, R.string.albania, R.string.europe, 41.329,19.818, 2500, 2, "alb_tirana", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(8, R.string.berat, R.string.berat_desc, R.string.albania, R.string.europe, 40.709,19.944, 2000, 1, "alb_berat", Stamp.F_CITY | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(9, R.string.butrint, R.string.butrint_desc, R.string.albania, R.string.europe, 39.746,20.020, 1000, 1, "alb_butrint", Stamp.F_C_WHS);
		createStamp(10, R.string.albanian_riviera, R.string.albanian_riviera_desc, R.string.albania, R.string.europe, 40.104,19.746, 10000, 1, "alb_riviera", Stamp.FEATURE_OUTDOOR);

		createStamp(11, R.string.algiers, R.string.algiers_desc, R.string.algeria, R.string.africa, 36.759,3.056, 5000, 2, "alg_algiers", Stamp.F_CAP | Stamp.FEATURE_WHS);
		createStamp(12, R.string.djemila, R.string.djemila_desc, R.string.algeria, R.string.africa, 36.314,5.736, 1000, 1, "alg_djemila", Stamp.F_C_WHS);
		createStamp(13, R.string.ghardaia, R.string.ghardaia_desc, R.string.algeria, R.string.africa, 32.489,3.679, 5000, 2, "alg_ghardaia", Stamp.F_CITY | Stamp.FEATURE_WHS);
		createStamp(14, R.string.timgad, R.string.timgad_desc, R.string.algeria, R.string.africa, 35.490,6.468, 1000, 1, "alg_timgad", Stamp.F_C_WHS);
		createStamp(15, R.string.eloued, R.string.eloued_desc, R.string.algeria, R.string.africa, 33.367,6.852, 10000, 1, "alg_eloued", Stamp.FEATURE_OUTDOOR);

		createStamp(16, R.string.pago_pago, R.string.pago_pago_desc, R.string.american_samoa, R.string.australia_continent, -14.273,-170.684, 2000, 1, "ame_pago", Stamp.F_CAP);

		createStamp(17, R.string.andorra_la_vella, R.string.andorra_la_vella_desc, R.string.andorra, R.string.europe, 42.507,1.522, 1000, 1, "and_lavella", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(18, R.string.luanda, R.string.luanda_desc, R.string.angola, R.string.africa, -8.822,13.229, 4000, 2, "ang_luanda", Stamp.F_CAP);
		createStamp(19, R.string.kalandula, R.string.kalandula_desc, R.string.angola, R.string.africa, -9.074,16.001, 1000, 1, "ang_kalandula", Stamp.FEATURE_OUTDOOR);
		createStamp(20, R.string.iona, R.string.iona_desc, R.string.angola, R.string.africa, -16.668,12.335, 30000, 1, "ang_iona", Stamp.FEATURE_OUTDOOR);

		createStamp(21, R.string.the_valley, R.string.the_valley_desc, R.string.anguilla, R.string.central_america, 18.218,-63.057, 2000, 1, "anu_valley", Stamp.F_CAP);

		createStamp(22, R.string.st_johns, R.string.st_johns_desc, R.string.antigua_and_barbuda, R.string.central_america, 17.121,-61.844, 1500, 1, "ant_st_johns", Stamp.F_CAP);

		createStamp(23, R.string.buenos_aires, R.string.buenos_aires_desc, R.string.argentina, R.string.south_america, -34.598,-58.390, 10000, 3, "arg_buenos_aires", Stamp.F_CAP);
		createStamp(24, R.string.cordoba, R.string.cordoba_desc, R.string.argentina, R.string.south_america, -31.409,-64.180, 5000, 1, "arg_cordoba", Stamp.F_CITY | Stamp.FEATURE_WHS);
		createStamp(25, R.string.rosario, R.string.rosario_desc, R.string.argentina, R.string.south_america, -32.959,-60.661, 6000, 1, "arg_rosario", Stamp.F_CITY);
		createStamp(26, R.string.los_glaciares, R.string.los_glaciares_desc, R.string.argentina, R.string.south_america, -50.311,-73.232, 40000, 2, "arg_glaciares", Stamp.FEATURE_WHS | Stamp.F_MNT);
		createStamp(27, R.string.iguazu, R.string.iguazu_desc, R.string.argentina, R.string.south_america, -25.695,-54.437, 1000, 1, "arg_iguazu", Stamp.F_N_WHS);
		createStamp(28, R.string.nahuel_huapi, R.string.nahuel_huapi_desc, R.string.argentina, R.string.south_america, -40.987,-71.500, 25000, 1, "arg_nahuel", Stamp.F_MNT);
		createStamp(196, R.string.laplata, R.string.laplata_desc, R.string.argentina, R.string.south_america, -34.921,-57.954, 5000, 1, "arg_laplata", Stamp.F_CITY);
		createStamp(197, R.string.cardones, R.string.cardones_desc, R.string.argentina, R.string.south_america, -25.125,-66.182, 10000, 1, "arg_cardones", Stamp.F_MNT);
		createStamp(198, R.string.elpalmar, R.string.elpalmar_desc, R.string.argentina, R.string.south_america, -31.853, -58.323, 3000, 1, "arg_elpalmar", Stamp.FEATURE_OUTDOOR);
		createStamp(199, R.string.leoncito, R.string.leoncito_desc, R.string.argentina, R.string.south_america, -31.800, -69.367, 10000, 1, "arg_leoncito", Stamp.F_MNT);

		createStamp(29, R.string.yerevan, R.string.yerevan_desc, R.string.armenia, R.string.asia, 40.183,44.515, 4000, 2, "arm_yerevan", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(30, R.string.dilijan, R.string.dilijan_desc, R.string.armenia, R.string.asia, 40.749,44.862, 20000, 1, "arm_dilijan", Stamp.F_MNT);

		createStamp(31, R.string.oranjestad, R.string.oranjestad_desc, R.string.aruba, R.string.central_america, 12.520,-70.029, 3000, 1, "aru_oranjestad", Stamp.F_CAP);

		createStamp(32, R.string.canberra, R.string.canberra_desc, R.string.australia, R.string.australia_continent, -35.282,149.129, 5000, 2, "aus_canberra", Stamp.F_CAP);
		createStamp(33, R.string.adelaide, R.string.adelaide_desc, R.string.australia, R.string.australia_continent, -34.926,138.601, 10000, 1, "aus_adelaide", Stamp.F_CITY);
		createStamp(34, R.string.brisbane, R.string.brisbane_desc, R.string.australia, R.string.australia_continent, -27.467,153.023, 15000, 1, "aus_brisbane", Stamp.F_CITY);
		createStamp(35, R.string.perth, R.string.perth_desc, R.string.australia, R.string.australia_continent, -31.953,115.859, 15000, 1, "aus_perth", Stamp.F_CITY);
		createStamp(36, R.string.melbourne, R.string.melbourne_desc, R.string.australia, R.string.australia_continent, -37.814,144.964, 15000, 2, "aus_melbourne", Stamp.F_CITY | Stamp.FEATURE_WHS);
		createStamp(37, R.string.sydney, R.string.sydney_desc, R.string.australia, R.string.australia_continent, -33.868,151.209, 8000, 3, "aus_sydney", Stamp.F_CITY | Stamp.FEATURE_WHS);
		createStamp(38, R.string.fraser_island, R.string.fraser_island_desc, R.string.australia, R.string.australia_continent, -25.270,153.159, 30000, 1, "aus_fraser", Stamp.F_N_WHS);
		createStamp(39, R.string.lamington, R.string.lamington_desc, R.string.australia, R.string.australia_continent, -28.217,153.150, 6000, 1, "aus_lamington", Stamp.F_N_WHS);
		createStamp(40, R.string.barrier_reef, R.string.barrier_reef_desc, R.string.australia, R.string.australia_continent, -16.815,146.249, 55000, 2, "aus_reef", Stamp.F_N_WHS);
		createStamp(41, R.string.howe_islands, R.string.howe_islands_desc, R.string.australia, R.string.australia_continent, -31.555,159.082, 5000, 1, "aus_howe", Stamp.F_N_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(42, R.string.macquarie_islands, R.string.macquarie_islands_desc, R.string.australia, R.string.antarctica, -54.619,158.856, 8000, 1, "aus_macquarie", Stamp.F_N_WHS);
		createStamp(43, R.string.heard_islands, R.string.heard_islands_desc, R.string.heard_and_mcdonald_islands, R.string.antarctica, -53.100,73.527, 10000, 1, "hea_heard", Stamp.F_N_WHS);
		createStamp(44, R.string.ningaloo, R.string.ningaloo_desc, R.string.australia, R.string.australia_continent, -22.707,113.680, 15000, 1, "aus_ningaloo", Stamp.F_N_WHS);
		createStamp(45, R.string.shark_bay, R.string.shark_bay_desc, R.string.australia, R.string.australia_continent, -25.916,114.046, 30000, 1, "aus_shark", Stamp.F_N_WHS);
		createStamp(46, R.string.blue_mountains, R.string.blue_mountains_desc, R.string.australia, R.string.australia_continent, -33.617,150.455, 15000, 1, "aus_blue_mnt", Stamp.F_N_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(47, R.string.kakadu, R.string.kakadu_desc, R.string.australia, R.string.australia_continent, -13.092,132.394, 10000, 1, "aus_kakadu", Stamp.F_N_WHS);
		createStamp(48, R.string.uluru, R.string.uluru_desc, R.string.australia, R.string.australia_continent, -25.360,131.017, 15000, 2, "aus_uluru", Stamp.F_N_WHS);
		createStamp(49, R.string.tasmania_southwest, R.string.tasmania_southwest_desc, R.string.australia, R.string.australia_continent, -42.935,146.133, 15000, 1, "aus_tas_sw", Stamp.F_N_WHS | Stamp.FEATURE_MOUNTAIN);

		createStamp(50, R.string.vienna, R.string.vienna_desc, R.string.austria, R.string.europe, 48.208,16.374, 5000, 3, "aut_vienna", Stamp.F_CAP | Stamp.FEATURE_WHS);
		createStamp(51, R.string.salzburg, R.string.salzburg_desc, R.string.austria, R.string.europe, 47.811,13.053, 3000, 1, "aut_salzburg", Stamp.F_C_WHS | Stamp.FEATURE_CITY);
		createStamp(52, R.string.graz, R.string.graz_desc, R.string.austria, R.string.europe, 47.071,15.439, 2000, 1, "aut_graz", Stamp.F_C_WHS | Stamp.FEATURE_CITY);
		createStamp(53, R.string.wachau, R.string.wachau_desc, R.string.austria, R.string.europe, 48.371,15.452, 10000, 1, "aut_wachau", Stamp.F_N_WHS);
		createStamp(54, R.string.hohe_tauern, R.string.hohe_tauern_desc, R.string.austria, R.string.europe, 47.108,12.584, 40000, 2, "aut_hohe_tauern", Stamp.F_MNT);
		createStamp(55, R.string.kalkalpen, R.string.kalkalpen_desc, R.string.austria, R.string.europe, 47.782,14.384, 15000, 1, "aut_kalkaplen", Stamp.F_MNT);

		createStamp(56, R.string.baku, R.string.baku_desc, R.string.azerbaijan, R.string.asia, 40.392,49.845, 8000, 2, "aze_baku", Stamp.F_CAP | Stamp.FEATURE_WHS);
		createStamp(57, R.string.ganja, R.string.ganja_desc, R.string.azerbaijan, R.string.asia, 40.681,46.361, 5000, 1, "aze_ganja", Stamp.F_CITY);
		createStamp(58, R.string.hirkan, R.string.hirkan_desc, R.string.azerbaijan, R.string.asia, 38.512,48.705, 15000, 1, "aze_hirkan", Stamp.F_MNT);

		createStamp(59, R.string.nassau, R.string.nassau_desc, R.string.bahamas, R.string.central_america, 25.060,-77.345, 3000, 1, "bah_nassau", Stamp.F_CAP);
		createStamp(60, R.string.lucayan, R.string.lucayan_desc, R.string.bahamas, R.string.central_america, 26.619,-78.412, 20000, 1, "bah_lucayan", Stamp.FEATURE_OUTDOOR);

		createStamp(61, R.string.manama, R.string.manama_desc, R.string.bahrain, R.string.asia, 26.217,50.583, 3000, 1, "baa_manama", Stamp.F_CAP);

		createStamp(62, R.string.dhaka, R.string.dhaka_desc, R.string.bangladesh, R.string.asia, 23.727,90.397, 8000, 2, "ban_dhaka", Stamp.F_CAP);
		createStamp(63, R.string.bagerhat, R.string.bagerhat_desc, R.string.bangladesh, R.string.asia, 22.668,89.749, 3000, 1, "ban_bagerhat", Stamp.F_C_WHS);
		createStamp(64, R.string.sundarbans, R.string.sundarbans_desc, R.string.bangladesh, R.string.asia, 22.058,89.266, 35000, 1, "ban_sundarbans", Stamp.F_N_WHS);
		createStamp(65, R.string.nafakhum, R.string.nafakhum_desc, R.string.bangladesh, R.string.asia, 21.720,92.533, 1000, 1, "ban_nafakhum", Stamp.FEATURE_OUTDOOR);

		createStamp(66, R.string.bridgetown, R.string.bridgetown_desc, R.string.barbados, R.string.central_america, 13.099,-59.613, 4000, 1, "bar_bridgetown", Stamp.F_CAP | Stamp.FEATURE_WHS);

		createStamp(67, R.string.minsk, R.string.minsk_desc, R.string.belarus, R.string.europe, 53.901,27.559, 3000, 2, "bel_minsk", Stamp.F_CAP);
		createStamp(68, R.string.brest, R.string.brest_desc, R.string.belarus, R.string.europe, 52.106,23.667, 4000, 1, "bel_brest", Stamp.F_CITY);
		createStamp(69, R.string.belavez, R.string.belavez_desc, R.string.belarus, R.string.europe, 52.575,23.956, 10000, 1, "bel_belavez", Stamp.F_N_WHS);
		createStamp(70, R.string.braslau, R.string.braslau_desc, R.string.belarus, R.string.europe, 55.667,27.073, 15000, 1, "bel_braslau", Stamp.FEATURE_OUTDOOR);

		createStamp(71, R.string.brussels, R.string.brussels_desc, R.string.belgium, R.string.europe, 50.847,4.348, 8000, 2, "beg_brussels", Stamp.F_CAP | Stamp.FEATURE_WHS);
		createStamp(72, R.string.antwerp, R.string.antwerp_desc, R.string.belgium, R.string.europe, 51.220,4.408, 6000, 1, "beg_antwerp", Stamp.F_CITY);
		createStamp(73, R.string.bruges, R.string.bruges_desc, R.string.belgium, R.string.europe, 51.209,3.225, 4000, 1, "beg_bruges", Stamp.F_CITY | Stamp.FEATURE_WHS);

		createStamp(74, R.string.belmopan, R.string.belmopan_desc, R.string.belize, R.string.central_america, 17.252,-88.767, 3000, 1, "bei_belmopan", Stamp.F_CAP);
		createStamp(75, R.string.xunantunich, R.string.xunantunich_desc, R.string.belize, R.string.central_america, 17.090,-89.142, 500, 1, "bei_xunantunich", Stamp.FEATURE_SIGHTS);
		createStamp(76, R.string.ambergris, R.string.ambergris_desc, R.string.belize, R.string.central_america, 18.004,-87.941, 6000, 1, "bei_ambergris", Stamp.F_N_WHS);

		createStamp(77, R.string.portonovo, R.string.portonovo_desc, R.string.benin, R.string.africa, 6.470,2.626, 1000, 1, "ben_portonovo", Stamp.F_CAP);
		createStamp(78, R.string.abomey, R.string.abomey_desc, R.string.benin, R.string.africa, 7.184,1.992, 2500, 1, "ben_abomey", Stamp.F_C_WHS);
		createStamp(79, R.string.pendjari, R.string.pendjari_desc, R.string.benin, R.string.africa, 11.240,1.587, 50000, 1, "ben_pendjari", Stamp.FEATURE_OUTDOOR);

		createStamp(80, R.string.hamilton, R.string.hamilton_desc, R.string.bermuda, R.string.north_america, 32.297,-64.781, 4000, 1, "ber_hamilton", Stamp.F_CAP);

		createStamp(81, R.string.thimphu, R.string.thimphu_desc, R.string.bhutan, R.string.asia, 27.453,89.654, 4000, 1, "bhu_thimphu", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(82, R.string.jigmedorji, R.string.jigmedorji_desc, R.string.bhutan, R.string.asia, 27.866,89.740, 15000, 1, "bhu_jigmedorji", Stamp.F_MNT);

		createStamp(83, R.string.sucre, R.string.sucre_desc, R.string.bolivia, R.string.south_america, -19.042,-65.256, 2000, 2, "bol_sucre", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN | Stamp.FEATURE_WHS);
		createStamp(84, R.string.lapaz, R.string.lapaz_desc, R.string.bolivia, R.string.south_america, -16.499,-68.146, 8000, 1, "bol_lapaz", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(85, R.string.santacruz, R.string.santacruz_desc, R.string.bolivia, R.string.south_america, -17.784,-63.182, 8000, 1, "bol_santacruz", Stamp.F_CITY);
		createStamp(86, R.string.potosi, R.string.potosi_desc, R.string.bolivia, R.string.south_america, -19.581,-65.758, 3000, 1, "bol_potosi", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(87, R.string.samaipata, R.string.samaipata_desc, R.string.bolivia, R.string.south_america, -18.167,-63.817, 1000, 1, "bol_samaipata", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(88, R.string.tiwanaku, R.string.tiwanaku_desc, R.string.bolivia, R.string.south_america, -16.553,-68.677, 2000, 1, "bol_tiwanaku", Stamp.F_C_WHS);
		createStamp(89, R.string.noelkempff, R.string.noelkempff_desc, R.string.bolivia, R.string.south_america, -14.356,-60.768, 35000, 1, "bol_noelkempff", Stamp.F_N_WHS);
		createStamp(90, R.string.sajama, R.string.sajama_desc, R.string.bolivia, R.string.south_america, -18.128,-68.954, 15000, 1, "bol_sajama", Stamp.F_N_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(92, R.string.titicaca, R.string.titicaca_desc, R.string.bolivia, R.string.south_america, -16.013,-69.143, 40000, 2, "bol_titicaca", Stamp.F_N_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(93, R.string.amboro, R.string.amboro_desc, R.string.bolivia, R.string.south_america, -17.733,-64.034, 25000, 1, "bol_amboro", Stamp.F_MNT);
		createStamp(94, R.string.madidi, R.string.madidi_desc, R.string.bolivia, R.string.south_america, -14.190,-68.333, 45000, 1, "bol_madidi", Stamp.F_MNT);
		createStamp(95, R.string.uyuni, R.string.uyuni_desc, R.string.bolivia, R.string.south_america, -20.177,-67.600, 20000, 1, "bol_uyuni", Stamp.FEATURE_OUTDOOR);
		createStamp(91, R.string.sorata, R.string.sorata_desc, R.string.bolivia, R.string.south_america, -15.772,-68.648, 10000, 1, "bol_sorata", Stamp.F_MNT);

		createStamp(96, R.string.kralendijk, R.string.kralendijk_desc, R.string.bonaire_sint_eustatius_and_saba, R.string.central_america, 12.151,-68.277, 2000, 1, "bon_kralendijk", Stamp.F_CAP);

		createStamp(97, R.string.sarajevo, R.string.sarajevo_desc, R.string.bosnia_and_herzegovina, R.string.europe, 43.856,18.405, 5000, 2, "bos_sarajevo", Stamp.F_CAP | Stamp.FEATURE_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(98, R.string.mostar, R.string.mostar_desc, R.string.bosnia_and_herzegovina, R.string.europe, 43.344,17.810, 3000, 1, "bos_mostar", Stamp.F_C_WHS);
		createStamp(99, R.string.sutjeska, R.string.sutjeska_desc, R.string.bosnia_and_herzegovina, R.string.europe, 43.300,18.750, 5000, 1, "bos_sutjeska", Stamp.F_MNT);
		createStamp(100, R.string.una, R.string.una_desc, R.string.bosnia_and_herzegovina, R.string.europe, 44.555,16.108, 5000, 1, "bos_una", Stamp.F_MNT);

		createStamp(101, R.string.gaborone, R.string.gaborone_desc, R.string.botswana, R.string.africa, -24.656,25.907, 5000, 2, "bot_gaborone", Stamp.F_CAP);
		createStamp(102, R.string.ghanzi, R.string.ghanzi_desc, R.string.botswana, R.string.africa, -21.700,21.650, 2000, 1, "bot_ghanzi", Stamp.F_CITY);
		createStamp(103, R.string.okavango, R.string.okavango_desc, R.string.botswana, R.string.africa, -19.283,22.862, 60000, 1, "bot_okavango", Stamp.F_N_WHS);
		createStamp(104, R.string.kalahari, R.string.kalahari_desc, R.string.botswana, R.string.africa, -22.116,23.790, 60000, 1, "bot_kalahari", Stamp.F_N_WHS);
		createStamp(105, R.string.chobe, R.string.chobe_desc, R.string.botswana, R.string.africa, -18.697,24.510, 30000, 2, "bot_chobe", Stamp.F_N_WHS);
		createStamp(106, R.string.kgalagadi, R.string.kgalagadi_desc, R.string.botswana, R.string.africa, -25.160,21.016, 60000, 1, "bot_kgalagadi", Stamp.FEATURE_OUTDOOR);
		createStamp(107, R.string.makgadikgadi, R.string.makgadikgadi_desc, R.string.botswana, R.string.africa, -20.441,24.777, 20000, 1, "bot_makgadikgadi", Stamp.F_N_WHS);

		createStamp(108, R.string.bouvet_island, R.string.bouvet_desc, R.string.bouvet_island, R.string.antarctica, -54.432,3.409, 5000, 1, "bou_island", Stamp.F_MNT);

		createStamp(109, R.string.brasilia, R.string.brasilia_desc, R.string.brazil, R.string.south_america, -15.792,-47.890, 8000, 2, "bra_brasilia", Stamp.F_C_WHS | Stamp.F_CAP);
		createStamp(110, R.string.manaus, R.string.manaus_desc, R.string.brazil, R.string.south_america, -3.078,-60.011, 8000, 1, "bra_manaus", Stamp.F_CITY);
		createStamp(111, R.string.porto_alegre, R.string.porto_alegre_desc, R.string.brazil, R.string.south_america, -30.034,-51.217, 5000, 1, "bra_porto_alegre", Stamp.F_CITY);
		createStamp(112, R.string.recife, R.string.recife_desc, R.string.brazil, R.string.south_america, -8.063,-34.895, 6000, 1, "bra_recife", Stamp.F_CITY);
		createStamp(113, R.string.rio_de_janeiro, R.string.rio_de_janeiro_desc, R.string.brazil, R.string.south_america, -22.895,-43.279, 15000, 3, "bra_rio", Stamp.F_C_WHS | Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(114, R.string.salvador, R.string.salvador_desc, R.string.brazil, R.string.south_america, -12.964,-38.489, 8000, 1, "bra_salvador", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(115, R.string.sao_paulo, R.string.sao_paulo_desc, R.string.brazil, R.string.south_america, -23.549,-46.633, 15000, 3, "bra_sao_paulo", Stamp.F_CITY);
		createStamp(116, R.string.sao_luis, R.string.sao_luis_desc, R.string.brazil, R.string.south_america, -2.539,-44.283, 4000, 1, "bra_sao_luis", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(117, R.string.goias, R.string.goias_desc, R.string.brazil, R.string.south_america, -15.938,-50.142, 2000, 1, "bra_goias", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(118, R.string.olinda, R.string.olinda_desc, R.string.brazil, R.string.south_america, -7.991,-34.842, 3000, 1, "bra_olinda", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(119, R.string.diamantina, R.string.diamantina_desc, R.string.brazil, R.string.south_america, -18.241,-43.603, 2000, 1, "bra_diamantina", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(120, R.string.chapada_diamantina, R.string.chapada_diamantina_desc, R.string.brazil, R.string.south_america, -12.800,-41.399, 10000, 1, "bra_chapada_diamantina", Stamp.FEATURE_OUTDOOR);
		createStamp(121, R.string.chapada_dos_veadeiros, R.string.chapada_dos_veadeiros_desc, R.string.brazil, R.string.south_america, -14.049,-47.635, 8000, 1, "bra_veadeiros", Stamp.F_N_WHS);
		createStamp(122, R.string.noronha, R.string.noronha_desc, R.string.brazil, R.string.south_america, -3.857,-32.430, 6000, 1, "bra_noronha", Stamp.F_N_WHS);
		createStamp(123, R.string.aguas, R.string.aguas_desc, R.string.brazil, R.string.south_america, -17.118,-56.689, 10000, 1, "bra_aguas", Stamp.F_N_WHS);
		createStamp(124, R.string.tumucumaque, R.string.tumucumaque_desc, R.string.brazil, R.string.south_america, 1.703,-53.015, 75000, 1, "bra_tumucumaque", Stamp.FEATURE_OUTDOOR);
		createStamp(125, R.string.amazonia, R.string.amazonia_desc, R.string.brazil, R.string.south_america, -4.412,-56.734, 50000, 2, "bra_amazonia", Stamp.F_N_WHS);
		createStamp(126, R.string.chapada_das_mesas, R.string.chapada_das_mesas_desc, R.string.brazil, R.string.south_america, -7.188,-47.167, 30000, 1, "bra_mesas", Stamp.F_N_WHS);
		createStamp(127, R.string.maranhenses, R.string.maranhenses_desc, R.string.brazil, R.string.south_america, -2.420,-43.110, 15000, 1, "bra_maranhenses", Stamp.FEATURE_OUTDOOR);

		createStamp(128, R.string.diego_garcia, R.string.diego_garcia_desc, R.string.british_indian_ocean_territory, R.string.asia, -7.325,72.428, 10000, 1, "bri_diego", Stamp.FEATURE_OUTDOOR);

		createStamp(129, R.string.bandar, R.string.bandar_desc, R.string.brunei_darussalam, R.string.asia, 4.890,114.942, 3000, 1, "bru_bandar", Stamp.F_CAP);

		createStamp(130, R.string.sofia, R.string.sofia_desc, R.string.bulgaria, R.string.europe, 42.698,23.322, 6000, 2, "bul_sofia", Stamp.F_CAP);
		createStamp(131, R.string.burgas, R.string.burgas_desc, R.string.bulgaria, R.string.europe, 42.506,27.467, 3000, 1, "bul_burgas", Stamp.F_CITY);
		createStamp(132, R.string.plovdiv, R.string.plovdiv_desc, R.string.bulgaria, R.string.europe, 42.139,24.746, 3000, 1, "bul_plovdiv", Stamp.F_C_WHS);
		createStamp(133, R.string.pirin, R.string.pirin_desc, R.string.bulgaria, R.string.europe, 41.753,23.433, 7000, 1, "bul_pirin", Stamp.F_N_WHS);
		createStamp(134, R.string.srebarna, R.string.srebarna_desc, R.string.bulgaria, R.string.europe, 44.111,27.073, 2000, 1, "bul_srebarna", Stamp.F_N_WHS);

		createStamp(135, R.string.ouagadougou, R.string.ouagadougou_desc, R.string.burkina_faso, R.string.africa, 12.368,-1.529, 6000, 2, "bur_ouagadougou", Stamp.F_CAP);
		createStamp(136, R.string.loropeni, R.string.loropeni_desc, R.string.burkina_faso, R.string.africa, 10.250,-3.583, 1000, 1, "bur_loropeni", Stamp.F_C_WHS);
		createStamp(137, R.string.arli, R.string.arli_desc, R.string.burkina_faso, R.string.africa, 11.543,1.048, 20000, 1, "bur_arli", Stamp.FEATURE_OUTDOOR);
		createStamp(138, R.string.mare, R.string.mare_desc, R.string.burkina_faso, R.string.africa, 11.564,-4.163, 1000, 1, "bur_mare", Stamp.FEATURE_OUTDOOR);

		createStamp(139, R.string.bujumbura, R.string.bujumbura_desc, R.string.burundi, R.string.africa, -3.377,29.360, 2000, 1, "buu_bujumbura", Stamp.F_CAP);
		createStamp(140, R.string.kibira, R.string.kibira_desc, R.string.burundi, R.string.africa, -3.000,29.512, 5000, 1, "buu_kibira", Stamp.FEATURE_OUTDOOR);

		createStamp(141, R.string.phnompenh, R.string.phnompenh_desc, R.string.cambodia, R.string.asia, 11.567,104.919, 4000, 2, "cam_phnompenh", Stamp.F_CAP);
		createStamp(142, R.string.angkor, R.string.angkor_desc, R.string.cambodia, R.string.asia, 13.411,103.868, 4000, 2, "cam_angkor", Stamp.F_C_WHS);
		createStamp(143, R.string.preahvihear, R.string.preahvihear_desc, R.string.cambodia, R.string.asia, 14.391,104.680, 500, 1, "cam_preahvihear", Stamp.F_C_WHS);
		createStamp(144, R.string.botum_sakor, R.string.botum_sakor_desc, R.string.cambodia, R.string.asia, 11.097,103.252, 10000, 1, "cam_botum_sakor", Stamp.FEATURE_OUTDOOR);
		createStamp(145, R.string.kirirom, R.string.kirirom_desc, R.string.cambodia, R.string.asia, 11.322,104.038, 8000, 1, "cam_kirirom", Stamp.FEATURE_OUTDOOR);
		createStamp(146, R.string.virachey, R.string.virachey_desc, R.string.cambodia, R.string.asia, 14.204,106.803, 12000, 1, "cam_virachey", Stamp.FEATURE_OUTDOOR);

		createStamp(147, R.string.yaounde, R.string.yaounde_desc, R.string.cameroon, R.string.africa, 3.867,11.517, 4000, 1, "cae_yaounde", Stamp.F_CAP);
		createStamp(148, R.string.dja, R.string.dja_desc, R.string.cameroon, R.string.africa, 3.146,12.998, 25000, 1, "cae_dja", Stamp.F_N_WHS);
		createStamp(149, R.string.benoue, R.string.benoue_desc, R.string.cameroon, R.string.africa, 8.338,13.888, 10000, 1, "cae_benoue", Stamp.FEATURE_OUTDOOR);
		createStamp(150, R.string.korup, R.string.korup_desc, R.string.cameroon, R.string.africa, 5.355,8.996, 15000, 1, "cae_korup", Stamp.FEATURE_OUTDOOR);

		createStamp(151, R.string.ottawa, R.string.ottawa_desc, R.string.canada, R.string.north_america, 45.421,-75.697, 4000, 2, "can_ottawa", Stamp.F_CAP | Stamp.FEATURE_WHS);
		createStamp(152, R.string.toronto, R.string.toronto_desc, R.string.canada, R.string.north_america, 43.652,-79.382, 5000, 2, "can_toronto", Stamp.F_CITY);
		createStamp(153, R.string.montreal, R.string.montreal_desc, R.string.canada, R.string.north_america, 45.506,-73.556, 9000, 3, "can_montreal", Stamp.F_CITY);
		createStamp(154, R.string.vancouver, R.string.vancouver_desc, R.string.canada, R.string.north_america, 49.266,-123.116, 10000, 1, "can_vancouver", Stamp.F_CITY);
		createStamp(155, R.string.calgary, R.string.calgary_desc, R.string.canada, R.string.north_america, 51.045,-114.063, 5000, 1, "can_calgary", Stamp.F_CITY);
		createStamp(156, R.string.edmonton, R.string.edmonton_desc, R.string.canada, R.string.north_america, 53.541,-113.509, 5000, 1, "can_edmonton", Stamp.F_CITY);
		createStamp(157, R.string.halifax, R.string.halifax_desc, R.string.canada, R.string.north_america, 44.647,-63.585, 5000, 1, "can_halifax", Stamp.F_CITY);
		createStamp(158, R.string.winnipeg, R.string.winnipeg_desc, R.string.canada, R.string.north_america, 49.895,-97.138, 5000, 1, "can_winnipeg", Stamp.F_CITY);
		createStamp(159, R.string.lanse, R.string.lanse_desc, R.string.canada, R.string.north_america, 51.595,-55.533, 500, 1, "can_lanse", Stamp.F_C_WHS);
		createStamp(160, R.string.lunenburg, R.string.lunenburg_desc, R.string.canada, R.string.north_america, 44.377,-64.318, 1500, 1, "can_lunenburg", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(161, R.string.algonquin, R.string.algonquin_desc, R.string.canada, R.string.north_america, 45.837,-78.379, 25000, 1, "can_algonquin", Stamp.FEATURE_OUTDOOR);
		createStamp(162, R.string.banff, R.string.banff_desc, R.string.canada, R.string.north_america, 51.497,-115.928, 15000, 2, "can_banff", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(163, R.string.jasper, R.string.jasper_desc, R.string.canada, R.string.north_america, 52.867,-118.087, 25000, 1, "can_jasper", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(164, R.string.terra_nova, R.string.terra_nova_desc, R.string.canada, R.string.north_america, 48.524,-53.901, 4000, 2, "can_terra_nova", Stamp.FEATURE_OUTDOOR);
		createStamp(165, R.string.waterton, R.string.waterton_desc, R.string.canada, R.string.north_america, 49.096,-113.962, 5000, 1, "can_waterton", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(166, R.string.yoho, R.string.yoho_desc, R.string.canada, R.string.north_america, 51.454,-116.508, 15000, 1, "can_yoho", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(167, R.string.torngat, R.string.torngat_desc, R.string.canada, R.string.north_america, 59.184,-64.026, 20000, 1, "can_torngat", Stamp.F_MNT);
		createStamp(168, R.string.wapusk, R.string.wapusk_desc, R.string.canada, R.string.north_america, 57.775,-93.159, 30000, 1, "can_wapusk", Stamp.FEATURE_OUTDOOR);
		createStamp(169, R.string.fundy, R.string.fundy_desc, R.string.canada, R.string.north_america, 45.621,-65.030, 6000, 1, "can_fundy", Stamp.FEATURE_OUTDOOR);
		createStamp(170, R.string.nahanni, R.string.nahanni_desc, R.string.canada, R.string.north_america, 61.507,-125.488, 50000, 1, "can_nahanni", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(171, R.string.cape_breton, R.string.cape_breton_desc, R.string.canada, R.string.north_america, 46.740,-60.634, 10000, 1, "can_cape_breton", Stamp.F_MNT);
		createStamp(172, R.string.sirmilik, R.string.sirmilik_desc, R.string.canada, R.string.north_america, 73.201,-82.037, 25000, 2, "can_sirmilik", Stamp.F_MNT);
		createStamp(173, R.string.thousand_islands, R.string.thousand_islands_desc, R.string.canada, R.string.north_america, 44.355,-75.955, 1500, 1, "can_thousand_islands", Stamp.FEATURE_OUTDOOR);
		createStamp(174, R.string.vuntut, R.string.vuntut_desc, R.string.canada, R.string.north_america, 68.417,-139.846, 25000, 1, "can_vuntut", Stamp.FEATURE_OUTDOOR);
		createStamp(175, R.string.grasslands, R.string.grasslands_desc, R.string.canada, R.string.north_america, 49.132,-107.424, 5000, 1, "can_grasslands", Stamp.FEATURE_OUTDOOR);
		createStamp(176, R.string.forillon, R.string.forillon_desc, R.string.canada, R.string.north_america, 48.912,-64.364, 5000, 1, "can_forillon", Stamp.FEATURE_OUTDOOR);
		createStamp(177, R.string.quebec, R.string.quebec_desc, R.string.canada, R.string.north_america, 46.806,-71.241, 6000, 1, "can_quebec", Stamp.F_C_WHS | Stamp.F_CITY);

		createStamp(178, R.string.praia, R.string.praia_desc, R.string.cape_verde, R.string.africa, 14.920,-23.511, 2000, 1, "cap_praia", Stamp.F_CAP);

		createStamp(179, R.string.george_town, R.string.george_town_desc, R.string.cayman_islands, R.string.central_america, 19.287,-81.372, 2000, 1, "cay_george", Stamp.F_CAP);

		createStamp(180, R.string.bangui, R.string.bangui_desc, R.string.central_african_republic, R.string.africa, 4.382,18.554, 5000, 2, "car_bangui", Stamp.F_CAP);
		createStamp(181, R.string.dzanga, R.string.dzanga_desc, R.string.central_african_republic, R.string.africa, 3.269,16.191, 35000, 1, "car_dzanga", Stamp.F_N_WHS);
		createStamp(182, R.string.manovo, R.string.manovo_desc, R.string.central_african_republic, R.string.africa, 8.909,21.497, 60000, 1, "car_manovo", Stamp.F_N_WHS);

		createStamp(183, R.string.ndjamena, R.string.ndjamena_desc, R.string.chad, R.string.africa, 12.106,15.043, 3000, 2, "cha_ndjamena", Stamp.F_CAP);
		createStamp(184, R.string.teli, R.string.teli_desc, R.string.chad, R.string.africa, 18.93,20.871, 2000, 1, "cha_teli", Stamp.F_N_WHS);
		createStamp(185, R.string.zakouma, R.string.zakouma_desc, R.string.chad, R.string.africa, 10.836,19.657, 25000, 1, "cha_zakouma", Stamp.FEATURE_OUTDOOR);

		createStamp(186, R.string.santiago, R.string.santiago_desc, R.string.chile, R.string.south_america, -33.460,-70.657, 10000, 3, "chi_santiago", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(187, R.string.concepcion, R.string.concepcion_desc, R.string.chile, R.string.south_america, -36.819,-73.050, 2500, 1, "chi_concepcion", Stamp.F_CITY);
		createStamp(188, R.string.valparaiso, R.string.valparaiso_desc, R.string.chile, R.string.south_america, -33.045,-71.620, 3000, 1, "chi_valparaiso", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(189, R.string.lauca, R.string.lauca_desc, R.string.chile, R.string.south_america, -18.231,-69.314, 10000, 2, "chi_lauca", Stamp.F_MNT);
		createStamp(190, R.string.rapanui, R.string.rapanui_desc, R.string.chile, R.string.australia_continent, -27.114,-109.358, 4000, 2, "chi_rapanui", Stamp.F_C_WHS);
		createStamp(191, R.string.juan_fernandez, R.string.juan_fernandez_desc, R.string.chile, R.string.south_america, -33.765,-80.791, 4000, 1, "chi_juan_fernandez", Stamp.F_N_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(192, R.string.llanos, R.string.llanos_desc, R.string.chile, R.string.south_america, -28.198,-71.039, 8000, 1, "chi_llanos", Stamp.F_MNT);
		createStamp(193, R.string.san_rafael, R.string.san_rafael_desc, R.string.chile, R.string.south_america, -46.663,-73.925, 40000, 2, "chi_rafael", Stamp.F_MNT);
		createStamp(194, R.string.campana, R.string.campana_desc, R.string.chile, R.string.south_america, -32.961,-71.080, 6000, 1, "chi_campana", Stamp.F_MNT);
		createStamp(195, R.string.puyehue, R.string.puyehue_desc, R.string.chile, R.string.south_america, -40.655,-72.088, 15000, 1, "chi_puyehue", Stamp.F_MNT);

		createStamp(200, R.string.beijing, R.string.beijing_desc, R.string.china, R.string.asia, 39.918,116.397, 9000, 3, "chn_beijing", Stamp.F_C_WHS | Stamp.F_CAP);
		createStamp(201, R.string.shanghai, R.string.shanghai_desc, R.string.china, R.string.asia, 31.230,121.474, 6000, 3, "chn_shanghai", Stamp.F_CITY);
		createStamp(202, R.string.chongqing, R.string.chongqing_desc, R.string.china, R.string.asia, 29.563,106.552, 6000, 1, "chn_chongqing", Stamp.F_CITY);
		createStamp(203, R.string.tianjin, R.string.tianjin_desc, R.string.china, R.string.asia, 39.102,117.203, 6000, 1, "chn_tianjin", Stamp.F_CITY);
		createStamp(204, R.string.guangzhou, R.string.guangzhou_desc, R.string.china, R.string.asia, 23.129,113.264, 5000, 2, "chn_guangzhou", Stamp.F_CITY);
		createStamp(205, R.string.shenzen, R.string.shenzen_desc, R.string.china, R.string.asia, 22.543,114.058, 5000, 1, "chn_shenzen", Stamp.F_CITY);
		createStamp(206, R.string.wuhan, R.string.wuhan_desc, R.string.china, R.string.asia, 30.593,114.306, 5000, 1, "chn_wuhan", Stamp.F_CITY);
		createStamp(207, R.string.dongguan, R.string.dongguan_desc, R.string.china, R.string.asia, 23.022,113.755, 5000, 1, "chn_dongguan", Stamp.F_CITY);
		createStamp(208, R.string.chengdu, R.string.chengdu_desc, R.string.china, R.string.asia, 30.658,104.065, 12000, 1, "chn_chengdu", Stamp.F_CITY);
		createStamp(209, R.string.nanjing, R.string.nanjing_desc, R.string.china, R.string.asia, 32.068,118.774, 8000, 2, "chn_nanjing", Stamp.F_CITY);
		createStamp(210, R.string.guilin, R.string.guilin_desc, R.string.china, R.string.asia, 25.274,110.290, 1500, 1, "chn_guilin", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(211, R.string.hangzhou, R.string.hangzhou_desc, R.string.china, R.string.asia, 30.273,120.155, 8000, 1, "chn_hangzhou", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(212, R.string.kunming, R.string.kunming_desc, R.string.china, R.string.asia, 24.881,102.833, 5000, 1, "chn_kunming", Stamp.F_CITY);
		createStamp(213, R.string.suzhou, R.string.suzhou_desc, R.string.china, R.string.asia, 31.302,120.572, 7000, 1, "chn_suzhou", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(214, R.string.xian, R.string.xian_desc, R.string.china, R.string.asia, 34.270,108.945, 10000, 2, "chn_xian", Stamp.F_CITY);
		createStamp(215, R.string.yangzhou, R.string.yangzhou_desc, R.string.china, R.string.asia, 32.395,119.413, 5000, 1, "chn_yangzhou", Stamp.F_CITY);
		createStamp(216, R.string.badaling, R.string.badaling_desc, R.string.china, R.string.asia, 40.364,116.015, 4000, 2, "chn_badaling", Stamp.F_C_WHS);
		createStamp(218, R.string.leshan, R.string.leshan_desc, R.string.china, R.string.asia, 29.543,103.772, 500, 1, "chn_leshan", Stamp.F_C_WHS);
		createStamp(219, R.string.tai, R.string.tai_desc, R.string.china, R.string.asia, 34.227,117.180, 500, 1, "chn_tai", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(220, R.string.cangyan, R.string.cangyan_desc, R.string.china, R.string.asia, 37.836,114.167, 1000, 1, "chn_cangyan", Stamp.F_MNT);
		createStamp(221, R.string.wudang, R.string.wudang_desc, R.string.china, R.string.asia, 32.409,111.023, 1000, 1, "chn_wudang", Stamp.F_C_WHS);
		createStamp(222, R.string.potala, R.string.potala_desc, R.string.china, R.string.asia, 29.655,91.119, 400, 2, "chn_potala", Stamp.F_C_WHS);
		createStamp(223, R.string.dengfeng, R.string.dengfeng_desc, R.string.china, R.string.asia, 34.459,113.068, 500, 1, "chn_dengfeng", Stamp.F_C_WHS);
		createStamp(224, R.string.hukou, R.string.hukou_desc, R.string.china, R.string.asia, 36.147,110.444, 500, 1, "chn_hukou", Stamp.FEATURE_OUTDOOR);
		createStamp(225, R.string.lijiang_yulong, R.string.lijiang_yulong_desc, R.string.china, R.string.asia, 27.101,100.262, 1000, 2, "chn_lijiang_yulong", Stamp.F_MNT);
		createStamp(226, R.string.sanqingshan, R.string.sanqingshan_desc, R.string.china, R.string.asia, 28.916, 118.065, 3000, 1, "chn_sanqingshan", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(227, R.string.huangshan, R.string.huangshan_desc, R.string.china, R.string.asia, 30.125, 118.167, 2500, 2, "chn_huangshan", Stamp.F_N_WHS);
		createStamp(228, R.string.wuyi, R.string.wuyi_desc, R.string.china, R.string.asia, 27.693,117.701, 4000, 1, "chn_wuyi", Stamp.F_N_WHS);
		createStamp(229, R.string.lushan, R.string.lushan_desc, R.string.china, R.string.asia, 29.573, 115.973, 1500, 1, "chn_lushan", Stamp.F_C_WHS);
		createStamp(230, R.string.guilin_lijiang, R.string.guilin_lijiang_desc, R.string.china, R.string.asia, 24.631,110.638, 2000, 2, "chn_guilin_lijiang", Stamp.F_MNT);
		createStamp(231, R.string.three_gorges, R.string.three_gorges_desc, R.string.china, R.string.asia, 31.043, 109.561, 5000, 2, "chn_three_gorges", Stamp.F_MNT);
		createStamp(232, R.string.emeishan, R.string.emeishan_desc, R.string.china, R.string.asia, 29.520, 103.333, 2000, 1, "chn_emeishan", Stamp.F_N_WHS);
		createStamp(233, R.string.jiuzhaigou, R.string.jiuzhaigou_desc, R.string.china, R.string.asia, 33.203,103.900, 800, 1, "chn_jiuzhaigou", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(234, R.string.huangguoshu, R.string.huangguoshu_desc, R.string.china, R.string.asia, 25.992, 105.666, 500, 1, "chn_huangguoshu", Stamp.FEATURE_OUTDOOR);
		createStamp(235, R.string.lunan_shilin, R.string.lunan_shilin_desc, R.string.china, R.string.asia, 24.816,103.343, 2500, 1, "chn_lunan_shilin", Stamp.F_N_WHS);
		createStamp(236, R.string.huashan, R.string.huashan_desc, R.string.china, R.string.asia, 34.497,110.079, 5000, 1, "chn_huashan", Stamp.F_N_WHS);
		createStamp(217, R.string.tianshan, R.string.tianshan_desc, R.string.china, R.string.asia, 43.886, 88.132, 1500, 1, "chn_tianshan", Stamp.F_N_WHS);

		createStamp(237, R.string.christmas_island, R.string.christmas_island_desc, R.string.christmas_island_country, R.string.australia_continent, -10.487,105.629, 3500, 1, "chr_island", Stamp.FEATURE_OUTDOOR);

		createStamp(238, R.string.cocos_islands, R.string.cocos_islands_desc, R.string.cocos_islands_country, R.string.australia_continent, -12.149,96.868, 6000, 1, "coc_islands", Stamp.FEATURE_OUTDOOR);

		createStamp(239, R.string.bogota, R.string.bogota_desc, R.string.colombia, R.string.south_america, 4.630,-74.081, 9000, 2, "col_bogota", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(240, R.string.cartagena, R.string.cartagena_desc, R.string.colombia, R.string.south_america, 10.415,-75.526, 5000, 2, "col_cartagena", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(241, R.string.cali, R.string.cali_desc, R.string.colombia, R.string.south_america, 3.435,-76.519, 5000, 1, "col_cali", Stamp.F_CITY);
		createStamp(242, R.string.barranquilla, R.string.barranquilla_desc, R.string.colombia, R.string.south_america, 10.974,-74.796, 6000, 1, "col_barranquilla", Stamp.F_CITY);
		createStamp(243, R.string.tierradentro, R.string.tierradentro_desc, R.string.colombia, R.string.south_america, 2.583,-76.033, 1000, 1, "col_tierradentro", Stamp.F_C_WHS);
		createStamp(244, R.string.agustin, R.string.agustin_desc, R.string.colombia, R.string.south_america, 1.890,-76.295, 2000, 1, "col_agustin", Stamp.F_C_WHS);
		createStamp(245, R.string.amacayacu, R.string.amacayacu_desc, R.string.colombia, R.string.south_america, -3.483, -70.2, 20000, 1, "col_amacayacu", Stamp.FEATURE_OUTDOOR);
		createStamp(246, R.string.nevados, R.string.nevados_desc, R.string.colombia, R.string.south_america, 4.806,-75.373, 12000, 2, "col_nevados", Stamp.F_MNT);
		createStamp(247, R.string.tayrona, R.string.tayrona_desc, R.string.colombia, R.string.south_america, 11.290,-74.153, 4000, 1, "col_tayrona", Stamp.FEATURE_OUTDOOR);
		createStamp(248, R.string.santa_marta, R.string.santa_marta_desc, R.string.colombia, R.string.south_america, 10.970,-73.623, 30000, 1, "col_santa_marta", Stamp.F_MNT);

		createStamp(249, R.string.moroni, R.string.moroni_desc, R.string.comoros, R.string.africa, -11.701,43.253, 2000, 1, "com_moroni", Stamp.F_CAP);

		createStamp(250, R.string.brazzaville, R.string.brazzaville_desc, R.string.congo_brazzaville, R.string.africa, -4.262,15.280, 3000, 2, "cnb_brazzaville", Stamp.F_CAP);
		createStamp(251, R.string.nouabale, R.string.nouabale_desc, R.string.congo_brazzaville, R.string.africa, 2.514,16.621, 15000, 1, "cnb_nouabale", Stamp.FEATURE_OUTDOOR);
		createStamp(252, R.string.odzala, R.string.odzala_desc, R.string.congo_brazzaville, R.string.africa, 1.258,14.913, 35000, 1, "cnb_odzala", Stamp.FEATURE_OUTDOOR);

		createStamp(253, R.string.kinshasa, R.string.kinshasa_desc, R.string.congo_kinshasa, R.string.africa, -4.332,15.315, 3000, 2, "cnk_kinshasa", Stamp.F_CAP);
		createStamp(254, R.string.garamba, R.string.garamba_desc, R.string.congo_kinshasa, R.string.africa, 4.186,29.472, 20000, 1, "cnk_garamba", Stamp.F_N_WHS);
		createStamp(255, R.string.kahuzi, R.string.kahuzi_desc, R.string.congo_kinshasa, R.string.africa, -1.961,28.026, 30000, 1, "cnk_kahuzi", Stamp.F_N_WHS);
		createStamp(256, R.string.okapi, R.string.okapi_desc, R.string.congo_kinshasa, R.string.africa, 1.703,28.572, 35000, 1, "cnk_okapi", Stamp.F_N_WHS);
		createStamp(257, R.string.salonga, R.string.salonga_desc, R.string.congo_kinshasa, R.string.africa, -2.032,21.239, 60000, 2, "cnk_salonga", Stamp.F_N_WHS);
		createStamp(258, R.string.virunga, R.string.virunga_desc, R.string.congo_kinshasa, R.string.africa, 0.063,29.465, 18000, 1, "cnk_virunga", Stamp.F_N_WHS | Stamp.F_MNT);

		createStamp(259, R.string.rarotonga, R.string.rarotonga_desc, R.string.cook_islands, R.string.australia_continent, -21.235,-159.776, 3500, 1, "coo_rarotonga", Stamp.FEATURE_OUTDOOR);

		createStamp(260, R.string.san_jose, R.string.san_jose_desc, R.string.costa_rica, R.string.central_america, 9.927,-84.082, 2500, 2, "cos_san_jose", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(261, R.string.cocos, R.string.cocos_desc, R.string.costa_rica, R.string.central_america, 5.531,-87.062, 3000, 1, "cos_cocos", Stamp.F_N_WHS);
		createStamp(262, R.string.amistad, R.string.amistad_desc, R.string.costa_rica, R.string.central_america, 9.370,-83.113, 15000, 1, "cos_amistad", Stamp.F_N_WHS | Stamp.F_MNT);

		createStamp(263, R.string.abidjan, R.string.abidjan_desc, R.string.cote_divoire, R.string.africa, 5.349,-4.026, 9000, 2, "cot_abidjan", Stamp.F_CAP);
		createStamp(265, R.string.comoe, R.string.comoe_desc, R.string.cote_divoire, R.string.africa, 9.148,-3.695, 35000, 1, "cot_comoe", Stamp.F_N_WHS);
		createStamp(266, R.string.tai_cot, R.string.tai_cot_desc, R.string.cote_divoire, R.string.africa, 5.714,-7.125, 15000, 1, "cot_tai", Stamp.F_N_WHS);

		createStamp(267, R.string.zagreb, R.string.zagreb_desc, R.string.croatia, R.string.europe, 45.813,15.978, 6000, 2, "cro_zagreb", Stamp.F_CAP);
		createStamp(268, R.string.dubrovnik, R.string.dubrovnik_desc, R.string.croatia, R.string.europe, 42.651,18.093, 3000, 1, "cro_dubrovnik", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(269, R.string.split, R.string.split_desc, R.string.croatia, R.string.europe, 43.513,16.454, 3000, 1, "cro_split", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(270, R.string.plitvice, R.string.plitvice_desc, R.string.croatia, R.string.europe, 44.875,15.598, 6000, 2, "cro_plitvice", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(271, R.string.mljet, R.string.mljet_desc, R.string.croatia, R.string.europe, 42.778,17.383, 3000, 1, "cro_mljet", Stamp.F_N_WHS);

		createStamp(272, R.string.havana, R.string.havana_desc, R.string.cuba, R.string.central_america, 23.130,-82.383, 9000, 2, "cub_havana", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(273, R.string.santiago_cub, R.string.santiago_cub_desc, R.string.cuba, R.string.central_america, 20.030,-75.829, 3000, 1, "cub_santiago", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(274, R.string.trinidad, R.string.trinidad_desc, R.string.cuba, R.string.central_america, 21.802,-79.984, 1000, 1, "cub_trinidad", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(275, R.string.humboldt, R.string.humboldt_desc, R.string.cuba, R.string.central_america, 20.429,-74.737, 10000, 1, "cub_humboldt", Stamp.F_N_WHS);
		createStamp(276, R.string.desembarco, R.string.desembarco_desc, R.string.cuba, R.string.central_america, 19.882,-77.632, 5000, 1, "cub_desembarco", Stamp.F_N_WHS);
		createStamp(277, R.string.vinales, R.string.vinales_desc, R.string.cuba, R.string.central_america, 22.613,-83.812, 2500, 1, "cub_vinales", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);

		createStamp(278, R.string.willemstad, R.string.willemstad_desc, R.string.curacao, R.string.central_america, 12.114,-68.932, 1500, 1, "cur_willemstad", Stamp.F_CAP | Stamp.F_C_WHS);

		createStamp(264, R.string.nicosia, R.string.nicosia_desc, R.string.cyprus, R.string.europe, 35.179,33.363, 3500, 2, "cyp_nicosia", Stamp.F_CAP);
		createStamp(283, R.string.paphos, R.string.paphos_desc, R.string.cyprus, R.string.europe, 34.776,32.422, 3000, 1, "cyp_paphos", Stamp.F_C_WHS);

		createStamp(279, R.string.prague, R.string.prague_desc, R.string.czech_republic, R.string.europe, 50.080,14.430, 9000, 2, "cze_prague", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(280, R.string.olomouc, R.string.olomouc_desc, R.string.czech_republic, R.string.europe, 49.596,17.255, 3000, 1, "cze_olomouc", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(281, R.string.czech_paradise, R.string.czech_paradise_desc, R.string.czech_republic, R.string.europe, 50.520,15.148, 6500, 1, "cze_paradise", Stamp.FEATURE_OUTDOOR);
		createStamp(282, R.string.krkonose, R.string.krkonose_desc, R.string.czech_republic, R.string.europe, 50.716,15.670, 8000, 1, "cze_krkonose", Stamp.F_MNT);
		createStamp(284, R.string.krumlov, R.string.krumlov_desc, R.string.czech_republic, R.string.europe, 48.811,14.315, 1000, 1, "cze_krumlov", Stamp.F_CITY | Stamp.F_C_WHS);

		createStamp(285, R.string.copenhagen, R.string.copenhagen_desc, R.string.denmark, R.string.europe, 55.686,12.569, 4000, 2, "den_copenhagen", Stamp.F_CAP);
		createStamp(286, R.string.kronborg, R.string.kronborg_desc, R.string.denmark, R.string.europe, 56.039,12.621, 600, 1, "den_kronborg", Stamp.F_C_WHS);
		createStamp(287, R.string.thy, R.string.thy_desc, R.string.denmark, R.string.europe, 56.932,8.339, 5000, 1, "den_thy", Stamp.FEATURE_OUTDOOR);

		createStamp(288, R.string.djibouti_city, R.string.djibouti_city_desc, R.string.djibouti, R.string.africa, 11.597,43.145, 2000, 2, "dji_djibouti", Stamp.F_CAP);
		createStamp(289, R.string.day, R.string.day_desc, R.string.djibouti, R.string.africa, 11.765,42.686, 4000, 1, "dji_day", Stamp.F_MNT);

		createStamp(290, R.string.roseau, R.string.roseau_desc, R.string.dominica, R.string.central_america, 15.303,-61.386, 500, 1, "dom_roseau", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(291, R.string.santo_domingo, R.string.santo_domingo_desc, R.string.dominican_republic, R.string.central_america, 18.470,-69.941, 3000, 2, "dor_santo_domingo", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(292, R.string.haitises, R.string.haitises_desc, R.string.dominican_republic, R.string.central_america, 19.017,-69.622, 4000, 1, "dor_haitises", Stamp.F_MNT);

		createStamp(293, R.string.quito, R.string.quito_desc, R.string.ecuador, R.string.south_america, -0.164,-78.468, 12000, 2, "ecu_quito", Stamp.F_CAP | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(294, R.string.cuenca, R.string.cuenca_desc, R.string.ecuador, R.string.south_america, -2.900,-79.006, 4000, 1, "ecu_cuenca", Stamp.F_CITY | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(295, R.string.guayaquil, R.string.guayaquil_desc, R.string.ecuador, R.string.south_america, -2.180,-79.897, 8000, 1, "ecu_guayaquil", Stamp.F_CITY);
		createStamp(296, R.string.galapagos, R.string.galapagos_desc, R.string.ecuador, R.string.south_america, -0.420,-91.111, 60000, 2, "ecu_galapagos", Stamp.F_N_WHS);
		createStamp(297, R.string.sangay, R.string.sangay_desc, R.string.ecuador, R.string.south_america, -2.007,-78.341, 15000, 1, "ecu_sangay", Stamp.F_MNT);
		createStamp(298, R.string.cotopaxi, R.string.cotopaxi_desc, R.string.ecuador, R.string.south_america, -0.707,-78.449, 8000, 2, "ecu_cotopaxi", Stamp.F_MNT);
		createStamp(299, R.string.pululahua, R.string.pululahua_desc, R.string.ecuador, R.string.south_america, 0.082,-78.532, 3000, 1, "ecu_pululahua", Stamp.F_MNT);

		createStamp(300, R.string.cairo, R.string.cairo_desc, R.string.egypt, R.string.africa, 30.044,31.236, 6000, 2, "egy_cairo", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(301, R.string.alexandria, R.string.alexandria_desc, R.string.egypt, R.string.africa, 31.202,29.916, 6000, 1, "egy_alexandria", Stamp.F_CITY);
		createStamp(302, R.string.giza, R.string.giza_desc, R.string.egypt, R.string.africa, 29.985,31.136, 6000, 3, "egy_giza", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(303, R.string.aswan, R.string.aswan_desc, R.string.egypt, R.string.africa, 24.092,32.901, 1500, 1, "egy_aswan", Stamp.F_CITY);
		createStamp(304, R.string.luxor, R.string.luxor_desc, R.string.egypt, R.string.africa, 25.695,32.641, 3500, 2, "egy_luxor", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(305, R.string.abu_simbel, R.string.abu_simbel_desc, R.string.egypt, R.string.africa, 22.346,31.616, 2000, 1, "egy_simbel", Stamp.F_C_WHS);
		createStamp(306, R.string.saint_catherine, R.string.saint_catherine_desc, R.string.egypt, R.string.africa, 28.540,33.977, 4000, 1, "egy_catherine", Stamp.F_C_WHS);
		createStamp(307, R.string.farafra, R.string.farafra_desc, R.string.egypt, R.string.africa, 27.058, 27.97, 20000, 1, "egy_farafra", Stamp.FEATURE_OUTDOOR);
		createStamp(308, R.string.gebel, R.string.gebel_desc, R.string.egypt, R.string.africa, 22.981,35.554, 35000, 1, "egy_gebel", Stamp.F_MNT);
		createStamp(309, R.string.ras, R.string.ras_desc, R.string.egypt, R.string.africa, 27.768,34.215, 10000, 1, "egy_ras", Stamp.FEATURE_OUTDOOR);
		createStamp(310, R.string.siwa, R.string.siwa_desc, R.string.egypt, R.string.africa, 29.206,25.520, 6000, 1, "egy_siwa", Stamp.FEATURE_SIGHTS);

		createStamp(311, R.string.san_salvador, R.string.san_salvador_desc, R.string.el_salvador, R.string.central_america, 13.702,-89.205, 5000, 2, "els_san_salvador", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(312, R.string.el_imposible, R.string.el_imposible_desc, R.string.el_salvador, R.string.central_america, 13.833,-89.930, 4000, 1, "els_imposible", Stamp.F_MNT);

		createStamp(313, R.string.malabo, R.string.malabo_desc, R.string.equatorial_guinea, R.string.africa, 3.751,8.783, 2500, 2, "equ_malabo", Stamp.F_CAP);

		createStamp(314, R.string.asmara, R.string.asmara_desc, R.string.eritrea, R.string.africa, 15.333,38.926, 3000, 2, "eri_asmara", Stamp.F_CAP);
		createStamp(315, R.string.dahlak, R.string.dahlak_desc, R.string.eritrea, R.string.africa, 15.644,40.126, 15000, 1, "eri_dahlak", Stamp.FEATURE_OUTDOOR);
		createStamp(316, R.string.semenawi, R.string.semenawi_desc, R.string.eritrea, R.string.africa, 15.325,39.490, 8000, 1, "eri_semenawi", Stamp.FEATURE_OUTDOOR);

		createStamp(317, R.string.tallinn, R.string.tallinn_desc, R.string.estonia, R.string.europe, 59.435,24.750, 5000, 2, "est_tallinn", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(318, R.string.tartu, R.string.tartu_desc, R.string.estonia, R.string.europe, 58.380,26.717, 3000, 1, "est_tartu", Stamp.F_CITY);
		createStamp(319, R.string.lahemaa, R.string.lahemaa_desc, R.string.estonia, R.string.europe, 59.537,25.842, 10000, 1, "est_lahemaa", Stamp.FEATURE_OUTDOOR);

		createStamp(320, R.string.addis_ababa, R.string.addis_ababa_desc, R.string.ethiopia, R.string.africa, 9.020,38.753, 6000, 2, "eth_addis_ababa", Stamp.F_CAP);
		createStamp(321, R.string.aksum, R.string.aksum_desc, R.string.ethiopia, R.string.africa, 14.124,38.724, 2000, 1, "eth_aksum", Stamp.F_C_WHS);
		createStamp(322, R.string.gondar, R.string.gondar_desc, R.string.ethiopia, R.string.africa, 12.608,37.470, 1000, 1, "eth_gondar", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(323, R.string.harar, R.string.harar_desc, R.string.ethiopia, R.string.africa, 9.309,42.138, 1500, 1, "eth_harar", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(324, R.string.lalibela, R.string.lalibela_desc, R.string.ethiopia, R.string.africa, 12.030,39.041, 1500, 1, "eth_lalibela", Stamp.F_C_WHS);
		createStamp(325, R.string.tiya, R.string.tiya_desc, R.string.ethiopia, R.string.africa, 8.435,38.612, 2000, 1, "eth_tiya", Stamp.F_C_WHS);
		createStamp(326, R.string.semien, R.string.semien_desc, R.string.ethiopia, R.string.africa, 13.221,38.289, 10000, 2, "eth_semien", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(327, R.string.nechisar, R.string.nechisar_desc, R.string.ethiopia, R.string.africa, 5.963,37.700, 8000, 1, "eth_nechisar", Stamp.F_MNT);
		createStamp(328, R.string.awash, R.string.awash_desc, R.string.ethiopia, R.string.africa, 8.997,39.994, 5000, 1, "eth_awash", Stamp.F_MNT);

		createStamp(329, R.string.stanley, R.string.stanley_desc, R.string.falkland_islands, R.string.south_america, -51.694,-57.857, 1000, 2, "fal_stanley", Stamp.F_CAP);

		createStamp(330, R.string.torshavn, R.string.torshavn_desc, R.string.faroe_islands, R.string.europe, 62.015,-6.771, 1500, 1, "far_torshavn", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(331, R.string.suva, R.string.suva_desc, R.string.fiji, R.string.australia_continent, -18.141,178.442, 3000, 2, "fij_suva", Stamp.F_CAP);

		createStamp(332, R.string.helsinki, R.string.helsinki_desc, R.string.finland, R.string.europe, 60.171,24.941, 3000, 2, "fin_helsinki", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(333, R.string.turku, R.string.turku_desc, R.string.finland, R.string.europe, 60.450,22.259, 2000, 1, "fin_turku", Stamp.F_CITY);
		createStamp(334, R.string.salamajrvi, R.string.salamajrvi_desc, R.string.finland, R.string.europe, 63.272,24.758, 3000, 1, "fin_salamajrvi", Stamp.FEATURE_OUTDOOR);
		createStamp(335, R.string.sammallahdenmaki, R.string.sammallahdenmaki_desc, R.string.finland, R.string.europe, 61.120,21.774, 1000, 1, "fin_sammallahdenmaki", Stamp.F_C_WHS);
		createStamp(336, R.string.koli, R.string.koli_desc, R.string.finland, R.string.europe, 63.083,29.822, 2000, 1, "fin_koli", Stamp.FEATURE_OUTDOOR);
		createStamp(337, R.string.pallas, R.string.pallas_desc, R.string.finland, R.string.europe, 67.977,24.120, 4000, 1, "fin_pallas", Stamp.F_MNT);
		createStamp(338, R.string.riisitunturi, R.string.riisitunturi_desc, R.string.finland, R.string.europe, 66.228,28.498, 3000, 1, "fin_riisitunturi", Stamp.F_MNT);

		createStamp(339, R.string.paris, R.string.paris_desc, R.string.france, R.string.europe, 48.855,2.346, 15000, 3, "fra_paris", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(340, R.string.lyon, R.string.lyon_desc, R.string.france, R.string.europe, 45.764,4.836, 6000, 2, "fra_lyon", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(341, R.string.marseille, R.string.marseille_desc, R.string.france, R.string.europe, 43.297,5.375, 8000, 1, "fra_marseille", Stamp.F_CITY);
		createStamp(342, R.string.toulouse, R.string.toulouse_desc, R.string.france, R.string.europe, 43.600,1.441, 4000, 1, "fra_toulouse", Stamp.F_CITY);
		createStamp(343, R.string.lille, R.string.lille_desc, R.string.france, R.string.europe, 50.630,3.057, 4000, 1, "fra_lille", Stamp.F_CITY);
		createStamp(344, R.string.bordeaux, R.string.bordeaux_desc, R.string.france, R.string.europe, 44.839,-0.580, 6000, 1, "fra_bordeaux", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(345, R.string.nice, R.string.nice_desc, R.string.france, R.string.europe, 43.696,7.266, 3000, 1, "fra_nice", Stamp.F_CITY);
		createStamp(346, R.string.bourges, R.string.bourges_desc, R.string.france, R.string.europe, 47.083,2.396, 3500, 1, "fra_bourges", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(347, R.string.nantes, R.string.nantes_desc, R.string.france, R.string.europe, 47.219,-1.554, 6000, 1, "fra_nantes", Stamp.F_CITY);
		createStamp(348, R.string.strasbourg, R.string.strasbourg_desc, R.string.france, R.string.europe, 48.583,7.748, 4000, 2, "fra_strasbourg", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(349, R.string.orleans, R.string.orleans_desc, R.string.france, R.string.europe, 47.903,1.909, 4000, 1, "fra_orleans", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(350, R.string.saint_michel, R.string.saint_michel_desc, R.string.france, R.string.europe, 48.636,-1.511, 500, 2, "fra_saint_michel", Stamp.F_C_WHS);
		createStamp(351, R.string.avignon, R.string.avignon_desc, R.string.france, R.string.europe, 43.949,4.806, 2500, 1, "fra_avignon", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(352, R.string.carcassonne, R.string.carcassonne_desc, R.string.france, R.string.europe, 43.213,2.354, 3500, 1, "fra_carcassonne", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(353, R.string.nimes, R.string.nimes_desc, R.string.france, R.string.europe, 43.947,4.535, 200, 1, "fra_nimes", Stamp.F_C_WHS);
		createStamp(355, R.string.camargue, R.string.camargue_desc, R.string.france, R.string.europe, 43.517,4.563, 12000, 1, "fra_camargue", Stamp.FEATURE_OUTDOOR);
		createStamp(356, R.string.cevennes, R.string.cevennes_desc, R.string.france, R.string.europe, 44.263,3.709, 20000, 1, "fra_cevennes", Stamp.F_MNT);
		createStamp(357, R.string.mercantour, R.string.mercantour_desc, R.string.france, R.string.europe, 44.183,6.938, 15000, 1, "fra_mercantour", Stamp.F_MNT);
		createStamp(358, R.string.pyrenees, R.string.pyrenees_desc, R.string.france, R.string.europe, 42.877,-0.087, 15000, 2, "fra_pyrenees", Stamp.F_MNT);
		createStamp(359, R.string.vanoise, R.string.vanoise_desc, R.string.france, R.string.europe, 45.392,6.863, 14000, 2, "fra_vanoise", Stamp.F_MNT);
		createStamp(360, R.string.reims, R.string.reims_desc, R.string.france, R.string.europe, 49.254,4.034, 2500, 1, "fra_reims", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(354, R.string.amiens, R.string.amiens_desc, R.string.france, R.string.europe, 49.897,2.300, 3500, 1, "fra_amiens", Stamp.F_CITY | Stamp.F_C_WHS);

		createStamp(361, R.string.cayenne, R.string.cayenne_desc, R.string.french_guiana, R.string.south_america, 4.937,-52.326, 1000, 2, "frg_cayenne", Stamp.F_CAP);
		createStamp(362, R.string.guiana, R.string.guiana_desc, R.string.french_guiana, R.string.south_america, 2.666,-53.512, 30000, 1, "frg_guiana", Stamp.FEATURE_OUTDOOR);

		createStamp(363, R.string.papeete, R.string.papeete_desc, R.string.french_polynesia, R.string.australia_continent, -17.536,-149.568, 2500, 1, "frp_papeete", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(364, R.string.kerguelen, R.string.kerguelen_desc, R.string.french_southern_lands, R.string.antarctica, -49.322,69.274, 25000, 1, "frs_kerguelen", Stamp.F_MNT);

		createStamp(365, R.string.saint_denis, R.string.saint_denis_desc, R.string.reunion, R.string.africa, -20.882,55.451, 1000, 1, "reu_denis", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(366, R.string.noumea, R.string.noumea_desc, R.string.new_caledonia, R.string.australia_continent, -22.276,166.458, 2000, 2, "nec_noumea", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(367, R.string.basse_terre, R.string.basse_terre_desc, R.string.guadeloupe, R.string.central_america, 15.999,-61.726, 1000, 1, "gua_basse_terre", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(368, R.string.libreville, R.string.libreville_desc, R.string.gabon, R.string.africa, 0.394,9.450, 2000, 2, "gab_libreville", Stamp.F_CAP);
		createStamp(369, R.string.lope, R.string.lope_desc, R.string.gabon, R.string.africa, -0.492,11.538, 25000, 1, "gab_lope", Stamp.F_N_WHS);
		createStamp(370, R.string.loango, R.string.loango_desc, R.string.gabon, R.string.africa, -2.116,9.603, 10000, 1, "gab_loango", Stamp.FEATURE_OUTDOOR);
		createStamp(371, R.string.minkebe, R.string.minkebe_desc, R.string.gabon, R.string.africa, 1.571,12.554, 30000, 1, "gab_minkebe", Stamp.FEATURE_OUTDOOR);

		createStamp(372, R.string.banjul, R.string.banjul_desc, R.string.gambia, R.string.africa, 13.453,-16.577, 750, 2, "gam_banjul", Stamp.F_CAP);
		createStamp(373, R.string.kiang, R.string.kiang_desc, R.string.gambia, R.string.africa, 13.390,-15.911, 2500, 1, "gam_kiang", Stamp.FEATURE_OUTDOOR);

		createStamp(374, R.string.tbilisi, R.string.tbilisi_desc, R.string.georgia, R.string.asia, 41.710,44.793, 4500, 2, "geo_tbilisi", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(375, R.string.mtskheta, R.string.mtskheta_desc, R.string.georgia, R.string.asia, 41.843,44.719, 800, 1, "geo_mtskheta", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(376, R.string.borjomi, R.string.borjomi_desc, R.string.georgia, R.string.asia, 41.871,43.172, 7000, 1, "geo_borjomi", Stamp.F_MNT);
		createStamp(377, R.string.kazbegi, R.string.kazbegi_desc, R.string.georgia, R.string.asia, 42.601,44.911, 10000, 1, "geo_kazbegi", Stamp.F_MNT);

		createStamp(378, R.string.accra, R.string.accra_desc, R.string.ghana, R.string.africa, 5.552,-0.202, 8000, 2, "gha_accra", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(379, R.string.cape_coast, R.string.cape_coast_desc, R.string.ghana, R.string.africa, 5.111,-1.256, 5000, 1, "gha_cape", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(380, R.string.kakum, R.string.kakum_desc, R.string.ghana, R.string.africa, 5.453,-1.341, 6000, 1, "gha_kakum", Stamp.FEATURE_OUTDOOR);
		createStamp(381, R.string.mole, R.string.mole_desc, R.string.ghana, R.string.africa, 9.445,-1.868, 22000, 1, "gha_mole", Stamp.FEATURE_OUTDOOR);

		createStamp(382, R.string.berlin, R.string.berlin_desc, R.string.germany, R.string.europe, 52.523,13.410, 4000, 3, "ger_berlin", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(383, R.string.hamburg, R.string.hamburg_desc, R.string.germany, R.string.europe, 53.551,9.993, 4000, 2, "ger_hamburg", Stamp.F_CITY);
		createStamp(384, R.string.munich, R.string.munich_desc, R.string.germany, R.string.europe, 48.141,11.576, 6000, 2, "ger_munich", Stamp.F_CITY);
		createStamp(385, R.string.cologne, R.string.cologne_desc, R.string.germany, R.string.europe, 50.938,6.961, 4000, 2, "ger_cologne", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(386, R.string.bremen, R.string.bremen_desc, R.string.germany, R.string.europe, 53.082,8.813, 6000, 1, "ger_bremen", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(387, R.string.dresden, R.string.dresden_desc, R.string.germany, R.string.europe, 51.051,13.738, 5000, 1, "ger_dresden", Stamp.F_CITY);
		createStamp(388, R.string.dusseldorf, R.string.dusseldorf_desc, R.string.germany, R.string.europe, 51.232,6.788, 4000, 1, "ger_dusseldorf", Stamp.F_CITY);
		createStamp(389, R.string.frankfurt, R.string.frankfurt_desc, R.string.germany, R.string.europe, 50.112,8.684, 3500, 1, "ger_frankfurt", Stamp.F_CITY);
		createStamp(390, R.string.nuremberg, R.string.nuremberg_desc, R.string.germany, R.string.europe, 49.452,11.077, 3500, 1, "ger_nuremberg", Stamp.F_CITY);
		createStamp(391, R.string.aachen, R.string.aachen_desc, R.string.germany, R.string.europe, 50.775,6.084, 1500, 1, "ger_aachen", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(392, R.string.kassel, R.string.kassel_desc, R.string.germany, R.string.europe, 51.313,9.472, 5000, 1, "ger_kassel", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(393, R.string.weimar, R.string.weimar_desc, R.string.germany, R.string.europe, 50.983,11.325, 2000, 1, "ger_weimar", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(394, R.string.lubeck, R.string.lubeck_desc, R.string.germany, R.string.europe, 53.866,10.687, 1500, 1, "ger_lubeck", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(395, R.string.regensburg, R.string.regensburg_desc, R.string.germany, R.string.europe, 49.013,12.100, 3000, 1, "ger_regensburg", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(396, R.string.trier, R.string.trier_desc, R.string.germany, R.string.europe, 49.748,6.643, 3000, 1, "ger_trier", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(397, R.string.holstein_wadden, R.string.holstein_wadden_desc, R.string.germany, R.string.europe, 54.601,8.723, 12000, 1, "ger_holstein_wadden", Stamp.F_N_WHS);
		createStamp(398, R.string.jasmund, R.string.jasmund_desc, R.string.germany, R.string.europe, 54.487,13.556, 8000, 2, "ger_jasmund", Stamp.F_N_WHS);
		createStamp(399, R.string.harz, R.string.harz_desc, R.string.germany, R.string.europe, 51.747,10.783, 12000, 1, "ger_harz", Stamp.F_MNT);
		createStamp(400, R.string.kellerwald, R.string.kellerwald_desc, R.string.germany, R.string.europe, 51.147,8.973, 3000, 1, "ger_kellerwald", Stamp.F_N_WHS);
		createStamp(401, R.string.berchtesgaden, R.string.berchtesgaden_desc, R.string.germany, R.string.europe, 47.555,12.920, 4000, 2, "ger_berchtesgaden", Stamp.F_MNT);

		createStamp(402, R.string.the_rock, R.string.the_rock_desc, R.string.gibraltar, R.string.europe, 36.126,-5.348, 1000, 1, "gib_rock", Stamp.F_MNT);

		createStamp(403, R.string.athens, R.string.athens_desc, R.string.greece, R.string.europe, 37.984,23.729, 6000, 3, "gre_athens", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(404, R.string.heraklion, R.string.heraklion_desc, R.string.greece, R.string.europe, 35.335,25.134, 2500, 1, "gre_heraklion", Stamp.F_CITY);
		createStamp(405, R.string.rhodes, R.string.rhodes_desc, R.string.greece, R.string.europe, 36.435,28.220, 2000, 1, "gre_rhodes", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(406, R.string.thessaloniki, R.string.thessaloniki_desc, R.string.greece, R.string.europe, 40.640,22.945, 5000, 1, "gre_thessaloniki", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(407, R.string.delphi, R.string.delphi_desc, R.string.greece, R.string.europe, 38.481,22.500, 600, 2, "gre_delphi", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(408, R.string.olympia, R.string.olympia_desc, R.string.greece, R.string.europe, 37.643,21.629, 600, 1, "gre_olympia", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(409, R.string.olympus, R.string.olympus_desc, R.string.greece, R.string.europe, 40.083,22.351, 2500, 2, "gre_olympus", Stamp.F_MNT);
		createStamp(410, R.string.parnassos, R.string.parnassos_desc, R.string.greece, R.string.europe, 38.535,22.622, 2500, 1, "gre_parnassos", Stamp.F_MNT);
		createStamp(411, R.string.samaria, R.string.samaria_desc, R.string.greece, R.string.europe, 35.292,23.960, 3000, 1, "gre_samaria", Stamp.F_MNT);
		createStamp(412, R.string.vikos, R.string.vikos_desc, R.string.greece, R.string.europe, 39.941,20.949, 12000, 1, "gre_vikos", Stamp.F_MNT);

		createStamp(413, R.string.nuuk, R.string.nuuk_desc, R.string.greenland, R.string.north_america, 64.184,-51.721, 2000, 2, "grn_nuuk", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(414, R.string.ilulissat, R.string.ilulissat_desc, R.string.greenland, R.string.north_america, 69.182,-50.592, 10000, 1, "grn_ilulissat", Stamp.F_N_WHS);
		createStamp(415, R.string.ne_greenland, R.string.ne_greenland_desc, R.string.greenland, R.string.north_america, 79.047,-28.704, 150000, 1, "grn_ne", Stamp.FEATURE_OUTDOOR);

		createStamp(416, R.string.st_georges, R.string.st_georges_desc, R.string.grenada, R.string.central_america, 12.054,-61.750, 700, 1, "grd_georges", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(417, R.string.hagatna, R.string.hagatna_desc, R.string.guam, R.string.australia_continent, 13.472,144.752, 1000, 1, "gum_hagatna", Stamp.F_CAP);

		createStamp(418, R.string.guatemala_city, R.string.guatemala_city_desc, R.string.guatemala, R.string.central_america, 14.626,-90.519, 5000, 2, "gut_guatemala", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(419, R.string.antigua, R.string.antigua_desc, R.string.guatemala, R.string.central_america, 14.557,-90.734, 1500, 1, "gut_antigua", Stamp.F_C_WHS | Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(420, R.string.rio_dulce, R.string.rio_dulce_desc, R.string.guatemala, R.string.central_america, 15.725,-88.888, 10000, 1, "gut_dulce", Stamp.FEATURE_OUTDOOR);
		createStamp(421, R.string.tikal, R.string.tikal_desc, R.string.guatemala, R.string.central_america, 17.223,-89.622, 10000, 2, "gut_tikal", Stamp.F_C_WHS);
		createStamp(422, R.string.mirador, R.string.mirador_desc, R.string.guatemala, R.string.central_america, 17.756,-89.919, 6000, 1, "gut_mirador", Stamp.FEATURE_SIGHTS | Stamp.FEATURE_MOUNTAIN);

		createStamp(423, R.string.saint_peter_port, R.string.saint_peter_port_desc, R.string.guernsey, R.string.europe, 49.457,-2.54, 1000, 1, "gue_peter", Stamp.F_CAP);

		createStamp(424, R.string.hong_kong_city, R.string.hong_kong_city_desc, R.string.hong_kong, R.string.asia, 22.284,114.159, 3000, 2, "hkg_hong", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);

		createStamp(425, R.string.conakry, R.string.conakry_desc, R.string.guinea, R.string.africa, 9.622,-13.600, 12000, 2, "gui_conakry", Stamp.F_CAP);
		createStamp(426, R.string.nimba, R.string.nimba_desc, R.string.guinea, R.string.africa, 7.641,-8.426, 5000, 1, "gui_nimba", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(427, R.string.upper_niger, R.string.upper_niger_desc, R.string.guinea, R.string.africa, 10.355,-10.188, 40000, 1, "gui_upper_niger", Stamp.FEATURE_OUTDOOR);

		createStamp(428, R.string.bissau, R.string.bissau_desc, R.string.guinea_bissau, R.string.africa, 11.859,-15.591, 2500, 2, "gub_bissau", Stamp.F_CAP);

		createStamp(429, R.string.georgetown, R.string.georgetown_desc, R.string.guyana, R.string.south_america, 6.810,-58.154, 4000, 2, "guy_georgetown", Stamp.F_CAP);
		createStamp(430, R.string.kaieteur, R.string.kaieteur_desc, R.string.guyana, R.string.south_america, 5.273,-59.392, 6000, 1, "guy_kaieteur", Stamp.FEATURE_OUTDOOR);

		createStamp(431, R.string.port_au_prince, R.string.port_au_prince_desc, R.string.haiti, R.string.central_america, 18.548,-72.344, 3000, 2, "hai_prince", Stamp.F_CAP);
		createStamp(432, R.string.ramiers, R.string.ramiers_desc, R.string.haiti, R.string.central_america, 19.573,-72.243, 3000, 1, "hai_ramiers", Stamp.F_C_WHS);

		createStamp(433, R.string.tegucigalpa, R.string.tegucigalpa_desc, R.string.honduras, R.string.central_america, 14.085,-87.211, 3500, 2, "hon_tegucigalpa", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(434, R.string.copan, R.string.copan_desc, R.string.honduras, R.string.central_america, 14.838,-89.142, 2000, 1, "hon_copan", Stamp.F_C_WHS);
		createStamp(435, R.string.platano, R.string.platano_desc, R.string.honduras, R.string.central_america, 15.534,-84.772, 30000, 1, "hon_platano", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(436, R.string.roatan, R.string.roatan_desc, R.string.honduras, R.string.central_america, 16.379,-86.404, 8000, 1, "hon_roatan", Stamp.FEATURE_OUTDOOR);

		createStamp(437, R.string.budapest, R.string.budapest_desc, R.string.hungary, R.string.europe, 47.499,19.054, 5000, 2, "hun_budapest", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(438, R.string.pecs, R.string.pecs_desc, R.string.hungary, R.string.europe, 46.073,18.233, 4000, 1, "hun_pecs", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(439, R.string.bukk, R.string.bukk_desc, R.string.hungary, R.string.europe, 48.051,20.516, 7000, 1, "hun_bukk", Stamp.F_MNT);
		createStamp(440, R.string.balaton, R.string.balaton_desc, R.string.hungary, R.string.europe, 46.909,17.879, 8000, 1, "hun_balaton", Stamp.FEATURE_OUTDOOR);

		createStamp(441, R.string.reykjavik, R.string.reykjavik_desc, R.string.iceland, R.string.europe, 64.136,-21.920, 2500, 2, "ice_reykjavik", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(442, R.string.husavik, R.string.husavik_desc, R.string.iceland, R.string.europe, 66.047,-17.343, 500, 1, "ice_husavik", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(443, R.string.vatnajokull, R.string.vatnajokull_desc, R.string.iceland, R.string.europe, 64.567,-17.189, 30000, 1, "ice_vatnajokull", Stamp.F_MNT);
		createStamp(444, R.string.snaefellsjokull, R.string.snaefellsjokull_desc, R.string.iceland, R.string.europe, 64.818,-23.881, 6000, 1, "ice_snaefellsjokull", Stamp.F_MNT);

		createStamp(445, R.string.delhi, R.string.delhi_desc, R.string.india, R.string.asia, 28.613,77.231, 7000, 3, "ind_delhi", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(446, R.string.bangalore, R.string.bangalore_desc, R.string.india, R.string.asia, 12.974,77.596, 8000, 1, "ind_bangalore", Stamp.F_CITY);
		createStamp(447, R.string.hyderabad, R.string.hyderabad_desc, R.string.india, R.string.asia, 17.385,78.487, 5000, 1, "ind_hyderabad", Stamp.F_CITY);
		createStamp(448, R.string.chennai, R.string.chennai_desc, R.string.india, R.string.asia, 13.052,80.251, 6000, 1, "ind_chennai", Stamp.F_CITY);
		createStamp(449, R.string.jaipur, R.string.jaipur_desc, R.string.india, R.string.asia, 26.913,75.787, 5000, 2, "ind_jaipur", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(450, R.string.kochi, R.string.kochi_desc, R.string.india, R.string.asia, 9.931,76.267, 5000, 1, "ind_kochi", Stamp.F_CITY);
		createStamp(451, R.string.kolkata, R.string.kolkata_desc, R.string.india, R.string.asia, 22.581,88.359, 7000, 2, "ind_kolkata", Stamp.F_CITY);
		createStamp(452, R.string.mumbai, R.string.mumbai_desc, R.string.india, R.string.asia, 19.081,72.878, 14000, 2, "ind_mumbai", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(453, R.string.shimla, R.string.shimla_desc, R.string.india, R.string.asia, 31.105,77.172, 1500, 1, "ind_shimla", Stamp.F_CITY);
		createStamp(454, R.string.varanasi, R.string.varanasi_desc, R.string.india, R.string.asia, 25.322,82.977, 4000, 1, "ind_varanasi", Stamp.F_CITY);
		createStamp(455, R.string.agra, R.string.agra_desc, R.string.india, R.string.asia, 27.186,78.008, 7000, 2, "ind_agra", Stamp.F_C_WHS);
		createStamp(456, R.string.ajanta, R.string.ajanta_desc, R.string.india, R.string.asia, 20.552,75.703, 600, 1, "ind_ajanta", Stamp.F_C_WHS);
		createStamp(457, R.string.champaner, R.string.champaner_desc, R.string.india, R.string.asia, 22.485,73.532, 600, 1, "ind_champaner", Stamp.F_C_WHS);
		createStamp(458, R.string.ellora, R.string.ellora_desc, R.string.india, R.string.asia, 20.017,75.183, 600, 1, "ind_ellora", Stamp.F_C_WHS);
		createStamp(459, R.string.fatehpur, R.string.fatehpur_desc, R.string.india, R.string.asia, 27.096,77.665, 600, 1, "ind_fatehpur", Stamp.F_C_WHS);
		createStamp(460, R.string.mahabodhi, R.string.mahabodhi_desc, R.string.india, R.string.asia, 24.696,84.991, 600, 1, "ind_mahabodhi", Stamp.F_C_WHS);
		createStamp(461, R.string.kaziranga, R.string.kaziranga_desc, R.string.india, R.string.asia, 26.660,93.369, 8000, 2, "ind_kaziranga", Stamp.F_N_WHS);
		createStamp(462, R.string.keoladeo, R.string.keoladeo_desc, R.string.india, R.string.asia, 27.165,77.518, 3000, 1, "ind_keoladeo", Stamp.F_N_WHS);
		createStamp(463, R.string.manas, R.string.manas_desc, R.string.india, R.string.asia, 26.780,90.836, 20000, 1, "ind_manas", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(464, R.string.valley_of_flowers, R.string.valley_of_flowers_desc, R.string.india, R.string.asia, 30.768,79.663, 20000, 1, "ind_flowers", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(465, R.string.jim_corbett, R.string.jim_corbett_desc, R.string.india, R.string.asia, 29.541,78.933, 8000, 1, "ind_corbett", Stamp.F_MNT);
		createStamp(466, R.string.kanha, R.string.kanha_desc, R.string.india, R.string.asia, 22.297,80.590, 10000, 1, "ind_kanha", Stamp.FEATURE_OUTDOOR);
		createStamp(467, R.string.bandhavgarh, R.string.bandhavgarh_desc, R.string.india, R.string.asia, 23.661,81.001, 10000, 2, "ind_bandhavgarh", Stamp.FEATURE_OUTDOOR);
		createStamp(468, R.string.gandhi_marine, R.string.gandhi_marine_desc, R.string.india, R.string.asia, 11.571,92.550, 7000, 1, "ind_gandhi_marine", Stamp.FEATURE_OUTDOOR);

		createStamp(469, R.string.jakarta, R.string.jakarta_desc, R.string.indonesia, R.string.asia, -6.168,106.831, 10000, 3, "ino_jakarta", Stamp.F_CAP);
		createStamp(470, R.string.surabaya, R.string.surabaya_desc, R.string.indonesia, R.string.asia, -7.257,112.754, 6000, 1, "ino_surabaya", Stamp.F_CITY);
		createStamp(471, R.string.bandung, R.string.bandung_desc, R.string.indonesia, R.string.asia, -6.915,107.608, 4000, 1, "ino_bandung", Stamp.F_CITY);
		createStamp(472, R.string.medan, R.string.medan_desc, R.string.indonesia, R.string.asia, 3.590,98.670, 4500, 1, "ino_medan", Stamp.F_CITY);
		createStamp(473, R.string.semarang, R.string.semarang_desc, R.string.indonesia, R.string.asia, -6.976,110.418, 4000, 1, "ino_semarang", Stamp.F_CITY);
		createStamp(474, R.string.makassar, R.string.makassar_desc, R.string.indonesia, R.string.asia, -5.136,119.422, 5000, 1, "ino_makassar", Stamp.F_CITY);
		createStamp(475, R.string.borobudur, R.string.borobudur_desc, R.string.indonesia, R.string.asia, -7.608,110.204, 800, 2, "ino_borobudur", Stamp.F_C_WHS);
		createStamp(476, R.string.prambanan, R.string.prambanan_desc, R.string.indonesia, R.string.asia, -7.752,110.492, 800, 1, "ino_prambanan", Stamp.F_C_WHS);
		createStamp(477, R.string.komodo, R.string.komodo_desc, R.string.indonesia, R.string.asia, -8.531,119.479, 5000, 2, "ino_komodo", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(478, R.string.lorentz, R.string.lorentz_desc, R.string.indonesia, R.string.asia, -4.555,138.004, 45000, 1, "ino_lorentz", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(479, R.string.ujung, R.string.ujung_desc, R.string.indonesia, R.string.asia, -6.759,105.344, 8000, 1, "ino_ujung", Stamp.F_N_WHS);
		createStamp(480, R.string.toba, R.string.toba_desc, R.string.indonesia, R.string.asia, 2.603,98.842, 15000, 2, "ino_toba", Stamp.F_MNT);
		createStamp(481, R.string.kerinci, R.string.kerinci_desc, R.string.indonesia, R.string.asia, -2.028,101.334, 20000, 1, "ino_kerinci", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(482, R.string.bunaken, R.string.bunaken_desc, R.string.indonesia, R.string.asia, 1.672,124.739, 7000, 1, "ino_bunaken", Stamp.F_N_WHS);
		createStamp(483, R.string.bromo, R.string.bromo_desc, R.string.indonesia, R.string.asia, -8.041,112.947, 11000, 1, "ino_bromo", Stamp.F_MNT);

		createStamp(484, R.string.tehran, R.string.tehran_desc, R.string.iran, R.string.asia, 35.701,51.424, 8000, 3, "ira_tehran", Stamp.F_CAP | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(485, R.string.isfahan, R.string.isfahan_desc, R.string.iran, R.string.asia, 32.665,51.671, 6000, 2, "ira_isfahan", Stamp.F_CITY | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(486, R.string.mashad, R.string.mashad_desc, R.string.iran, R.string.asia, 36.298,59.608, 8000, 1, "ira_mashad", Stamp.F_CITY);
		createStamp(487, R.string.tabriz, R.string.tabriz_desc, R.string.iran, R.string.asia, 38.074,46.298, 5000, 2, "ira_tabriz", Stamp.F_CITY | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(488, R.string.shiraz, R.string.shiraz_desc, R.string.iran, R.string.asia, 29.612,52.525, 5000, 1, "ira_shiraz", Stamp.F_CITY);
		createStamp(489, R.string.kermanshah, R.string.kermanshah_desc, R.string.iran, R.string.asia, 34.330,47.081, 5000, 1, "ira_kermanshah", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(490, R.string.hamedan, R.string.hamedan_desc, R.string.iran, R.string.asia, 34.799,48.515, 2000, 1, "ira_hamedan", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(491, R.string.qom, R.string.qom_desc, R.string.iran, R.string.asia, 34.644,50.879, 4000, 1, "ira_qom", Stamp.F_CITY);
		createStamp(492, R.string.persepolis, R.string.persepolis_desc, R.string.iran, R.string.asia, 29.935,52.891, 800, 2, "ira_persepolis", Stamp.F_C_WHS);
		createStamp(493, R.string.susa, R.string.susa_desc, R.string.iran, R.string.asia, 32.195,48.254, 1500, 1, "ira_susa", Stamp.FEATURE_SIGHTS);
		createStamp(494, R.string.pasargad, R.string.pasargad_desc, R.string.iran, R.string.asia, 30.203,53.179, 2000, 1, "ira_pasargad", Stamp.F_C_WHS);
		createStamp(495, R.string.bam, R.string.bam_desc, R.string.iran, R.string.asia, 29.106,58.357, 3000, 1, "ira_bam", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(496, R.string.khar_turan, R.string.khar_turan_desc, R.string.iran, R.string.asia, 36.211,55.437, 30000, 2, "ira_khar_turan", Stamp.F_MNT);
		createStamp(497, R.string.kavir, R.string.kavir_desc, R.string.iran, R.string.asia, 34.640,52.399, 20000, 1, "ira_kavir", Stamp.FEATURE_OUTDOOR);
		createStamp(498, R.string.golestan, R.string.golestan_desc, R.string.iran, R.string.asia, 37.527,56.315, 40000, 1, "ira_golestan", Stamp.F_MNT);

		createStamp(499, R.string.baghdad, R.string.baghdad_desc, R.string.iraq, R.string.asia, 33.333,44.397, 8000, 3, "irq_baghdad", Stamp.F_CAP);
		createStamp(500, R.string.mosul, R.string.mosul_desc, R.string.iraq, R.string.asia, 36.343,43.127, 2000, 1, "irq_mosul", Stamp.F_CITY);
		createStamp(501, R.string.erbil, R.string.erbil_desc, R.string.iraq, R.string.asia, 36.191,44.009, 3000, 1, "irq_erbil", Stamp.F_CITY);
		createStamp(502, R.string.kirkuk, R.string.kirkuk_desc, R.string.iraq, R.string.asia, 35.469,44.391, 3000, 1, "irq_kirkuk", Stamp.F_CITY);
		createStamp(503, R.string.hatra, R.string.hatra_desc, R.string.iraq, R.string.asia, 35.587,42.720, 800, 2, "irq_hatra", Stamp.F_CITY);

		createStamp(504, R.string.dublin, R.string.dublin_desc, R.string.ireland, R.string.europe, 53.347,-6.264, 8000, 2, "ire_dublin", Stamp.F_CAP);
		createStamp(505, R.string.cork, R.string.cork_desc, R.string.ireland, R.string.europe, 51.898,-8.473, 2000, 1, "ire_cork", Stamp.F_CITY);
		createStamp(506, R.string.galway, R.string.galway_desc, R.string.ireland, R.string.europe, 53.271,-9.057, 1500, 1, "ire_galway", Stamp.F_CITY);
		createStamp(507, R.string.bru, R.string.bru_desc, R.string.ireland, R.string.europe, 53.695,-6.476, 600, 1, "ire_bru", Stamp.F_C_WHS);
		createStamp(508, R.string.killarney, R.string.killarney_desc, R.string.ireland, R.string.europe, 52.004,-9.55, 4500, 1, "ire_killarney", Stamp.F_MNT);

		createStamp(509, R.string.douglas, R.string.douglas_desc, R.string.isle_of_man, R.string.europe, 54.156,-4.486, 1000, 1, "ima_douglas", Stamp.F_CAP);

		createStamp(510, R.string.kingston, R.string.kingston_desc, R.string.jamaica, R.string.central_america, 18.011,-76.798, 5000, 2, "jam_kingston", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(511, R.string.jerusalem, R.string.jerusalem_desc, R.string.israel, R.string.asia, 31.774,35.203, 2000, 3, "isr_jerusalem", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(512, R.string.tel_aviv, R.string.tel_aviv_desc, R.string.israel, R.string.asia, 32.079,34.780, 3000, 1, "isr_aviv", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(513, R.string.haifa, R.string.haifa_desc, R.string.israel, R.string.asia, 32.804,34.987, 3000, 1, "isr_haifa", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(514, R.string.massada, R.string.massada_desc, R.string.israel, R.string.asia, 31.316,35.354, 700, 2, "isr_massada", Stamp.F_C_WHS);
		createStamp(515, R.string.acre, R.string.acre_desc, R.string.israel, R.string.asia, 32.926,35.075, 1500, 1, "isr_acre", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(516, R.string.avdat, R.string.avdat_desc, R.string.israel, R.string.asia, 30.833,34.771, 1500, 2, "isr_avdat", Stamp.F_MNT);
		createStamp(517, R.string.gedi, R.string.gedi_desc, R.string.israel, R.string.asia, 31.450, 35.383, 1500, 1, "isr_gedi", Stamp.FEATURE_OUTDOOR);

		createStamp(518, R.string.rome, R.string.rome_desc, R.string.italy, R.string.europe, 41.897,12.482, 5000, 3, "ita_rome", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(519, R.string.milan, R.string.milan_desc, R.string.italy, R.string.europe, 45.465,9.187, 5000, 1, "ita_milan", Stamp.F_CITY);
		createStamp(520, R.string.bologna, R.string.bologna_desc, R.string.italy, R.string.europe, 44.494,11.343, 4000, 1, "ita_bologna", Stamp.F_CITY);
		createStamp(521, R.string.florence, R.string.florence_desc, R.string.italy, R.string.europe, 43.775,11.247, 4000, 2, "ita_florence", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(522, R.string.genoa, R.string.genoa_desc, R.string.italy, R.string.europe, 44.406,8.940, 4000, 1, "ita_genoa", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(523, R.string.naples, R.string.naples_desc, R.string.italy, R.string.europe, 40.852,14.268, 4000, 1, "ita_naples", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(524, R.string.pisa, R.string.pisa_desc, R.string.italy, R.string.europe, 43.718,10.400, 2000, 1, "ita_pisa", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(525, R.string.turin, R.string.turin_desc, R.string.italy, R.string.europe, 45.073,7.673, 6000, 1, "ita_turin", Stamp.F_CITY);
		createStamp(526, R.string.venice, R.string.venice_desc, R.string.italy, R.string.europe, 45.437,12.330, 1500, 2, "ita_venice", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(527, R.string.agrigento, R.string.agrigento_desc, R.string.italy, R.string.europe, 37.310,13.583, 2000, 1, "ita_agrigento", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(528, R.string.pompei, R.string.pompei_desc, R.string.italy, R.string.europe, 40.749,14.485, 1000, 2, "ita_pompei", Stamp.F_C_WHS);
		createStamp(529, R.string.assisi, R.string.assisi_desc, R.string.italy, R.string.europe, 43.071,12.614, 1000, 1, "ita_assisi", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(530, R.string.del_monte, R.string.del_monte_desc, R.string.italy, R.string.europe, 41.084,16.271, 8000, 1, "ita_monte", Stamp.F_C_WHS);
		createStamp(531, R.string.verona, R.string.verona_desc, R.string.italy, R.string.europe, 45.439,10.992, 2000, 2, "ita_verona", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(532, R.string.amalfi, R.string.amalfi_desc, R.string.italy, R.string.europe, 40.634,14.603, 1500, 1, "ita_amalfi", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(533, R.string.ravenna, R.string.ravenna_desc, R.string.italy, R.string.europe, 44.418,12.199, 2000, 1, "ita_ravenna", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(534, R.string.siena, R.string.siena_desc, R.string.italy, R.string.europe, 43.325,11.327, 1500, 2, "ita_siena", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(535, R.string.cinque_terre, R.string.cinque_terre_desc, R.string.italy, R.string.europe, 44.107,9.728, 3000, 1, "ita_cinque", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(536, R.string.su_nuraxi, R.string.su_nuraxi_desc, R.string.italy, R.string.europe, 39.708,8.986, 1000, 1, "ita_nuraxi", Stamp.F_C_WHS);
		createStamp(537, R.string.etna, R.string.etna_desc, R.string.italy, R.string.europe, 37.750,14.994, 3000, 2, "ita_etna", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(538, R.string.dolomites, R.string.dolomites_desc, R.string.italy, R.string.europe, 46.181,12.024, 3000, 2, "ita_dolomites", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(539, R.string.gran_paradiso, R.string.gran_paradiso_desc, R.string.italy, R.string.europe, 45.541,7.295, 6000, 1, "ita_paradiso", Stamp.F_MNT);
		createStamp(540, R.string.val_grande, R.string.val_grande_desc, R.string.italy, R.string.europe, 46.039,8.451, 4000, 1, "ita_val_grande", Stamp.F_MNT);
		createStamp(541, R.string.gran_sasso, R.string.gran_sasso_desc, R.string.italy, R.string.europe, 42.490,13.501, 7000, 1, "ita_sasso", Stamp.F_MNT);

		createStamp(542, R.string.tokyo, R.string.tokyo_desc, R.string.japan, R.string.asia, 35.687,139.766, 5000, 3, "jap_tokyo", Stamp.F_CAP);
		createStamp(543, R.string.hiroshima, R.string.hiroshima_desc, R.string.japan, R.string.asia, 34.392,132.454, 4000, 2, "jap_hiroshima", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(544, R.string.kyoto, R.string.kyoto_desc, R.string.japan, R.string.asia, 35.011,135.768, 7000, 2, "jap_kyoto", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(545, R.string.osaka, R.string.osaka_desc, R.string.japan, R.string.asia, 34.695,135.502, 6000, 1, "jap_osaka", Stamp.F_CITY);
		createStamp(546, R.string.saporo, R.string.saporo_desc, R.string.japan, R.string.asia, 43.062,141.357, 5000, 1, "jap_saporo", Stamp.F_CITY);
		createStamp(547, R.string.yokohama, R.string.yokohama_desc, R.string.japan, R.string.asia, 35.444,139.638, 3000, 1, "jap_yokohama", Stamp.F_CITY);
		createStamp(548, R.string.sendai, R.string.sendai_desc, R.string.japan, R.string.asia, 38.266,140.871, 4000, 1, "jap_sendai", Stamp.F_CITY);
		createStamp(549, R.string.kanazawa, R.string.kanazawa_desc, R.string.japan, R.string.asia, 36.561,136.656, 4000, 1, "jap_kanazawa", Stamp.F_CITY);
		createStamp(550, R.string.horyu_ji, R.string.horyu_ji_desc, R.string.japan, R.string.asia, 34.614,135.736, 600, 1, "jap_horyu", Stamp.F_C_WHS);
		createStamp(551, R.string.himeji_jo, R.string.himeji_jo_desc, R.string.japan, R.string.asia, 34.839,134.694, 800, 2, "jap_himeji", Stamp.F_C_WHS);
		createStamp(552, R.string.itsukushima, R.string.itsukushima_desc, R.string.japan, R.string.asia, 34.296,132.320, 400, 1, "jap_itsukushima", Stamp.F_C_WHS);
		createStamp(553, R.string.fuji, R.string.fuji_desc, R.string.japan, R.string.asia, 35.364,138.730, 11000, 2, "jap_fuji", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(554, R.string.shiretoko, R.string.shiretoko_desc, R.string.japan, R.string.asia, 44.186,145.254, 15000, 1, "jap_shiretoko", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(555, R.string.yakushima, R.string.yakushima_desc, R.string.japan, R.string.asia, 30.340,130.531, 10000, 1, "jap_yakushima", Stamp.F_N_WHS);
		createStamp(556, R.string.daisetsuzan, R.string.daisetsuzan_desc, R.string.japan, R.string.asia, 43.612,142.920, 18000, 1, "jap_daisetsuzan", Stamp.F_MNT);
		createStamp(557, R.string.sanriku, R.string.sanriku_desc, R.string.japan, R.string.asia, 39.622,142.010, 4000, 2, "jap_sanriku", Stamp.FEATURE_OUTDOOR);
		createStamp(558, R.string.ogasawara, R.string.ogasawara_desc, R.string.japan, R.string.asia, 27.097,142.213, 6000, 1, "jap_ogasawara", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(559, R.string.joshinetsu, R.string.joshinetsu_desc, R.string.japan, R.string.asia, 36.719,138.641, 8000, 1, "jap_joshinetsu", Stamp.F_MNT);
		createStamp(560, R.string.iriomote, R.string.iriomote_desc, R.string.japan, R.string.asia, 24.341,123.829, 10000, 1, "jap_iriomote", Stamp.FEATURE_OUTDOOR);
		createStamp(561, R.string.yoshino, R.string.yoshino_desc, R.string.japan, R.string.asia, 33.799, 135.940, 8000, 1, "jap_yoshino", Stamp.F_N_WHS);
		createStamp(562, R.string.sanin, R.string.sanin_desc, R.string.japan, R.string.asia, 36.496,136.490, 5000, 1, "jap_sanin", Stamp.FEATURE_OUTDOOR);

		createStamp(563, R.string.saint_helier, R.string.saint_helier_desc, R.string.jersey, R.string.europe, 49.185,-2.107, 1000, 1, "jer_helier", Stamp.F_CAP);

		createStamp(564, R.string.amman, R.string.amman_desc, R.string.jordan, R.string.asia, 31.955,35.946, 5000, 2, "jor_amman", Stamp.F_CAP);
		createStamp(565, R.string.petra, R.string.petra_desc, R.string.jordan, R.string.asia, 30.330,35.442, 1500, 2, "jor_petra", Stamp.F_C_WHS);
		createStamp(566, R.string.jerash, R.string.jerash_desc, R.string.jordan, R.string.asia, 32.281,35.891, 1000, 1, "jor_jerash", Stamp.FEATURE_SIGHTS);
		createStamp(567, R.string.wadi_rum, R.string.wadi_rum_desc, R.string.jordan, R.string.asia, 29.569,35.417, 4000, 1, "jor_wadi", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(568, R.string.kerak, R.string.kerak_desc, R.string.jordan, R.string.asia, 31.181,35.702, 800, 1, "jor_kerak", Stamp.FEATURE_SIGHTS);

		createStamp(569, R.string.astana, R.string.astana_desc, R.string.kazakhstan, R.string.asia, 51.170,71.426, 8000, 2, "kaz_astana", Stamp.F_CAP);
		createStamp(570, R.string.almaty, R.string.almaty_desc, R.string.kazakhstan, R.string.asia, 43.266,76.911, 7000, 1, "kaz_almaty", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(571, R.string.turkestan, R.string.turkestan_desc, R.string.kazakhstan, R.string.asia, 43.299,68.277, 3500, 1, "kaz_turkestan", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(572, R.string.altyn_emel, R.string.altyn_emel_desc, R.string.kazakhstan, R.string.asia, 44.062,78.804, 45000, 2, "kaz_altyn", Stamp.FEATURE_OUTDOOR);
		createStamp(573, R.string.karkaraly, R.string.karkaraly_desc, R.string.kazakhstan, R.string.asia, 49.355,75.387, 10000, 1, "kaz_karkaraly", Stamp.F_MNT);

		createStamp(574, R.string.nairobi, R.string.nairobi_desc, R.string.kenya, R.string.africa, -1.286,36.817, 4000, 2, "ken_nairobi", Stamp.F_CAP);
		createStamp(575, R.string.mombasa, R.string.mombasa_desc, R.string.kenya, R.string.africa, -4.043,39.666, 4500, 1, "ken_mombasa", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(576, R.string.lamu, R.string.lamu_desc, R.string.kenya, R.string.africa, -2.280,40.860, 6000, 1, "ken_lamu", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(577, R.string.mount_kenya, R.string.mount_kenya_desc, R.string.kenya, R.string.africa, -0.152,37.305, 10000, 1, "ken_mount_kenya", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(578, R.string.sibiloi, R.string.sibiloi_desc, R.string.kenya, R.string.africa, 3.983,36.355, 30000, 1, "ken_sibiloi", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(579, R.string.tsavo, R.string.tsavo_desc, R.string.kenya, R.string.africa, -2.754,38.754, 50000, 2, "ken_tsavo", Stamp.FEATURE_OUTDOOR);
		createStamp(580, R.string.amboseli, R.string.amboseli_desc, R.string.kenya, R.string.africa, -2.638,37.257, 6000, 1, "ken_amboseli", Stamp.F_MNT);

		createStamp(581, R.string.phoenix, R.string.phoenix_desc, R.string.kiribati, R.string.australia_continent, -4.454,-171.245, 2500, 1, "kir_phoenix", Stamp.F_N_WHS);

		createStamp(582, R.string.pyongyang, R.string.pyongyang_desc, R.string.korea_north, R.string.asia, 39.036,125.747, 4000, 2, "kon_pyongyang", Stamp.F_CAP);
		createStamp(583, R.string.chilposan, R.string.chilposan_desc, R.string.korea_north, R.string.asia, 41.043, 129.614, 15000, 1, "kon_chilposan", Stamp.F_MNT);
		createStamp(584, R.string.geumgangsan, R.string.geumgangsan_desc, R.string.korea_north, R.string.asia, 38.646,128.128, 10000, 1, "kon_geumgangsan", Stamp.F_MNT);
		createStamp(585, R.string.myohyangsan, R.string.myohyangsan_desc, R.string.korea_north, R.string.asia, 40.019, 126.333, 10000, 1, "kon_myohyangsan", Stamp.F_MNT);

		createStamp(586, R.string.seoul, R.string.seoul_desc, R.string.korea_south, R.string.asia, 37.568,126.979, 6000, 3, "kos_seoul", Stamp.F_CAP | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(587, R.string.busan, R.string.busan_desc, R.string.korea_south, R.string.asia, 35.180,129.076, 3500, 1, "kos_busan", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(588, R.string.suwon, R.string.suwon_desc, R.string.korea_south, R.string.asia, 37.281,127.013, 4000, 1, "kos_suwon", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(589, R.string.hallasan, R.string.hallasan_desc, R.string.korea_south, R.string.asia, 33.369,126.529, 8000, 2, "kos_hallasan", Stamp.F_MNT);
		createStamp(590, R.string.seoraksan, R.string.seoraksan_desc, R.string.korea_south, R.string.asia, 38.125, 128.416, 10000, 1, "kos_seoraksan", Stamp.F_MNT);
		createStamp(591, R.string.hallyeohaesang, R.string.hallyeohaesang_desc, R.string.korea_south, R.string.asia, 34.756,127.977, 4000, 1, "kos_hallyeohaesang", Stamp.FEATURE_OUTDOOR);

		createStamp(592, R.string.kuwait_city, R.string.kuwait_city_desc, R.string.kuwait, R.string.asia, 29.372,47.975, 6000, 2, "kuw_city", Stamp.F_CAP);

		createStamp(593, R.string.bishkek, R.string.bishkek_desc, R.string.kyrgyzstan, R.string.asia, 42.876,74.589, 7000, 2, "kyr_bishkek", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(594, R.string.ala_archa, R.string.ala_archa_desc, R.string.kyrgyzstan, R.string.asia, 42.610,74.487, 5000, 1, "kyr_archa", Stamp.F_MNT);
		createStamp(595, R.string.osh, R.string.osh_desc, R.string.kyrgyzstan, R.string.asia, 40.524,72.803, 4000, 1, "kyr_osh", Stamp.FEATURE_MOUNTAIN | Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(596, R.string.issyk_kul, R.string.issyk_kul_desc, R.string.kyrgyzstan, R.string.asia, 42.184,77.574, 40000, 1, "kyr_issyk", Stamp.F_MNT);

		createStamp(597, R.string.vientiane, R.string.vientiane_desc, R.string.laos, R.string.asia, 17.968,102.620, 3000, 2, "lao_vientiane", Stamp.F_CAP);
		createStamp(598, R.string.luang_prabeng, R.string.luang_prabeng_desc, R.string.laos, R.string.asia, 19.884,102.142, 2000, 1, "lao_prabeng", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(599, R.string.nong_khiaw, R.string.nong_khiaw_desc, R.string.laos, R.string.asia, 14.025,105.872, 5000, 1, "lao_khiaw", Stamp.F_MNT);
		createStamp(600, R.string.si_phan_don, R.string.si_phan_don_desc, R.string.laos, R.string.asia, 20.571,102.612, 5000, 1, "lao_phan", Stamp.FEATURE_OUTDOOR);

		createStamp(601, R.string.riga, R.string.riga_desc, R.string.latvia, R.string.europe, 56.949,24.105, 3000, 2, "lat_riga", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(602, R.string.sigulda, R.string.sigulda_desc, R.string.latvia, R.string.europe, 57.150,24.860, 2000, 1, "lat_sigulda", Stamp.F_CITY);
		createStamp(603, R.string.gauja, R.string.gauja_desc, R.string.latvia, R.string.europe, 57.298,25.115, 10000, 1, "lat_gauja", Stamp.FEATURE_OUTDOOR);

		createStamp(604, R.string.beirut, R.string.beirut_desc, R.string.lebanon, R.string.asia, 33.889,35.495, 4000, 2, "leb_beirut", Stamp.F_CAP);
		createStamp(605, R.string.baalbek, R.string.baalbek_desc, R.string.lebanon, R.string.asia, 34.007,36.204, 1000, 2, "leb_baalbek", Stamp.F_C_WHS);
		createStamp(606, R.string.tyre, R.string.tyre_desc, R.string.lebanon, R.string.asia, 33.268,35.211, 1000, 1, "leb_tyre", Stamp.F_C_WHS | Stamp.F_CITY);

		createStamp(607, R.string.maseru, R.string.maseru_desc, R.string.lesotho, R.string.africa, -29.316,27.494, 2000, 2, "les_maseru", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(608, R.string.sehlabathebe, R.string.sehlabathebe_desc, R.string.lesotho, R.string.africa, -29.888,29.109, 3000, 1, "les_sehlabathebe", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(609, R.string.tsehlanyane, R.string.tsehlanyane_desc, R.string.lesotho, R.string.africa, -29.000,28.486, 7000, 1, "les_tsehlanyane", Stamp.F_N_WHS | Stamp.F_MNT);

		createStamp(610, R.string.monrovia, R.string.monrovia_desc, R.string.liberia, R.string.africa, 6.296,-10.795, 2500, 2, "lib_monrovia", Stamp.F_CAP);
		createStamp(611, R.string.sapo, R.string.sapo_desc, R.string.liberia, R.string.africa, 5.395,-8.469, 8000, 1, "lib_sapo", Stamp.FEATURE_OUTDOOR);

		createStamp(612, R.string.tripoli, R.string.tripoli_desc, R.string.libya, R.string.africa, 32.881,13.180, 4000, 2, "liy_tripoli", Stamp.F_CAP);
		createStamp(613, R.string.cyrene, R.string.cyrene_desc, R.string.libya, R.string.africa, 32.819,21.861, 1000, 1, "liy_cyrene", Stamp.F_C_WHS);
		createStamp(614, R.string.leptis_magna, R.string.leptis_magna_desc, R.string.libya, R.string.africa, 32.637,14.290, 1000, 1, "liy_leptis", Stamp.F_C_WHS);
		createStamp(615, R.string.ghadames, R.string.ghadames_desc, R.string.libya, R.string.africa, 30.129,9.494, 1000, 1, "liy_ghadames", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(616, R.string.el_kouf, R.string.el_kouf_desc, R.string.libya, R.string.africa, 32.743, 21.205, 10000, 1, "liy_kouf", Stamp.FEATURE_OUTDOOR);

		createStamp(617, R.string.vaduz, R.string.vaduz_desc, R.string.liechtenstein, R.string.europe, 47.143,9.520, 1500, 1, "lie_vaduz", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(618, R.string.luxembourg_city, R.string.luxembourg_city_desc, R.string.luxembourg, R.string.europe, 49.612,6.132, 2000, 1, "lux_city", Stamp.F_CAP | Stamp.F_C_WHS);

		createStamp(619, R.string.vilnius, R.string.vilnius_desc, R.string.lithuania, R.string.europe, 54.687,25.280, 3000, 2, "lit_vilnius", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(620, R.string.kaunas, R.string.kaunas_desc, R.string.lithuania, R.string.europe, 54.899,23.903, 5000, 1, "lit_kaunas", Stamp.F_CITY);
		createStamp(621, R.string.curonian_spit, R.string.curonian_spit_desc, R.string.lithuania, R.string.europe, 55.450,21.078, 10000, 1, "lit_spit", Stamp.F_N_WHS);
		createStamp(622, R.string.aukstaitija, R.string.aukstaitija_desc, R.string.lithuania, R.string.europe, 55.399,26.073, 5000, 1, "lit_aukstaitija", Stamp.FEATURE_OUTDOOR);

		createStamp(623, R.string.macau_city, R.string.macau_city_desc, R.string.macau, R.string.asia, 22.188,113.556, 3000, 1, "mac_city", Stamp.F_CAP);

		createStamp(624, R.string.skopje, R.string.skopje_desc, R.string.macedonia, R.string.europe, 41.995,21.432, 4000, 2, "mae_skopje", Stamp.F_CAP);
		createStamp(625, R.string.ohrid, R.string.ohrid_desc, R.string.macedonia, R.string.europe, 41.118,20.801, 2000, 1, "mae_ohrid", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(626, R.string.pelister, R.string.pelister_desc, R.string.macedonia, R.string.europe, 40.995,21.193, 5000, 1, "mae_pelister", Stamp.F_MNT);

		createStamp(627, R.string.antananarivo, R.string.antananarivo_desc, R.string.madagascar, R.string.africa, -18.911,47.532, 2000, 2, "mad_antananarivo", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(628, R.string.masoala, R.string.masoala_desc, R.string.madagascar, R.string.africa, -15.586,50.150, 30000, 1, "mad_masoala", Stamp.FEATURE_OUTDOOR);
		createStamp(629, R.string.bemaraha, R.string.bemaraha_desc, R.string.madagascar, R.string.africa, -18.811,44.784, 10000, 1, "mad_bemaraha", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(630, R.string.marojejy, R.string.marojejy_desc, R.string.madagascar, R.string.africa, -14.423,49.715, 10000, 1, "mad_marojejy", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(631, R.string.isalo, R.string.isalo_desc, R.string.madagascar, R.string.africa, -22.441,45.296, 12000, 1, "mad_isalo", Stamp.F_MNT);

		createStamp(632, R.string.lilongwe, R.string.lilongwe_desc, R.string.malawi, R.string.africa, -13.977,33.786, 7000, 2, "mal_lilongwe", Stamp.F_CAP);
		createStamp(633, R.string.lake_malawi, R.string.lake_malawi_desc, R.string.malawi, R.string.africa, -14.065,34.881, 6000, 1, "mal_lake", Stamp.F_N_WHS);
		createStamp(634, R.string.liwonde, R.string.liwonde_desc, R.string.malawi, R.string.africa, -14.882,35.346, 5000, 1, "mal_liwonde", Stamp.FEATURE_OUTDOOR);

		createStamp(635, R.string.kuala_lumpur, R.string.kuala_lumpur_desc, R.string.malaysia, R.string.asia, 3.149,101.697, 7000, 3, "maa_kuala", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(636, R.string.malacca, R.string.malacca_desc, R.string.malaysia, R.string.asia, 2.196,102.251, 6000, 1, "maa_malacca", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(637, R.string.georgetown_mal, R.string.georgetown_mal_desc, R.string.malaysia, R.string.asia, 5.412,100.334, 3000, 1, "maa_georgetown", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(638, R.string.gunung, R.string.gunung_desc, R.string.malaysia, R.string.asia, 3.951,114.906, 12000, 1, "maa_gunung", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(639, R.string.kinabalu, R.string.kinabalu_desc, R.string.malaysia, R.string.asia, 6.155,116.642, 10000, 2, "maa_kinabalu", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(640, R.string.taman_negara, R.string.taman_negara_desc, R.string.malaysia, R.string.asia, 4.720,102.472, 25000, 1, "maa_taman", Stamp.F_MNT);

		createStamp(641, R.string.male, R.string.male_desc, R.string.maldives, R.string.asia, 4.174,73.510, 1000, 1, "mal_male", Stamp.F_CAP);

		createStamp(642, R.string.bamako, R.string.bamako_desc, R.string.mali, R.string.africa, 12.648,-8.000, 7000, 2, "mai_bamako", Stamp.F_CAP);
		createStamp(643, R.string.djenne, R.string.djenne_desc, R.string.mali, R.string.africa, 13.905,-4.556, 1000, 1, "mai_djenne", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(644, R.string.timbuktu, R.string.timbuktu_desc, R.string.mali, R.string.africa, 16.773,-3.008, 1500, 2, "mai_timbuktu", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(645, R.string.gao, R.string.gao_desc, R.string.mali, R.string.africa, 16.276,-0.050, 3000, 1, "mai_gao", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(646, R.string.bandiagara, R.string.bandiagara_desc, R.string.mali, R.string.africa, 14.349,-3.610, 10000, 1, "mai_bandiagara", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);

		createStamp(647, R.string.valletta, R.string.valletta_desc, R.string.malta, R.string.europe, 35.889,14.494, 2000, 2, "mat_valletta", Stamp.F_CAP | Stamp.F_C_WHS);

		createStamp(648, R.string.majuro, R.string.majuro_desc, R.string.marshall_islands, R.string.australia_continent, 7.090,171.381, 1000, 1, "mar_majuro", Stamp.F_CAP);

		createStamp(649, R.string.fort_de_france, R.string.fort_de_france_desc, R.string.martinique, R.string.central_america, 14.607,-61.073, 2000, 1, "man_fort", Stamp.F_CAP);

		createStamp(650, R.string.nouakchott, R.string.nouakchott_desc, R.string.mauritania, R.string.africa, 18.084,-15.972, 5000, 2, "mau_nouakchott", Stamp.F_CAP);
		createStamp(651, R.string.chinguetti, R.string.chinguetti_desc, R.string.mauritania, R.string.africa, 20.462,-12.366, 2000, 1, "mau_chinguetti", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(652, R.string.arguin, R.string.arguin_desc, R.string.mauritania, R.string.africa, 20.113,-16.252, 25000, 1, "mau_arguin", Stamp.F_N_WHS);

		createStamp(653, R.string.port_louis, R.string.port_louis_desc, R.string.mauritius, R.string.africa, -20.160,57.503, 2500, 1, "mas_louis", Stamp.F_CAP | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);

		createStamp(654, R.string.mamoudzou, R.string.mamoudzou_desc, R.string.mayotte, R.string.africa, -12.781,45.228, 1000, 1, "may_mamoudzou", Stamp.F_CAP);

		createStamp(655, R.string.mexico_city, R.string.mexico_city_desc, R.string.mexico, R.string.central_america, 19.424,-99.133, 8000, 3, "mex_city", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(656, R.string.guadalajara, R.string.guadalajara_desc, R.string.mexico, R.string.central_america, 20.671,-103.345, 6000, 1, "mex_guadalajara", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(657, R.string.monterrey, R.string.monterrey_desc, R.string.mexico, R.string.central_america, 25.685,-100.318, 8000, 1, "mex_monterrey", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(658, R.string.acapulco, R.string.acapulco_desc, R.string.mexico, R.string.central_america, 16.858,-99.893, 5000, 1, "mex_acapulco", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(659, R.string.cancun, R.string.cancun_desc, R.string.mexico, R.string.central_america, 21.164,-86.827, 4500, 1, "mex_cancun", Stamp.F_CITY);
		createStamp(660, R.string.mazatlan, R.string.mazatlan_desc, R.string.mexico, R.string.central_america, 23.235,-106.423, 5000, 1, "mex_mazatlan", Stamp.F_CITY);
		createStamp(661, R.string.san_luis_potosi, R.string.san_luis_potosi_desc, R.string.mexico, R.string.central_america, 22.156,-100.975, 3000, 1, "mex_san_luis", Stamp.F_CITY);
		createStamp(662, R.string.tijuana, R.string.tijuana_desc, R.string.mexico, R.string.central_america, 32.500,-116.967, 5000, 1, "mex_tijuana", Stamp.F_CITY);
		createStamp(663, R.string.chichen_itza, R.string.chichen_itza_desc, R.string.mexico, R.string.central_america, 20.684,-88.568, 1000, 2, "mex_itza", Stamp.F_C_WHS);
		createStamp(664, R.string.coba, R.string.coba_desc, R.string.mexico, R.string.central_america, 20.491,-87.733, 1000, 1, "mex_coba", Stamp.FEATURE_SIGHTS);
		createStamp(665, R.string.el_tajin, R.string.el_tajin_desc, R.string.mexico, R.string.central_america, 20.446,-97.378, 1000, 1, "mex_tajin", Stamp.F_C_WHS);
		createStamp(666, R.string.monte_alban, R.string.monte_alban_desc, R.string.mexico, R.string.central_america, 17.044,-96.768, 800, 1, "mex_alban", Stamp.F_C_WHS);
		createStamp(667, R.string.teotihuacan, R.string.teotihuacan_desc, R.string.mexico, R.string.central_america, 19.692,-98.844, 1000, 2, "mex_teotihuacan", Stamp.F_C_WHS);
		createStamp(668, R.string.uxmal, R.string.uxmal_desc, R.string.mexico, R.string.central_america, 20.360,-89.771, 800, 1, "mex_uxmal", Stamp.F_C_WHS);
		createStamp(669, R.string.xochicalco, R.string.xochicalco_desc, R.string.mexico, R.string.central_america, 18.804,-99.296, 600, 1, "mex_xochicalco", Stamp.F_C_WHS);
		createStamp(670, R.string.morelia, R.string.morelia_desc, R.string.mexico, R.string.central_america, 19.703,-101.198, 3500, 2, "mex_morelia", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(671, R.string.puebla, R.string.puebla_desc, R.string.mexico, R.string.central_america, 19.041,-98.206, 4000, 1, "mex_puebla", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(672, R.string.palenque, R.string.palenque_desc, R.string.mexico, R.string.central_america, 17.524,-91.993, 3000, 1, "mex_palenque", Stamp.F_C_WHS);
		createStamp(673, R.string.san_miguel, R.string.san_miguel_desc, R.string.mexico, R.string.central_america, 20.914,-100.746, 2500, 2, "mex_miguel", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(674, R.string.monarch_butterfly, R.string.monarch_butterfly_desc, R.string.mexico, R.string.central_america, 19.603,-100.300, 8000, 2, "mex_monarch", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(675, R.string.el_pinacate, R.string.el_pinacate_desc, R.string.mexico, R.string.central_america, 32.012,-114.338, 30000, 1, "mex_pinacate", Stamp.F_N_WHS);
		createStamp(676, R.string.sumidero, R.string.sumidero_desc, R.string.mexico, R.string.central_america, 16.850,-93.079, 8000, 2, "mex_sumidero", Stamp.F_MNT);
		createStamp(677, R.string.cacahuamilpa, R.string.cacahuamilpa_desc, R.string.mexico, R.string.central_america, 18.662,-99.510, 2000, 1, "mex_cacahuamilpa", Stamp.F_MNT);
		createStamp(678, R.string.basaseachic, R.string.basaseachic_desc, R.string.mexico, R.string.central_america, 28.108,-108.279, 10000, 1, "mex_basaseachic", Stamp.F_MNT);

		createStamp(679, R.string.pohnpei, R.string.pohnpei_desc, R.string.micronesia, R.string.australia_continent, 6.890,158.232, 12000, 1, "mic_pohnpei", Stamp.F_MNT);

		createStamp(680, R.string.monaco_city, R.string.monaco_city_desc, R.string.monaco, R.string.europe, 43.731,7.425, 600, 1, "mon_city", Stamp.F_CAP);

		createStamp(681, R.string.chisinau, R.string.chisinau_desc, R.string.moldova, R.string.europe, 47.028,28.842, 4500, 2, "mol_chisinau", Stamp.F_CAP);
		createStamp(682, R.string.soroca, R.string.soroca_desc, R.string.moldova, R.string.europe, 48.1613,28.305, 1000, 1, "mol_soroca", Stamp.F_CITY);

		createStamp(683, R.string.ulaanbaatar, R.string.ulaanbaatar_desc, R.string.mongolia, R.string.asia, 47.922,106.906, 5000, 2, "mog_ulaanbaatar", Stamp.F_CAP);
		createStamp(684, R.string.karakorum, R.string.karakorum_desc, R.string.mongolia, R.string.asia, 47.199,102.833, 2000, 1, "mog_karakorum", Stamp.F_C_WHS);
		createStamp(685, R.string.altai_tavan, R.string.altai_tavan_desc, R.string.mongolia, R.string.asia, 48.471,88.722, 25000, 2, "mog_tavan", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(686, R.string.uvs_nuur, R.string.uvs_nuur_desc, R.string.mongolia, R.string.asia, 50.430,92.400, 30000, 1, "mog_uvs", Stamp.F_N_WHS);
		createStamp(688, R.string.gorkhi_terelj, R.string.gorkhi_terelj_desc, R.string.mongolia, R.string.asia, 48.320,107.747, 35000, 1, "mog_terelj", Stamp.F_MNT);
		createStamp(689, R.string.khustain_nuruu, R.string.khustain_nuruu_desc, R.string.mongolia, R.string.asia, 47.674,105.888, 12000, 1, "mog_khustain", Stamp.FEATURE_OUTDOOR);
		createStamp(690, R.string.gobi_gurvan, R.string.gobi_gurvan_desc, R.string.mongolia, R.string.asia, 43.763,101.430, 40000, 1, "mog_gurvan", Stamp.FEATURE_OUTDOOR);

		createStamp(687, R.string.podgorica, R.string.podgorica_desc, R.string.montenegro, R.string.europe, 42.442,19.267, 2500, 2, "mot_podgorica", Stamp.F_CAP);
		createStamp(691, R.string.kotor, R.string.kotor_desc, R.string.montenegro, R.string.europe, 42.425,18.771, 500, 1, "mot_kotor", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(692, R.string.durmitor, R.string.durmitor_desc, R.string.montenegro, R.string.europe, 43.131,19.045, 6000, 1, "mot_durmitor", Stamp.F_N_WHS | Stamp.F_MNT);

		createStamp(693, R.string.brades, R.string.brades_desc, R.string.montserrat, R.string.central_america, 16.793,-62.211, 1000, 1, "mos_brades", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(694, R.string.rabat, R.string.rabat_desc, R.string.morocco, R.string.africa, 34.018,-6.833, 8000, 2, "mor_rabat", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(695, R.string.casablanca, R.string.casablanca_desc, R.string.morocco, R.string.africa, 33.592,-7.618, 9000, 1, "mor_casablanca", Stamp.F_CITY);
		createStamp(696, R.string.fez, R.string.fez_desc, R.string.morocco, R.string.africa, 34.035,-4.999, 2500, 2, "mor_fez", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(697, R.string.marrakech, R.string.marrakech_desc, R.string.morocco, R.string.africa, 31.634,-8.000, 5000, 2, "mor_marrakech", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(698, R.string.tangier, R.string.tangier_desc, R.string.morocco, R.string.africa, 35.772,-5.815, 3500, 1, "mor_tangier", Stamp.F_CITY);
		createStamp(699, R.string.volubilis, R.string.volubilis_desc, R.string.morocco, R.string.africa, 34.074,-5.554, 600, 1, "mor_volubilis", Stamp.F_C_WHS);
		createStamp(700, R.string.ait_ben_hadou, R.string.ait_ben_hadou_desc, R.string.morocco, R.string.africa, 31.047,-7.130, 800, 1, "mor_hadou", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(701, R.string.haut_atlas, R.string.haut_atlas_desc, R.string.morocco, R.string.africa, 33.413,-5.519, 3000, 1, "mor_atlas", Stamp.F_MNT);
		createStamp(702, R.string.essaouira, R.string.essaouira_desc, R.string.morocco, R.string.africa, 31.514,-9.770, 2000, 1, "mor_essaouira", Stamp.F_CITY | Stamp.F_C_WHS);

		createStamp(703, R.string.maputo, R.string.maputo_desc, R.string.mozambique, R.string.africa, -25.973,32.594, 8000, 2, "moz_maputo", Stamp.F_CAP);
		createStamp(704, R.string.isle_of_mozambique, R.string.isle_of_mozambique_desc, R.string.mozambique, R.string.africa, -15.036,40.733, 1000, 1, "moz_mozambique", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(705, R.string.bazaruto, R.string.bazaruto_desc, R.string.mozambique, R.string.africa, -21.648,35.469, 8000, 1, "moz_bazaruto", Stamp.FEATURE_OUTDOOR);
		createStamp(706, R.string.gorongosa, R.string.gorongosa_desc, R.string.mozambique, R.string.africa, -18.788,34.476, 30000, 1, "moz_gorongosa", Stamp.F_MNT);
		createStamp(707, R.string.quirimbas, R.string.quirimbas_desc, R.string.mozambique, R.string.africa, -12.119,40.423, 8000, 1, "moz_quirimbas", Stamp.FEATURE_OUTDOOR);

		createStamp(708, R.string.naypyidaw, R.string.naypyidaw_desc, R.string.myanmar, R.string.asia, 19.738,96.113, 5000, 2, "mya_naypyidaw", Stamp.F_CAP);
		createStamp(709, R.string.yangon, R.string.yangon_desc, R.string.myanmar, R.string.asia, 16.813,96.191, 10000, 2, "mya_yangon", Stamp.F_CITY);
		createStamp(710, R.string.mandalay, R.string.mandalay_desc, R.string.myanmar, R.string.asia, 21.939,96.080, 7000, 2, "mya_mandalay", Stamp.F_CITY);
		createStamp(711, R.string.bagan, R.string.bagan_desc, R.string.myanmar, R.string.asia, 21.172,94.860, 2000, 1, "mya_bagan", Stamp.FEATURE_SIGHTS);
		createStamp(712, R.string.inle, R.string.inle_desc, R.string.myanmar, R.string.asia, 20.520,96.915, 3000, 1, "mya_inle", Stamp.FEATURE_OUTDOOR);
		createStamp(713, R.string.popa, R.string.popa_desc, R.string.myanmar, R.string.asia, 20.902,95.246, 5000, 1, "mya_popa", Stamp.FEATURE_SIGHTS | Stamp.FEATURE_MOUNTAIN);
		createStamp(714, R.string.alaungdaw, R.string.alaungdaw_desc, R.string.myanmar, R.string.asia, 23.600, 95.533, 3000, 1, "mya_alaungdaw", Stamp.FEATURE_OUTDOOR);

		createStamp(715, R.string.windhoek, R.string.windhoek_desc, R.string.namibia, R.string.africa, -22.572,17.082, 4000, 2, "nam_windhoek", Stamp.F_CAP);
		createStamp(716, R.string.luderitz, R.string.luderitz_desc, R.string.namibia, R.string.africa, -26.644,15.155, 600, 1, "nam_luderitz", Stamp.F_CITY);
		createStamp(717, R.string.etosha, R.string.etosha_desc, R.string.namibia, R.string.africa, -19.010,16.001, 50000, 1, "nam_etosha", Stamp.FEATURE_OUTDOOR);
		createStamp(718, R.string.waterberg, R.string.waterberg_desc, R.string.namibia, R.string.africa, -20.354,17.341, 10000, 1, "nam_waterberg", Stamp.F_MNT);
		createStamp(719, R.string.fish_river, R.string.fish_river_desc, R.string.namibia, R.string.africa, -27.550,17.598, 15000, 2, "nam_fish", Stamp.F_MNT);
		createStamp(720, R.string.namib, R.string.namib_desc, R.string.namibia, R.string.africa, -23.277,15.094, 50000, 1, "nam_namib", Stamp.F_N_WHS);

		createStamp(721, R.string.nauru_island, R.string.nauru_island_desc, R.string.nauru, R.string.australia_continent, -0.527508,166.934581, 3000, 1, "nau_nauru", Stamp.FEATURE_OUTDOOR);

		createStamp(723, R.string.kathmandu, R.string.kathmandu_desc, R.string.nepal, R.string.asia, 27.712,85.328, 5000, 2, "nep_kathmandu", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(724, R.string.janakpur, R.string.janakpur_desc, R.string.nepal, R.string.asia, 26.731,85.925, 1000, 1, "nep_janakpur", Stamp.F_CITY);
		createStamp(725, R.string.pokhara, R.string.pokhara_desc, R.string.nepal, R.string.asia, 28.210,83.986, 3000, 1, "nep_pokhara", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(726, R.string.chitwan, R.string.chitwan_desc, R.string.nepal, R.string.asia, 27.461,84.665, 15000, 1, "nep_chitwan", Stamp.F_N_WHS);
		createStamp(727, R.string.sagarmatha, R.string.sagarmatha_desc, R.string.nepal, R.string.asia, 27.913,86.727, 16000, 2, "nep_sagarmatha", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(722, R.string.bardiya, R.string.bardiya_desc, R.string.nepal, R.string.asia, 28.373,81.531, 10000, 1, "nep_bardiya", Stamp.FEATURE_OUTDOOR);

		createStamp(728, R.string.amsterdam, R.string.amsterdam_desc, R.string.netherlands, R.string.europe, 52.371,4.897, 2500, 3, "net_amsterdam", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(729, R.string.rotterdam, R.string.rotterdam_desc, R.string.netherlands, R.string.europe, 51.924,4.477, 2500, 1, "net_rotterdam", Stamp.F_CITY);
		createStamp(730, R.string.hague, R.string.hague_desc, R.string.netherlands, R.string.europe, 52.071,4.301, 4500, 1, "net_hague", Stamp.F_CITY);
		createStamp(731, R.string.kinderdijk, R.string.kinderdijk_desc, R.string.netherlands, R.string.europe, 51.884,4.633, 600, 2, "net_kinderdijk", Stamp.F_C_WHS);
		createStamp(732, R.string.keukenhof, R.string.keukenhof_desc, R.string.netherlands, R.string.europe, 52.267,4.544, 600, 1, "net_keukenhof", Stamp.FEATURE_OUTDOOR);

		createStamp(733, R.string.wellington, R.string.wellington_desc, R.string.new_zealand, R.string.australia_continent, -41.286,174.776, 4000, 2, "new_wellington", Stamp.F_CAP);
		createStamp(734, R.string.auckland, R.string.auckland_desc, R.string.new_zealand, R.string.australia_continent, -36.861,174.760, 9000, 1, "new_auckland", Stamp.F_CITY);
		createStamp(735, R.string.abel_tasman, R.string.abel_tasman_desc, R.string.new_zealand, R.string.australia_continent, -40.936,172.973, 6000, 1, "new_abel", Stamp.FEATURE_OUTDOOR);
		createStamp(736, R.string.aoraki, R.string.aoraki_desc, R.string.new_zealand, R.string.australia_continent, -43.597,170.263, 6000, 1, "new_aoraki", Stamp.F_MNT);
		createStamp(737, R.string.tongariro, R.string.tongariro_desc, R.string.new_zealand, R.string.australia_continent, -39.273,175.579, 15000, 2, "new_tongariro", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(738, R.string.arthurs_pass, R.string.arthurs_pass_desc, R.string.new_zealand, R.string.australia_continent, -42.883,171.712, 12000, 1, "new_arthurs", Stamp.F_MNT);

		createStamp(739, R.string.managua, R.string.managua_desc, R.string.nicaragua, R.string.central_america, 12.144,-86.259, 6000, 2, "nic_managua", Stamp.F_CAP);
		createStamp(740, R.string.leon, R.string.leon_desc, R.string.nicaragua, R.string.central_america, 12.435,-86.878, 3000, 1, "nic_leon", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(741, R.string.apoyo, R.string.apoyo_desc, R.string.nicaragua, R.string.central_america, 11.924,-86.034, 3500, 1, "nic_apoyo", Stamp.FEATURE_OUTDOOR);
		createStamp(742, R.string.somoto, R.string.somoto_desc, R.string.nicaragua, R.string.central_america, 13.462,-86.700, 1000, 1, "nic_somoto", Stamp.F_MNT);

		createStamp(743, R.string.niamey, R.string.niamey_desc, R.string.niger, R.string.africa, 13.522,2.111, 4000, 2, "nig_niamey", Stamp.F_CAP);
		createStamp(744, R.string.agadez, R.string.agadez_desc, R.string.niger, R.string.africa, 16.973,7.983, 3000, 1, "nig_agadez", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(745, R.string.zinder, R.string.zinder_desc, R.string.niger, R.string.africa, 13.807,8.986, 2500, 1, "nig_zinder", Stamp.F_CITY);

		createStamp(746, R.string.lagos, R.string.lagos_desc, R.string.nigeria, R.string.africa, 6.461,3.383, 10000, 2, "nie_lagos", Stamp.F_CITY);
		createStamp(747, R.string.ibadan, R.string.ibadan_desc, R.string.nigeria, R.string.africa, 7.399,3.909, 10000, 1, "nie_ibadan", Stamp.F_CITY);
		createStamp(748, R.string.port_harcourt, R.string.port_harcourt_desc, R.string.nigeria, R.string.africa, 4.811,7.017, 5000, 1, "nie_harcourt", Stamp.F_CITY);
		createStamp(749, R.string.benin_city, R.string.benin_city_desc, R.string.nigeria, R.string.africa, 6.333,5.623, 6000, 1, "nie_benin", Stamp.F_CITY);
		createStamp(750, R.string.abuja, R.string.abuja_desc, R.string.nigeria, R.string.africa, 9.060,7.490, 4000, 2, "nie_abuja", Stamp.F_CAP);
		createStamp(751, R.string.osogbo, R.string.osogbo_desc, R.string.nigeria, R.string.africa, 7.757,4.552, 800, 1, "nie_osogbo", Stamp.F_C_WHS);
		createStamp(752, R.string.kainji, R.string.kainji_desc, R.string.nigeria, R.string.africa, 10.069,4.107, 26000, 1, "nie_kainji", Stamp.FEATURE_OUTDOOR);
		createStamp(753, R.string.yankari, R.string.yankari_desc, R.string.nigeria, R.string.africa, 9.844,10.514, 25000, 2, "nie_yankari", Stamp.FEATURE_OUTDOOR);
		createStamp(754, R.string.kamuku, R.string.kamuku_desc, R.string.nigeria, R.string.africa, 10.804,6.302, 10000, 1, "nie_kamuku", Stamp.FEATURE_OUTDOOR);

		createStamp(755, R.string.alofi, R.string.alofi_desc, R.string.niue, R.string.australia_continent, -19.054,-169.918, 2500, 1, "niu_alofi", Stamp.F_CAP);

		createStamp(756, R.string.kingston_nor, R.string.kingston_nor_desc, R.string.norfolk_island, R.string.australia_continent, -29.058,167.962, 1500, 1, "nof_kingston", Stamp.F_CAP);

		createStamp(757, R.string.saipan, R.string.saipan_desc, R.string.northern_mariana_islands, R.string.australia_continent, 15.186,145.746, 5000, 1, "nom_saipan", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(758, R.string.oslo, R.string.oslo_desc, R.string.norway, R.string.europe, 59.914,10.752, 3000, 2, "nor_oslo", Stamp.F_CAP);
		createStamp(759, R.string.bergen, R.string.bergen_desc, R.string.norway, R.string.europe, 60.390,5.324, 1500, 1, "nor_bergen", Stamp.F_CITY | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(760, R.string.stavanger, R.string.stavanger_desc, R.string.norway, R.string.europe, 58.966,5.733, 2500, 1, "nor_stavanger", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(761, R.string.trondheim, R.string.trondheim_desc, R.string.norway, R.string.europe, 63.433,10.391, 2500, 1, "nor_trondheim", Stamp.F_CITY);
		createStamp(762, R.string.jostedalsbreen, R.string.jostedalsbreen_desc, R.string.norway, R.string.europe, 61.659,7.036, 12000, 2, "nor_jostedalsbreen", Stamp.F_MNT);
		createStamp(763, R.string.nordkapp, R.string.nordkapp_desc, R.string.norway, R.string.europe, 71.171,25.784, 600, 1, "nor_nordkapp", Stamp.F_MNT);
		createStamp(764, R.string.rondane, R.string.rondane_desc, R.string.norway, R.string.europe, 61.970,9.733, 12000, 1, "nor_rondane", Stamp.F_MNT);
		createStamp(765, R.string.jotunheimen, R.string.jotunheimen_desc, R.string.norway, R.string.europe, 61.537,8.521, 10000, 2, "nor_jotunheimen", Stamp.F_MNT);

		createStamp(766, R.string.muscat, R.string.muscat_desc, R.string.oman, R.string.asia, 23.610,58.540, 6000, 2, "oma_muscat", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);
		createStamp(767, R.string.bahla, R.string.bahla_desc, R.string.oman, R.string.asia, 22.964,57.300, 2000, 1, "oma_bahla", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(768, R.string.masirah, R.string.masirah_desc, R.string.oman, R.string.asia, 20.311,58.716, 6000, 1, "oma_masirah", Stamp.FEATURE_OUTDOOR);

		createStamp(769, R.string.islamabad, R.string.islamabad_desc, R.string.pakistan, R.string.asia, 33.710,73.057, 6000, 2, "pak_islamabad", Stamp.F_CAP);
		createStamp(770, R.string.karachi, R.string.karachi_desc, R.string.pakistan, R.string.asia, 24.847,67.007, 15000, 2, "pak_karachi", Stamp.F_CITY);
		createStamp(771, R.string.lahore, R.string.lahore_desc, R.string.pakistan, R.string.asia, 31.519,74.328, 10000, 1, "pak_lahore", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(772, R.string.multan, R.string.multan_desc, R.string.pakistan, R.string.asia, 30.196,71.479, 5000, 1, "pak_multan", Stamp.F_CITY);
		createStamp(773, R.string.peshawar, R.string.peshawar_desc, R.string.pakistan, R.string.asia, 34.008,71.569, 3000, 1, "pak_peshawar", Stamp.F_CITY);
		createStamp(774, R.string.moenjodaro, R.string.moenjodaro_desc, R.string.pakistan, R.string.asia, 27.324,68.136, 800, 2, "pak_moenjodaro", Stamp.F_C_WHS);
		createStamp(775, R.string.makli, R.string.makli_desc, R.string.pakistan, R.string.asia, 24.766,67.900, 2000, 1, "pak_makli", Stamp.F_C_WHS);
		createStamp(776, R.string.taxila, R.string.taxila_desc, R.string.pakistan, R.string.asia, 33.777,72.875, 1500, 1, "pak_taxila", Stamp.F_C_WHS);
		createStamp(777, R.string.central_karakoram, R.string.central_karakoram_desc, R.string.pakistan, R.string.asia, 36.020,75.533, 60000, 2, "pak_karakoram", Stamp.F_MNT);
		createStamp(778, R.string.deosai, R.string.deosai_desc, R.string.pakistan, R.string.asia, 34.971,75.400, 12000, 1, "pak_deosai", Stamp.F_MNT);
		createStamp(779, R.string.hingol, R.string.hingol_desc, R.string.pakistan, R.string.asia, 25.684,65.525, 25000, 1, "pak_hingol", Stamp.F_MNT);
		createStamp(780, R.string.lulusar, R.string.lulusar_desc, R.string.pakistan, R.string.asia, 35.083,74.005, 5000, 1, "pak_lulusar", Stamp.F_MNT);

		createStamp(781, R.string.koror, R.string.koror_desc, R.string.palau, R.string.australia_continent, 7.343,134.480, 1500, 1, "pal_koror", Stamp.F_CITY);

		createStamp(782, R.string.bethlehem, R.string.bethlehem_desc, R.string.palestine, R.string.asia, 31.707,35.198, 1500, 1, "pae_bethlehem", Stamp.F_CITY | Stamp.F_C_WHS);

		createStamp(783, R.string.panama_city, R.string.panama_city_desc, R.string.panama, R.string.central_america, 8.992,-79.521, 6000, 2, "pan_panama", Stamp.F_CAP);
		createStamp(784, R.string.san_lorenzo, R.string.san_lorenzo_desc, R.string.panama, R.string.central_america, 9.554,-79.656, 600, 1, "pan_lorenzo", Stamp.F_C_WHS);
		createStamp(785, R.string.coiba, R.string.coiba_desc, R.string.panama, R.string.central_america, 7.484,-81.776, 12000, 1, "pan_coiba", Stamp.F_N_WHS);
		createStamp(786, R.string.chiriqui, R.string.chiriqui_desc, R.string.panama, R.string.central_america, 8.111,-82.343, 3000, 1, "pan_chiriqui", Stamp.FEATURE_OUTDOOR);
		createStamp(787, R.string.baru, R.string.baru_desc, R.string.panama, R.string.central_america, 8.804,-82.538, 3000, 1, "pan_baru", Stamp.F_MNT);

		createStamp(788, R.string.port_moresby, R.string.port_moresby_desc, R.string.papua_new_guinea, R.string.australia_continent, -9.475,147.175, 5000, 2, "pap_moresby", Stamp.F_CAP);
		createStamp(789, R.string.lae, R.string.lae_desc, R.string.papua_new_guinea, R.string.australia_continent, -6.724,146.993, 2000, 1, "pap_lae", Stamp.F_CITY);
		createStamp(790, R.string.madang, R.string.madang_desc, R.string.papua_new_guinea, R.string.australia_continent, -5.228,145.798, 3000, 1, "pap_madang", Stamp.F_CITY);
		createStamp(791, R.string.rabaul, R.string.rabaul_desc, R.string.papua_new_guinea, R.string.australia_continent, -4.199,152.171, 1500, 1, "pap_rabaul", Stamp.F_CITY);

		createStamp(792, R.string.asuncion, R.string.asuncion_desc, R.string.paraguay, R.string.south_america, -25.296,-57.639, 6000, 2, "par_asuncion", Stamp.F_CAP);
		createStamp(793, R.string.jesus_tavarangue, R.string.jesus_tavarangue_desc, R.string.paraguay, R.string.south_america, -27.132,-55.702, 1000, 1, "par_tavarangue", Stamp.F_C_WHS);
		createStamp(794, R.string.cerro_cora, R.string.cerro_cora_desc, R.string.paraguay, R.string.south_america, -22.636,-56.208, 5000, 1, "par_cora", Stamp.FEATURE_OUTDOOR);
		createStamp(795, R.string.nacunday, R.string.nacunday_desc, R.string.paraguay, R.string.south_america, -26.050,-54.706, 2000, 1, "par_nacunday", Stamp.FEATURE_OUTDOOR);

		createStamp(796, R.string.lima, R.string.lima_desc, R.string.peru, R.string.south_america, -12.044,-77.042, 12000, 3, "per_lima", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(797, R.string.chan_chan, R.string.chan_chan_desc, R.string.peru, R.string.south_america, -8.106,-79.075, 1000, 1, "per_chan", Stamp.F_C_WHS);
		createStamp(798, R.string.chavin, R.string.chavin_desc, R.string.peru, R.string.south_america, -9.594,-77.178, 600, 1, "per_chavin", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(799, R.string.cuzco, R.string.cuzco_desc, R.string.peru, R.string.south_america, -13.525,-71.968, 4000, 2, "per_cuzco", Stamp.F_CITY | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(800, R.string.arequipa, R.string.arequipa_desc, R.string.peru, R.string.south_america, -16.397,-71.537, 3000, 1, "per_arequipa", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(801, R.string.caral_supe, R.string.caral_supe_desc, R.string.peru, R.string.south_america, -10.881,-77.540, 1500, 1, "per_caral", Stamp.F_C_WHS);
		createStamp(802, R.string.machu_picchu, R.string.machu_picchu_desc, R.string.peru, R.string.south_america, -13.164,-72.546, 600, 2, "per_picchu", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(803, R.string.huascaran, R.string.huascaran_desc, R.string.peru, R.string.south_america, -9.315,-77.356, 10000, 2, "per_huascaran", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(804, R.string.manu, R.string.manu_desc, R.string.peru, R.string.south_america, -12.055,-71.720, 45000, 1, "per_manu", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(805, R.string.rio_abiseo, R.string.rio_abiseo_desc, R.string.peru, R.string.south_america, -7.716,-77.231, 30000, 1, "per_abiseo", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(806, R.string.cutervo, R.string.cutervo_desc, R.string.peru, R.string.south_america, -6.149,-78.713, 4000, 1, "per_cutervo", Stamp.F_MNT);

		createStamp(807, R.string.manila, R.string.manila_desc, R.string.philippines, R.string.asia, 14.593,120.980, 4000, 2, "phi_manila", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(808, R.string.cebu, R.string.cebu_desc, R.string.philippines, R.string.asia, 10.309,123.893, 2000, 1, "phi_cebu", Stamp.F_CITY);
		createStamp(809, R.string.davao, R.string.davao_desc, R.string.philippines, R.string.asia, 7.074,125.607, 5000, 1, "phi_davao", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(810, R.string.vigan, R.string.vigan_desc, R.string.philippines, R.string.asia, 17.571,120.386, 1000, 1, "phi_vigan", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(811, R.string.banaue, R.string.banaue_desc, R.string.philippines, R.string.asia, 16.924,121.056, 2000, 2, "phi_banaue", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(812, R.string.batangas, R.string.batangas_desc, R.string.philippines, R.string.asia, 13.751,121.053, 4000, 1, "phi_batangas", Stamp.F_MNT);
		createStamp(813, R.string.coron, R.string.coron_desc, R.string.philippines, R.string.asia, 11.998,120.204, 1000, 1, "phi_coron", Stamp.FEATURE_OUTDOOR);
		createStamp(814, R.string.puerto_princesa, R.string.puerto_princesa_desc, R.string.philippines, R.string.asia, 10.178,118.936, 6000, 2, "phi_princesa", Stamp.F_N_WHS);
		createStamp(815, R.string.pagsanjan, R.string.pagsanjan_desc, R.string.philippines, R.string.asia, 14.262,121.500, 1000, 1, "phi_pagsanjan", Stamp.F_MNT);

		createStamp(816, R.string.adamstown, R.string.adamstown_desc, R.string.pitcairn, R.string.australia_continent, -25.066,-130.101, 800, 1, "pit_adamstown", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(817, R.string.warsaw, R.string.warsaw_desc, R.string.poland, R.string.europe, 52.229,21.012, 6000, 2, "pol_warsaw", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(818, R.string.krakow, R.string.krakow_desc, R.string.poland, R.string.europe, 50.062,19.940, 3000, 2, "pol_krakow", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(819, R.string.lodz, R.string.lodz_desc, R.string.poland, R.string.europe, 51.759,19.456, 4500, 1, "pol_lodz", Stamp.F_CITY);
		createStamp(820, R.string.wroclaw, R.string.wroclaw_desc, R.string.poland, R.string.europe, 51.110,17.033, 4000, 1, "pol_wroclaw", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(821, R.string.oswiecim, R.string.oswiecim_desc, R.string.poland, R.string.europe, 50.027,19.202, 1000, 1, "pol_oswiecim", Stamp.F_C_WHS);
		createStamp(822, R.string.malbork, R.string.malbork_desc, R.string.poland, R.string.europe, 54.040,19.028, 1000, 2, "pol_malbork", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(823, R.string.torun, R.string.torun_desc, R.string.poland, R.string.europe, 53.017,18.606, 4000, 1, "pol_torun", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(824, R.string.slowinski, R.string.slowinski_desc, R.string.poland, R.string.europe, 54.726,17.279, 8000, 1, "pol_slowinski", Stamp.FEATURE_OUTDOOR);
		createStamp(825, R.string.wielkopolski, R.string.wielkopolski_desc, R.string.poland, R.string.europe, 52.268,16.813, 2500, 1, "pol_wielkopolski", Stamp.FEATURE_OUTDOOR);

		createStamp(826, R.string.lisbon, R.string.lisbon_desc, R.string.portugal, R.string.europe, 38.721,-9.140, 5000, 2, "por_lisbon", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(827, R.string.porto, R.string.porto_desc, R.string.portugal, R.string.europe, 41.158,-8.629, 2000, 2, "por_porto", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(828, R.string.funchal, R.string.funchal_desc, R.string.portugal, R.string.europe, 32.650,-16.919, 3000, 1, "por_funchal", Stamp.F_CITY);
		createStamp(829, R.string.angra, R.string.angra_desc, R.string.portugal, R.string.europe, 38.656,-27.216, 2000, 1, "por_angra", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(830, R.string.sintra, R.string.sintra_desc, R.string.portugal, R.string.europe, 38.798,-9.391, 2000, 1, "por_sintra", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(831, R.string.evora, R.string.evora_desc, R.string.portugal, R.string.europe, 38.571,-7.909, 1000, 1, "por_evora", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(832, R.string.estrela, R.string.estrela_desc, R.string.portugal, R.string.europe, 40.372,-7.584, 6000, 1, "por_estrela", Stamp.F_MNT);

		createStamp(833, R.string.san_juan, R.string.san_juan_desc, R.string.puerto_rico, R.string.central_america, 18.442,-66.063, 4000, 2, "pue_juan", Stamp.F_CAP | Stamp.F_C_WHS);

		createStamp(834, R.string.doha, R.string.doha_desc, R.string.qatar, R.string.asia, 25.291,51.524, 6000, 2, "qat_doha", Stamp.F_CAP);

		createStamp(835, R.string.bucharest, R.string.bucharest_desc, R.string.romania, R.string.europe, 44.432,26.103, 4500, 2, "rom_bucharest", Stamp.F_CAP);
		createStamp(836, R.string.sighisoara, R.string.sighisoara_desc, R.string.romania, R.string.europe, 46.220,24.788, 1000, 1, "rom_sighisoara", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(837, R.string.sibiu, R.string.sibiu_desc, R.string.romania, R.string.europe, 45.793,24.146, 2000, 1, "rom_sibiu", Stamp.F_CITY);
		createStamp(838, R.string.horezu, R.string.horezu_desc, R.string.romania, R.string.europe, 45.160,23.995, 600, 1, "rom_horezu", Stamp.F_C_WHS);
		createStamp(839, R.string.danube_delta, R.string.danube_delta_desc, R.string.romania, R.string.europe, 45.202,29.348, 28000, 2, "rom_delta", Stamp.F_N_WHS);
		createStamp(840, R.string.ceahlau, R.string.ceahlau_desc, R.string.romania, R.string.europe, 46.961,25.940, 3000, 1, "rom_ceahlau", Stamp.F_MNT);
		createStamp(841, R.string.retezat, R.string.retezat_desc, R.string.romania, R.string.europe, 45.342,22.821, 7000, 1, "rom_retezat", Stamp.F_MNT);

		createStamp(842, R.string.moscow, R.string.moscow_desc, R.string.russian_federation, R.string.europe, 55.755,37.619, 5000, 3, "rus_moscow", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(843, R.string.saint_petersburg, R.string.saint_petersburg_desc, R.string.russian_federation, R.string.europe, 59.942,30.310, 10000, 2, "rus_petersburg", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(844, R.string.novosibirsk, R.string.novosibirsk_desc, R.string.russian_federation, R.string.asia, 55.013,82.929, 4000, 2, "rus_novosibirsk", Stamp.F_CITY);
		createStamp(845, R.string.yekaterinburg, R.string.yekaterinburg_desc, R.string.russian_federation, R.string.asia, 56.838,60.603, 4000, 1, "rus_yekaterinburg", Stamp.F_CITY);
		createStamp(846, R.string.nizhny_novgorod, R.string.nizhny_novgorod_desc, R.string.russian_federation, R.string.europe, 56.322,43.956, 5000, 1, "rus_nizhny_novgorod", Stamp.F_CITY);
		createStamp(847, R.string.kazan, R.string.kazan_desc, R.string.russian_federation, R.string.europe, 55.799,49.102, 4000, 1, "rus_kazan", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(848, R.string.volgograd, R.string.volgograd_desc, R.string.russian_federation, R.string.europe, 48.703,44.511, 4000, 1, "rus_volgograd", Stamp.F_CITY);
		createStamp(849, R.string.vladivostok, R.string.vladivostok_desc, R.string.russian_federation, R.string.asia, 43.141,131.904, 4000, 1, "rus_vladivostok", Stamp.F_CITY);
		createStamp(850, R.string.derbent, R.string.derbent_desc, R.string.russian_federation, R.string.europe, 42.069,48.297, 4000, 1, "rus_derbent", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(851, R.string.ferapontovo, R.string.ferapontovo_desc, R.string.russian_federation, R.string.europe, 59.952,38.579, 800, 1, "rus_ferapontovo", Stamp.F_C_WHS);
		createStamp(852, R.string.veliky_novgorod, R.string.veliky_novgorod_desc, R.string.russian_federation, R.string.europe, 58.522,31.277, 2500, 2, "rus_veliky_novgorod", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(853, R.string.yaroslavl, R.string.yaroslavl_desc, R.string.russian_federation, R.string.europe, 57.632,39.886, 4000, 2, "rus_yaroslavl", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(854, R.string.sochi, R.string.sochi_desc, R.string.russian_federation, R.string.europe, 43.585,39.719, 2500, 1, "rus_sochi", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(855, R.string.irkutsk, R.string.irkutsk_desc, R.string.russian_federation, R.string.asia, 52.283,104.298, 4500, 1, "rus_irkutsk", Stamp.F_CITY);
		createStamp(856, R.string.yakutsk, R.string.yakutsk_desc, R.string.russian_federation, R.string.asia, 62.033,129.744, 6000, 1, "rus_yakutsk", Stamp.F_CITY);
		createStamp(857, R.string.petropavlovsk_kamchatsky, R.string.petropavlovsk_kamchatsky_desc, R.string.russian_federation, R.string.asia, 53.017,158.650, 2000, 1, "rus_petropavlovsk_kamchatsky", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(858, R.string.solovetsky, R.string.solovetsky_desc, R.string.russian_federation, R.string.europe, 65.090,35.680, 5000, 1, "rus_solovetsky", Stamp.F_C_WHS);
		createStamp(859, R.string.kizhi_pogost, R.string.kizhi_pogost_desc, R.string.russian_federation, R.string.europe, 62.069,35.224, 800, 1, "rus_kizhi", Stamp.F_C_WHS);
		createStamp(860, R.string.samara, R.string.samara_desc, R.string.russian_federation, R.string.europe, 53.231,50.180, 7000, 1, "rus_samara", Stamp.F_CITY);
		createStamp(861, R.string.omsk, R.string.omsk_desc, R.string.russian_federation, R.string.asia, 54.984,73.379, 6000, 1, "rus_omsk", Stamp.F_CITY);

		createStamp(862, R.string.kigali, R.string.kigali_desc, R.string.rwanda, R.string.africa, -1.954,30.093, 4000, 2, "rwa_kigali", Stamp.F_CAP);
		createStamp(863, R.string.nyungwe, R.string.nyungwe_desc, R.string.rwanda, R.string.africa, -2.505,29.282, 6000, 1, "rwa_nyungwe", Stamp.F_MNT);

		createStamp(864, R.string.gustavia, R.string.gustavia_desc, R.string.saint_barthelemy, R.string.central_america, 17.896,-62.852, 600, 1, "sab_gustavia", Stamp.F_CAP);

		createStamp(865, R.string.jamestown, R.string.jamestown_desc, R.string.saint_helena, R.string.africa, -15.925,-5.719, 600, 1, "sah_jamestown", Stamp.F_CAP);

		createStamp(866, R.string.brimstone, R.string.brimstone_desc, R.string.saint_kitts_and_nevis, R.string.central_america, 17.355,-62.846, 600, 1, "sak_brimstone", Stamp.F_C_WHS);

		createStamp(867, R.string.castries, R.string.castries_desc, R.string.saint_lucia, R.string.central_america, 14.011,-60.990, 1000, 1, "sal_castries", Stamp.F_CAP);

		createStamp(868, R.string.marigot, R.string.marigot_desc, R.string.saint_martin_french_part, R.string.central_america, 18.070,-63.084, 600, 1, "saf_marigot", Stamp.F_CAP);

		createStamp(869, R.string.saint_pierre, R.string.saint_pierre_desc, R.string.saint_pierre_and_miquelon, R.string.north_america, 46.781,-56.172, 800, 1, "sap_pierre", Stamp.F_CAP);

		createStamp(870, R.string.kingstown, R.string.kingstown_desc, R.string.saint_vincent_and_the_grenadines, R.string.central_america, 13.156,-61.227, 1000, 1, "sav_kingstown", Stamp.F_CAP);

		createStamp(871, R.string.apia, R.string.apia_desc, R.string.samoa, R.string.australia_continent, -13.833,-171.750, 1500, 1, "sam_apia", Stamp.F_CAP);

		createStamp(872, R.string.san_marino_city, R.string.san_marino_city_desc, R.string.san_marino, R.string.europe, 43.933,12.447, 600, 1, "san_marino", Stamp.F_CAP | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);

		createStamp(873, R.string.sao_tome, R.string.sao_tome_desc, R.string.sao_tome_and_principe, R.string.africa, 0.338,6.730, 1500, 1, "sao_tome", Stamp.F_CAP);

		createStamp(874, R.string.riyadh, R.string.riyadh_desc, R.string.saudi_arabia, R.string.asia, 24.726,46.710, 10000, 2, "sau_riyadh", Stamp.F_CAP);
		createStamp(875, R.string.jeddah, R.string.jeddah_desc, R.string.saudi_arabia, R.string.asia, 21.558,39.174, 9000, 1, "sau_jeddah", Stamp.F_CITY);
		createStamp(876, R.string.makkah, R.string.makkah_desc, R.string.saudi_arabia, R.string.asia, 21.422,39.822, 3500, 2, "sau_makkah", Stamp.F_CITY);
		createStamp(877, R.string.madinah, R.string.madinah_desc, R.string.saudi_arabia, R.string.asia, 24.466,39.611, 5000, 1, "sau_madinah", Stamp.F_CITY);
		createStamp(878, R.string.hijr, R.string.hijr_desc, R.string.saudi_arabia, R.string.asia, 26.776,37.945, 1500, 1, "sau_hijr", Stamp.F_C_WHS);

		createStamp(879, R.string.dakar, R.string.dakar_desc, R.string.senegal, R.string.africa, 14.744,-17.423, 10000, 2, "sen_dakar", Stamp.F_CAP);
		createStamp(880, R.string.saint_louis, R.string.saint_louis_desc, R.string.senegal, R.string.africa, 16.026,-16.498, 2000, 1, "sen_louis", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(881, R.string.djoudj, R.string.djoudj_desc, R.string.senegal, R.string.africa, 16.403,-16.226, 3500, 1, "sen_djoudj", Stamp.F_N_WHS);
		createStamp(882, R.string.niokolo, R.string.niokolo_desc, R.string.senegal, R.string.africa, 12.982,-13.097, 30000, 1, "sen_niokolo", Stamp.F_N_WHS);
		createStamp(883, R.string.saloum_delta, R.string.saloum_delta_desc, R.string.senegal, R.string.africa, 13.912,-16.681, 20000, 1, "sen_saloum_delta", Stamp.F_N_WHS);

		createStamp(884, R.string.belgrade, R.string.belgrade_desc, R.string.serbia, R.string.europe, 44.811,20.467, 5000, 2, "ser_belgrade", Stamp.F_CAP);
		createStamp(885, R.string.stari_ras, R.string.stari_ras_desc, R.string.serbia, R.string.europe, 43.128,20.416, 600, 1, "ser_ras", Stamp.F_C_WHS);
		createStamp(886, R.string.gamzigrad, R.string.gamzigrad_desc, R.string.serbia, R.string.europe, 43.899,22.186, 600, 1, "ser_gamzigrad", Stamp.F_C_WHS);
		createStamp(887, R.string.kopaonik, R.string.kopaonik_desc, R.string.serbia, R.string.europe, 43.319,20.802, 5000, 1, "ser_kopaonik", Stamp.F_MNT);
		createStamp(888, R.string.tara, R.string.tara_desc, R.string.serbia, R.string.europe, 43.930,19.358, 4000, 1, "ser_tara", Stamp.F_MNT);

		createStamp(889, R.string.victoria, R.string.victoria_desc, R.string.seychelles, R.string.africa, -4.620,55.455, 1000, 1, "sey_victoria", Stamp.F_CAP);

		createStamp(890, R.string.freetown, R.string.freetown_desc, R.string.sierra_leone, R.string.africa, 8.486,-13.241, 3500, 2, "sie_freetown", Stamp.F_CAP);

		createStamp(891, R.string.singapore_city, R.string.singapore_city_desc, R.string.singapore, R.string.asia, 1.288,103.853, 5000, 3, "sin_singapore", Stamp.F_CAP);

		createStamp(892, R.string.philipsburg, R.string.philipsburg_desc, R.string.sint_maarten, R.string.central_america, 18.031,-63.046, 1500, 1, "sim_philipsburg", Stamp.F_CAP);

		createStamp(893, R.string.bratislava, R.string.bratislava_desc, R.string.slovakia, R.string.europe, 48.149,17.113, 3500, 2, "slo_bratislava", Stamp.F_CAP);
		createStamp(894, R.string.bardejov, R.string.bardejov_desc, R.string.slovakia, R.string.europe, 49.294,21.273, 1000, 1, "slo_bardejov", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(895, R.string.spis, R.string.spis_desc, R.string.slovakia, R.string.europe, 49.001,20.769, 600, 1, "slo_spis", Stamp.F_C_WHS);
		createStamp(896, R.string.tatry, R.string.tatry_desc, R.string.slovakia, R.string.europe, 49.168,20.163, 8000, 1, "slo_tatry", Stamp.F_MNT);

		createStamp(897, R.string.ljubljana, R.string.ljubljana_desc, R.string.slovenia, R.string.europe, 46.058,14.506, 3000, 2, "slv_ljubljana", Stamp.F_CAP);
		createStamp(898, R.string.skocjan, R.string.skocjan_desc, R.string.slovenia, R.string.europe, 45.667,13.987, 1500, 1, "slv_skocjan", Stamp.F_N_WHS);

		createStamp(899, R.string.honiara, R.string.honiara_desc, R.string.solomon_islands, R.string.australia_continent, -9.430,159.950, 2000, 2, "sol_honiara", Stamp.F_CAP);

		createStamp(900, R.string.mogadishu, R.string.mogadishu_desc, R.string.somalia, R.string.africa, 2.035,45.343, 4000, 2, "som_mogadishu", Stamp.F_CAP);

		createStamp(901, R.string.pretoria, R.string.pretoria_desc, R.string.south_africa, R.string.africa, -25.745,28.190, 5000, 1, "soa_pretoria", Stamp.F_CAP);
		createStamp(902, R.string.cape_town, R.string.cape_town_desc, R.string.south_africa, R.string.africa, -33.923,18.436, 12000, 3, "soa_cape", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(903, R.string.durban, R.string.durban_desc, R.string.south_africa, R.string.africa, -29.858,31.028, 8000, 1, "soa_durban", Stamp.F_CITY);
		createStamp(904, R.string.johannesburg, R.string.johannesburg_desc, R.string.south_africa, R.string.africa, -26.204,28.047, 7000, 2, "soa_johannesburg", Stamp.F_CITY);
		createStamp(905, R.string.kimberley, R.string.kimberley_desc, R.string.south_africa, R.string.africa, -28.731,24.757, 6000, 1, "soa_kimberley", Stamp.F_CITY);
		createStamp(906, R.string.kruger, R.string.kruger_desc, R.string.south_africa, R.string.africa, -23.952,31.474, 30000, 2, "soa_kruger", Stamp.FEATURE_OUTDOOR);
		createStamp(907, R.string.isimangaliso, R.string.isimangaliso_desc, R.string.south_africa, R.string.africa, -27.659,32.573, 12000, 1, "soa_isimangaliso", Stamp.F_N_WHS);
		createStamp(908, R.string.addo, R.string.addo_desc, R.string.south_africa, R.string.africa, -33.485,25.772, 6000, 1, "soa_addo", Stamp.FEATURE_OUTDOOR);
		createStamp(909, R.string.pilanesberg, R.string.pilanesberg_desc, R.string.south_africa, R.string.africa, -25.248,27.082, 12000, 1, "soa_pilanesberg", Stamp.FEATURE_OUTDOOR);

		createStamp(910, R.string.grytviken, R.string.grytviken_desc, R.string.south_georgia_and_south_sandwich_islands, R.string.antarctica, -54.281,-36.508, 1000, 2, "sog_grytviken", Stamp.F_MNT);

		createStamp(911, R.string.juba, R.string.juba_desc, R.string.south_sudan, R.string.africa, 4.840,31.589, 4000, 2, "sos_juba", Stamp.F_CAP);
		createStamp(912, R.string.bandinglio, R.string.bandinglio_desc, R.string.south_sudan, R.string.africa, 5.464,32.272, 35000, 1, "sos_bandinglio", Stamp.FEATURE_OUTDOOR);
		createStamp(913, R.string.boma, R.string.boma_desc, R.string.south_sudan, R.string.africa, 6.326,33.991, 60000, 1, "sos_boma", Stamp.FEATURE_OUTDOOR);

		createStamp(914, R.string.madrid, R.string.madrid_desc, R.string.spain, R.string.europe, 40.415,-3.704, 5000, 3, "spa_madrid", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(915, R.string.barcelona, R.string.barcelona_desc, R.string.spain, R.string.europe, 41.403,2.186, 5000, 2, "spa_barcelona", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(916, R.string.cadiz, R.string.cadiz_desc, R.string.spain, R.string.europe, 36.526,-6.289, 4000, 1, "spa_cadiz", Stamp.F_CITY);
		createStamp(917, R.string.cordoba_spain, R.string.cordoba_spain_desc, R.string.spain, R.string.europe, 37.892,-4.780, 3000, 1, "spa_cordoba", Stamp.F_CITY);
		createStamp(918, R.string.granada, R.string.granada_desc, R.string.spain, R.string.europe, 37.178,-3.599, 3000, 1, "spa_granada", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(919, R.string.seville, R.string.seville_desc, R.string.spain, R.string.europe, 37.388,-5.982, 3500, 1, "spa_seville", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(920, R.string.valencia, R.string.valencia_desc, R.string.spain, R.string.europe, 39.468,-0.377, 4000, 1, "spa_valencia", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(921, R.string.palma, R.string.palma_desc, R.string.spain, R.string.europe, 39.571,2.648, 3000, 1, "spa_palma", Stamp.F_CITY);
		createStamp(922, R.string.merida, R.string.merida_desc, R.string.spain, R.string.europe, 38.919,-6.342, 2000, 1, "spa_merida", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(923, R.string.toledo, R.string.toledo_desc, R.string.spain, R.string.europe, 39.862,-4.027, 2000, 2, "spa_toledo", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(924, R.string.salamanca, R.string.salamanca_desc, R.string.spain, R.string.europe, 40.970,-5.663, 1500, 1, "spa_salamanca", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(925, R.string.avila, R.string.avila_desc, R.string.spain, R.string.europe, 40.656,-4.697, 1500, 1, "spa_avila", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(926, R.string.segovia, R.string.segovia_desc, R.string.spain, R.string.europe, 40.944,-4.111, 1500, 1, "spa_segovia", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(927, R.string.cuenca_spain, R.string.cuenca_spain_desc, R.string.spain, R.string.europe, 40.070,-2.137, 1500, 1, "spa_cuenca", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(928, R.string.burgos, R.string.burgos_desc, R.string.spain, R.string.europe, 42.344,-3.696, 1500, 1, "spa_burgos", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(929, R.string.santiago_compostela, R.string.santiago_compostela_desc, R.string.spain, R.string.europe, 42.877,-8.546, 1000, 2, "spa_santiago", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(930, R.string.teide, R.string.teide_desc, R.string.spain, R.string.europe, 28.265,-16.634, 10000, 2, "spa_teide", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(931, R.string.aiguestortes, R.string.aiguestortes_desc, R.string.spain, R.string.europe, 42.558,0.933, 4000, 1, "spa_aiguestortes", Stamp.F_MNT);
		createStamp(932, R.string.picos, R.string.picos_desc, R.string.spain, R.string.europe, 43.193,-4.962, 10000, 2, "spa_picos", Stamp.F_MNT);
		createStamp(933, R.string.sierra_nevada, R.string.sierra_nevada_desc, R.string.spain, R.string.europe, 37.077,-3.171, 10000, 1, "spa_nevada", Stamp.F_MNT);

		createStamp(934, R.string.colombo, R.string.colombo_desc, R.string.sri_lanka, R.string.asia, 6.934,79.851, 3000, 2, "sri_colombo", Stamp.F_CAP);
		createStamp(935, R.string.kandy, R.string.kandy_desc, R.string.sri_lanka, R.string.asia, 7.294,80.641, 1000, 1, "sri_kandy", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(936, R.string.polonnaruwa, R.string.polonnaruwa_desc, R.string.sri_lanka, R.string.asia, 7.916,81.001, 1000, 1, "sri_polonnaruwa", Stamp.F_C_WHS);
		createStamp(937, R.string.yala, R.string.yala_desc, R.string.sri_lanka, R.string.asia, 6.495,81.438, 10000, 1, "sri_yala", Stamp.FEATURE_OUTDOOR);

		createStamp(938, R.string.khartoum, R.string.khartoum_desc, R.string.sudan, R.string.africa, 15.596,32.535, 10000, 2, "sud_khartoum", Stamp.F_CAP);
		createStamp(939, R.string.meroe, R.string.meroe_desc, R.string.sudan, R.string.africa, 16.938,33.751, 800, 1, "sud_meroe", Stamp.F_C_WHS);
		createStamp(940, R.string.dinder, R.string.dinder_desc, R.string.sudan, R.string.africa, 12.999,35.667, 50000, 1, "sud_dinder", Stamp.FEATURE_OUTDOOR);

		createStamp(941, R.string.paramaribo, R.string.paramaribo_desc, R.string.suriname, R.string.south_america, 5.824,-55.168, 4000, 2, "sur_paramaribo", Stamp.F_CAP | Stamp.F_C_WHS);

		createStamp(942, R.string.longyearbyen, R.string.longyearbyen_desc, R.string.svalbard_and_jan_mayen_islands, R.string.europe, 78.220,15.650, 1000, 2, "sva_longyearbyen", Stamp.F_CAP | Stamp.FEATURE_MOUNTAIN);

		createStamp(943, R.string.mbabane, R.string.mbabane_desc, R.string.swaziland, R.string.africa, -26.316,31.134, 2000, 2, "swa_mbabane", Stamp.F_CAP);
		createStamp(944, R.string.hlane, R.string.hlane_desc, R.string.swaziland, R.string.africa, -26.248,31.882, 6000, 1, "swa_hlane", Stamp.FEATURE_OUTDOOR);

		createStamp(945, R.string.stockholm, R.string.stockholm_desc, R.string.sweden, R.string.europe, 59.329,18.065, 4500, 2, "swe_stockholm", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(946, R.string.visby, R.string.visby_desc, R.string.sweden, R.string.europe, 57.636,18.295, 1500, 1, "swe_visby", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(947, R.string.karlskrona, R.string.karlskrona_desc, R.string.sweden, R.string.europe, 56.162,15.586, 1000, 1, "swe_karlskrona", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(948, R.string.gothenburg, R.string.gothenburg_desc, R.string.sweden, R.string.europe, 57.709,11.974, 3000, 1, "swe_gothenburg", Stamp.F_CITY);
		createStamp(949, R.string.sarek, R.string.sarek_desc, R.string.sweden, R.string.europe, 67.279,17.710, 15000, 1, "swe_sarek", Stamp.F_MNT);
		createStamp(950, R.string.muddus, R.string.muddus_desc, R.string.sweden, R.string.europe, 66.927,20.204, 10000, 1, "swe_muddus", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(951, R.string.sanfjallet, R.string.sanfjallet_desc, R.string.sweden, R.string.europe, 62.278,13.543, 5000, 2, "swe_sanfjallet", Stamp.F_MNT);

		createStamp(952, R.string.bern, R.string.bern_desc, R.string.switzerland, R.string.europe, 46.949,7.445, 2000, 2, "swi_bern", Stamp.F_CAP | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(953, R.string.zurich, R.string.zurich_desc, R.string.switzerland, R.string.europe, 47.368,8.539, 5500, 2, "swi_zurich", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(954, R.string.basel, R.string.basel_desc, R.string.switzerland, R.string.europe, 47.564,7.593, 1500, 1, "swi_basel", Stamp.F_CITY);
		createStamp(955, R.string.bellinzona, R.string.bellinzona_desc, R.string.switzerland, R.string.europe, 46.198,9.027, 2000, 1, "swi_bellinzona", Stamp.F_CITY | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(956, R.string.geneva, R.string.geneva_desc, R.string.switzerland, R.string.europe, 46.204,6.140, 3000, 1, "swi_geneva", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(957, R.string.rhine_falls, R.string.rhine_falls_desc, R.string.switzerland, R.string.europe, 47.678,8.616, 500, 1, "swi_falls", Stamp.FEATURE_OUTDOOR);

		createStamp(958, R.string.damascus, R.string.damascus_desc, R.string.syria, R.string.asia, 33.515,36.300, 3000, 3, "syr_damascus", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(959, R.string.aleppo, R.string.aleppo_desc, R.string.syria, R.string.asia, 36.206,37.157, 3500, 1, "syr_aleppo", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(960, R.string.bosra, R.string.bosra_desc, R.string.syria, R.string.asia, 32.519,36.483, 1000, 1, "syr_bosra", Stamp.F_C_WHS);
		createStamp(961, R.string.crac, R.string.crac_desc, R.string.syria, R.string.asia, 34.757,36.295, 600, 2, "syr_crac", Stamp.F_C_WHS);
		createStamp(962, R.string.palmyra, R.string.palmyra_desc, R.string.syria, R.string.asia, 34.562,38.278, 1000, 2, "syr_palmyra", Stamp.F_C_WHS);

		createStamp(963, R.string.taipei, R.string.taipei_desc, R.string.taiwan, R.string.asia, 25.063,121.537, 7000, 2, "tai_taipei", Stamp.F_CAP);
		createStamp(964, R.string.tainan, R.string.tainan_desc, R.string.taiwan, R.string.asia, 23.162,120.181, 9000, 1, "tai_tainan", Stamp.F_CITY);
		createStamp(965, R.string.sheipa, R.string.sheipa_desc, R.string.taiwan, R.string.asia, 24.388,121.134, 12000, 1, "tai_sheipa", Stamp.F_MNT);

		createStamp(966, R.string.dushanbe, R.string.dushanbe_desc, R.string.tajikistan, R.string.asia, 38.548,68.772, 6000, 2, "taj_dushanbe", Stamp.F_CAP);
		createStamp(967, R.string.pamir, R.string.pamir_desc, R.string.tajikistan, R.string.asia, 39.199,72.613, 30000, 1, "taj_pamir", Stamp.F_MNT | Stamp.F_N_WHS);

		createStamp(968, R.string.dodoma, R.string.dodoma_desc, R.string.tanzania, R.string.africa, -6.169,35.743, 4000, 2, "tan_dodoma", Stamp.F_CAP);
		createStamp(969, R.string.salaam, R.string.salaam_desc, R.string.tanzania, R.string.africa, -6.815,39.282, 8000, 1, "tan_salaam", Stamp.F_CITY);
		createStamp(970, R.string.kisiwani, R.string.kisiwani_desc, R.string.tanzania, R.string.africa, -8.950,39.527, 1000, 1, "tan_kisiwani", Stamp.F_C_WHS);
		createStamp(971, R.string.zanzibar, R.string.zanzibar_desc, R.string.tanzania, R.string.africa, -6.164,39.193, 1500, 1, "tan_zanzibar", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(972, R.string.kilimanjaro, R.string.kilimanjaro_desc, R.string.tanzania, R.string.africa, -3.066,37.352, 8000, 2, "tan_kilimanjaro", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(973, R.string.selous, R.string.selous_desc, R.string.tanzania, R.string.africa, -8.440,37.765, 70000, 1, "tan_selous", Stamp.F_N_WHS);
		createStamp(974, R.string.serengeti, R.string.serengeti_desc, R.string.tanzania, R.string.africa, -2.405,34.777, 50000, 2, "tan_serengeti", Stamp.F_N_WHS);
		createStamp(975, R.string.ngorongoro, R.string.ngorongoro_desc, R.string.tanzania, R.string.africa, -3.171,35.564, 20000, 2, "tan_ngorongoro", Stamp.F_N_WHS);

		createStamp(976, R.string.bangkok, R.string.bangkok_desc, R.string.thailand, R.string.asia, 13.728,100.525, 8000, 3, "tha_bangkok", Stamp.F_CAP);
		createStamp(977, R.string.ayutthaya, R.string.ayutthaya_desc, R.string.thailand, R.string.asia, 14.353,100.561, 1500, 2, "tha_ayutthaya", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(978, R.string.sukhothai, R.string.sukhothai_desc, R.string.thailand, R.string.asia, 17.019,99.704, 1500, 1, "tha_sukhothai", Stamp.F_C_WHS);
		createStamp(979, R.string.surat_thani, R.string.surat_thani_desc, R.string.thailand, R.string.asia, 9.134,99.327, 2000, 1, "tha_surat", Stamp.F_CITY);
		createStamp(980, R.string.kanchanaburi, R.string.kanchanaburi_desc, R.string.thailand, R.string.asia, 14.032,99.526, 2000, 1, "tha_kanchanaburi", Stamp.F_CITY);
		createStamp(981, R.string.tarutao, R.string.tarutao_desc, R.string.thailand, R.string.asia, 6.608,99.651, 8000, 1, "tha_tarutao", Stamp.FEATURE_OUTDOOR);
		createStamp(982, R.string.khao_sok, R.string.khao_sok_desc, R.string.thailand, R.string.asia, 9.005,98.610, 8000, 2, "tha_sok", Stamp.F_MNT);
		createStamp(983, R.string.khao_yai, R.string.khao_yai_desc, R.string.thailand, R.string.asia, 14.336,101.508, 12000, 1, "tha_yai", Stamp.F_N_WHS);
		createStamp(984, R.string.ko_pha_ngan, R.string.ko_pha_ngan_desc, R.string.thailand, R.string.asia, 9.745,100.025, 7500, 1, "tha_ko_pha", Stamp.FEATURE_OUTDOOR);

		createStamp(985, R.string.dili, R.string.dili_desc, R.string.timor_leste, R.string.asia, -8.554,125.572, 3500, 2, "tim_dili", Stamp.F_CAP);

		createStamp(986, R.string.lome, R.string.lome_desc, R.string.togo, R.string.africa, 6.138,1.217, 7000, 2, "tog_lome", Stamp.F_CAP);
		createStamp(987, R.string.fazao, R.string.fazao_desc, R.string.togo, R.string.africa, 9.026,0.974, 10000, 1, "tog_fazao", Stamp.F_MNT);

		createStamp(988, R.string.nukunonu, R.string.nukunonu_desc, R.string.tokelau, R.string.australia_continent, -9.133,-171.788, 2000, 1, "tok_nukunonu", Stamp.FEATURE_OUTDOOR);

		createStamp(989, R.string.nukualofa, R.string.nukualofa_desc, R.string.tonga, R.string.australia_continent, -21.138,-175.203, 1000, 1, "ton_nukualofa", Stamp.F_CAP);

		createStamp(990, R.string.port_of_spain, R.string.port_of_spain_desc, R.string.trinidad_and_tobago, R.string.central_america, 10.663,-61.525, 2000, 2, "tri_spain", Stamp.F_CAP	);

		createStamp(991, R.string.tunis, R.string.tunis_desc, R.string.tunisia, R.string.africa, 36.820,10.166, 8000, 3, "tun_tunis", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(992, R.string.sfax, R.string.sfax_desc, R.string.tunisia, R.string.africa, 34.738,10.760, 8000, 1, "tun_sfax", Stamp.F_CITY);
		createStamp(993, R.string.el_jem, R.string.el_jem_desc, R.string.tunisia, R.string.africa, 35.298,10.707, 1000, 2, "tun_jem", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(994, R.string.dougga, R.string.dougga_desc, R.string.tunisia, R.string.africa, 36.424,9.220, 1000, 1, "tun_dougga", Stamp.F_C_WHS);
		createStamp(995, R.string.kairouan, R.string.kairouan_desc, R.string.tunisia, R.string.africa, 35.675,10.098, 3000, 1, "tun_kairouan", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(996, R.string.sousse, R.string.sousse_desc, R.string.tunisia, R.string.africa, 35.833,10.639, 4000, 2, "tun_sousse", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(997, R.string.kerkuane, R.string.kerkuane_desc, R.string.tunisia, R.string.africa, 36.946,11.099, 1000, 1, "tun_kerkuane", Stamp.F_C_WHS);
		createStamp(998, R.string.jebil, R.string.jebil_desc, R.string.tunisia, R.string.africa, 32.923,9.157, 35000, 1, "tun_jebil", Stamp.FEATURE_OUTDOOR);
		createStamp(999, R.string.monastir, R.string.monastir_desc, R.string.tunisia, R.string.africa, 35.775,10.831, 3000, 1, "tun_monastir", Stamp.F_CITY);

		createStamp(1000, R.string.ankara, R.string.ankara_desc, R.string.turkey, R.string.asia, 39.940,32.840, 6000, 2, "tur_ankara", Stamp.F_CAP);
		createStamp(1001, R.string.istanbul, R.string.istanbul_desc, R.string.turkey, R.string.europe, 41.015,28.984, 12000, 3, "tur_istanbul", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1002, R.string.antalya, R.string.antalya_desc, R.string.turkey, R.string.asia, 36.885,30.706, 7000, 1, "tur_antalya", Stamp.F_CITY);
		createStamp(1003, R.string.bursa, R.string.bursa_desc, R.string.turkey, R.string.asia, 40.204,29.061, 7000, 1, "tur_bursa", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(1004, R.string.edirne, R.string.edirne_desc, R.string.turkey, R.string.europe, 41.671,26.564, 3000, 2, "tur_edirne", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1005, R.string.izmir, R.string.izmir_desc, R.string.turkey, R.string.asia, 38.432,27.136, 8000, 1, "tur_izmir", Stamp.F_CITY);
		createStamp(1006, R.string.konya, R.string.konya_desc, R.string.turkey, R.string.asia, 37.873,32.495, 8000, 1, "tur_konya", Stamp.F_CITY);
		createStamp(1007, R.string.troy, R.string.troy_desc, R.string.turkey, R.string.asia, 39.957,26.241, 1000, 2, "tur_troy", Stamp.F_C_WHS);
		createStamp(1008, R.string.divrigi, R.string.divrigi_desc, R.string.turkey, R.string.asia, 39.371,38.115, 1500, 1, "tur_divrigi", Stamp.F_C_WHS | Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(1009, R.string.hattusha, R.string.hattusha_desc, R.string.turkey, R.string.asia, 40.010,34.616, 1000, 1, "tur_hattusha", Stamp.F_C_WHS);
		createStamp(1010, R.string.nemrut_dag, R.string.nemrut_dag_desc, R.string.turkey, R.string.asia, 37.980,38.741, 1000, 1, "tur_nemrut", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(1011, R.string.goreme, R.string.goreme_desc, R.string.turkey, R.string.asia, 38.644,34.831, 2000, 2, "tur_goreme", Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(1012, R.string.kackar, R.string.kackar_desc, R.string.turkey, R.string.asia, 40.867,41.117, 4000, 2, "tur_kackar", Stamp.F_MNT);
		createStamp(1013, R.string.ilgaz, R.string.ilgaz_desc, R.string.turkey, R.string.asia, 41.077,33.812, 2000, 1, "tur_ilgaz", Stamp.F_MNT);
		createStamp(1014, R.string.munzur, R.string.munzur_desc, R.string.turkey, R.string.asia, 39.476,39.593, 5000, 1, "tur_munzur", Stamp.F_MNT);

		createStamp(1015, R.string.ashgabat, R.string.ashgabat_desc, R.string.turkmenistan, R.string.asia, 37.947,58.388, 4000, 2, "tuk_ashgabat", Stamp.F_CAP);
		createStamp(1016, R.string.door_to_hell, R.string.door_to_hell_desc, R.string.turkmenistan, R.string.asia, 40.168,58.411, 800, 1, "tuk_door", Stamp.FEATURE_OUTDOOR);
		createStamp(1017, R.string.kunya, R.string.kunya_desc, R.string.turkmenistan, R.string.asia, 42.323,59.145, 2000, 1, "tuk_kunya", Stamp.F_CITY | Stamp.F_C_WHS);

		createStamp(1018, R.string.cockburn, R.string.cockburn_desc, R.string.turks_and_caicos_islands, R.string.central_america, 21.462,-71.147, 1000, 1, "tuc_cockburn", Stamp.F_CAP);

		createStamp(1019, R.string.funafuti, R.string.funafuti_desc, R.string.tuvalu, R.string.australia_continent, -8.521,179.199, 1500, 1, "tuv_funafuti", Stamp.F_CAP);

		createStamp(1020, R.string.kampala, R.string.kampala_desc, R.string.uganda, R.string.africa, 0.313,32.583, 6000, 2, "uga_kampala", Stamp.F_CAP);
		createStamp(1021, R.string.rwenzori, R.string.rwenzori_desc, R.string.uganda, R.string.africa, 0.328,29.952, 10000, 1, "uga_rwenzori", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(1022, R.string.kibale, R.string.kibale_desc, R.string.uganda, R.string.africa, 0.522,30.420, 8000, 2, "uga_kibale", Stamp.FEATURE_OUTDOOR);
		createStamp(1023, R.string.queen_elizabeth, R.string.queen_elizabeth_desc, R.string.uganda, R.string.africa, -0.148,30.009, 15000, 1, "uga_elizabeth", Stamp.FEATURE_OUTDOOR);
		createStamp(1024, R.string.murchison, R.string.murchison_desc, R.string.uganda, R.string.africa, 2.183,31.789, 35000, 1, "uga_murchison", Stamp.FEATURE_OUTDOOR);
		createStamp(1025, R.string.bwindi, R.string.bwindi_desc, R.string.uganda, R.string.africa, -1.048,29.690, 10000, 2, "uga_bwindi", Stamp.F_N_WHS | Stamp.F_MNT);

		createStamp(1026, R.string.kiev, R.string.kiev_desc, R.string.ukraine, R.string.europe, 50.454,30.521, 4000, 2, "ukr_kiev", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(1027, R.string.lviv, R.string.lviv_desc, R.string.ukraine, R.string.europe, 49.844,24.027, 5000, 1, "ukr_lviv", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1028, R.string.sevastopol, R.string.sevastopol_desc, R.string.ukraine, R.string.europe, 44.614,33.523, 4000, 1, "ukr_sevastopol", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1029, R.string.pripyat, R.string.pripyat_desc, R.string.ukraine, R.string.europe, 51.398,30.071, 3000, 2, "ukr_pripyat", Stamp.FEATURE_SIGHTS);

		createStamp(1030, R.string.abu_dhabi, R.string.abu_dhabi_desc, R.string.united_arab_emirates, R.string.asia, 24.441,54.442, 10000, 2, "uae_dhabi", Stamp.F_CAP);
		createStamp(1031, R.string.dubai, R.string.dubai_desc, R.string.united_arab_emirates, R.string.asia, 25.257,55.284, 10000, 3, "uae_dubai", Stamp.F_CITY);
		createStamp(1032, R.string.al_ain, R.string.al_ain_desc, R.string.united_arab_emirates, R.string.asia, 24.220,55.733, 7000, 1, "uae_ain", Stamp.F_CITY | Stamp.F_C_WHS);

		createStamp(1033, R.string.london, R.string.london_desc, R.string.united_kingdom, R.string.europe, 51.518,-0.120, 10000, 3, "unk_london", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(1034, R.string.manchester, R.string.manchester_desc, R.string.united_kingdom, R.string.europe, 53.480,-2.248, 3000, 1, "unk_manchester", Stamp.F_CITY);
		createStamp(1035, R.string.birmingham, R.string.birmingham_desc, R.string.united_kingdom, R.string.europe, 52.481,-1.895, 3000, 1, "unk_birmingham", Stamp.F_CITY);
		createStamp(1036, R.string.glasgow, R.string.glasgow_desc, R.string.united_kingdom, R.string.europe, 55.863,-4.256, 3000, 1, "unk_glasgow", Stamp.F_CITY);
		createStamp(1037, R.string.liverpool, R.string.liverpool_desc, R.string.united_kingdom, R.string.europe, 53.411,-2.982, 5000, 2, "unk_liverpool", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1038, R.string.bristol, R.string.bristol_desc, R.string.united_kingdom, R.string.europe, 51.455,-2.591, 3000, 1, "unk_bristol", Stamp.F_CITY);
		createStamp(1039, R.string.canterbury, R.string.canterbury_desc, R.string.united_kingdom, R.string.europe, 51.280,1.079, 1500, 2, "unk_canterbury", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1040, R.string.hadrians_wall, R.string.hadrians_wall_desc, R.string.united_kingdom, R.string.europe, 54.990,-2.601, 1000, 2, "unk_hadrians", Stamp.F_C_WHS);
		createStamp(1041, R.string.edinburgh, R.string.edinburgh_desc, R.string.united_kingdom, R.string.europe, 55.952,-3.197, 3500, 1, "unk_edinburgh", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1042, R.string.stonehenge, R.string.stonehenge_desc, R.string.united_kingdom, R.string.europe, 51.179,-1.826, 600, 2, "unk_stonehenge", Stamp.F_C_WHS);
		createStamp(1043, R.string.oxford, R.string.oxford_desc, R.string.united_kingdom, R.string.europe, 51.755,-1.259, 3000, 1, "unk_oxford", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1044, R.string.caernarfon, R.string.caernarfon_desc, R.string.united_kingdom, R.string.europe, 53.141,-4.275, 1000, 1, "unk_caernarfon", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1045, R.string.loch_lomond, R.string.loch_lomond_desc, R.string.united_kingdom, R.string.europe, 56.251,-4.560, 20000, 1, "unk_lomond", Stamp.F_MNT);
		createStamp(1046, R.string.peak_district, R.string.peak_district_desc, R.string.united_kingdom, R.string.europe, 53.428,-1.758, 9000, 1, "unk_peak", Stamp.F_MNT);
		createStamp(1047, R.string.lake_district, R.string.lake_district_desc, R.string.united_kingdom, R.string.europe, 54.487,-3.086, 14000, 2, "unk_lake", Stamp.F_MNT);
		createStamp(1048, R.string.snowdonia, R.string.snowdonia_desc, R.string.united_kingdom, R.string.europe, 53.049,-3.940, 12000, 1, "unk_snowdonia", Stamp.F_MNT);
		createStamp(1049, R.string.dartmoor, R.string.dartmoor_desc, R.string.united_kingdom, R.string.europe, 50.572,-3.919, 10000, 1, "unk_dartmoor", Stamp.FEATURE_OUTDOOR);
		createStamp(1050, R.string.pembrokeshire, R.string.pembrokeshire_desc, R.string.united_kingdom, R.string.europe, 52.023,-4.835, 6000, 1, "unk_pembrokeshire", Stamp.FEATURE_OUTDOOR);
		createStamp(1051, R.string.south_downs, R.string.south_downs_desc, R.string.united_kingdom, R.string.europe, 50.748,0.195, 3000, 2, "unk_downs", Stamp.FEATURE_OUTDOOR);
		createStamp(1052, R.string.giants_causeway, R.string.giants_causeway_desc, R.string.united_kingdom, R.string.europe, 55.241,-6.511, 1000, 1, "unk_causeway", Stamp.F_N_WHS);

		createStamp(1053, R.string.vatican, R.string.vatican_desc, R.string.vatican_city, R.string.europe, 41.903,12.455, 400, 1, "vat_vatican", Stamp.F_CAP | Stamp.F_C_WHS);

		createStamp(1054, R.string.washington, R.string.washington_desc, R.string.united_states_of_america, R.string.north_america, 38.898,-77.036, 10000, 2, "usa_washington", Stamp.F_CAP);
		createStamp(1055, R.string.new_york, R.string.new_york_desc, R.string.united_states_of_america, R.string.north_america, 40.709,-74.014, 20000, 3, "usa_york", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1056, R.string.los_angeles, R.string.los_angeles_desc, R.string.united_states_of_america, R.string.north_america, 33.908,-118.238, 18000, 2, "usa_angeles", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(1057, R.string.chicago, R.string.chicago_desc, R.string.united_states_of_america, R.string.north_america, 41.879,-87.630, 12000, 1, "usa_chicago", Stamp.F_CITY);
		createStamp(1058, R.string.dallas, R.string.dallas_desc, R.string.united_states_of_america, R.string.north_america, 32.781,-96.801, 10000, 1, "usa_dallas", Stamp.F_CITY);
		createStamp(1059, R.string.boston, R.string.boston_desc, R.string.united_states_of_america, R.string.north_america, 42.359,-71.058, 7000, 1, "usa_boston", Stamp.F_CITY);
		createStamp(1060, R.string.las_vegas, R.string.las_vegas_desc, R.string.united_states_of_america, R.string.north_america, 36.159,-115.158, 10000, 1, "usa_vegas", Stamp.F_CITY);
		createStamp(1061, R.string.miami, R.string.miami_desc, R.string.united_states_of_america, R.string.north_america, 25.786,-80.215, 12000, 2, "usa_miami", Stamp.F_CITY);
		createStamp(1062, R.string.new_orleans, R.string.new_orleans_desc, R.string.united_states_of_america, R.string.north_america, 29.960,-90.066, 10000, 1, "usa_orleans", Stamp.F_CITY);
		createStamp(1063, R.string.san_francisco, R.string.san_francisco_desc, R.string.united_states_of_america, R.string.north_america, 37.788,-122.390, 10000, 1, "usa_francisco", Stamp.F_CITY);
		createStamp(1064, R.string.seattle, R.string.seattle_desc, R.string.united_states_of_america, R.string.north_america, 47.610,-122.332, 10000, 1, "usa_seattle", Stamp.F_CITY);
		createStamp(1065, R.string.philadelphia, R.string.philadelphia_desc, R.string.united_states_of_america, R.string.north_america, 39.958,-75.162, 10000, 2, "usa_philadelphia", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1066, R.string.atlantic_city, R.string.atlantic_city_desc, R.string.united_states_of_america, R.string.north_america, 39.365,-74.423, 3500, 1, "usa_atlantic", Stamp.F_CITY);
		createStamp(1067, R.string.anchorage, R.string.anchorage_desc, R.string.united_states_of_america, R.string.north_america, 61.174,-149.915, 8000, 1, "usa_anchorage", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(1068, R.string.honolulu, R.string.honolulu_desc, R.string.united_states_of_america, R.string.australia_continent, 21.300,-157.857, 4000, 1, "usa_honolulu", Stamp.F_CITY | Stamp.FEATURE_MOUNTAIN);
		createStamp(1069, R.string.denali, R.string.denali_desc, R.string.united_states_of_america, R.string.north_america, 63.102,-151.195, 50000, 1, "usa_denali", Stamp.F_MNT);
		createStamp(1070, R.string.everglades, R.string.everglades_desc, R.string.united_states_of_america, R.string.north_america, 25.410,-80.862, 25000, 1, "usa_everglades", Stamp.F_N_WHS);
		createStamp(1071, R.string.great_smokey_mountains, R.string.great_smokey_mountains_desc, R.string.united_states_of_america, R.string.north_america, 35.542,-83.599, 20000, 1, "usa_smokey", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(1072, R.string.niagara, R.string.niagara_desc, R.string.united_states_of_america, R.string.north_america, 43.083,-79.074, 1000, 2, "usa_niagara", Stamp.FEATURE_OUTDOOR);
		createStamp(1073, R.string.acadia, R.string.acadia_desc, R.string.united_states_of_america, R.string.north_america, 44.343,-68.251, 4000, 1, "usa_acadia", Stamp.F_MNT);
		createStamp(1074, R.string.lassen, R.string.lassen_desc, R.string.united_states_of_america, R.string.north_america, 40.566,-121.287, 25000, 1, "usa_lassen", Stamp.F_MNT);
		createStamp(1075, R.string.isle_royale, R.string.isle_royale_desc, R.string.united_states_of_america, R.string.north_america, 48.006,-88.910, 15000, 1, "usa_royale", Stamp.FEATURE_OUTDOOR);
		createStamp(1076, R.string.big_bend, R.string.big_bend_desc, R.string.united_states_of_america, R.string.north_america, 29.278,-103.209, 20000, 1, "usa_bend", Stamp.F_MNT);
		createStamp(1077, R.string.gates_of_the_arctic, R.string.gates_of_the_arctic_desc, R.string.united_states_of_america, R.string.north_america, 67.847,-153.492, 50000, 1, "usa_arctic", Stamp.F_MNT);
		createStamp(1078, R.string.rushmore, R.string.rushmore_desc, R.string.united_states_of_america, R.string.north_america, 43.879,-103.459, 1000, 1, "usa_rushmore", Stamp.FEATURE_SIGHTS);
		createStamp(1079, R.string.yellowstone, R.string.yellowstone_desc, R.string.united_states_of_america, R.string.north_america, 44.477,-110.403, 55000, 2, "usa_yellowstone", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(1080, R.string.rocky_mountain, R.string.rocky_mountain_desc, R.string.united_states_of_america, R.string.north_america, 40.386,-105.638, 15000, 1, "usa_rocky", Stamp.F_MNT);
		createStamp(1081, R.string.mesa_verde, R.string.mesa_verde_desc, R.string.united_states_of_america, R.string.north_america, 37.243,-108.460, 6000, 1, "usa_verde", Stamp.FEATURE_MOUNTAIN | Stamp.F_C_WHS);
		createStamp(1082, R.string.great_sand_dunes, R.string.great_sand_dunes_desc, R.string.united_states_of_america, R.string.north_america, 37.742,-105.607, 6000, 1, "usa_dunes", Stamp.F_MNT);
		createStamp(1083, R.string.crater_lake, R.string.crater_lake_desc, R.string.united_states_of_america, R.string.north_america, 42.944,-122.112, 15000, 1, "usa_crater", Stamp.F_MNT);
		createStamp(1084, R.string.glacier, R.string.glacier_desc, R.string.united_states_of_america, R.string.north_america, 48.647,-113.905, 20000, 1, "usa_glacier", Stamp.F_MNT);
		createStamp(1085, R.string.glacier_bay, R.string.glacier_bay_desc, R.string.united_states_of_america, R.string.north_america, 58.333,-135.946, 60000, 2, "usa_bay", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(1086, R.string.channel_islands, R.string.channel_islands_desc, R.string.united_states_of_america, R.string.north_america, 33.943,-120.024, 30000, 1, "usa_islands", Stamp.F_MNT);
		createStamp(1087, R.string.grand_canyon, R.string.grand_canyon_desc, R.string.united_states_of_america, R.string.north_america, 36.084,-112.039, 16000, 2, "usa_canyon", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(1088, R.string.carlsbad_caverns, R.string.carlsbad_caverns_desc, R.string.united_states_of_america, R.string.north_america, 32.128,-104.644, 15000, 2, "usa_caverns", Stamp.F_N_WHS);
		createStamp(1089, R.string.canyonlands, R.string.canyonlands_desc, R.string.united_states_of_america, R.string.north_america, 38.293,-109.920, 10000, 1, "usa_canyonlands", Stamp.F_MNT);
		createStamp(1090, R.string.death_valley, R.string.death_valley_desc, R.string.united_states_of_america, R.string.north_america, 36.505,-117.077, 25000, 2, "usa_death", Stamp.F_MNT);
		createStamp(1091, R.string.yosemite, R.string.yosemite_desc, R.string.united_states_of_america, R.string.north_america, 37.860,-119.537, 40000, 2, "usa_yosemite", Stamp.F_MNT | Stamp.F_N_WHS);

		createStamp(1092, R.string.montevideo, R.string.montevideo_desc, R.string.uruguay, R.string.south_america, -34.899,-56.180, 8000, 2, "uru_montevideo", Stamp.F_CAP);
		createStamp(1093, R.string.colonia, R.string.colonia_desc, R.string.uruguay, R.string.south_america, -34.468,-57.840, 1000, 1, "uru_colonia", Stamp.F_CITY | Stamp.F_C_WHS);

		createStamp(1094, R.string.tashkent, R.string.tashkent_desc, R.string.uzbekistan, R.string.asia, 41.301,69.249, 9000, 2, "uzb_tashkent", Stamp.F_CAP);
		createStamp(1095, R.string.bukhara, R.string.bukhara_desc, R.string.uzbekistan, R.string.asia, 39.775,64.422, 2000, 1, "uzb_bukhara", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1096, R.string.samarkand, R.string.samarkand_desc, R.string.uzbekistan, R.string.asia, 39.656,66.953, 6000, 2, "uzb_samarkand", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1097, R.string.shakrisyabz, R.string.shakrisyabz_desc, R.string.uzbekistan, R.string.asia, 39.057,66.829, 3000, 1, "uzb_shakrisyabz", Stamp.F_CITY | Stamp.F_C_WHS);

		createStamp(1098, R.string.port_vila, R.string.port_vila_desc, R.string.vanuatu, R.string.australia_continent, -17.735,168.313, 3000, 2, "van_vila", Stamp.F_CAP);

		createStamp(1099, R.string.caracas, R.string.caracas_desc, R.string.venezuela, R.string.south_america, 10.502,-66.918, 8000, 2, "ven_caracas", Stamp.F_CAP | Stamp.F_C_WHS | Stamp.FEATURE_MOUNTAIN);
		createStamp(1100, R.string.coro, R.string.coro_desc, R.string.venezuela, R.string.south_america, 11.402,-69.672, 4000, 1, "ven_coro", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1101, R.string.maracaibo, R.string.maracaibo_desc, R.string.venezuela, R.string.south_america, 10.650,-71.633, 6000, 1, "ven_maracaibo", Stamp.F_CITY);
		createStamp(1102, R.string.canaima, R.string.canaima_desc, R.string.venezuela, R.string.south_america, 5.496,-62.002, 50000, 2, "ven_canaima", Stamp.F_N_WHS | Stamp.F_MNT);
		createStamp(1103, R.string.henri_pittier, R.string.henri_pittier_desc, R.string.venezuela, R.string.south_america, 10.497,-67.644, 15000, 1, "ven_pittier", Stamp.F_MNT);
		createStamp(1104, R.string.sierra_nevada_ven, R.string.sierra_nevada_ven_desc, R.string.venezuela, R.string.south_america, 8.494,-70.884, 20000, 1, "ven_nevada", Stamp.F_MNT);
		createStamp(1105, R.string.restinga, R.string.restinga_desc, R.string.venezuela, R.string.south_america, 10.993,-64.158, 1500, 1, "ven_restinga", Stamp.FEATURE_OUTDOOR);

		createStamp(1106, R.string.hanoi, R.string.hanoi_desc, R.string.vietnam, R.string.asia, 21.031,105.841, 7000, 2, "vie_hanoi", Stamp.F_CAP | Stamp.F_C_WHS);
		createStamp(1107, R.string.saigon, R.string.saigon_desc, R.string.vietnam, R.string.asia, 10.782,106.655, 7000, 1, "vie_saigon", Stamp.F_CITY);
		createStamp(1108, R.string.hue, R.string.hue_desc, R.string.vietnam, R.string.asia, 16.470,107.578, 1000, 1, "vie_hue", Stamp.F_CITY | Stamp.F_C_WHS);
		createStamp(1109, R.string.my_son, R.string.my_son_desc, R.string.vietnam, R.string.asia, 15.763,108.124, 600, 1, "vie_son", Stamp.F_C_WHS);
		createStamp(1110, R.string.ha_long, R.string.ha_long_desc, R.string.vietnam, R.string.asia, 20.836,107.139, 8000, 2, "vie_long", Stamp.F_MNT | Stamp.F_N_WHS);
		createStamp(1111, R.string.cuc_phuong, R.string.cuc_phuong_desc, R.string.vietnam, R.string.asia, 20.322,105.614, 3000, 1, "vie_phuong", Stamp.F_MNT);
		createStamp(1112, R.string.nha_ke, R.string.nha_ke_desc, R.string.vietnam, R.string.asia, 17.568,106.139, 7000, 1, "vie_nha", Stamp.FEATURE_OUTDOOR);

		createStamp(1113, R.string.road_town, R.string.road_town_desc, R.string.virgin_islands_british, R.string.central_america, 18.427,-64.619, 1000, 1, "vib_road", Stamp.F_CAP);

		createStamp(1114, R.string.charlotte, R.string.charlotte_desc, R.string.virgin_islands_us, R.string.central_america, 18.342,-64.931, 1000, 1, "via_charlotte", Stamp.F_CAP);

		createStamp(1115, R.string.mata_utu, R.string.mata_utu_desc, R.string.wallis_and_futuna_islands, R.string.australia_continent, -13.282,-176.176, 1000, 1, "wal_mata", Stamp.F_CAP);

		createStamp(1116, R.string.el_aaiun, R.string.el_aaiun_desc, R.string.western_sahara, R.string.africa, 27.150,-13.199, 3000, 2, "wes_aaiun", Stamp.F_CAP);

		createStamp(1117, R.string.zabid, R.string.zabid_desc, R.string.yemen, R.string.asia, 14.195,43.316, 1000, 1, "yem_zabid", Stamp.F_C_WHS | Stamp.F_CITY);
		createStamp(1118, R.string.sanaa, R.string.sanaa_desc, R.string.yemen, R.string.asia, 15.365,44.210, 5000, 2, "yem_sanaa", Stamp.F_C_WHS | Stamp.F_CAP);
		createStamp(1119, R.string.shibam, R.string.shibam_desc, R.string.yemen, R.string.asia, 15.920,48.634, 1500, 2, "yem_shibam", Stamp.F_C_WHS | Stamp.F_CITY);

		createStamp(1120, R.string.lusaka, R.string.lusaka_desc, R.string.zambia, R.string.africa, -15.414,28.289, 5000, 2, "zam_lusaka", Stamp.F_CAP);
		createStamp(1121, R.string.victoria_falls, R.string.victoria_falls_desc, R.string.zambia, R.string.africa, -17.926,25.859, 800, 2, "zam_victoria", Stamp.F_N_WHS);
		createStamp(1122, R.string.kafue, R.string.kafue_desc, R.string.zambia, R.string.africa, -14.608,25.882, 30000, 2, "zam_kafue", Stamp.FEATURE_OUTDOOR);
		createStamp(1123, R.string.lochinvar, R.string.lochinvar_desc, R.string.zambia, R.string.africa, -15.897,27.228, 6000, 1, "zam_lochinvar", Stamp.FEATURE_OUTDOOR);
		createStamp(1124, R.string.lower_zambezi, R.string.lower_zambezi_desc, R.string.zambia, R.string.africa, -15.398,29.660, 30000, 1, "zam_lower_zambezi", Stamp.FEATURE_OUTDOOR);
		createStamp(1125, R.string.south_luangwa, R.string.south_luangwa_desc, R.string.zambia, R.string.africa, -12.796,31.676, 45000, 2, "zam_south_luangwa", Stamp.FEATURE_OUTDOOR);

		createStamp(1126, R.string.harare, R.string.harare_desc, R.string.zimbabwe, R.string.africa, -17.830,31.052, 8000, 2, "zim_harare", Stamp.F_CAP);
		createStamp(1127, R.string.great_zimbabwe, R.string.great_zimbabwe_desc, R.string.zimbabwe, R.string.africa, -20.271,30.932, 800, 1, "zim_zimbabwe", Stamp.F_C_WHS);
		createStamp(1128, R.string.khami, R.string.khami_desc, R.string.zimbabwe, R.string.africa, -20.158,28.377, 800, 1, "zim_khami", Stamp.F_C_WHS);
		createStamp(1129, R.string.chimanimani, R.string.chimanimani_desc, R.string.zimbabwe, R.string.africa, -19.803,32.874, 4000, 1, "zim_chimanimani", Stamp.F_MNT);
		createStamp(1130, R.string.hwange, R.string.hwange_desc, R.string.zimbabwe, R.string.africa, -19.054,26.575, 60000, 1, "zim_hwange", Stamp.FEATURE_OUTDOOR);
		createStamp(1131, R.string.matobo, R.string.matobo_desc, R.string.zimbabwe, R.string.africa, -20.540,28.520, 10000, 2, "zim_matobo", Stamp.F_MNT | Stamp.F_N_WHS);

		Collections.sort(mStamps, Stamp.getByLatComparator());

		for (StampGroup s : mContinents)
			s.sort (mContext);

		for (StampGroup s : mCountries)
			s.sort (mContext);

		for (StampGroup s : mFeatures)
			s.sort (mContext);
	}

	private List<Stamp> getNearbyStamps (Location loc, double degreeDelta) {
		ArrayList<Stamp> stamps = new ArrayList<Stamp> ();

		double latDelta = degreeDelta;
		double lonDelta = 2 * latDelta;

		for (Stamp s : mStamps) {
			if (s.isVisited())
				continue;

			if (Math.abs(s.getLatitude() - loc.getLatitude()) < latDelta) {
					if (Math.abs(loc.getLatitude()) > 60 || (Math.abs(s.getLongitude() - loc.getLongitude()) < lonDelta))
						stamps.add(s);
			} else if (s.getLatitude() > loc.getLatitude())
				break;
		}

		return stamps;
	}

	public Stamp checkStamps (Location loc, StateSave state) {
		List<Stamp> nearbyStamps = getNearbyStamps (loc, 0.5);

		Stamp newlyVisitedStamp = null;

		for (Stamp s : nearbyStamps) {
			float[] distance = new float[1];

			Location.distanceBetween(loc.getLatitude(), loc.getLongitude(), s.getLatitude(), s.getLongitude(), distance);

			if (distance[0] <= s.getRadiusMeters()) {
				s.setVisited(true);
				state.visit(s.getId());
				newlyVisitedStamp = s;
				break;
			}
		}

		if (newlyVisitedStamp != null)
			updateState (null);

		return newlyVisitedStamp;
	}

	private void refreshCounters () {
		for (StampGroup g : mCountries)
			g.refreshCounters ();

		for (StampGroup g : mContinents)
			g.refreshCounters ();

		for (StampGroup g : mFeatures)
			g.refreshCounters();
	}

	private void refreshScore () {
		mScore = 0;
		mVisitedLocations = 0;
		mVisitedCountries = 0;
		mVisitedContinents = 0;

		for (Stamp s : mStamps)
			if (s.isVisited()) {
				mVisitedLocations++;
				mScore += s.getWeight();
			}

		for (StampGroup g : mCountries)
			if (g.getVisitedCount() > 0) {
				mVisitedCountries++;
				mScore += 5;
			}

		for (StampGroup g : mContinents)
			if (g.getVisitedCount() > 0) {
				mVisitedContinents++;
				mScore += 10;
			}
	}

	public void updateState (StateSave state) {
		if (state != null) {
			for (Stamp s : mStamps) {
				for (int i : state.getVisitedLocations())
					if (i == s.getId())
						s.setVisited(true);
			}
		}

		refreshCounters ();
		refreshScore ();
	}

	public List<Stamp> getStamps() {
		return mStamps;
	}

	public List<StampGroup> getContinents() {
		return mContinents;
	}

	public List<StampGroup> getCountries() {
		return mCountries;
	}

	public List<StampGroup> getFeatures() {
		return mFeatures;
	}

	public int getScore() {
		return mScore;
	}

	public int getVisitedLocations() {
		return mVisitedLocations;
	}

	public int getVisitedCountries() {
		return mVisitedCountries;
	}

	public int getVisitedContinents() {
		return mVisitedContinents;
	}
}
