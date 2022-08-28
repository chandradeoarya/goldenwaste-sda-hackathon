pipeline {
	agent any

	environment {

		ARTIFACT_NAME         = "ROOT.jar"

		SONAR_PROJECT_KEY     = "goldenwaste-sda-hackathon"
		SONAR_IP              = "localhost:9000"
		SONAR_TOKEN           = "sqp_c6e9430471a3fa637a8816cb7a18b55762fa3179"
	}

	stages {

		
		stage('Validate') {
			steps {
				sh "mvn validate"
				sh "mvn clean"
			}
		}

		stage('Build') {
			steps {
				sh "mvn compile"
			}
		}

		stage('Test') {
			steps {
				sh "mvn test"
			}

			post {
				always {
					junit allowEmptyResults: true, testResults: '**/target/surefire-reports/TEST-*.xml'
				}
			}
		}

		stage('Quality Scan'){

			steps {
                sh '''
                mvn clean verify sonar:sonar \
                    -Dsonar.projectKey=$SONAR_PROJECT_KEY \
                    -Dsonar.host.url=http://$SONAR_IP \
                    -Dsonar.login=$SONAR_TOKEN
                '''
            }
		}

		stage('Package') {
            steps {                
                sh "mvn package"
            }

            post {
                success {
                    archiveArtifacts artifacts: '**/target/**.jar', followSymlinks: false                   
                }
            }
        }
	}
}