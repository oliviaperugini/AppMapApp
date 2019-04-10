package com.example.practicemapapp;

import java.util.ArrayList;
import java.util.List;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.content.Context;
import android.preference.PreferenceManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.widget.Button;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;

import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.views.MapView;
import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.api.IMapController;
import org.osmdroid.views.overlay.infowindow.MarkerInfoWindow;
import org.osmdroid.views.overlay.Marker; // Used for markers
import org.osmdroid.views.overlay.OverlayItem;


// MainActivity is responsible for creating the map of app state's campus
// and adding the markers.
public class MainActivity extends Activity {

    MapView map;
    IMapController mapController;
    LocationManager locationManager;
    //List<MarkerGeoPair<Marker, GeoPoint>> markerGeoList =
    //        new ArrayList<MarkerGeoPair<Marker, GeoPoint>>();

    // MARKERS
    ArrayList<Marker> markers;
    // Activity centers, food, and larger buildings
    Marker srcMarker;
    Marker broyhillEventMarker;
    Marker broyhillMusicMarker;
    Marker schaeferMarker;
    Marker stadiumMarker;
    Marker trivetteMarker;
    Marker athleticsCenterMarker;
    Marker quinnMarker;
    Marker parkingDeckMarker;       // Parking deck, University Police, and Traffic & Parking Dept.
    Marker jetMarker;
    Marker convoMarker;
    Marker chancellorsHouseMarker;
    Marker estesHouseMarker;        // Estes House - Environmental Services
    Marker turchinMarker;
    Marker valborgTheaterMarker;
    Marker libraryMarker;
    Marker doughertyMarker;         // Dougherty Building
    Marker sanfordMallMarker;
    Marker roessMarker;             // Central/Roess Dining Hall
    Marker varsityMarker;           // Varsity Gym
    Marker tennisMarker;
    Marker bbDoughertyMarker;
    Marker igGreerMarker;
    Marker mailMarker;              // Mail apart of health services building
    Marker healthServicesMarker;
    Marker studentUnionMarker;      // student union, solarium, bookstore, food, coffee, ...
    Marker bookstoreMarker;
    Marker foundersMarker;
    Marker alumniMarker;
    Marker legendsMarker;
    Marker softballStadiumMarker;   // Sywassink / Lloyd Family Stadium
    Marker sofieldIndoorMarker;     // Sofield Family Indoor Practice Facility
    Marker baseballStadiumMarker;   // Baseball Stadium (Jim and Bettie Smith Baseball Stadium)
    // School building halls
    Marker weyMarker;
    Marker garwoodMarker;
    Marker katharpMarker;
    Marker peacockMarker;
    Marker chapelWilsonMarker;
    Marker edwinDuncanMarker;
    Marker rankinWestMarker;
    Marker rankinNorthMarker;
    Marker smithWrightMarker;
    Marker doughertyHallMarker;     // DD Dougherty Hall
    Marker anneBelkMarker;
    Marker educationMarker;
    Marker sanfordMarker;
    // Dorms
    Marker belkMarker;
    Marker frankMarker;
    Marker eggersMarker;
    Marker bowieMarker;
    Marker gardnerMarker;
    Marker coltraneMarker;
    Marker justiceMarker;
    Marker newlandMarker;
    Marker llcMarker;
    Marker appHeightsMarker;
    Marker mountaineerMarker;
    Marker summitMarker;
    Marker coneMarker;
    Marker appalachianMarker;   // Appalachian Hall
    Marker lovillMarker;
    Marker whiteMarker;
    Marker eastMarker;
    Marker doughtonMarker;
    Marker hoeyMarker;
    Marker cannonMarker;
    // Parking Lots & Decks
    Marker stadiumLotMarker;
    Marker hillStreetLotMarker;
    Marker holmesLotMarker;
    Marker appHeightsLotMarker;
    Marker greenwoodLotMarker;
    Marker peacockLotMarker;
    Marker collegeStreetDeckMarker;
    Marker admissionsLotMarker;
    Marker southLotMarker;          // South parking lot (by baseball stadium)

