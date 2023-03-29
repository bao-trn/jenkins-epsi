pipeline {
    agent any
    tools {
            maven 'Maven 3.9.1'
        }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean test'
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Packaging') {
            steps {
                sh 'mvn package'
            }
        }
        /*stage('Cleaning Workspace') {
             steps {
                //cleanWs()
             }
        }*/
    }
}