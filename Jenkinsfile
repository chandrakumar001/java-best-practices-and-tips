@Library('pipeline-library-demo')

node {
    stage('Checkout') {
        checkout scm
    }
    stage('Demo') {
        echo 'Hello world'
        sayHello 'Dave'
    }
}
