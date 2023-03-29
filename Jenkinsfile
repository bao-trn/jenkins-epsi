pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                sh 'mvn clean'
                echo 'Building..'
            }
        }
        stage('Test') {
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