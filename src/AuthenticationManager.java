import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    public Map<String, Integer> map;
    public int timeToLive;

    public AuthenticationManager(int timeToLive) {
        this.map = new HashMap<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        this.map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if (!this.map.containsKey(tokenId) || currentTime - this.map.get(tokenId) >= timeToLive) {
            return;
        }
        this.map.put(tokenId, currentTime);
    }

    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (Integer time : this.map.values()) {
            if (currentTime - time < timeToLive) {
                ++count;
            }
        }
        return count;
    }
}
