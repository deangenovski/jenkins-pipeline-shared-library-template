package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Constants

class TestOperation extends GradleOperation {

    TestOperation(List<BuildType> buildTypes, Integer buildNumber, String buildName) {
        super(buildTypes, buildNumber, buildName)
    }

    @Override
    protected String getGetArgumentFormat() {
        return Constants.TEST_FORMAT
    }
}
