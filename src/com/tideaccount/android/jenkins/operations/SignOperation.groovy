package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType
import com.tideaccount.android.jenkins.Keystore

abstract class SignOperation extends GradleOperation {

    private Keystore keystore

    SignOperation(List<BuildType> buildTypes, Integer buildNumber, String buildName, Keystore keystore) {
        super(buildTypes, buildNumber, buildName)
        this.keystore = keystore
    }

    @Override
    String getGradleBuildString() {
        def buildString = super.getGradleBuildString()


        return buildString + " " + getSignString()
    }

    private String getSignString() {
        return "-Ptide.signing=true " +
                "-PkeyStore=${keystore.keystore} " +
                "-PkeyStorePassword=${keystore.keystorePassword} " +
                "-Palias=tide " +
                "-PkeyPass=${keystore.keystorePassword} "

    }
}
