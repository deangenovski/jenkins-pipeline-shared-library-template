package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType

abstract class GradleOperation {

    def buildTypes

    GradleOperation(List<BuildType> buildTypes) {

        if (buildTypes == null || buildTypes.size() == 0) {
            throw new IllegalStateException("Need at least one buildType to run this command")
        }

        this.buildTypes = buildTypes

    }

    def generateGradleArgumentFor(BuildType type) {
        return String.format(getArgumentFormat(), type.env.capitalize(), type.user.capitalize())
    }

    abstract String getGetArgumentFormat()

    def getGradleBuildString() {
        def buildStrings = []

        for (BuildType build : buildTypes) {
            buildStrings.add(generateGradleArgumentFor(build))
        }

        return "./gradlew " + buildStrings.join(" ")
    }
}
