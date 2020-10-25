package guimodule;

import java.util.ArrayList;
import java.util.List;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
//import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class MapVisualization extends PApplet {

	private UnfoldingMap map;

	public void setup() {
		size(950, 600, OPENGL);
		map = new UnfoldingMap(this, 200, 50, 700, 500, new OpenStreetMap.OpenStreetMapProvider());
//		map = new UnfoldingMap(this, 200, 50, 700, 500, new Google.GoogleMapProvider());
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);

		Location loc = new Location(-38.14f, -73.03f);
		Feature f = new PointFeature(loc);
		f.addProperty("title", "Valvidia, Chile");
		f.addProperty("magnitude", "9.5");
		f.addProperty("date", "May 22, 1960");
		f.addProperty("year", "1960");

		Marker m = new SimplePointMarker(loc, f.getProperties());
		map.addMarker(m);
		
		PointFeature alskaF = new PointFeature(new Location(61.02f, 147.65f));
		alskaF.addProperty("year", 1964);
		PointFeature sumatra = new PointFeature(new Location(3.30f, 95.78f));
		sumatra.addProperty("year", 2004);
		PointFeature japan = new PointFeature(new Location(38.32f, 142.36f));
		japan.addProperty("year", 2011);
		PointFeature kamchatka = new PointFeature(new Location(52.76f, 160.06f));
		kamchatka.addProperty("year", 1952);

		List<PointFeature> bigEqs = new ArrayList<PointFeature>();
		bigEqs.add(alskaF);
		bigEqs.add(sumatra);
		bigEqs.add(japan);
		bigEqs.add(kamchatka);

		List<Marker> markers = new ArrayList<Marker>();
		for (PointFeature eq : bigEqs) {
			markers.add(new SimplePointMarker(eq.getLocation(), eq.getProperties()));
		}

		for (Marker mk : markers) {
			if ((int) mk.getProperty("year") > 2000)
				mk.setColor(color(255, 204, 0));
			else
				mk.setColor(210);
		}

		map.addMarkers(markers);

	}

	public void draw() {
		background(10);
		map.draw();
		addKey();

	}

	private void addKey() {
		// Remember you can use Processing's graphics methods here

	}
}
