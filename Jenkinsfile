#!groovy
@Library('pipeline-library-demo@4.2.0')_

node {
    stage('Checkout') {
        checkout scm
    }
    stage('Demo') {
        echo 'Hello world'
        sayHello 'Dave'
    }
}
