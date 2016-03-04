multibranchWorkflowJob('pipeline-as-code-demo') {
    branchSources {
        git {
            remote('https://github.com/rlespinasse/jenkinsdsl__pipeline-as-code-demo.git')
        }
    }
    triggers {
        periodic(1)
    }
}