package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType

abstract class GradleOperation {

    private List<BuildType> buildTypes
    private String buildName
    private Integer buildNumber

    GradleOperation(List<BuildType> buildTypes, Integer buildNumber, String buildName) {

        if (buildTypes == null || buildTypes.size() == 0) {
            throw new IllegalStateException("Need at least one buildType to run this command")
        }



        this.buildTypes = buildTypes
        this.buildName = buildName
        this.buildNumber = buildNumber

    }

    def private generateGradleArgumentFor(BuildType type) {
        return String.format(getArgumentFormat(), type.env.capitalize(), type.user.capitalize())
    }

    abstract protected String getGetArgumentFormat()

    String getGradleBuildString() {
        def buildStrings = []

        print(buildTypes.toString())

//        for (BuildType build : buildTypes) {
//            buildStrings.add(generateGradleArgumentFor(build))
//        }
//
//        return "./gradlew " + buildStrings.join(" ") +
//                " -PbuildNumber=${buildNumber} " +
//                "-PbuildName=${buildName}"

        return "fake"
    }
}
