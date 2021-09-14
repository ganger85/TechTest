package com.ganger85.domain;

import com.ganger85.repository.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Comparator {
    @Autowired
    Provider recordProvider;

    Set<Record> previous = null;
    private static final Logger log = LoggerFactory.getLogger(Comparator.class);

    public Comparator() {
    }

    public Comparator(Provider provider) {
        recordProvider = provider;
    }

    @Scheduled(fixedRate = 30000)
    public String compareResults() {
        Set<Record> newers;
        Set<Record> deleted;

        Set<Record> current = recordProvider.getRecords();

        if (null == previous) {
            previous = current;
        }

        newers = getNewers(previous, current);
        deleted = getDeleted(previous, current);

        log.info("newers-->" + newers);
        log.info("deleted-->" + deleted);
        String result = "newers-->" + newers + "deleted-->" + deleted;

        previous = current;

        return result;
    }


    public Set<Record> getNewers(Set<Record> latest, Set<Record> current) {
        Set<Record> newers = new HashSet<>();

        newers.addAll(current);
        newers.removeAll(latest);

        return newers;
    }

    public Set<Record> getDeleted(Set<Record> latest, Set<Record> current) {
        Set<Record> deleted = new HashSet<>();

        deleted.addAll(latest);
        deleted.removeAll(current);

        return deleted;
    }
}
