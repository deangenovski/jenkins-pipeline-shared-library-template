package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Keystore

abstract class SignOperation extends GradleOperation {

    private Keystore keystore

    SignOperation(List<BuildType> buildTypes, Keystore keystore) {
        super(buildTypes)
        this.keystore = keystore
    }

    @Override
    def getGradleBuildString() {
        def buildString = super.getGradleBuildString()


        return buildString + " " + getSignString()
    }

    String getSignString() {
        return "-Ptide.signing=true " +
                "-PkeyStore=${keystore.keystore} " +
                "-PkeyStorePassword=${keystore.keystorePassword} " +
                "-Palias=tide " +
                "-PkeyPass=${keystore.keystorePassword} " +
                "-PbuildNumber=${BUILD_NUMBER} " +
                "-PbuildName=${BRANCH_NAME}"
    }
}
