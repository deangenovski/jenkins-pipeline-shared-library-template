#!groovy


def call() {

    echo(currentBuild.toString())

    def myBuild = currentBuild.rawBuild.getPreviousBuildInProgress()

    while (myBuild != null) {

        echo("Build found" + myBuild.toString())
        echo(myBuild.getExecution().isComplete().toString())
        echo(myBuild.getEnvironment(null).BUILD_NUMBER)

        myBuild = myBuild.getPreviousBuild()
    }

}


