pipeline {
    agent any

    stages {
      stage('Build') {
                steps {
                    script {
                            def javaHome = tool 'Java 17'
                            def mvnHome = tool 'Maven 3.8.6'

                            env.JAVA_HOME = javaHome
                            env.PATH = "${mvnHome}/bin:${env.JAVA_HOME}/bin:${env.PATH}"

                    }
                    sh 'mvn clean package'
                }
            }
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