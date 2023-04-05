def PERCENT_FAILURE = 0;

pipeline {
    agent any
    tools {
            maven 'Maven 3.9.1'
        }
    stages {
        stage('BUILD') {
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

                    //the job will always be successful due to the 'true' in the script above
                    //we're using the percentage of failed test to make the job pass or not
                    //NOTE : by default a failed test will fail the job, hence the use of 'true'
                    if (PERCENT_FAILURE > 20) {
                        error 'YOU SUCK AT UNIT TESTING'
                    }
                }
            }
        }
        stage('PACKAGING') {
            steps {
                sh 'mvn -B -Dmaven.test.skip=true package'
            }
        }

    }

    post {
        success {
            echo 'YOUR SO GOOD AT UNIT TESTING'
        }
        failure {
            echo 'THE PERCENTAGE OF FAILED TESTS IS: ' + PERCENT_FAILURE.toString()
            echo 'BUILD FAILED, SENDING AN EMAIL...'
                mail to: 'baoanh.tran@epsi.fr',
                subject: 'Build failed',
                body: PERCENT_FAILURE.toString()
        }
    }
}