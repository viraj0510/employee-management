pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh '/usr/local/bin/mvn clean package'
            }
        }

        stage('Archive') {
            steps {
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }
}