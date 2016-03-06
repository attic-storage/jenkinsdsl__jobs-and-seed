node {
    git 'https://github.com/rlespinasse/jenkinsdsl__project-maven.git'
    sh "${tool 'Maven 3.x'}/bin/mvn"
    sh "java -jar target/Golo-0.0.1-SNAPSHOT-jar-with-dependencies.jar"
}