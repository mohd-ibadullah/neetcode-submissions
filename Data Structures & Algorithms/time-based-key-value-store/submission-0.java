class TimeMap {
    private static class Pair<K, V> {
        private final K key;
        private final V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    HashMap<String, List<Pair<String, Integer>>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        hm.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair<>(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<Pair<String, Integer>> v = hm.getOrDefault(key, new ArrayList<>());
        int l = 0;
        int r = v.size() - 1;
        String result = "";
        while (l <= r) {
            int m = (l + r) / 2;
            if (v.get(m).getValue() <= timestamp) {
                result = v.get(m).getKey();
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return result;
    }
}
