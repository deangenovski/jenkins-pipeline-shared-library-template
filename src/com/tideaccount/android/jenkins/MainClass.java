package com.tideaccount.android.jenkins;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        List<BuildType> buildTypes = new ArrayList<>();
        buildTypes.add(BuildType.QA_DUMMY);

        System.out.println(Util.test());
    }
}
