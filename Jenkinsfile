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
        stage('Testing copy') {
            steps {

                sh 'cp /target/*.jar /Users/Bao/Desktop/'
                echo Workspace
            }
        }
        /*stage('Cleaning Workspace') {
             steps {
                //cleanWs()
             }
        }*/
    }
}