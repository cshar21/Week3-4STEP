package test.java;

import main.java.UC1TransactionFeeSort;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UC1TransactionFeeSortTest {

    @Test
    void testBubbleSortFee() {
        List<UC1TransactionFeeSort.Transaction> transactions = Arrays.asList(
                new UC1TransactionFeeSort.Transaction("id1", 10.5, "10:00"),
                new UC1TransactionFeeSort.Transaction("id2", 25.0, "09:30"),
                new UC1TransactionFeeSort.Transaction("id3", 5.0, "10:15")
        );
        UC1TransactionFeeSort.bubbleSortFee(transactions);
        assertEquals(5.0, transactions.get(0).fee);
        assertEquals(10.5, transactions.get(1).fee);
        assertEquals(25.0, transactions.get(2).fee);
    }

    @Test
    void testInsertionSortFeeTimestamp() {
        List<UC1TransactionFeeSort.Transaction> transactions = Arrays.asList(
                new UC1TransactionFeeSort.Transaction("id1", 10.5, "10:00"),
                new UC1TransactionFeeSort.Transaction("id2", 25.0, "09:30"),
                new UC1TransactionFeeSort.Transaction("id3", 5.0, "10:15")
        );
        UC1TransactionFeeSort.insertionSortFeeTimestamp(transactions);
        assertEquals("id3", transactions.get(0).id);
        assertEquals("id1", transactions.get(1).id);
        assertEquals("id2", transactions.get(2).id);
    }

    @Test
    void testHighFeeOutliers() {
        List<UC1TransactionFeeSort.Transaction> transactions = Arrays.asList(
                new UC1TransactionFeeSort.Transaction("id1", 10.5, "10:00"),
                new UC1TransactionFeeSort.Transaction("id2", 55.0, "09:30")
        );
        List<UC1TransactionFeeSort.Transaction> outliers = UC1TransactionFeeSort.getHighFeeOutliers(transactions, 50.0);
        assertEquals(1, outliers.size());
        assertEquals("id2", outliers.get(0).id);
    }
}