package test.java;

import main.java.UC2ClientRiskSort;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UC2ClientRiskSortTest {

    @Test
    void testBubbleSortRisk() {
        List<UC2ClientRiskSort.Client> clients = Arrays.asList(
                new UC2ClientRiskSort.Client("C", 80, 1000),
                new UC2ClientRiskSort.Client("A", 20, 2000),
                new UC2ClientRiskSort.Client("B", 50, 1500)
        );
        UC2ClientRiskSort.bubbleSortRisk(clients);
        assertEquals("A", clients.get(0).name);
        assertEquals("B", clients.get(1).name);
        assertEquals("C", clients.get(2).name);
    }

    @Test
    void testInsertionSortRiskDesc() {
        List<UC2ClientRiskSort.Client> clients = Arrays.asList(
                new UC2ClientRiskSort.Client("C", 80, 1000),
                new UC2ClientRiskSort.Client("A", 20, 2000),
                new UC2ClientRiskSort.Client("B", 50, 1500)
        );
        UC2ClientRiskSort.insertionSortRiskDesc(clients);
        assertEquals("C", clients.get(0).name);
        assertEquals("B", clients.get(1).name);
        assertEquals("A", clients.get(2).name);
    }

    @Test
    void testTopRisks() {
        List<UC2ClientRiskSort.Client> clients = Arrays.asList(
                new UC2ClientRiskSort.Client("C", 80, 1000),
                new UC2ClientRiskSort.Client("A", 20, 2000),
                new UC2ClientRiskSort.Client("B", 50, 1500)
        );
        List<UC2ClientRiskSort.Client> top2 = UC2ClientRiskSort.topRisks(clients, 2);
        assertEquals(2, top2.size());
        assertEquals("C", top2.get(0).name);
        assertEquals("B", top2.get(1).name);
    }
}