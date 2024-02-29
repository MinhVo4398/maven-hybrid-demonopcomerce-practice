pipeline {
    agent any
    tools
    {
        maven 'apache-maven-3.0.1'
    }

    stages {

        stage('Test') {
            steps {
                sh "mvn clean test"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                   publishHTML([
                       allowMissing: false,
                       alwaysLinkToLastBuild: false,
                       keepAll: false,
                       reportDir: 'target/surefire-reports/',
                       reportFiles: 'emailable-report.html',
                       reportName: 'HTML Report',
                       reportTitles: '',
                       useWrapperFileDirectly: true])
                }
            }
        }
    }
}