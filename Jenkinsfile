pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withMaven {
                    sh 'mvn clean test'
                }
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