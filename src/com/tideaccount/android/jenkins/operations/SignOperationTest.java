package com.tideaccount.android.jenkins.operations;

import com.tideaccount.android.jenkins.BuildType;
import com.tideaccount.android.jenkins.Constants;

import java.util.List;

public class SignOperationTest extends GradleOperation {

    public SignOperationTest(List<BuildType> buildTypes, Integer buildNumber, String buildName) {
        super(buildTypes, buildNumber, buildName);
    }

    @Override
    public String getGradleBuildString() {
        String gradleBuildString = super.getGradleBuildString();
        return gradleBuildString + " test";
    }

    @Override
    protected String getArgumentFormat() {
        return Constants.ASSEMBLE_FORMAT;
    }
}
