package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType

abstract class SignOperation extends GradleOperation {

    SignOperation(BuildType... buildTypes) {
        super(buildTypes)
    }

    @Override
    def getGradleBuildString() {
        def buildString = super.getGradleBuildString()


        return buildString + " " + getSignString()
    }

    String getSignString() {
        return ""
    }
}
