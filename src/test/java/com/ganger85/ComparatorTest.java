package com.ganger85;

import com.ganger85.domain.Comparator;
import com.ganger85.repository.Record;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ComparatorTest {

    @Test
    public void ComparatorTest() {
        Comparator sut = new Comparator(() -> {
            Set<Record> current = new HashSet<>();
            current.add(new Record("1"));
            return current;
        });

        String result = sut.compareResults();
        assertEquals("newers-->[]deleted-->[]", result);

    }

    @Test
    public void newerTest() {
        Comparator sut = new Comparator();
        Set<Record> latest = new HashSet<>();
        Set<Record> current = new HashSet<>();
        latest.add(new Record("1"));
        current.add(new Record("1"));
        current.add(new Record("2"));

        Set<Record> newers = sut.getNewers(latest, current);
        assertEquals(1, newers.size());
    }

    @Test
    public void deletedTest() {
        Comparator sut = new Comparator();
        Set<Record> latest = new HashSet<>();
        Set<Record> current = new HashSet<>();
        current.add(new Record("1"));
        latest.add(new Record("1"));
        latest.add(new Record("2"));

        Set<Record> deleted = sut.getDeleted(latest, current);
        assertEquals(1, deleted.size());
    }
}
