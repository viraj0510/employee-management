pipeline {
    agent any

    tools {
    maven 'Maven3'
    jdk 'JDK17'
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
        stage('Build Docker Image') {
    steps {
        sh 'docker build -t viraj0510/employee-management:latest .'
    }
}

stage('Push Docker Image') {
    steps {
        withCredentials([usernamePassword(
            credentialsId: 'dockerhub',
            usernameVariable: 'DOCKER_USERNAME',
            passwordVariable: 'DOCKER_PASSWORD'
        )]) {
            sh '''
                echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
                docker push viraj0510/employee-management:latest
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