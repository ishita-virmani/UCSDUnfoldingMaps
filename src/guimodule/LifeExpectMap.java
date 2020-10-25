package guimodule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectMap extends PApplet {

	private UnfoldingMap map;
	Map<String, Float> lifeExpectancyByCountry;

	List<Feature> countries;
	List<Marker> countryMarkers;

	public void setup() {
		size(800, 600, OPENGL);
//		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		map = new UnfoldingMap(this, 50, 50, 700, 500, new OpenStreetMap.OpenStreetMapProvider());

		MapUtils.createDefaultEventDispatcher(this, map);

		lifeExpectancyByCountry = loadLifeExpectancyFromCSV("LifeExpectancyWorldBankModule3.csv");

		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);

		map.addMarkers(countryMarkers);
		shadeCountries();
	}

	public void draw() {
		map.draw();
	}

	private void shadeCountries() {
		for (Marker m : countryMarkers) {
			String countryId = m.getId();

			if (lifeExpectancyByCountry.containsKey(countryId)) {
				Float lifeExpectancy = lifeExpectancyByCountry.get(countryId);
				int colorLevel = (int) map(lifeExpectancy, 40, 90, 0, 255);
				m.setColor(color(255 - colorLevel, 50, colorLevel));
			} else {
				m.setColor(color(100, 100, 100));
			}
		}

	}

	// Helper method to load life expectancy data from file
	private Map<String, Float> loadLifeExpectancyFromCSV(String fileName) {
		Map<String, Float> lifeExpMap = new HashMap<String, Float>();

		String[] rows = loadStrings(fileName);

		for (String row : rows) {
			String[] cols = row.split(",");

			if (cols.length == 6 && !cols[5].equals("..")) {
				Float value = Float.parseFloat(cols[5]);
				lifeExpMap.put(cols[4], value);
			}
		}
		return lifeExpMap;
	}
}
