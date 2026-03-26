package main.java;

import java.util.*;

public class UC6RiskThresholdSearch {

    // Linear search threshold match
    public static boolean linearSearch(int[] risks, int target) {
        for (int r : risks) if (r == target) return true;
        return false;
    }

    // Binary search for exact match
    public static int binarySearch(int[] risks, int target) {
        int low = 0, high = risks.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (risks[mid] == target) return mid;
            if (risks[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Floor (largest <= target)
    public static int floor(int[] risks, int target) {
        int low = 0, high = risks.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (risks[mid] <= target) {
                ans = risks[mid];
                low = mid + 1;
            } else high = mid - 1;
        }
        return ans;
    }

    // Ceiling (smallest >= target)
    public static int ceiling(int[] risks, int target) {
        int low = 0, high = risks.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (risks[mid] >= target) {
                ans = risks[mid];
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }
}