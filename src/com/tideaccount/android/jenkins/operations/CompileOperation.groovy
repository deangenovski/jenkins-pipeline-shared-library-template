package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Constants

class CompileOperation extends GradleOperation {

    CompileOperation(List<BuildType> buildTypes) {
        super(buildTypes)
    }

    @Override
    String getGetArgumentFormat() {
        return Constants.COMPILE_FORMAT
    }
}
