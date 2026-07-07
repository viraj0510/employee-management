pipeline {
    agent any

    environment {
        MAVEN_HOME = "/usr/local/bin"
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Source code is available"
            }
        }

        stage('Build') {
            steps {
                sh '/usr/local/bin/mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh '/usr/local/bin/mvn test'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        success {
            echo 'Build Successful!'
        }

        failure {
            echo 'Build Failed!'
        }
    }
}