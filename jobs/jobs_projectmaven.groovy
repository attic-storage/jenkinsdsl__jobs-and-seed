multibranchWorkflowJob('project-maven') {
    branchSources {
        git {
            remote('https://github.com/rlespinasse/jenkinsdsl__project-maven.git')
        }
    }
    triggers {
        periodic(1)
    }
}