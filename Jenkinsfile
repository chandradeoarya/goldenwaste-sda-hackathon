pipeline {
	agent any

	environment {

 		 	ARTIFACT_NAME         = "ROOT.war"

  			SONAR_PROJECT_KEY     = "goldenwaste-sda-hackathon"
  			SONAR_IP              = "100.25.23.137:9000"
  			SONAR_TOKEN           = "sqp_3ee5e38ffea3480013f8efe6778119a10f83dc8d"
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
                    archiveArtifacts artifacts: '**/target/**.war', followSymlinks: false                   
                }
            }
        }
	}
}