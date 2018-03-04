package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Constants
import com.tideaccount.android.jenkins.Keystore

class AssembleOperation extends SignOperation {


    AssembleOperation(List<BuildType> buildTypes, Integer buildNumber, String buildName, Keystore keystore) {
        super(buildTypes, buildNumber, buildName, keystore)
    }

    @Override
    protected String getArgumentFormat() {
        return Constants.ASSEMBLE_FORMAT
    }
}
