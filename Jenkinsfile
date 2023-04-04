pipeline {
    agent any
    tools {
            maven 'Maven 3.9.1'
        }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean test'
                //passed_tests=$(grep -E 'Tests run: [0-9]+, Failures: 0, Errors: 0, Skipped: 0' test-results.txt | grep -Eo '[0-9]+')
            }
        }
        stage('Script') {
            steps {
                echo 'HERE SCRIPT LAUNCH'
                script {
                    def testResult = sh(script: 'mvn test', returnStdout: true).trim()
                    def failurePattern = /Failures:\s*(\d+)/
                    def match = (testResult =~failurePattern)
                    def numberOfFailures = match[0][1]

                    if (numberOfFailures > 0) {
                        println("failures superior to one")
                    } else {
                        println("no failures")
                    }
                }
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