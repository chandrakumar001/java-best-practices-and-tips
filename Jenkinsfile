#!groovy
@Library('pipeline-library-demo')_

node {
    stage('Checkout') {
        checkout scm
    }
    stage('Demo') {
        echo 'Hello world'
        sayHello 'Dave'
    }
}
