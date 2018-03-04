package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Constants

class CompileOperation extends GradleOperation {


    CompileOperation(List<BuildType> buildTypes, Integer buildNumber, String buildName) {
        super(buildTypes, buildNumber, buildName)
    }

    @Override
    protected String getArgumentFormat() {
        return Constants.COMPILE_FORMAT
    }
}
