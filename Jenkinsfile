pipeline {
    agent any
    def percentFailures = 0;
    tools {
            maven 'Maven 3.9.1'
        }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('QUALITY GATES') {
            steps {
                script {
                    def testResult = sh(script: 'mvn test', returnStdout: true).trim()

                    def testRunPattern = /Tests\s*run:\s*(\d+)/
                    def failurePattern = /Failures:\s*(\d+)/

                    def testRunMatch = (testResult =~ testRunPattern)
                    def failureMatch = (testResult =~ failurePattern)

                    def numberOfTestRuns = testRunMatch[0][1].toInteger()
                    def numberOfFailures = failureMatch[0][1].toInteger()

                    percentFailures = ((numberOfFailures / numberOfTestRuns) * 100)

                    println(percentFailures)
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
    post {
        failure {
            echo percentFailures
            echo 'Build failed'
                mail to: 'baoanh.tran@epsi.fr',
                subject: 'Build failed',
                body: percentFailures
        }
    }
}