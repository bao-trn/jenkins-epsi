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
                    def failurePattern = /Failures: [0-1000]/
                    def match = (testResult =~failurePattern)
                    if (match) {
                        println(match[0])
                    } else {
                        println("no match found")
                    }
                    println(testResult)
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