package com.tideaccount.android.jenkins

class Util {
    private static final String COMPILE_FORMAT = "compile%s%sReleaseSources"
    private static final String ASSEMBLE_FORMAT = "assemble%s%sRelease"
    private static final String TEST_FORMAT = "test%s%sReleaseUnitTest"
    private static final String UPLOAD_FORMAT = "crashlyticsUploadDistribution%s%sRelease"

    private static def buildGradleArgFor(String type, BuildType buildType) {
        return String.format(type, buildType.env.capitalize(), buildType.user.capitalize())
    }

    static def getCompileGradleArgFor(BuildType buildType) {
        return buildGradleArgFor(COMPILE_FORMAT, buildType)
    }


    static def getAssembleGradleArgFor(BuildType buildType) {
        return buildGradleArgFor(ASSEMBLE_FORMAT, buildType)
    }


    static def getTestGradleArgFor(BuildType buildType) {
        return buildGradleArgFor(TEST_FORMAT, buildType)
    }


    static def getUploadGradleArgFor(BuildType buildType) {
        return buildGradleArgFor(UPLOAD_FORMAT, buildType)
    }




}
