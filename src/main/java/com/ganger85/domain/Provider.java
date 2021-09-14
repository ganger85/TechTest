package com.ganger85.domain;

import com.ganger85.repository.Record;

import java.util.Set;

public interface Provider {
    Set<Record> getRecords();
}