    // GEOPOINTS
    // Activity centers, food, and larger buildings
    GeoPoint srcGeoPoint;
    GeoPoint broyhillEventGeoPoint;
    GeoPoint broyhillMusicGeoPoint;
    GeoPoint schaeferGeoPoint;
    GeoPoint stadiumGeoPoint;
    GeoPoint trivetteGeoPoint;
    GeoPoint athleticsCenterGeoPoint;
    GeoPoint quinnGeoPoint;
    GeoPoint parkingDeckGeoPoint;   // parking deck, University Police, and Traffic & Parking Dept.
    GeoPoint jetGeoPoint;
    GeoPoint convoGeoPoint;
    GeoPoint chancellorsHouseGeoPoint;
    GeoPoint estesHouseGeoPoint;    // Estes House - Environmental Services
    GeoPoint turchinGeoPoint;
    GeoPoint valborgTheaterGeoPoint;
    GeoPoint libraryGeoPoint;
    GeoPoint doughertyGeoPoint;     // Dougherty Building
    GeoPoint sanfordMallGeoPoint;
    GeoPoint roessGeoPoint;         // Central/Roess Dining Hall
    GeoPoint varsityGeoPoint;       // Varsity Gym
    GeoPoint tennisGeoPoint;
    GeoPoint bbDoughertyGeoPoint;
    GeoPoint igGreerGeoPoint;
    GeoPoint mailGeoPoint;  // Mail apart of health services building
    GeoPoint healthServicesGeoPoint;
    GeoPoint studentUnionGeoPoint;  // student union, solarium, bookstore, food, coffee, ...
    GeoPoint bookstoreGeoPoint;
    GeoPoint foundersGeoPoint;
    GeoPoint alumniGeoPoint;
    GeoPoint legendsGeoPoint;
    GeoPoint softballStadiumGeoPoint; // Sywassink / Lloyd Family Stadium
    GeoPoint sofieldIndoorGeoPoint;   // Sofield Family Indoor Practice Facility
    GeoPoint baseballStadiumGeoPoint; // Baseball Stadium (Jim and Bettie Smith Baseball Stadium)
    // School building halls
    GeoPoint weyGeoPoint;
    GeoPoint garwoodGeoPoint;
    GeoPoint katharpGeoPoint;
    GeoPoint peacockGeoPoint;
    GeoPoint chapelWilsonGeoPoint;
    GeoPoint edwinDuncanGeoPoint;
    GeoPoint rankinWestGeoPoint;
    GeoPoint rankinNorthGeoPoint;
    GeoPoint smithWrightGeoPoint;
    GeoPoint doughertyHallGeoPoint;   // DD Dougherty Hall
    GeoPoint anneBelkGeoPoint;
    GeoPoint educationGeoPoint;
    GeoPoint sanfordGeoPoint;
    // Dorms
    GeoPoint belkGeoPoint;
    GeoPoint frankGeoPoint;
    GeoPoint eggersGeoPoint;
    GeoPoint bowieGeoPoint;
    GeoPoint gardnerGeoPoint;
    GeoPoint coltraneGeoPoint;
    GeoPoint justiceGeoPoint;
    GeoPoint newlandGeoPoint;
    GeoPoint llcGeoPoint;
    GeoPoint appHeightsGeoPoint;
    GeoPoint mountaineerGeoPoint;
    GeoPoint summitGeoPoint;
    GeoPoint coneGeoPoint;
    GeoPoint appalachianGeoPoint;   // Appalachian Hall
    GeoPoint lovillGeoPoint;
    GeoPoint whiteGeoPoint;
    GeoPoint eastGeoPoint;
    GeoPoint doughtonGeoPoint;
    GeoPoint hoeyGeoPoint;
    GeoPoint cannonGeoPoint;
    // Parking Lots & Decks
    GeoPoint stadiumLotGeoPoint;
    GeoPoint hillStreetLotGeoPoint;
    GeoPoint holmesLotGeoPoint;
    GeoPoint appHeightsLotGeoPoint;
    GeoPoint greenwoodLotGeoPoint;
    GeoPoint peacockLotGeoPoint;
    GeoPoint collegeStreetDeckGeoPoint;
    GeoPoint admissionsLotGeoPoint;
    GeoPoint southLotGeoPoint;        // South parking lot (by baseball stadium)

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // IMPORTANT: handle permissions before map is created.
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        setContentView(R.layout.activity_main);

