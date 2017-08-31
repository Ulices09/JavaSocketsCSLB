package clbss;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class Balancer {
    
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public Balancer() {
        map.put(1, 6666);
        map.put(2, 5555);
    }

    public Integer getServidor(){
        int servidor = (Math.random() <= 0.5) ? 1 : 2;
        return map.get(servidor);
    }
}
