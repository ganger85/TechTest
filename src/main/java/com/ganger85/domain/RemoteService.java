package com.ganger85.domain;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.LinkedHashMap;
import java.util.List;

public interface RemoteService {
    List<LinkedHashMap> getRecordList() throws JsonProcessingException;

}
