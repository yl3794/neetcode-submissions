class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < times.length; i++) {
            int from = times[i][0];
            int to = times[i][1];
            int weight = times[i][2];

            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<int[]>());
            }

            map.get(from).add(new int[]{to, weight});
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare (int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        minHeap.offer(new int[]{0, k});

        Set<Integer> visit = new HashSet<>();

        int lastDistance = 0;
        while (!minHeap.isEmpty()) {
            int[] candidate = minHeap.poll();
            int distanceSoFar = candidate[0];
            int currNode = candidate[1]; 

            if (visit.contains(currNode)) {
                continue;
            }

            visit.add(currNode);
            lastDistance = distanceSoFar;

            if (map.containsKey(currNode)) {
                List<int[]> neighbors = map.get(currNode);
                for (int i = 0; i < neighbors.size(); i++) {
                    int neighborNode = neighbors.get(i)[0];
                    int roadWeight = neighbors.get(i)[1];

                    if (!visit.contains(neighborNode)) {
                        int newDistance = distanceSoFar + roadWeight;
                        minHeap.offer(new int[]{newDistance, neighborNode});
                    }
                }
            }
        }

        if (visit.size() == n) {
            return lastDistance;
        } else {
            return -1;
        }

    }
}
