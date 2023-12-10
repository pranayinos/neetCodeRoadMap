import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    public static void main(String[] args) {
        /*
         * ["TimeMap", "set", "get", "get", "set", "get", "get"]
         * [[], ["foo", "bar", 1], ["foo", 1], ["foo", 3],
         * ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
         */
        TimeMap map = new TimeMap();
        map.set("foo", "bar", 1);
        System.out.println(map.get("foo", 1));
        System.out.println(map.get("foo", 3));
        map.set("foo", "barrrr2", 4);
        System.out.println(map.get("foo", 4));
        System.out.println(map.get("foo", 5));
    }

    static class TimeMap {
        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (map.containsKey(key)) {
                TreeMap<Integer, String> innerMap = map.get(key);
                innerMap.put(timestamp, value);
            } else {
                TreeMap<Integer, String> innerMap = new TreeMap<>();
                innerMap.put(timestamp, value);
                map.put(key, innerMap);
            }
        }

        public String get(String key, int timestamp) {
            if (map.containsKey(key)) {
                TreeMap<Integer, String> innerMap = map.get(key);
                if (innerMap.containsKey(timestamp)) {
                    return innerMap.get(timestamp);
                } else {
                    Map.Entry<Integer, String> entry = innerMap.lowerEntry(timestamp);
                    if (entry != null) {
                        return entry.getValue();
                    } else {
                        return "";
                    }
                }
            } else {
                return "";
            }
        }

    }

    /**
     * Your TimeMap object will be instantiated and called as such:
     * TimeMap obj = new TimeMap();
     * obj.set(key,value,timestamp);
     * String param_2 = obj.get(key,timestamp);
     */
}
