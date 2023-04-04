pipeline {
    agent any
    tools {
            maven 'Maven 3.9.1'
        }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean test'
                def testResult = sh(script: 'mvn test', returnStdout: true).trim()
                //passed_tests=$(grep -E 'Tests run: [0-9]+, Failures: 0, Errors: 0, Skipped: 0' test-results.txt | grep -Eo '[0-9]+')
                echo '$testResult'
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