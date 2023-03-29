pipeline {
    agent any
    tools {
            maven 'Maven 13.2.1'
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean'
                echo 'Building..'
            }
        }
        stage('Test') {
            sh 'mvn test'
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                echo 'does that work'
            }
        }
    }
}