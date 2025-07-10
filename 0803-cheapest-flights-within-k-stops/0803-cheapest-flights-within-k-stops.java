public class Solution {
    static class Node {
        int city;
        int cost;
        int stops;

        public Node(int city, int cost, int stops) {
            this.city = city;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], x -> new ArrayList<>()).add(new int[]{f[1], f[2]});
        }

        // Min-heap: ordered by cost
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Node(src, 0, 0));

        // Visited: [city][stops] = min cost to reach that city with given stops
        int[][] visited = new int[n][K + 2];
        for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);
        visited[src][0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int city = node.city;
            int cost = node.cost;
            int stops = node.stops;

            // Reached destination
            if (city == dst) return cost;

            // If we can still take more stops
            if (stops <= K) {
                for (int[] nei : graph.getOrDefault(city, new ArrayList<>())) {
                    int nextCity = nei[0];
                    int price = nei[1];
                    int newCost = cost + price;

                    if (newCost < visited[nextCity][stops + 1]) {
                        visited[nextCity][stops + 1] = newCost;
                        pq.offer(new Node(nextCity, newCost, stops + 1));
                    }
                }
            }
        }

        return -1;
    }
}
