package com.tideaccount.android.jenkins

enum BuildType {


    QA_DUMMY("qa", "dummy"),
    QA_REAL("qa", "real"),
    STAGING_REAL("staging", "real")
    private final String env
    private final String user

    BuildType(String env, String user) {
        this.user = user
        this.env = env
    }

    String getEnv() {
        return env
    }

    String getUser() {
        return user
    }
}