#!groovy
//@Library('pipeline-library-demo@1.0.1')_
@Library('pipeline-library-demo')_

node {
    stage('Checkout') {
        checkout scm
    }
    stage('Demo') {
        echo 'Hello world'
        sayHello 'Dave'
    }
    stage('Demo1') {
        sayHello 'Dave'
    }
    stage('SonarQube analysis') {
        withSonarQubeEnv('Sonar Quality Gate') {
            sh 'mvn clean install sonar:sonar -Dsonar.host.url=http://localhost:9000'
        } // submitted SonarQube taskId is automatically attached to the pipeline context
    }
    qualityGate()
}
void qualityGate() {
    stage("Quality Gate") {
        sleep 5
        timeout(time: 5, unit: 'MINUTES') {
            def qualityGate = waitForQualityGate()
            if (qualityGate.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${qualityGate.status}"
            }
        }
    }
}