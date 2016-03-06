node {
    stage 'Checkout'
    new jenkinsdsl.Github().checkOutFrom 'project-maven'

    stage 'Build'
    maven 'clean install'

    stage 'Execute'
    jar 'target/Golo-0.0.1-SNAPSHOT-jar-with-dependencies.jar'
}