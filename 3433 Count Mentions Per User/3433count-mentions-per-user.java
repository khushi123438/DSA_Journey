import java.util.*;

class Solution {
    static class Event {
        String type;
        int time;
        String info;
        Event(String t, int ti, String in) {
            type = t; time = ti; info = in;
        }
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int n = events.size();
        List<Event> list = new ArrayList<>();
        for (List<String> e : events) {
            list.add(new Event(e.get(0), Integer.parseInt(e.get(1)), e.get(2)));
        }

       
        list.sort(Comparator.comparingInt(a -> a.time));

        boolean[] online = new boolean[numberOfUsers];
        Arrays.fill(online, true);

        int[] offlineUntil = new int[numberOfUsers];
        Arrays.fill(offlineUntil, -1);

        int[] mentions = new int[numberOfUsers];

        int i = 0;
        while (i < n) {
            int currTime = list.get(i).time;

          
            int r = i;
            while (r < n && list.get(r).time == currTime) r++;

           
            for (int u = 0; u < numberOfUsers; u++) {
                if (!online[u] && offlineUntil[u] <= currTime) {
                    online[u] = true;
                    offlineUntil[u] = -1;
                }
            }

    
            for (int k = i; k < r; k++) {
                if (list.get(k).type.equals("OFFLINE")) {
                    int user = Integer.parseInt(list.get(k).info);
                    online[user] = false;
                    offlineUntil[user] = currTime + 60;
                }
            }

           
            for (int k = i; k < r; k++) {
                if (list.get(k).type.equals("MESSAGE")) {
                    processMessage(list.get(k).info, online, mentions);
                }
            }

            i = r;
        }

        return mentions;
    }

    private void processMessage(String msg, boolean[] online, int[] mentions) {
        int n = mentions.length;
        String[] tokens = msg.split(" ");
        for (String t : tokens) {
            if (t.equals("ALL")) {
                for (int u = 0; u < n; u++) mentions[u]++;
            } else if (t.equals("HERE")) {
                for (int u = 0; u < n; u++) if (online[u]) mentions[u]++;
            } else if (t.startsWith("id")) {
                int id = Integer.parseInt(t.substring(2));
                if (id >= 0 && id < n) mentions[id]++;
            }
        }
    }
}
