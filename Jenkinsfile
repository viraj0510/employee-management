pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    environment {
        SCANNER_HOME = tool 'SonarScanner'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/viraj0510/employee-management.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh '''
                    mvn sonar:sonar \
                    -Dsonar.projectKey=employee-management \
                    -Dsonar.projectName=employee-management
                    '''
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline Successful!"
        }
    }
}