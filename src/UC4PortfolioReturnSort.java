package main.java;

import java.util.*;

public class UC4PortfolioReturnSort {

    public static class Asset {
        String name;
        double returnRate; // in percent
        double volatility;

        public Asset(String name, double returnRate, double volatility) {
            this.name = name;
            this.returnRate = returnRate;
            this.volatility = volatility;
        }

        @Override
        public String toString() {
            return name + ":" + returnRate + "%";
        }
    }

    // Merge Sort ascending by returnRate (stable)
    public static void mergeSort(Asset[] assets) {
        if (assets.length < 2) return;
        int mid = assets.length / 2;
        Asset[] left = Arrays.copyOfRange(assets, 0, mid);
        Asset[] right = Arrays.copyOfRange(assets, mid, assets.length);
        mergeSort(left);
        mergeSort(right);
        merge(assets, left, right);
    }

    private static void merge(Asset[] assets, Asset[] left, Asset[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].returnRate <= right[j].returnRate) assets[k++] = left[i++];
            else assets[k++] = right[j++];
        }
        while (i < left.length) assets[k++] = left[i++];
        while (j < right.length) assets[k++] = right[j++];
    }

    // Quick Sort descending returnRate, ascending volatility
    public static void quickSort(Asset[] assets, int low, int high) {
        if (low < high) {
            int pi = partition(assets, low, high);
            quickSort(assets, low, pi - 1);
            quickSort(assets, pi + 1, high);
        }
    }

    private static int partition(Asset[] assets, int low, int high) {
        Asset pivot = assets[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (assets[j].returnRate > pivot.returnRate ||
                    (assets[j].returnRate == pivot.returnRate && assets[j].volatility < pivot.volatility)) {
                i++;
                Asset temp = assets[i];
                assets[i] = assets[j];
                assets[j] = temp;
            }
        }
        Asset temp = assets[i + 1];
        assets[i + 1] = assets[high];
        assets[high] = temp;
        return i + 1;
    }
}