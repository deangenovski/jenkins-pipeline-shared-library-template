package com.tideaccount.android.jenkins.operations

import com.tideaccount.android.jenkins.BuildType

import java.lang.reflect.Field

abstract class GradleOperation implements Serializable {

    List<BuildType> buildTypesField
    String buildName
    Integer buildNumber

    GradleOperation(List<BuildType> buildTypes, Integer buildNumber, String buildName) {

        if (buildTypes == null || buildTypes.size() == 0) {
            throw new IllegalStateException("Need at least one buildType to run this command")
        } else {
            System.out.println(buildTypes.size())
        }



        this.buildTypesField = buildTypes
        this.buildName = buildName
        this.buildNumber = buildNumber

    }

    def generateGradleArgumentFor(BuildType type) {
        return String.format(getArgumentFormat(), type.env.capitalize(), type.user.capitalize())
    }

    abstract protected String getArgumentFormat()

    String getGradleBuildString() {

        def buildStrings = []

        for (BuildType build : buildTypesField) {
            buildStrings.add(generateGradleArgumentFor(build))
        }

        return "./gradlew " + buildStrings.join(" ") +
                " -PbuildNumber=${buildNumber} " +
                "-PbuildName=${buildName}"

    }
}
