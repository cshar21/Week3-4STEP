package main.java;

import java.util.*;

public class UC1TransactionFeeSort {

    public static class Transaction {
        String id;
        double fee;
        String timestamp;

        public Transaction(String id, double fee, String timestamp) {
            this.id = id;
            this.fee = fee;
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return id + ":" + fee + "@" + timestamp;
        }
    }

    // Bubble Sort by fee
    public static void bubbleSortFee(List<Transaction> transactions) {
        int n = transactions.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (transactions.get(j).fee > transactions.get(j + 1).fee) {
                    Collections.swap(transactions, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Insertion Sort by fee + timestamp
    public static void insertionSortFeeTimestamp(List<Transaction> transactions) {
        for (int i = 1; i < transactions.size(); i++) {
            Transaction key = transactions.get(i);
            int j = i - 1;
            while (j >= 0 && (transactions.get(j).fee > key.fee ||
                    (transactions.get(j).fee == key.fee && transactions.get(j).timestamp.compareTo(key.timestamp) > 0))) {
                transactions.set(j + 1, transactions.get(j));
                j--;
            }
            transactions.set(j + 1, key);
        }
    }

    // High fee outliers
    public static List<Transaction> getHighFeeOutliers(List<Transaction> transactions, double threshold) {
        List<Transaction> outliers = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.fee > threshold) outliers.add(t);
        }
        return outliers;
    }
}