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
    qualityGate()
}
void qualityGate() {
    stage("Sonar Quality Gate") {
        sleep 5
        timeout(time: 5, unit: 'MINUTES') {
            def qualityGate = waitForQualityGate()
            if (qg.status != 'OK') {
                error "Pipeline aborted due to quality gate failure: ${qualityGate.status}"
            }
        }
    }
}