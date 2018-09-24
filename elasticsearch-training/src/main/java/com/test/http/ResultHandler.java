package com.test.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ResultHandler {

    public static List<HashMap> extractSources(HashMap originSource) {
        List<HashMap> documents = new ArrayList<HashMap>();
        try {
            Object obj = ((HashMap) originSource.get("hits")).get("hits");
            List<HashMap> hits = obj == null ? new ArrayList<HashMap>() : (List<HashMap>) obj;

            if (hits.size() == 0) {
                return documents;
            }
            for (HashMap source : hits) {
                documents.add((HashMap) source.get("_source"));
            }
        } catch (Exception e) {
            return Collections.emptyList();
        }
        return documents;
    }
}
