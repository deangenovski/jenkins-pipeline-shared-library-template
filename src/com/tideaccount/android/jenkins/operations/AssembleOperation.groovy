package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Constants

class AssembleOperation extends GradleOperation {

    AssembleOperation(BuildType... buildTypes) {
        super(buildTypes)
    }

    @Override
    String getGetArgumentFormat() {
        return Constants.ASSEMBLE_FORMAT
    }
}
