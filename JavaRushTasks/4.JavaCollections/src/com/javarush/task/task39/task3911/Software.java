package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (rollbackVersion >= currentVersion) return false;
        Map<Integer, String> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, String> pair : versionHistoryMap.entrySet()) {
            result.put(pair.getKey(), pair.getValue());
            if (pair.getKey() == rollbackVersion) {
                currentVersion = pair.getKey();
                break;
            }
        }
        versionHistoryMap = result;
        return true;
    }
}
