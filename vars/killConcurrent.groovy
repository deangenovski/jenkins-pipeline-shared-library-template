#!groovy


def call() {

    echo(currentBuild.toString())

    def myBuild = currentBuild.rawBuild.getPreviousBuildInProgress()

    echo(myBuild.toString())

    while (myBuild != null) {

        echo("Build found" + myBuild.toString())
        def execution = myBuild.getExecution()
        if (execution != null) {
            echo(execution.isComplete().toString())
        } else {
            echo("null execution")
        }
        echo(myBuild.getEnvironment(null).BUILD_NUMBER)

        myBuild = myBuild.getPreviousBuildInProgress()
    }

}


