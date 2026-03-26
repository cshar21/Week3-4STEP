package main.java;

import java.util.*;

public class UC5AccountIDLookup {

    // Linear search for first occurrence
    public static int linearSearchFirst(String[] logs, String accountId) {
        for (int i = 0; i < logs.length; i++) {
            if (logs[i].equals(accountId)) return i;
        }
        return -1;
    }

    // Linear search for last occurrence
    public static int linearSearchLast(String[] logs, String accountId) {
        for (int i = logs.length - 1; i >= 0; i--) {
            if (logs[i].equals(accountId)) return i;
        }
        return -1;
    }

    // Binary search (logs must be sorted)
    public static int binarySearch(String[] logs, String accountId) {
        int low = 0, high = logs.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = logs[mid].compareTo(accountId);
            if (cmp == 0) return mid;
            if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    // Count occurrences in sorted array
    public static int countOccurrences(String[] logs, String accountId) {
        int count = 0;
        for (String s : logs) if (s.equals(accountId)) count++;
        return count;
    }
}