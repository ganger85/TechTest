package com.ganger85.domain;

import com.ganger85.repository.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@Component
public class RecordProvider implements Provider {

    @Autowired
    RemoteService caller;

    public RecordProvider() {
    }

    public RecordProvider(RemoteService caller) {
        this.caller = caller;
    }

    @Override
    public Set<Record> getRecords() {
        Set<Record> current = new HashSet<Record>();
        try {
            List<LinkedHashMap> result = caller.getRecordList();
            for (LinkedHashMap r : result) {
                current.add(new Record(r));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return current;
    }
}