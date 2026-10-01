import java.util.ArrayList;
import java.util.List;

class UndergroundSystem {

    // Helper class to store check-in details for a customer
    private static class CheckInInfo {
        int id;
        String stationName;
        int time;

        CheckInInfo(int id, String stationName, int time) {
            this.id = id;
            this.stationName = stationName;
            this.time = time;
        }
    }

    // Helper class to store travel time data between two stations
    private static class RouteData {
        String startStation;
        String endStation;
        double totalTime;
        int tripCount;

        RouteData(String startStation, String endStation, int time) {
            this.startStation = startStation;
            this.endStation = endStation;
            this.totalTime = time;
            this.tripCount = 1;
        }
    }

    private List<CheckInInfo> checkIns;
    private List<RouteData> routes;

    public UndergroundSystem() {
        checkIns = new ArrayList<>();
        routes = new ArrayList<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.add(new CheckInInfo(id, stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        // Find and remove the check-in record for this user ID
        CheckInInfo info = null;
        for (int i = 0; i < checkIns.size(); i++) {
            if (checkIns.get(i).id == id) {
                info = checkIns.remove(i);
                break;
            }
        }

        if (info == null) return;

        int travelTime = t - info.time;
        String startStation = info.stationName;

        // Search for existing route in list
        RouteData route = null;
        for (RouteData r : routes) {
            if (r.startStation.equals(startStation) && r.endStation.equals(stationName)) {
                route = r;
                break;
            }
        }

        if (route != null) {
            route.totalTime += travelTime;
            route.tripCount++;
        } else {
            routes.add(new RouteData(startStation, stationName, travelTime));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        for (RouteData r : routes) {
            if (r.startStation.equals(startStation) && r.endStation.equals(endStation)) {
                return r.totalTime / r.tripCount;
            }
        }
        return 0.0;
    }
}