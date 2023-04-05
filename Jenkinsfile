def PERCENT_FAILURE = 0;

pipeline {
    agent any
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
                    def testResult = sh(script: 'mvn test || true', returnStdout: true).trim()

                    def testRunPattern = /Tests\s*run:\s*(\d+)/
                    def failurePattern = /Failures:\s*(\d+)/

                    def testRunMatch = (testResult =~ testRunPattern)
                    def failureMatch = (testResult =~ failurePattern)

                    def numberOfTestRuns = testRunMatch[0][1].toInteger()
                    def numberOfFailures = failureMatch[0][1].toInteger()

                    PERCENT_FAILURE = ((numberOfFailures / numberOfTestRuns) * 100)


                }
            }
        }

        stage('Packaging') {
            steps {
                sh 'mvn -B -Dmaven.test.skip=true package'
            }
        }

        /*stage('Cleaning Workspace') {
             steps {
                //cleanWs()
             }
        }*/

    }
    post {
        success {
            echo 'YOUR CODE IS A GODDAMN SUCCESS'
        }
        failure {
            echo PERCENT_FAILURE.toString()
            echo 'Build failed'
                mail to: 'baoanh.tran@epsi.fr',
                subject: 'Build failed',
                body: PERCENT_FAILURE.toString()
        }
    }
}