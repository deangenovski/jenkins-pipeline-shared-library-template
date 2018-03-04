package com.tideaccount.android.jenkins;

import com.tideaccount.android.jenkins.operations.CompileOperation;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        List<BuildType> buildTypes = new ArrayList<>();
        buildTypes.add(BuildType.QA_DUMMY);

        String hi = new CompileOperation(buildTypes, 1, "hi")
                .getGradleBuildString();

        System.out.println(hi);
    }
}
