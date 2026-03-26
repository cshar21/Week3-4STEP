package main.java;

import java.util.*;

public class UC3TradeVolumeAnalysis {

    public static class Trade {
        String id;
        int volume;

        public Trade(String id, int volume) {
            this.id = id;
            this.volume = volume;
        }

        @Override
        public String toString() {
            return id + ":" + volume;
        }
    }

    // Merge Sort ascending
    public static void mergeSort(Trade[] trades) {
        if (trades.length < 2) return;
        int mid = trades.length / 2;
        Trade[] left = Arrays.copyOfRange(trades, 0, mid);
        Trade[] right = Arrays.copyOfRange(trades, mid, trades.length);
        mergeSort(left);
        mergeSort(right);
        merge(trades, left, right);
    }

    private static void merge(Trade[] trades, Trade[] left, Trade[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].volume <= right[j].volume) trades[k++] = left[i++];
            else trades[k++] = right[j++];
        }
        while (i < left.length) trades[k++] = left[i++];
        while (j < right.length) trades[k++] = right[j++];
    }

    // Quick Sort descending
    public static void quickSortDesc(Trade[] trades, int low, int high) {
        if (low < high) {
            int pi = partition(trades, low, high);
            quickSortDesc(trades, low, pi - 1);
            quickSortDesc(trades, pi + 1, high);
        }
    }

    private static int partition(Trade[] trades, int low, int high) {
        int pivot = trades[high].volume;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (trades[j].volume > pivot) {
                i++;
                Trade temp = trades[i];
                trades[i] = trades[j];
                trades[j] = temp;
            }
        }
        Trade temp = trades[i + 1];
        trades[i + 1] = trades[high];
        trades[high] = temp;
        return i + 1;
    }

    public static int totalVolume(Trade[] trades) {
        int sum = 0;
        for (Trade t : trades) sum += t.volume;
        return sum;
    }
}