        // OSM Map Initialize
        // important! set your user agent to prevent getting banned from the osm servers
        //Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setMultiTouchControls(true);
        mapController = map.getController();
        mapController.setZoom(17);
        GeoPoint startPoint = new GeoPoint(36.214201, -81.679850);
        mapController.setCenter(startPoint);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        setMarkers();
    }

    private void setMarkers() {

        createMarkerList();


       // Marker tempM;
        //GeoPoint tempG;
        //for (Marker m : markers) {
        //for ( MarkerGeoPair mg : markerGeoList ) {
        //    tempM = (Marker) mg.getMarker();
            //tempG = (GeoPoint) mg.getGeoPoint();
         //   tempM.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
         //   map.getOverlays().add(tempM);
            //map.getController().animateTo(tempG);
        //}

        for (Marker m: markers) {
            m.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
            map.getOverlays().add(m);
        }
    }

    private void createMarkerList() {

        markers = new ArrayList<Marker>();

        srcMarker = createMarker(srcMarker, srcGeoPoint, 36.216649, -81.686158,
                "Student Recreation Center (SRC)");
        broyhillMusicMarker = createMarker(broyhillMusicMarker, broyhillMusicGeoPoint, 36.215849,
                -81.684908, "Broyhill Music Center");
        broyhillEventMarker = createMarker(broyhillEventMarker, broyhillEventGeoPoint, 36.21443,
                -81.69318, "Broyhill Event Center");
        schaeferMarker = createMarker(schaeferMarker, schaeferGeoPoint, 36.215308, -81.683975,
                "Schaefer Center");
        stadiumMarker = createMarker(stadiumMarker, stadiumGeoPoint, 36.212222, -81.685648,
                "Kidd Brewer Stadium");
        trivetteMarker = createMarker(trivetteMarker, trivetteGeoPoint, 36.213432, -81.683686,
                "Trivette Hall");
        athleticsCenterMarker = createMarker(athleticsCenterMarker, athleticsCenterGeoPoint,
                36.211506, -81.686524, "Appalachian Athletics Center");
        quinnMarker = createMarker(quinnMarker, quinnGeoPoint, 36.211736, -81.683685,
                "Dwight W. Quinn Recreation Center");
        parkingDeckMarker = createMarker(parkingDeckMarker, parkingDeckGeoPoint, 36.212142, -81.680524,
                "Rivers Street Parking Deck/University Police/Traffic & Parking Dept.");
        jetMarker = createMarker(jetMarker, jetGeoPoint, 36.210996, -81.677734,
                "John E. Thomas Hall (JET)");
        convoMarker = createMarker(convoMarker, convoGeoPoint, 36.210743, -81.675851,
                "Holmes Convocation Center");
        chancellorsHouseMarker = createMarker(chancellorsHouseMarker, chancellorsHouseGeoPoint,
                36.213911, -81.688345, "Appalachian House and Chancellor's Residence");
        estesHouseMarker = createMarker(estesHouseMarker, estesHouseGeoPoint, 36.216885, -81.682889,
                "Estes House - Environmental Services");
        turchinMarker = createMarker(turchinMarker, turchinGeoPoint, 36.217015, -81.680703,
                "Turchin Center for the Visual Arts");
        valborgTheaterMarker = createMarker(valborgTheaterMarker, valborgTheaterGeoPoint, 36.216227,
                -81.681161, "Valborg Theater");
        libraryMarker = createMarker(libraryMarker, libraryGeoPoint, 36.21544, -81.68043,
                "Belk Library");
        doughertyMarker = createMarker(doughertyMarker, doughertyGeoPoint, 36.21433, -81.67865,
                "Dougherty Building");
        sanfordMallMarker = createMarker(sanfordMallMarker, sanfordMallGeoPoint, 36.21408, -81.67908,
                "Sanford Mall");
        roessMarker = createMarker(roessMarker, roessGeoPoint, 36.21305, -81.67996,
                "Roess(Central) Dining Hall");
        varsityMarker = createMarker(varsityMarker, varsityGeoPoint, 36.21341, -81.68081,
                "Varsity Gymnasium");
        tennisMarker = createMarker(tennisMarker, tennisGeoPoint, 36.21216, -81.67811,
                "Bob Light Tennis Courts");
        bbDoughertyMarker = createMarker(bbDoughertyMarker, bbDoughertyGeoPoint, 36.21255, -81.67747,
                "BB Dougherty Administration Building");
        igGreerMarker = createMarker(igGreerMarker, igGreerGeoPoint, 36.21322, -81.67845,
                "IG Greer Hall");
        mailMarker = createMarker(mailMarker, mailGeoPoint, 36.21532, -81.67897,
                "University Post Office");
        healthServicesMarker = createMarker(healthServicesMarker, healthServicesGeoPoint, 36.21549,
                -81.67891, "Student Health Services");
        studentUnionMarker = createMarker(studentUnionMarker, studentUnionGeoPoint, 36.21473,
                -81.67915, "Plemmons Student Union and Solarium");
        bookstoreMarker = createMarker(bookstoreMarker, bookstoreGeoPoint, 36.21500, -81.67960,
                "University Bookstore");
        foundersMarker = createMarker(foundersMarker, foundersGeoPoint, 36.21289, -81.67682,
                "Founders Hall");
        alumniMarker = createMarker(alumniMarker, alumniGeoPoint, 36.21053, -81.67420,
                "McKinney Alumni Center");
        legendsMarker = createMarker(legendsMarker, legendsGeoPoint, 36.21538, -81.67541,
                "Legends");
        softballStadiumMarker = createMarker(softballStadiumMarker, softballStadiumGeoPoint, 36.21278,
                -81.68758, "Softball @ Sywassink/Lloyd Family Stadium");
        sofieldIndoorMarker = createMarker(sofieldIndoorMarker, sofieldIndoorGeoPoint, 36.21222,
                -81.68726, "Sofield Family Indoor Practice Facility");
        baseballStadiumMarker = createMarker(baseballStadiumMarker, baseballStadiumGeoPoint, 36.21142,
                -81.69289, "Baseball Stadium (Jim and Bettie Smith Baseball Stadium)");
        weyMarker = createMarker(weyMarker, weyGeoPoint, 36.21461, -81.68412, "Wey Hall");
        garwoodMarker = createMarker(garwoodMarker, garwoodGeoPoint, 36.21270, -81.68177,
                "Garwood Hall");
        katharpMarker = createMarker(katharpMarker, katharpGeoPoint, 36.21163, -81.67943,
                "Katherine Harper Hall - W. Kerr Scott Hall");
        peacockMarker = createMarker(peacockMarker, peacockGeoPoint, 36.21634, -81.68232,
                "Peacock Hall");
        chapelWilsonMarker = createMarker(chapelWilsonMarker, chapelWilsonGeoPoint, 36.21592,
                -81.68143, "Chapel Wilson Hall");
        edwinDuncanMarker = createMarker(edwinDuncanMarker, edwinDuncanGeoPoint, 36.21482,
                -81.68208, "Edwin Duncan Hall");
        rankinWestMarker = createMarker(rankinWestMarker, rankinWestGeoPoint, 36.21398, -81.68162,
                "Rankin Science West");
        rankinNorthMarker = createMarker(rankinNorthMarker, rankinNorthGeoPoint, 36.21413,
                -81.68124, "Rankin Science North");
        smithWrightMarker = createMarker(smithWrightMarker, smithWrightGeoPoint, 36.21485,
                -81.68085, "Smith Wright Hall");
        doughertyHallMarker = createMarker(doughertyHallMarker, doughertyHallGeoPoint, 36.21479,
                -81.68015, "DD Dougherty Hall");
        anneBelkMarker = createMarker(anneBelkMarker, anneBelkGeoPoint, 36.21423, -81.68045,
                "Anne Belk Hall");
        educationMarker = createMarker(educationMarker, educationGeoPoint, 36.21605, -81.67915,
                "Reich College of Education");
        sanfordMarker = createMarker(sanfordMarker, sanfordGeoPoint, 36.21375, -81.67786,
                "Sanford Hall");
        belkMarker = createMarker(belkMarker, belkGeoPoint, 36.21457, -81.68519,
                "Belk Residence Hall");
        frankMarker = createMarker(frankMarker, frankGeoPoint, 36.21472, -81.68573,
                "Frank Residence Hall");
        eggersMarker = createMarker(eggersMarker, eggersGeoPoint, 36.21391, -81.68612,
                "Eggers Residence Hall");
        bowieMarker = createMarker(bowieMarker, bowieGeoPoint, 36.21349, -81.68620,
                "Bowie Residence Hall");
        gardnerMarker = createMarker(gardnerMarker, gardnerGeoPoint, 36.21254, -81.68399,
                "Gardner Residence Hall");
        coltraneMarker = createMarker(coltraneMarker, coltraneGeoPoint, 36.21247, -81.68347,
                "Coltrane Residence Hall");
        justiceMarker = createMarker(justiceMarker, justiceGeoPoint, 36.21285, -81.68288,
                "Justice Residence Hall");
        newlandMarker = createMarker(newlandMarker, newlandGeoPoint, 36.21404, -81.68387,
                "Newland Residence Hall");
        llcMarker = createMarker(llcMarker, llcGeoPoint, 36.21552, -81.68618, "Living Learning Center");
        appHeightsMarker = createMarker(appHeightsMarker, appHeightsGeoPoint, 36.21502, -81.68936,
                "Appalachian Heights Residence Hall");
        mountaineerMarker = createMarker(mountaineerMarker, mountaineerGeoPoint, 36.21649, -81.68918,
                "Mountaineer Residence Hall");
        summitMarker = createMarker(summitMarker, summitGeoPoint, 36.21441, -81.67782,
                "Summit Residence Hall");
        coneMarker = createMarker(coneMarker, coneGeoPoint, 36.21463, -81.67725,
                "Cone Residence Hall");
        appalachianMarker = createMarker(appalachianMarker, appalachianGeoPoint, 36.21419, -81.67734,
                "Appalachian Residence Hall");
        lovillMarker = createMarker(lovillMarker, lovillGeoPoint, 36.21399, -81.67657,
                "Lovill Residence Hall");
        whiteMarker = createMarker(whiteMarker, whiteGeoPoint, 36.21464, -81.67667,
                "White Residence Hall");
        eastMarker = createMarker(eastMarker, eastGeoPoint, 36.21375, -81.67705,
                "East Residence Hall");
        doughtonMarker = createMarker(doughtonMarker, doughtonGeoPoint, 36.21454, -81.67610,
                "Doughton Residence Hall");
        hoeyMarker = createMarker(hoeyMarker, hoeyGeoPoint, 36.21437, -81.67550, "Hoey Residence Hall");
        cannonMarker = createMarker(cannonMarker, cannonGeoPoint, 36.21387, -81.67594,
                "Cannon Residence Hall");
        stadiumLotMarker = createMarker(stadiumLotMarker, stadiumLotGeoPoint, 36.21350, -81.68509,
                "Kidd Brewer Stadium Parking");
        hillStreetLotMarker = createMarker(hillStreetLotMarker, hillStreetLotGeoPoint, 36.20912,
                -81.67879, "Hill Street Parking");
        holmesLotMarker = createMarker(holmesLotMarker, holmesLotGeoPoint, 36.21021, -81.67690,
                "Holmes Convocation Center Parking (George M. Holmes)");
        appHeightsLotMarker = createMarker(appHeightsLotMarker, appHeightsLotGeoPoint, 36.21506,
                -81.68980, "Appalachian Heights Parking");
        greenwoodLotMarker = createMarker(greenwoodLotMarker, greenwoodLotGeoPoint, 36.21377,
                -81.68919, "Greenwood Parking Lot");
        peacockLotMarker = createMarker(peacockLotMarker, peacockLotGeoPoint, 36.21589, -81.68279,
                "Peacock Parking");
        collegeStreetDeckMarker = createMarker(collegeStreetDeckMarker, collegeStreetDeckGeoPoint,
                36.21595,-81.68003, "College Street Parking Deck");
        admissionsLotMarker = createMarker(admissionsLotMarker, admissionsLotGeoPoint, 36.21064,
                -81.67723, "Admissions Parking");
        southLotMarker = createMarker(southLotMarker, southLotGeoPoint, 36.21274, -81.69365,
                "South Parking Lot");


        markers.add(srcMarker);
        markers.add(broyhillMusicMarker);
        markers.add(broyhillEventMarker);
        markers.add(schaeferMarker);
        markers.add(stadiumMarker);
        markers.add(trivetteMarker);
        markers.add(athleticsCenterMarker);
        markers.add(quinnMarker);
        markers.add(parkingDeckMarker);
        markers.add(jetMarker);
        markers.add(convoMarker);
        markers.add(chancellorsHouseMarker);
        markers.add(estesHouseMarker);
        markers.add(turchinMarker);
        markers.add(valborgTheaterMarker);
        markers.add(libraryMarker);
        markers.add(doughertyMarker);
        markers.add(sanfordMallMarker);
        markers.add(roessMarker);
        markers.add(varsityMarker);
        markers.add(tennisMarker);
        markers.add(bbDoughertyMarker);
        markers.add(igGreerMarker);
        markers.add(mailMarker);
        markers.add(healthServicesMarker);
        markers.add(studentUnionMarker);
        markers.add(bookstoreMarker);
        markers.add(foundersMarker);
        markers.add(alumniMarker);
        markers.add(legendsMarker);
        markers.add(softballStadiumMarker);
        markers.add(sofieldIndoorMarker);
        markers.add(baseballStadiumMarker);
        markers.add(weyMarker);
        markers.add(garwoodMarker);
        markers.add(katharpMarker);
        markers.add(peacockMarker);
        markers.add(chapelWilsonMarker);
        markers.add(edwinDuncanMarker);
        markers.add(rankinWestMarker);
        markers.add(rankinNorthMarker);
        markers.add(smithWrightMarker);
        markers.add(doughertyHallMarker);
        markers.add(anneBelkMarker);
        markers.add(educationMarker);
        markers.add(sanfordMarker);
        markers.add(belkMarker);
        markers.add(frankMarker);
        markers.add(eggersMarker);
        markers.add(bowieMarker);
        markers.add(gardnerMarker);
        markers.add(coltraneMarker);
        markers.add(justiceMarker);
        markers.add(newlandMarker);
        markers.add(llcMarker);
        markers.add(appHeightsMarker);
        markers.add(mountaineerMarker);
        markers.add(summitMarker);
        markers.add(coneMarker);
        markers.add(appalachianMarker);
        markers.add(lovillMarker);
        markers.add(whiteMarker);
        markers.add(eastMarker);
        markers.add(doughtonMarker);
        markers.add(hoeyMarker);
        markers.add(cannonMarker);
        markers.add(stadiumLotMarker);
        markers.add(hillStreetLotMarker);
        markers.add(holmesLotMarker);
        markers.add(appHeightsLotMarker);
        markers.add(greenwoodLotMarker);
        markers.add(peacockLotMarker);
        markers.add(collegeStreetDeckMarker);
        markers.add(admissionsLotMarker);
        markers.add(southLotMarker);

    }


    private Marker createMarker(Marker m, GeoPoint p, double lat, double lon, String title) {
        m = new Marker(map);
        p = new GeoPoint(lat, lon);
        m.setTitle(title);
        m.setPosition(p);
        //m.setIcon(new ColorDrawable(Color.BLUE));
        //m.setIcon(ContextCompat.getDrawable(mContext,R.drawable.order_pin));
        return m;
    }

}