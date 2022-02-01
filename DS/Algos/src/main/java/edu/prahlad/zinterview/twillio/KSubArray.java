package edu.prahlad.zinterview.twillio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KSubArray {
    public static long kSub1(int k, List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0, sum = 0;

        for(Integer num: nums){
            sum = (sum + num) % k;
            if(sum < 0) sum += k;

            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;
    }
}
