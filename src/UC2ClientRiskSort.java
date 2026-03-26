package main.java;

import java.util.*;

public class UC2ClientRiskSort {

    public static class Client {
        String name;
        int riskScore;
        double accountBalance;

        public Client(String name, int riskScore, double accountBalance) {
            this.name = name;
            this.riskScore = riskScore;
            this.accountBalance = accountBalance;
        }

        @Override
        public String toString() {
            return name + ":" + riskScore;
        }
    }

    // Bubble sort ascending by riskScore
    public static void bubbleSortRisk(List<Client> clients) {
        int n = clients.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (clients.get(j).riskScore > clients.get(j + 1).riskScore) {
                    Collections.swap(clients, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Insertion sort descending by riskScore, ascending accountBalance
    public static void insertionSortRiskDesc(List<Client> clients) {
        for (int i = 1; i < clients.size(); i++) {
            Client key = clients.get(i);
            int j = i - 1;
            while (j >= 0 && (clients.get(j).riskScore < key.riskScore ||
                    (clients.get(j).riskScore == key.riskScore && clients.get(j).accountBalance > key.accountBalance))) {
                clients.set(j + 1, clients.get(j));
                j--;
            }
            clients.set(j + 1, key);
        }
    }

    // Top N risk clients
    public static List<Client> topRisks(List<Client> clients, int n) {
        List<Client> copy = new ArrayList<>(clients);
        insertionSortRiskDesc(copy);
        return copy.subList(0, Math.min(n, copy.size()));
    }
}